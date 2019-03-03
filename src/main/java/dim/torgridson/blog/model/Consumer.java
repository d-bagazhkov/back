package dim.torgridson.blog.model;

import lombok.Data;

@Data
public class Consumer {

    private Long id;
    private String userName;
    private String password;
    private String email;

}
