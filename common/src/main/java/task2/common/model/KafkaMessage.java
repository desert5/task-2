package task2.common.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class KafkaMessage {
    private String firstName;
    private String lastName;
    private Integer age;
    private Double seed;
}
