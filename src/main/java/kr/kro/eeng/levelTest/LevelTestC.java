package kr.kro.eeng.levelTest;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class LevelTestC {
    private final LevelTestS levelTestS;
    private int score;

    @GetMapping("/level-test")
    public String levelTest(Model model) {
        ArrayList<LevelTestD> ltList = levelTestS.levelTest();
        model.addAttribute("ltList", ltList);

        ArrayList<LevelTestChoiceD> ltcList = levelTestS.levelTestChoice();
        model.addAttribute("ltcList", ltcList);

        return "levelTest";
    }

    @PostMapping("/level-test/checkAnswer.do")
    public String checkAnswer(Model model, HttpServletRequest request) {
        String answer = request.getParameter("answer");
        String userAnswer = request.getParameter("userAnswer");
        String lv = request.getParameter("lv");

        System.out.println("정답: " + answer);
        System.out.println("사용자정답: " + userAnswer);
        System.out.println("레벨: " + lv);

        if (answer.equals(userAnswer)){
            score += Integer.parseInt(lv);
        }

        System.out.println(score);

        return "checkAnswer";
    }
}
