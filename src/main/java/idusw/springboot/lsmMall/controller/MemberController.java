package idusw.springboot.lsmMall.controller;

import idusw.springboot.lsmMall.model.Member;
import idusw.springboot.lsmMall.service.MemberServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberServiceImpl memberService;
    @GetMapping("members/{id}")
    public String getById(@PathVariable String id, Model model){
        //Member member = new Member();
        Member member = Member.builder().build();
        member.setId(id);
        model.addAttribute("member", member);
        return "./main/index";
    }

    @GetMapping("members/login")
    public String getLogin(Model model){
        model.addAttribute("member", Member.builder().build());
        return "./main/login";
    }

    @GetMapping("members/register")
    public String getRegister(){
        return "./main/register";
    }

    @PostMapping("members/login")
    public String postLogin(@ModelAttribute("member") Member member, Model model, HttpSession session){
        String id = member.getId();
        String pw = member.getPw();

        Member m = Member.builder()
                .id(id)
                .pw(pw)
                .build();
        String msg="";

        Member ret = memberService.loginById(m);
        String dbId = ret.getId();
        String dbPw = ret.getPw();

        if(id.equals("induk") && pw.equals("comso")){
            session.setAttribute("id",id);
            msg="login success";
        }
        else
        {
            msg="login fail";
        }
        model.addAttribute("message", msg);
        return "./main/400";
    }

    @GetMapping("/members/logout")
    public String getLogout(HttpSession session){
        //session.setAttribute("id", ""); //or invalidate();
        session.invalidate();
        return "redirect:/";
    }

}
