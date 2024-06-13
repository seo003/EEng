package kr.kro.eeng.voca.repository;

import kr.kro.eeng.voca.dto.VocaListD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VocaListR extends JpaRepository<VocaListD, Long> {
    @Query(value = "SELECT * FROM VocaList WHERE vocaLv = :vocaLv ORDER BY DBMS_RANDOM.VALUE", nativeQuery = true)
    List<VocaListD> findByVocaLv(int vocaLv);

    List<VocaListD> findByVocaIdIn(List<Integer> vocaIds);
}


