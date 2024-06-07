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
//                .addPathPatterns("/**") //인터셉터 적용될 경로
                .addPathPatterns("/index", "/level-test", "/voca.do", "/booklist.do") //
                .excludePathPatterns("/login.do", "/css/**", "/js/**", "/assets/**"); //인터셉터 무시될 경로
    }
}
