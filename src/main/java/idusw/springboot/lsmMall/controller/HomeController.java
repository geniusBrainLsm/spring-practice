package idusw.springboot.lsmMall.controller;

import idusw.springboot.lsmMall.model.MemberDTO;
import idusw.springboot.lsmMall.service.HomeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final HomeService homeService;

    @GetMapping(value = { "/",""})
//    public String goLogin(){
//        return "redirect:/members/login";
//    }
    public String goMain() {return "main/index2";}

    @GetMapping(value = { "/1"})
    public String getRoot(HttpServletRequest request, Model model){
        homeService.sayHello();
        model.addAttribute("greeting",request.getParameter("name"));
        return "main/index";
    }


    @GetMapping("/2")
    public String getIndex2(@RequestParam Map<String, String> param , Model model){
        MemberDTO member = MemberDTO.builder().build();
        member.setId("lsm");
        member.setName(param.get("name"));
        member.setEmail("asd@asd.asd");

        // spring에서 Ui를 통해  view에게 전달할 때 사용하는 객체: Model model
        model.addAttribute("member",member);
        // model ==  dto (data transfer object) - 데이터를 주고받기 위한 목적
        // -- dto --> service -- dto --> repository -> service -> controller -> view
        return "main/index2"; // view
    }

}
