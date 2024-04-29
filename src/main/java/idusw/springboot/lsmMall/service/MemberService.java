package idusw.springboot.lsmMall.service;

import idusw.springboot.lsmMall.entity.MemberEntity;
import idusw.springboot.lsmMall.model.MemberDTO;

import java.util.List;

public interface MemberService {
    MemberDTO create(MemberDTO memberDTO);
    MemberDTO readById(Long idx);
    List<MemberDTO> readAll();
    void update(MemberDTO member);
    void delete(MemberDTO member);

    MemberDTO loginById(MemberDTO member);

    default MemberEntity toEntity(MemberDTO member){
        MemberEntity entity = MemberEntity.builder()
                .idx(member.getIdx())
                .id(member.getId())
                .pw(member.getPw())
                .build();

        return entity;
    }

    default MemberDTO fromEntity(MemberEntity entity){
        MemberDTO member = MemberDTO.builder()
                .idx(entity.getIdx())
                .id(entity.getId())
                .pw(entity.getPw())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
        return member;
    }
}
