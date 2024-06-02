package kr.kro.eeng.book.controller;

import kr.kro.eeng.book.repository.BookContentR;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.translate.TranslateClient;
import software.amazon.awssdk.services.translate.model.TranslateTextRequest;
import software.amazon.awssdk.services.translate.model.TranslateTextResponse;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TranslateC {

    private static final Logger logger = LoggerFactory.getLogger(TranslateC.class);

    @Autowired
    private BookContentR bookContentR;

    @PostMapping("/translate")
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
}
