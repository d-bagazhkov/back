package dim.torgridson.blog.model;

import lombok.Data;

@Data
public class ResultResponse<D> {

    private D data;

    public ResultResponse() {
    }

    public ResultResponse(D data) {
        this.data = data;
    }

}
