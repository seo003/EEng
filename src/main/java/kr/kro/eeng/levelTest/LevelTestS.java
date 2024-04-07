package kr.kro.eeng.levelTest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LevelTestS {
    private final LevelTestR levelTestR;

    public LevelTestD levelTest(Long num){
        Optional<LevelTestD> levelTestEntitiy = levelTestR.findByNum(num);
        if(levelTestEntitiy.isPresent()){
            LevelTestD levelTestD = levelTestEntitiy.get();
            return levelTestD;
        } else {
            throw new IllegalArgumentException("Level test data not found for num: " + num);
        }
    }
}
