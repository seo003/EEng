package kr.kro.eeng.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexC {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
