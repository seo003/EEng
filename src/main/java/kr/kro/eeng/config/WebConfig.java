package kr.kro.eeng.config;

import kr.kro.eeng.interceptor.LoginInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
//                .addPathPatterns("/**") //인터셉터 호출하는 주소
                .addPathPatterns("/index", "/levelTest") //나중에 더 추가하기
                .excludePathPatterns("/login.do", "/css/**", "/js/**", "/assets/**"); //인터셉터 무시하는 주소
    }
}
