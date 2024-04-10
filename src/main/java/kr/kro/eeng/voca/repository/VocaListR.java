package kr.kro.eeng.voca.repository;

import kr.kro.eeng.voca.dto.VocaListD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface VocaListR extends JpaRepository<VocaListD, Long> {
    ArrayList<VocaListD> findByVocaLv(int vocaLv);
}
