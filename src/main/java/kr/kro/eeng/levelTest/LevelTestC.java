package kr.kro.eeng.levelTest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.kro.eeng.user.UserD;
import kr.kro.eeng.user.UserS;
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
    private final UserS userS;
    private int score;
    private ArrayList<LevelTestD> ltList;
    private ArrayList<LevelTestChoiceD> ltcList;
    private int num;
    private boolean tf = false;

    @GetMapping("/level-test")
    public String levelTest(Model model) {
        ltList = levelTestS.levelTest();
        model.addAttribute("ltList", ltList);

        ltcList = levelTestS.levelTestChoice();
        model.addAttribute("ltcList", ltcList);

        num = userS.getNum();
        System.out.println("***num: " + num);

        model.addAttribute("numOrder", num);

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
            tf = true;
        }else {
            tf = false;
        }

        System.out.println("***score: " + score);
        System.out.println(tf);

        model.addAttribute("ltList", ltList);
        model.addAttribute("ltcList", ltcList);
        model.addAttribute("numOrder", num);
        model.addAttribute("tf", tf);

        return "checkAnswer";
    }

    @PostMapping("/level-test/nextNum.do")
    public String nextNum(Model model) {
        model.addAttribute("ltList", ltList);
        model.addAttribute("ltcList", ltcList);

        num += 1;
        model.addAttribute("numOrder", num);

        if (num == ltList.size()){
            return "redirect:/level-test/result";
        }

        System.out.println("++++++++++num: " + num);
        System.out.println("++++++++++size: " + ltList.size());

        return "levelTest";
    }

    @GetMapping("/level-test/result")
    public String showResult(Model model, HttpSession session){
        String userId = (String)session.getAttribute("userId");
        levelTestS.saveLv(userId, score);
        model.addAttribute("score", score);
        return "ltResult";
    }
}
