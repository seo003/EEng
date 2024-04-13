package kr.kro.eeng.levelTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface LevelTestR extends JpaRepository<LevelTestD, Long> {
    @Query(value = "SELECT * FROM LEVELTEST WHERE lv = :lv ORDER BY RAND()", nativeQuery = true)
    ArrayList<LevelTestD> findByLv(@Param("lv") int lv);
}
