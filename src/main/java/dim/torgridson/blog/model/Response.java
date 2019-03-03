package dim.torgridson.blog.model;

import dim.torgridson.blog.model.exception.ResultCode;

public class Response {

    private ResultCode code = ResultCode.OK;
    private Error error;

    public void setError(String message, Throwable throwable) {
        this.error = new Error(message, throwable);
    }

    private class Error {
        private String message;
        private Throwable throwable;

        public Error(String message, Throwable throwable) {
            this.message = message;
            this.throwable = throwable;
        }
    }

}
