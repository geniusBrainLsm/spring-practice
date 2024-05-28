package idusw.springboot.lsmMall.Service;

import idusw.springboot.lsmMall.entity.MemberEntity;
import idusw.springboot.lsmMall.model.MemberDTO;
import idusw.springboot.lsmMall.repository.MemberRepository;
import idusw.springboot.lsmMall.service.MemberService;
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
    @Autowired
    MemberService memberService;
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
        MemberDTO member = memberService.readById(2L);
        if(member != null){
            System.out.println("read success" + member.toString());
        } else{
            System.out.println("read fail");
        }
//        Optional<MemberEntity> optionalMember = memberRepository.findById(1L);
//
//        if (optionalMember.isPresent()) {
//            System.out.println("success");
//        }
    }

    @Test
    public void readAll() {
        List<MemberEntity> memberList = memberRepository.findAll();

    }
}
