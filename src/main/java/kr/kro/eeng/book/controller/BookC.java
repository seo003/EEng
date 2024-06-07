package kr.kro.eeng.book.controller;

import kr.kro.eeng.book.dto.BookContentD;
import kr.kro.eeng.book.dto.BookInfoD;
import kr.kro.eeng.book.service.BookS;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


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
    public String bookContent(int bookId, @RequestParam(defaultValue = "0") int page, Model model) {
        int pageSize = 7; //7문장
        Page<BookContentD> bookContentPage = bookS.findByBookId(bookId, page, pageSize);
        BookInfoD bookInfo = bookS.findBookInfoByBookId(bookId);

        model.addAttribute("bookContent", bookContentPage.getContent());
        model.addAttribute("bookInfo", bookInfo);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", bookContentPage.getTotalPages());

        return "readbook";
    }
}
