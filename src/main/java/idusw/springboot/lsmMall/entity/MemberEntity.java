package idusw.springboot.lsmMall.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(length = 20,nullable = false)
    private String id;
    @Column(length = 20,nullable = false)
    private String pw;
    @Column(length = 20)
    private String name;
    @Column(length = 20,nullable = false)
    private String email;


}
