package dim.torgridson.blog.controller;

import dim.torgridson.blog.anotation.CatchException;
import dim.torgridson.blog.model.Consumer;
import dim.torgridson.blog.model.ResultResponse;
import dim.torgridson.blog.model.exception.ConsumerNotFound;
import dim.torgridson.blog.model.exception.CreateEntryException;
import dim.torgridson.blog.model.exception.ResponseError;
import dim.torgridson.blog.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    private ConsumerService consumerService;

    @CatchException
    @PostMapping("/create/")
    public ResultResponse<Consumer> createConsumer(@RequestBody Consumer consumer) {
        return consumerService.createConsumer(consumer);
    }

    @CatchException
    @PostMapping("/update/")
    public ResultResponse<Consumer> updateConsumer(@RequestBody Consumer consumer) {
        return consumerService.updateConsumer(consumer);
    }

    @CatchException
    @GetMapping("/delete/{id}")
    public ResultResponse<Consumer> deleteConsumer(@PathVariable Long id) {
        return consumerService.deleteConsumer(id);
    }

    @CatchException
    @GetMapping("/get/{id}")
    public ResultResponse<Consumer> getConsumer(@PathVariable Long id) {
        return consumerService.getConsumer(id);
    }

    @CatchException
    @GetMapping("/get/all")
    public ResultResponse<Set<Consumer>> getConsumers() {
        return consumerService.getAllConsumers();
    }

    @Autowired
    public void setConsumerService(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }
}
