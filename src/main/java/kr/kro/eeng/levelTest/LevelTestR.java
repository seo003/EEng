package kr.kro.eeng.levelTest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LevelTestR extends JpaRepository<LevelTestD, Long> {
    Optional<LevelTestD> findByNum(Long num);
}
