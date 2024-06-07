package kr.kro.eeng.voca.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.kro.eeng.voca.dto.VocaListD;
import kr.kro.eeng.voca.service.VocaS;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class VocaC {
    private final VocaS vocaS;

    //단어
    @GetMapping("/voca")
    public String voca(int lv, Model model) {
        List<VocaListD> vocaListFromLv = vocaS.getVocaListbyLv(lv);
        if (!vocaListFromLv.isEmpty()) {
            // 데이터를 JSON 문자열로 변환
            ObjectMapper objectMapper = new ObjectMapper();
            String vocaJson = "";
            try {
                vocaJson = objectMapper.writeValueAsString(vocaListFromLv);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            model.addAttribute("voca", vocaJson);
        }

        model.addAttribute("lv", lv);
        return "voca";
    }

    //단어 목록
    @GetMapping("/vocaList")
    public String vocaList(int lv, Model model) {
        List<VocaListD> vocaListFromLv = vocaS.getVocaListbyLv(lv);
        if (!vocaListFromLv.isEmpty()) {
            //데이터 존재
            model.addAttribute("vocaListFromLv", vocaListFromLv);
        }

        model.addAttribute("lv", lv);
        return "vocaList";
    }

// 내 단어장 추가

}