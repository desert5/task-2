package task2.data.collector.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DataCollectionRequest {
    private String firstName;
    private String lastName;
    private Integer age;
}
