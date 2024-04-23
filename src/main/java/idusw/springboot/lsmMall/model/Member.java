package idusw.springboot.lsmMall.model;

import lombok.*;

@Data
@Builder
public class Member { // DTO
    private Long idx;
    private String id;
    private String pw;
    private String name;
    private String email;

}
