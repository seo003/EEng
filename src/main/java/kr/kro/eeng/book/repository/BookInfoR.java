package kr.kro.eeng.book.repository;

import kr.kro.eeng.book.dto.BookInfoD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface BookInfoR extends JpaRepository<BookInfoD,Long> {
    BookInfoD findByBookId(int bookId);

//    ArrayList<BookInfoD> findAll(); JpaRepository에 이미 정의되어 있음
}
