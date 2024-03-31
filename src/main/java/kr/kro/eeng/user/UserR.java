package kr.kro.eeng.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserR extends JpaRepository<UserD, Long> {
    Optional<UserD> findByUserId(String userId);
}
