package idusw.springboot.lsmMall.controller;

import idusw.springboot.lsmMall.entity.MemberEntity;
import idusw.springboot.lsmMall.model.MemberDTO;
import idusw.springboot.lsmMall.repository.MemberRepository;
import idusw.springboot.lsmMall.service.MemberServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberServiceImpl memberService;
    private final MemberRepository memberRepository;

    @GetMapping("members/{id}")
    public String getById(@PathVariable String id, Model model) {
        //Member member = new Member();
        MemberDTO member = MemberDTO.builder().build();
        member.setId(id);
        model.addAttribute("member", member);
        return "./main/index";
    }

    @GetMapping("members/login")
    public String getLogin(Model model) {
        model.addAttribute("member", MemberDTO.builder().build());
        return "./main/login";
    }

    @PostMapping("/members/login")
    public String postLogin(@ModelAttribute("member") MemberDTO memberDTO, Model model, HttpSession session) {

        System.out.println(memberDTO.getEmail());
        MemberDTO authenticatedMember = memberService.loginById(memberDTO);
        System.out.println(authenticatedMember);
        String msg;
        if (authenticatedMember != null) {
            session.setAttribute("id", authenticatedMember.getName());
            msg = "Login successful";
        } else {
            msg = "Login failed";
        }

        model.addAttribute("message", msg);
        model.addAttribute("member", memberDTO);

        return "./main/400";
    }

    @GetMapping("/members/register")
    public String getRegister() {
        return "./main/register";
    }

    @PostMapping("/members/register")
    public String postRegister(@ModelAttribute MemberDTO memberDTO, Model model) {
        Optional<MemberEntity> optionalMember = memberRepository.findByEmail(memberDTO.getEmail());
        String msg;

        if (optionalMember.isPresent()) {
            msg = "이미 존재하는 회원";
            model.addAttribute("message", msg);
            return "./main/400";
        } else {
            memberService.create(memberDTO);
            msg = "회원가입 성공";
            model.addAttribute("message", msg);
            return "./main/400";
        }
    }


    @GetMapping("/members/{idx}")
    public String getMember(@PathVariable("idx") Long idx, Model model) {
        MemberDTO result = memberService.readById(idx);
        model.addAttribute("member", result);
        return "./main/detail";

    }

    @GetMapping("/members")
    public String getMembers(Model model){
        List<MemberDTO> members = memberService.readAll();
        if(members != null){
            model.addAttribute("memberlist", members);
        }
        else {
            model.addAttribute("message", "회원목록 조회 실패");
            return "./main/400";
        }
        return "./members/list";
    }


    @GetMapping("/members/update")
    public String getUpdate() {
        return "./main/update";
    }


    @PutMapping("/members/update")
    public String putUpdate(@ModelAttribute MemberDTO memberDTO, Model model) {
        return "./main/400";
    }
    @GetMapping("/members/logout")
    public String getLogout (HttpSession session){
        //session.setAttribute("id", ""); //or invalidate();
        session.invalidate();
        return "redirect:/";
    }
}
