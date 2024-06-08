package kr.kro.eeng.voca.repository;

import jakarta.transaction.Transactional;
import kr.kro.eeng.voca.dto.UserVocaD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface UserVocaR extends JpaRepository<UserVocaD, Integer> {
    List<UserVocaD> findByUserId(String userId);

    void deleteByUserIdAndVocaId(String userId, int vocaId);
}
