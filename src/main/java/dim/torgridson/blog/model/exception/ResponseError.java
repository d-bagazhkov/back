package dim.torgridson.blog.model.exception;

public abstract class ResponseError extends RuntimeException {

    public ResponseError(String desc) {
        super(desc);
    }

    public ResponseError() {
    }

    public abstract ResultCode getResultCode();

}
