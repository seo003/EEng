package kr.kro.eeng.voca.controller;

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

    @GetMapping("/voca.do")
    public String voca(int lv, Model model) {
        List<VocaListD> vocaListFromLv = vocaS.getVocaListbyLv(lv);
        if (vocaListFromLv.isEmpty() == false) {
            //데이터 존재
            model.addAttribute("vocaListFromLv", vocaListFromLv);
        }

        model.addAttribute("lv", lv);
        return "voca";
    }
}