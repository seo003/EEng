package kr.kro.eeng.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override //요청이 컨트롤러로 전달 되기 전에 실행되는 로직 정의
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("userId") == null) {
            // 로그인하지 않은 사용자를 로그인 페이지로 리다이렉트
            response.sendRedirect("/login?error=loginRequired");
            return false; // 요청 처리를 계속하지 않음
        }

        return true; // 요청 처리 계속
    }

}
