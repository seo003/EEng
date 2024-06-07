package kr.kro.eeng.levelTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface LevelTestR extends JpaRepository<LevelTestD, Long> {
    @Query(value = "SELECT * FROM (SELECT * FROM LEVELTEST ORDER BY DBMS_RANDOM.RANDOM)", nativeQuery = true)
    ArrayList<LevelTestD> levelTest();
}
