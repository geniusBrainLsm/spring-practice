package idusw.springboot.lsmMall.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Builder
@Table(name="member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    @Column(length = 20,nullable = true)
    private String id;
    @Column(length = 20,nullable = true)
    private String pw;
    @Column(length = 20)
    private String name;
    @Column(length = 50,nullable = false)
    private String email;

    @OneToMany(mappedBy = "writer")
    private List<BlogEntity> blogEntity;
 //todo: repository만들기.
}
