package task2.rating.calculator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import task2.common.Constants;

@Service
public class RatingCalculationService {
    private final Logger logger = LoggerFactory.getLogger(RatingCalculationService.class);
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    public RatingCalculationService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @KafkaListener(topics = Constants.KAFKA_TOPIC, groupId = "group_id")
    public void consumeMessage(String message) {
        logger.info(String.format("#### -> Consumed message -> %s", message));
        redisTemplate.opsForValue().set("key", message);
    }
}
