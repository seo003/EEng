package kr.kro.eeng.levelTest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class LevelTestC {
    private final LevelTestS levelTestS;

    //    @GetMapping("/level-test/{num}")
//    public String levelTest(@PathVariable Long num, Model model){
//        LevelTestD levelTestD = levelTestS.levelTest(num);
//        model.addAttribute("levelTestD", levelTestD);
//        return "levelTest";
//    }
    @GetMapping("/level-test")
    public String levelTest() {
        return "levelTest";
    }
}
