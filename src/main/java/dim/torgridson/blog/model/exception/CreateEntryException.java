package dim.torgridson.blog.model.exception;

public class CreateEntryException extends ResponseError {

    private static final ResultCode rc = ResultCode.CREATE_ENTRY_EXCEPTION;

    public CreateEntryException() {
    }

    public CreateEntryException(String desc) {
        super(desc);
    }

    @Override
    public ResultCode getResultCode() {
        return rc;
    }

}
