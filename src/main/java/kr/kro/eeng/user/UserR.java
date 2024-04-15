package kr.kro.eeng.user;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserR extends JpaRepository<UserD, Long> {
    Optional<UserD> findByUserId(String userId);
    @Query("SELECT u.userLv FROM User u WHERE u.userId = :userId")
    Long findUserLvByUserId(@Param("userId") String userId);
}
