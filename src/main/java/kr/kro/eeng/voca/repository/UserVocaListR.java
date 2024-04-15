package kr.kro.eeng.voca.repository;

import kr.kro.eeng.voca.dto.UserVocaListD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVocaListR extends JpaRepository<UserVocaListD, Long> {

}
