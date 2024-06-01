package kr.kro.eeng.book.repository;

import kr.kro.eeng.book.dto.BookContentD;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookContentR extends JpaRepository<BookContentD, Long> {

    //    List<BookContentD> findByBookId(int bookId);
    @Query(value = "SELECT * FROM (SELECT a.*, rownum r__ FROM (SELECT b.* FROM bookContent b " +
            "WHERE b.BOOKID = :bookId ORDER BY b.BOOKID) a WHERE rownum <= :#{#pageable.offset + #pageable.pageSize}) " +
            "WHERE r__ > :#{#pageable.offset}",
            countQuery = "SELECT count(*) FROM bookContent b WHERE b.BOOKID = :bookId",
            nativeQuery = true)
    Page<BookContentD> findByBookId(@Param("bookId") int bookId, Pageable pageable);
}
