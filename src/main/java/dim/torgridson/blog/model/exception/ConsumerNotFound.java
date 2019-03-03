package dim.torgridson.blog.model.exception;

public class ConsumerNotFound extends ResponseError {

    private static final ResultCode rc = ResultCode.CONSUMER_NOT_FOUND;

    public ConsumerNotFound() {
    }

    public ConsumerNotFound(String desc) {
        super(desc);
    }

    @Override
    public ResultCode getResultCode() {
        return rc;
    }

}
