package task2.rating.calculator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import task2.common.model.KafkaMessage;

@Service
public class RatingCalculationService {
    private final Logger logger = LoggerFactory.getLogger(RatingCalculationService.class);
    private KafkaMessage message;

    @KafkaListener(topics = "rating", groupId = "group_id")
    public void consumeMessage(String message) {
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }
}
