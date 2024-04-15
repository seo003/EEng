package kr.kro.eeng.voca.service;

import kr.kro.eeng.voca.dto.VocaListD;
import kr.kro.eeng.voca.repository.VocaListR;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VocaS {
    @Autowired
    private final VocaListR vocaListR;

    public List<VocaListD> getVocaListbyLv(int lv) {
        return vocaListR.findByVocaLv(lv);
    }
}