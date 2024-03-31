package kr.kro.eeng.user;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserC {
    private final UserS userS;
    @Autowired
    public UserC(UserS userS) {
        this.userS = userS;
    }
    @PostMapping("/login")
    public String login(String userId, String userPw, HttpSession session, Model model) {
        if (userS.login(userId, userPw)) {
            session.setAttribute("loginId", userId);
        } else {
            System.out.println("로그인 실패");
        }
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }
}
