package kr.kro.eeng.levelTest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class LevelTestS {

    private final LevelTestR ltR;
    private final LevelTestChoiceR ltcR;

    public ArrayList<LevelTestD> levelTest(int lv) {
        return ltR.findByLv(lv);
    }

    public ArrayList<LevelTestChoiceD> levelTestChoice() {
        return (ArrayList<LevelTestChoiceD>) ltcR.findAll();
    }
}
