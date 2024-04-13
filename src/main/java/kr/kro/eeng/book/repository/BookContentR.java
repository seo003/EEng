package kr.kro.eeng.book.repository;

import kr.kro.eeng.book.dto.BookContentD;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookContentR extends JpaRepository<BookContentD, Long>{

}
