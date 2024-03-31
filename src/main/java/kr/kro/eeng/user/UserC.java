package kr.kro.eeng.user;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserC {

    @PostMapping("/login")
    public String login(String userId, String userPw, HttpSession session, Model model) {


        return "index";
    }
}
