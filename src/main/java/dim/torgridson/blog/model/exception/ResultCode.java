package dim.torgridson.blog.model.exception;

public enum ResultCode {

    OK(0),
    UNKNOWN_EXCEPTION(1),
    CONSUMER_NOT_FOUND(2),
    CREATE_ENTRY_EXCEPTION(3),
    CONSUMER_WILL_BE_EXIST(4);

    private int code;

    ResultCode(int i) {
        this.code = i;
    }

    public int getCode() {
        return code;
    }
}
