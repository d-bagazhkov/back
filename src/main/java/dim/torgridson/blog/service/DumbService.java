package dim.torgridson.blog.service;

import dim.torgridson.blog.model.Consumer;
import dim.torgridson.blog.model.ResultResponse;
import dim.torgridson.blog.model.exception.ConsumerNotFound;
import dim.torgridson.blog.model.exception.ConsumerWillBeExistException;
import dim.torgridson.blog.model.exception.CreateEntryException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DumbService {

    private Set<Consumer> consumers = new HashSet<>();

    @PostConstruct
    private void init() {
        this.consumers.addAll(new HashSet<>());
    }

    public ResultResponse<Consumer> addConsumer(Consumer consumer) {
        if (consumers.stream().anyMatch(c -> consumer.getId() == null || consumer.getId().equals(c.getId())))
            throw new ConsumerWillBeExistException();
        if (!consumers.add(consumer)) {
            throw new CreateEntryException("Consumer will be exist");
        }
        return new ResultResponse<>(consumer);
    }

    public ResultResponse<Consumer> deleteConsumer(Long id) {
        Consumer c = consumers.stream().filter(c1 -> id.equals(c1.getId())).findFirst().orElse(null);
        if (c == null) throw new ConsumerNotFound();
        consumers = consumers.stream()
                .filter(c2 -> !c2.getId().equals(id))
                .collect(Collectors.toSet());
        return new ResultResponse<>(c);
    }

    public ResultResponse<Consumer> updateConsumer(Consumer consumer) {
        Consumer oldConsumer = getConsumerById(consumer.getId()).getData();
        deleteConsumer(consumer.getId());
        if (consumer.getUserName() != null && !oldConsumer.getUserName().equals(consumer.getUserName()))
            oldConsumer.setUserName(consumer.getUserName());
        if (consumer.getPassword() != null && !oldConsumer.getPassword().equals(consumer.getPassword()))
            oldConsumer.setPassword(consumer.getPassword());
        if (consumer.getEmail() != null && !oldConsumer.getEmail().equals(consumer.getEmail()))
            oldConsumer.setEmail(consumer.getEmail());
        return addConsumer(oldConsumer);
    }

    public ResultResponse<Consumer> getConsumerById(Long id) {
        Consumer c = consumers.stream()
                .filter(consumer -> id.equals(consumer.getId()))
                .findFirst()
                .orElse(null);
        if (c == null) throw new ConsumerNotFound();
        return new ResultResponse<>(c);
    }

    public ResultResponse<Set<Consumer>> getAllConsumers() {
        return new ResultResponse<>(consumers);
    }

}
