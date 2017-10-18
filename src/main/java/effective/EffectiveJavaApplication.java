package effective;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {
		"effective.executor"
})
public class EffectiveJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EffectiveJavaApplication.class, args);
	}
}
