package kr.kro.eeng.voca.repository;

import kr.kro.eeng.voca.dto.VocaListD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VocaListR extends JpaRepository<VocaListD, Long> {
    List<VocaListD> findByVocaLv(int vocaLv);

    List<VocaListD> findByVocaIdIn(List<Integer> vocaIds);
}


