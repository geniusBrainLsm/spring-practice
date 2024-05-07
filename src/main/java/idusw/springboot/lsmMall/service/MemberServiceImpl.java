package idusw.springboot.lsmMall.service;

import idusw.springboot.lsmMall.entity.MemberEntity;
import idusw.springboot.lsmMall.model.MemberDTO;
import idusw.springboot.lsmMall.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    @Override
    public MemberDTO create(MemberDTO memberDTO) {

        MemberEntity memberEntity = MemberEntity.builder()
                .idx(memberDTO.getIdx())
                .id("asd")
                //.id(memberDTO.getId())
                //이거추가
                .name(memberDTO.getName())
                .email(memberDTO.getEmail())
                .pw(memberDTO.getPw())
                .build();

        MemberEntity savedEntity = memberRepository.save(memberEntity);

        return MemberDTO.builder()
                .idx(savedEntity.getIdx())
                .id("asd")
                //.id(memberDTO.getId())

                .name(savedEntity.getName())
                .email(savedEntity.getEmail())
                .pw(savedEntity.getPw())
                .build();
    }

    @Override
    public MemberDTO readById(Long idx) {
        MemberEntity member = memberRepository.findById(idx)
                .orElseThrow(() -> new IllegalArgumentException("없음: " + idx));
        return fromEntity(member);
    }

    @Override
    public List<MemberDTO> readAll() {
        List<MemberEntity> memberList = memberRepository.findAll();

        return memberList.stream()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MemberDTO update(MemberDTO memberDTO) {
        MemberEntity memberEntity = memberRepository.findById(memberDTO.getIdx())
                .orElseThrow(() -> new IllegalArgumentException("Member not found with id: " + memberDTO.getIdx()));

        MemberEntity updatedMemberEntity = MemberEntity.builder()
                .idx(memberEntity.getIdx())
                .id(memberDTO.getId())
                .name(memberDTO.getName())
                .email(memberDTO.getEmail())
                .pw(memberDTO.getPw())
                .build();

        updatedMemberEntity = memberRepository.save(updatedMemberEntity);

        return MemberDTO.builder()
                .idx(updatedMemberEntity.getIdx())
                .id(updatedMemberEntity.getId())
                .name(updatedMemberEntity.getName())
                .email(updatedMemberEntity.getEmail())
                .pw(updatedMemberEntity.getPw())
                .build();
    }

    @Override
    public void delete(Long idx) {
        memberRepository.deleteById(idx);
    }

    @Override
    public MemberDTO loginById(MemberDTO memberDTO) {
        //Optional<MemberEntity> optionalMember = memberRepository.findByEmail(memberDTO.getEmail());
        Optional<MemberEntity> optionalMember = memberRepository.findById(memberDTO.getId());

        if (optionalMember.isPresent()) {
            MemberEntity memberEntity = optionalMember.get();

            if (memberEntity.getPw().equals(memberDTO.getPw())) {
                return fromEntity(memberEntity);
            }
        }

        return null;
    }
}
