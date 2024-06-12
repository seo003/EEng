package kr.kro.eeng.index;

import jakarta.servlet.http.HttpSession;
import kr.kro.eeng.book.dto.BookInfoD;
import kr.kro.eeng.book.service.BookS;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexC {
    private final BookS bookS;

    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        if (session.getAttribute("userId") == null)
            return "redirect:/login";
        else {
            return "index";
        }
    }
}
