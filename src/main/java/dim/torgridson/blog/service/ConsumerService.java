package dim.torgridson.blog.service;

import dim.torgridson.blog.model.Consumer;
import dim.torgridson.blog.model.ResultResponse;
import dim.torgridson.blog.model.exception.ConsumerNotFound;
import dim.torgridson.blog.model.exception.CreateEntryException;
import dim.torgridson.blog.model.exception.ResponseError;
import dim.torgridson.blog.model.exception.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ConsumerService {

    @Value("${dumb:false}")
    private Boolean dumb;
    private DumbService dumbService;

    public ResultResponse<Consumer> createConsumer(Consumer consumer) {
        if (dumb) {
            return dumbService.addConsumer(consumer);
        }
        throw new CreateEntryException();
    }

    public ResultResponse<Consumer> deleteConsumer(Long id) {
        if (dumb) {
            return dumbService.deleteConsumer(id);
        }
        throw new ConsumerNotFound();
    }

    public ResultResponse<Consumer> getConsumer(Long id) {
        if (dumb) {
            return dumbService.getConsumerById(id);
        }
        throw new ConsumerNotFound();
    }

    public ResultResponse<Consumer> updateConsumer(Consumer consumer) {
        if (dumb) {
            return dumbService.updateConsumer(consumer);
        }
        throw new ConsumerNotFound();
    }

    public ResultResponse<Set<Consumer>> getAllConsumers() {
        if (dumb) {
            return dumbService.getAllConsumers();
        }
        throw new ResponseError() {
            @Override
            public ResultCode getResultCode() {
                return ResultCode.UNKNOWN_EXCEPTION;
            }

        };
    }

    @Autowired
    public void setDumbService(DumbService dumbService) {
        this.dumbService = dumbService;
    }
}
