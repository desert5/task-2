package task2.data.collector.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import task2.data.collector.model.DataCollectionRequest;
import task2.data.collector.service.DataCollectorService;

@RestController
public class DataCollectorEndpoint {

    private final Logger logger = LoggerFactory.getLogger(DataCollectorEndpoint.class);
    private DataCollectorService service;

    @Autowired
    public DataCollectorEndpoint(DataCollectorService service) {
        this.service = service;
    }

    @PostMapping(value = "/collect")
    public void collectData(DataCollectionRequest request) {
        logger.info("Received request to endpoint: " + request.toString());
        service.collectData(request);
    }

    @GetMapping(value = "/test")
    public void test() {
        logger.info("Received request to test endpoint");
        service.collectTestData("hello");
    }
}
