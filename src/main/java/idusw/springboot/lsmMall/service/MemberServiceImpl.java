package idusw.springboot.lsmMall.service;

import idusw.springboot.lsmMall.entity.MemberEntity;
import idusw.springboot.lsmMall.model.MemberDTO;
import idusw.springboot.lsmMall.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    @Override
    public MemberDTO create(MemberDTO memberDTO) {

        MemberEntity memberEntity = MemberEntity.builder()
                .idx(memberDTO.getIdx())
                .id("asd")
                .name(memberDTO.getName())
                .email(memberDTO.getEmail())
                .pw(memberDTO.getPw())
                .build();

        MemberEntity savedEntity = memberRepository.save(memberEntity);

        return MemberDTO.builder()
                .idx(savedEntity.getIdx())
                .id("asd")
                .name(savedEntity.getName())
                .email(savedEntity.getEmail())
                .pw(savedEntity.getPw())
                .build();
    }

    @Override
    public MemberDTO readById(Long idx) {
        return null;
    }

    @Override
    public List<MemberDTO> readAll() {
        return null;
    }

    @Override
    public void update(MemberDTO member) {

    }

    @Override
    public void delete(MemberDTO member) {

    }

    @Override
    public MemberDTO loginById(MemberDTO memberDTO) {
        Optional<MemberEntity> optionalMember = memberRepository.findByEmail(memberDTO.getEmail());

        if (optionalMember.isPresent()) {
            MemberEntity memberEntity = optionalMember.get();

            if (memberEntity.getPw().equals(memberDTO.getPw())) {
                return fromEntity(memberEntity);
            }
        }

        return null;
    }
}
