package kr.kro.eeng.levelTest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class LevelTestS {
    private static int pre = 11;
    private final LevelTestR levelTestR;

    public ArrayList<LevelTestD> levelTest(int lv){
        ArrayList<LevelTestD> lt1 = levelTestR.findByLv(1);
        ArrayList<LevelTestD> lt2 = levelTestR.findByLv(2);
        ArrayList<LevelTestD> lt3 = levelTestR.findByLv(3);



        return lt1;
    }
}
