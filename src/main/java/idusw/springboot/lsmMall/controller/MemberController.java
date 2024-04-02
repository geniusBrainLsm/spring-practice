package idusw.springboot.lsmMall.controller;

import idusw.springboot.lsmMall.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {
    @GetMapping("members/{id}")
    public String getById(@PathVariable String id, Model model){
        Member member = new Member();
        member.setId(id);
        model.addAttribute("member", member);
        return "./main/index";
    }

    @GetMapping("members/login")
    public String getLogin(Model model){
        model.addAttribute("member", new Member());
        return "./main/login";
    }

    @PostMapping("members/login")
    public String postLogin(@ModelAttribute("member") Member member, Model model){
        String id = member.getId();
        String pw = member.getPw();

        Member m = new Member();
        String msg="";
        if(id.equals("induk") && pw.equals("comso")){
            msg="login success";
        }
        else
        {
            msg="login fail";
        }
        model.addAttribute("message", msg);
        return "./main/400";
    }

}
