package kr.kro.eeng.book.service;

import kr.kro.eeng.book.dto.BookContentD;
import kr.kro.eeng.book.dto.BookInfoD;
import kr.kro.eeng.book.repository.BookContentR;
import kr.kro.eeng.book.repository.BookInfoR;
import kr.kro.eeng.user.UserD;
import kr.kro.eeng.user.UserR;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<BookContentD> findByBookId(int bookId) {
        return bookContentR.findByBookId(bookId);
    }

    public BookInfoD findBookInfoByBookId(int bookId) {
        return bookInfoR.findByBookId(bookId);
    }
}
