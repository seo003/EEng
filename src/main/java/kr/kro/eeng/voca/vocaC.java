package kr.kro.eeng.voca;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class vocaC {
    @GetMapping("/voca.do")
    public String voca() {
        return "voca";
    }
}
