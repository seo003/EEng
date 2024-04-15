package kr.kro.eeng.voca.repository;

import kr.kro.eeng.voca.dto.VocaInListD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VocaInListR extends JpaRepository<VocaInListD, Long> {

}
