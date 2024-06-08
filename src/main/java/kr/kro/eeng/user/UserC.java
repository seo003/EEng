package kr.kro.eeng.user;

import jakarta.servlet.http.HttpSession;
import kr.kro.eeng.book.dto.BookInfoD;
import kr.kro.eeng.book.service.BookS;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserC {
    private final UserS userS;
    private final BookS bookS;

    @GetMapping("/")
    public String home(HttpSession session) {
        if (session.getAttribute("userId") == null)
            return "redirect:/login";
        else {
//            BookInfoD bookInfo = bookS.getRandomBookInfo();
            return "index";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login.do")
    public String login(String userId, String userPw, HttpSession session) {
        UserD user = userS.login(userId, userPw);
        if (user != null) {
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("userLv", user.getUserLv());
        } else {
            System.out.println("로그인 실패");
            return "redirect:/login";
        }

        if (user.getUserLv() == 0) {
            return "redirect:/level-test";
        } else
            return "redirect:/index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register.do")
    public String register(UserD userD) {
        System.out.println("userD" + userD.toString());
        userS.register(userD);

        return "redirect:/login";
    }
}