package kr.kro.eeng.user;

import jakarta.servlet.http.HttpSession;
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

    @GetMapping("/")
    public String home(HttpSession session) {
        if (session.getAttribute("loginId") == null)
            return "redirect:/login.do";
        else return "index";
    }

    @GetMapping("/login.do")
    public String login() {
        return "login";
    }

    @PostMapping("/login.do")
    public String login(String userId, String userPw, HttpSession session) {
        UserD user = userS.login(userId, userPw);
        if (user != null) {
            session.setAttribute("user", user);
        } else {
            System.out.println("로그인 실패");
            return "redirect:/login.do";
        }
        return "redirect:/index";
    }

    @GetMapping("/logout.do")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login.do";
    }
}