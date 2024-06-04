package idusw.springboot.lsmMall.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Builder
public class BlogDTO {
    private Long bno;

    private String title;

    private String content;

    private Long views;

    private String block; //차단

    private Long writerMno;

    private String writerEmail;

    private String writerName;

    private LocalDateTime regDate;

    private LocalDateTime modDate;
}
