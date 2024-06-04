package kr.kro.eeng.levelTest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class LevelTestS {

    private final LevelTestR ltR;
    private final LevelTestChoiceR ltcR;

    public ArrayList<LevelTestD> levelTest() {
        return ltR.levelTest();
    }

    public ArrayList<LevelTestChoiceD> levelTestChoice() {
        return (ArrayList<LevelTestChoiceD>) ltcR.findAll();
    }
}
