package idusw.springboot.lsmMall.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@Table(name="board")
@ToString(exclude = "writer")
@AllArgsConstructor
@NoArgsConstructor
public class BlogEntity extends BaseEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Id
    private Long bno;
    private String title;

    private String content;

    private Long views;

    private String block;

    @ManyToOne(fetch = FetchType.LAZY)
    private MemberEntity writer;
}
