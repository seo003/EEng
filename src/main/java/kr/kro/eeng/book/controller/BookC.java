package kr.kro.eeng.book.controller;

import kr.kro.eeng.book.dto.BookContentD;
import kr.kro.eeng.book.dto.BookInfoD;
import kr.kro.eeng.book.service.BookS;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class BookC {
    private final BookS bookS;

    @GetMapping("/booklist.do")
    public String bookList(Model model) {
        List<BookInfoD> bookInfoList = bookS.getBookInfoList();
        model.addAttribute("bookInfoList", bookInfoList);
        return "bookList";
    }

    @GetMapping("/readBook.do")
    public String bookList(int bookId, Model model) {
        List<BookContentD> bookContent = bookS.findByBookId(bookId);
        BookInfoD bookInfo = bookS.findBookInfoByBookId(bookId);
        model.addAttribute("bookContent", bookContent);
        model.addAttribute("bookInfo", bookInfo);
        return "readbook";
    }
}
