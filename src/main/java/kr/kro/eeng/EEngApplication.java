package kr.kro.eeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class EEngApplication {

	public static void main(String[] args) {
		SpringApplication.run(EEngApplication.class, args);
	}

}
