package task2.data.collector.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import task2.common.Constants;
import task2.common.model.KafkaMessage;
import task2.data.collector.model.DataCollectionRequest;

@Service
public class DataCollectorService {

    private Double calculationSeed;
    private KafkaTemplate<String, String> kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(DataCollectorService.class);
    private KafkaMessage message;

    @Autowired
    public DataCollectorService(@Value("${calculation.seed}") Double calculationSeed, KafkaTemplate<String, String> kafkaTemplate) {
        this.calculationSeed = calculationSeed;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void collectData(DataCollectionRequest data) {
        logger.info("Received request to service: " + data.toString());
        kafkaTemplate.send(Constants.KAFKA_TOPIC, "hello");
    }

    public void collectTestData(String data) {
        logger.info("Received test request to service: " + data);
        kafkaTemplate.send(Constants.KAFKA_TOPIC, data);
    }
}
