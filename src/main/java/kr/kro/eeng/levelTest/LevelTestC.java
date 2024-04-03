package kr.kro.eeng.levelTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LevelTestC {
    @GetMapping("/level-test")
    public String levelTest(){
        return "levelTest";
    }
}
