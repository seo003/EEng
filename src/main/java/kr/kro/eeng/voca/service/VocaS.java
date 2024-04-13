package kr.kro.eeng.voca.service;

import kr.kro.eeng.voca.dto.VocaListD;
import kr.kro.eeng.voca.repository.VocaListR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class VocaS {
    @Autowired
    private VocaListR vocaListR;


    public ArrayList<VocaListD> getVocaListbyLv(int lv) {
        ArrayList<VocaListD> vocaListFromLv = vocaListR.findByVocaLv(lv);

        return vocaListFromLv;
    }
}