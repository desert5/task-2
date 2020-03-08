package task2.rating.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import task2.common.Constants;

@SpringBootTest
@EmbeddedKafka(
		topics = Constants.KAFKA_TOPIC,
		partitions = 1,
		brokerProperties = {
		"listeners=PLAINTEXT://localhost:8081",
		"port=8081"})
class RatingCalculatorApplicationTests {

	@Test
	void contextLoads() {
	}

}
