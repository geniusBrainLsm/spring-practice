package idusw.springboot.lsmMall.service;

import idusw.springboot.lsmMall.entity.MemberEntity;
import idusw.springboot.lsmMall.model.Member;

import java.util.List;

public interface MemberService {
    void create(Member member);
    Member readById(Long idx);
    List<Member> readAll();
    void update(Member member);
    void delete(Member member);

    Member loginById(Member member);

    default MemberEntity toEntity(Member member){
        MemberEntity entity = MemberEntity.builder()
                .idx(member.getIdx())
                .id(member.getId())
                .pw(member.getPw())
                .build();

        return entity;
    }

    default Member fromEntity(MemberEntity entity){
        Member member = Member.builder()
                .idx(entity.getIdx())
                .id(entity.getId())
                .pw(entity.getPw())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
        return member;
    }
}
