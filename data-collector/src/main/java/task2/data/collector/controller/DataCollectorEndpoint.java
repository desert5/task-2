package task2.data.collector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import task2.data.collector.service.DataCollectorService;
import task2.data.collector.model.DataCollectionRequest;

@RestController
public class DataCollectorEndpoint {

    private DataCollectorService service;

    @Autowired
    public DataCollectorEndpoint(DataCollectorService service) {
        this.service = service;
    }

    @PostMapping(value = "/collect")
    public void collectData(DataCollectionRequest request) {
        service.collectData(request);
    }
}
