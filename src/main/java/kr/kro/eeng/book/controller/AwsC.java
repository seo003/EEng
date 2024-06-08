
package kr.kro.eeng.book.controller;

import jakarta.servlet.http.HttpServletResponse;
import kr.kro.eeng.book.repository.BookContentR;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.polly.PollyClient;
import software.amazon.awssdk.services.polly.model.*;
import software.amazon.awssdk.services.translate.TranslateClient;
import software.amazon.awssdk.services.translate.model.TranslateTextRequest;
import software.amazon.awssdk.services.translate.model.TranslateTextResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AwsC {

    private static final Logger logger = LoggerFactory.getLogger(AwsC.class);

    @Autowired
    private BookContentR bookContentR;

    @PostMapping("/translate.do")
    public Map<String, String> translateText(@RequestBody Map<String, String> request) {
        String textToTranslate = request.get("text");
        String translatedText;
        logger.info("Received text to translate: {}", textToTranslate);

        // 번역 된 적이 없으면 번역 진행
        if (bookContentR.findTFBySent(textToTranslate) == 0) {
            // AWS 번역 서비스를 호출하는 데 사용되는 객체 생성
            TranslateClient translateClient = TranslateClient.builder()
                    .region(Region.AP_NORTHEAST_2)
                    .build();

            // 번역 요청 세부 정보 객체 생성
            TranslateTextRequest translateRequest = TranslateTextRequest.builder()
                    .text(textToTranslate)
                    .sourceLanguageCode("en")
                    .targetLanguageCode("ko")
                    .build();

            // 번역 수행
            TranslateTextResponse response = translateClient.translateText(translateRequest);
            // 번역된 값 가져오기
            translatedText = response.translatedText();
            logger.info("Translated text: {}", translatedText);

            translateClient.close();

            // 번역된 값 DB 저장
            bookContentR.updateTranslatedText(textToTranslate, translatedText);
        } else
            // 번역된 적이 있으면 DB에서 값 가져오기
            translatedText = bookContentR.findTransBySent(textToTranslate);

        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("translatedText", translatedText);
        return responseBody;
    }

    @PostMapping("/speech.do")
    public void synthesizeSpeech(@RequestBody Map<String, String> request, HttpServletResponse response) throws IOException {
        String textToSynthesize = request.get("text");
        logger.info("Received text to synthesize: {}", textToSynthesize);

        // AWS Polly 클라이언트 생성
        PollyClient pollyClient = PollyClient.builder()
                .region(Region.AP_NORTHEAST_2)
                .build();

        // 음성 합성 요청 생성
        SynthesizeSpeechRequest synthReq = SynthesizeSpeechRequest.builder()
                .text(textToSynthesize)
                .voiceId("Danielle")// 원하는 음성 ID 선택
                .outputFormat(OutputFormat.MP3)
                .engine(Engine.NEURAL) // 엔진을 neural로 설정
                .build();

        // 음성 합성 수행 및 스트림 처리
        try (ResponseInputStream<SynthesizeSpeechResponse> synthRes = pollyClient.synthesizeSpeech(synthReq);
             InputStream audioStream = synthRes) {

            // 응답의 Content-Type 설정
            response.setContentType("audio/mpeg");
            response.setHeader("Content-Disposition", "inline; filename=\"speech.mp3\"");

            // 응답 스트림에 오디오 데이터 쓰기
            OutputStream out = response.getOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = audioStream.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            out.flush();

        } catch (IOException e) {
            logger.error("Error generating speech", e);
            throw e;
        } finally {
            // Polly 클라이언트 종료
            pollyClient.close();
        }
    }
}
