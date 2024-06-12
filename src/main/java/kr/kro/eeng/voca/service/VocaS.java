package kr.kro.eeng.voca.service;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import kr.kro.eeng.voca.dto.UserVocaD;
import kr.kro.eeng.voca.dto.VocaListD;
import kr.kro.eeng.voca.repository.UserVocaR;
import kr.kro.eeng.voca.repository.VocaListR;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class VocaS {
    @Autowired
    private final VocaListR vocaListR;
    private final UserVocaR userVocaR;

    //레벨 별로 단어 가져오기
    public List<VocaListD> getVocaListbyLv(int lv) {
        return vocaListR.findByVocaLv(lv);
    }

    //유저 별로 단어가져오기
    public List<VocaListD> getUserVocaList(String userId) {
        // userId에 해당하는 모든 UserVocaD를 가져옴
        List<UserVocaD> userVocaList = userVocaR.findByUserId(userId);

        // 모든 vocaId를 추출하여 리스트로 만듦
        List<Integer> vocaIds = userVocaList.stream()
                .map(UserVocaD::getVocaId)
                .collect(Collectors.toList());

        // 해당 vocaId 리스트를 사용하여 VocaListD 리스트를 가져옴
        return vocaListR.findByVocaIdIn(vocaIds);
    }

    //유저 단어장에 단어 추가
    public boolean addToUserVoca(String userId, int vocaId) {
        try {
            // UserVocaD에 단어 추가
            UserVocaD userVocaD = new UserVocaD();
            userVocaD.setUserId(userId);
            userVocaD.setVocaId(vocaId);
            userVocaR.save(userVocaD);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //유저 단어 삭제
    public void deleteVoca(String userId, int vocaId){
        userVocaR.deleteByUserIdAndVocaId(userId, vocaId);
    }

}