package kr.kro.eeng.levelTest;

import kr.kro.eeng.user.UserD;
import kr.kro.eeng.user.UserR;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class LevelTestS {

    private final LevelTestR ltR;
    private final LevelTestChoiceR ltcR;
    private final UserR userR;

    public ArrayList<LevelTestD> levelTest() {
        return ltR.levelTest();
    }

    public ArrayList<LevelTestChoiceD> levelTestChoice() {
        return (ArrayList<LevelTestChoiceD>) ltcR.findAll();
    }

    public void saveLv(UserD userD, int score) {
        int userLv;
        if (score >= 0 && score < 19) {
            userLv = 1;
        } else if (score >= 19 && score < 37) {
            userLv = 2;
        } else {
            userLv = 3;
        }
        userD.setUserLv(userLv);
        userR.save(userD);
    }
}
