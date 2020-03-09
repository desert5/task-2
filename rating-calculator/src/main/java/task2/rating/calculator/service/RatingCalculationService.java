package task2.rating.calculator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import task2.common.Constants;
import task2.common.model.KafkaMessage;

@Service
public class RatingCalculationService {
    private final Logger logger = LoggerFactory.getLogger(RatingCalculationService.class);
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public RatingCalculationService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @KafkaListener(topics = Constants.KAFKA_TOPIC, groupId = "group_id")
    public void consumeMessage(KafkaMessage message) {
        logger.info("Received message from Kafka: " + message.toString());
        double rating = message.getAge() * message.getSeed();
        logger.info(message.getFirstName() + " " + message.getLastName() + " has a " + rating + " score");
        String username = message.getFirstName() + "_" + message.getLastName();
        redisTemplate.opsForValue().set(username, rating);
        logger.info("Redis is now containing value " + redisTemplate.opsForValue().get(username) + " for key " + username);
    }
}
