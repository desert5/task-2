package task2.rating.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class RatingCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingCalculatorApplication.class, args);
	}

	@Bean
	@Autowired
	public LettuceConnectionFactory lettuceConnectionFactory(@Value("${redis.host}") String redisHost) {
		return new LettuceConnectionFactory(new RedisStandaloneConfiguration(redisHost));
	}


	@Bean
	@Autowired
	public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory connectionFactory) {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		return redisTemplate;
	}

}
