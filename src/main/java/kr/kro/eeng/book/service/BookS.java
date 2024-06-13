package kr.kro.eeng.book.service;

import kr.kro.eeng.book.dto.BookContentD;
import kr.kro.eeng.book.dto.BookInfoD;
import kr.kro.eeng.book.repository.BookContentR;
import kr.kro.eeng.book.repository.BookInfoR;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookS {

    @Autowired
    private final BookInfoR bookInfoR;

    @Autowired
    private final BookContentR bookContentR;

    public List<BookInfoD> getBookInfoList() {
        return bookInfoR.findAll();
    }

    public Page<BookContentD> findByBookId(int bookId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookContentR.findByBookId(bookId, pageable);
    }

    public BookInfoD findBookInfoByBookId(int bookId) {
        return bookInfoR.findByBookId(bookId);
    }

    public BookContentD getRandomBookContent() {
        return bookContentR.findRandByRand();
    }

    public String getBookName(int bookId) {
        BookInfoD bookInfo = bookInfoR.findByBookId(bookId);
        return bookInfo.getBookName();
    }
}
