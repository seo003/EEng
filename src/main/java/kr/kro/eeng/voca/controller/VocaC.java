package kr.kro.eeng.voca.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import kr.kro.eeng.user.UserD;
import kr.kro.eeng.voca.dto.UserVocaD;
import kr.kro.eeng.voca.dto.VocaListD;
import kr.kro.eeng.voca.repository.UserVocaR;
import kr.kro.eeng.voca.service.VocaS;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @PostMapping("/addToMyVoca")
    public ResponseEntity<Map<String, Object>> addToMyVoca(@RequestBody Map<String, Integer> payload, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        int vocaId = payload.get("vocaId");

        boolean success = vocaS.addToUserVoca(userId, vocaId);

        Map<String, Object> response = new HashMap<>();
        response.put("success", success);
        return ResponseEntity.ok(response);
    }

    // 내 단어장 목록
    @GetMapping("/myVocaList")
    public String myVocaList(Model model, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        model.addAttribute("userId", userId);

        List<VocaListD> userVocaList = vocaS.getUserVocaList(userId);
        model.addAttribute("userVocaList", userVocaList);
        return "myVocaList";
    }

    //내 단어 삭제
    @GetMapping("/vocaDelete")
    public String vocaDelete(int vocaId, HttpSession session){
        String userId = (String) session.getAttribute("userId");
        vocaS.deleteVoca(userId, vocaId);
        return "redirect:/myVocaList";
    }
}