package kr.kro.eeng.levelTest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
@RequiredArgsConstructor
public class LevelTestC {
    private final LevelTestS levelTestS;

    @GetMapping("/level-test")
    public String levelTest(Model model) {
        ArrayList<LevelTestD> ltList1 = levelTestS.levelTest(1);
        ArrayList<LevelTestD> ltList2 = levelTestS.levelTest(2);
        ArrayList<LevelTestD> ltList3 = levelTestS.levelTest(3);

        model.addAttribute("ltList1", ltList1);
        model.addAttribute("ltList2", ltList2);
        model.addAttribute("ltList3", ltList3);
        
        ArrayList<LevelTestChoiceD> ltcList = levelTestS.levelTestChoice();

        model.addAttribute("ltcList", ltcList);

        return "levelTest";
    }


}
