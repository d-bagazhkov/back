package dim.torgridson.blog.model.exception;

public class ConsumerWillBeExistException extends ResponseError {
    private static final ResultCode rc = ResultCode.CONSUMER_WILL_BE_EXIST;

    public ConsumerWillBeExistException(String desc) {
        super(desc);
    }

    public ConsumerWillBeExistException() {
    }

    @Override
    public ResultCode getResultCode() {
        return rc;
    }

}
