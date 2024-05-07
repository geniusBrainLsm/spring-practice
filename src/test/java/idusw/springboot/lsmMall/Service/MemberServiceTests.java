package idusw.springboot.lsmMall.Service;

import idusw.springboot.lsmMall.entity.MemberEntity;
import idusw.springboot.lsmMall.model.MemberDTO;
import idusw.springboot.lsmMall.repository.MemberRepository;
import jakarta.persistence.Table;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootTest
public class MemberServiceTests {
    @Autowired
    MemberRepository memberRepository;
    @Test
    public void registerMember() {
        MemberEntity memberEntity = MemberEntity.builder()
                .id("dream")
                .pw("cometrue")
                .name("lsm")
                .email("qaz@qaz.qaz")
                .build();
    }

    @Test
    public void loginMember() {
        Optional<MemberEntity> optionalMember = memberRepository.findByEmail("asd@asd.asd");

        if (optionalMember.isPresent()) {
            System.out.println("success");
        }
    }

    @Test
    public void readMemberByIdx() {
        Optional<MemberEntity> optionalMember = memberRepository.findById(1L);

        if (optionalMember.isPresent()) {
            System.out.println("success");
        }
    }

    @Test
    public void readAll() {
        List<MemberEntity> memberList = memberRepository.findAll();

    }
}
