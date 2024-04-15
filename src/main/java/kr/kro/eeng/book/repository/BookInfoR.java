package kr.kro.eeng.book.repository;

import kr.kro.eeng.book.dto.BookInfoD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookInfoR extends JpaRepository<BookInfoD, Long> {
    //    ArrayList<BookInfoD> findAll(); JpaRepository에 이미 정의되어 있음
    BookInfoD findByBookId(int bookId);

}
