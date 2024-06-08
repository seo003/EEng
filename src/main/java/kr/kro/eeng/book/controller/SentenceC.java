package kr.kro.eeng.book.controller;

import kr.kro.eeng.book.dto.BookContentD;
import kr.kro.eeng.book.service.BookS;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SentenceC {

    private final BookS bookS;

    @GetMapping("/sentence")
    public String sentence(Model model) {
        BookContentD bookContent = bookS.getRandomBookContent();
        String bookName = bookS.getBookName(bookContent.getBookId());

        model.addAttribute("bookContent", bookContent);
        model.addAttribute("sentTrans", bookContent.getSentTrans());
        model.addAttribute("bookName", bookName);
        return "sentence";
    }

    @PostMapping("/sentence/checkSentence.do")
    public String sentence(String userAnswer, String answer, String sentTrans, String bookName, Model model) {
        boolean tf = userAnswer.equals(answer);

        System.out.println("sentTrans "+sentTrans);
        System.out.println("bookName "+bookName);
        System.out.println("answer "+answer);
        System.out.println("userAnswer "+userAnswer);

        model.addAttribute("sentTrans", sentTrans);
        model.addAttribute("bookName", bookName);
        model.addAttribute("answer", answer);
        model.addAttribute("tf", tf);
        return "checkSentence";
    }
}
