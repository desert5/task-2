package task2.data.collector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import task2.data.collector.model.DataCollectionRequest;

@Service
public class DataCollectorService {

    private Double calculationSeed;
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public DataCollectorService(@Value("${calculation.seed}") Double calculationSeed, KafkaTemplate<String, String> kafkaTemplate) {
        this.calculationSeed = calculationSeed;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void collectData(DataCollectionRequest data) {
        kafkaTemplate.send("topic", "msg");
    }
}
