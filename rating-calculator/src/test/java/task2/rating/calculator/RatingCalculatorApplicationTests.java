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
		"listeners=PLAINTEXT://localhost:9092",
		"port=9092"})
class RatingCalculatorApplicationTests {

	@Test
	void contextLoads() {
	}

}
