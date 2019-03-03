package dim.torgridson.blog.model.exception;

public class UnknownError extends ResponseError {
    private static final ResultCode rc = ResultCode.UNKNOWN_EXCEPTION;

    public UnknownError(String desc) {
        super(desc);
    }

    public UnknownError() {
    }

    @Override
    public ResultCode getResultCode() {
        return rc;
    }

}
