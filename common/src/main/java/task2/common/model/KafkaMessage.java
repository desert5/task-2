package task2.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class KafkaMessage {
    private String firstName;
    private String lastName;
    private Integer age;
    private Double seed;
}
