package kr.kro.eeng.levelTest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LevelTestS {
    private final LevelTestR levelTestR;

    public ArrayList<LevelTestD> levelTest(int lv){
        ArrayList<LevelTestD> levelTest1 = (ArrayList<LevelTestD>) levelTestR.findByLv(1);
        ArrayList<LevelTestD> levelTest2 = (ArrayList<LevelTestD>) levelTestR.findByLv(2);
        ArrayList<LevelTestD> levelTest3 = (ArrayList<LevelTestD>) levelTestR.findByLv(3);

        System.out.println(levelTest1);

        return levelTest1;

    }
}
