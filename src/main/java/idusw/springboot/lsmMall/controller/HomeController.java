package idusw.springboot.lsmMall.controller;

import idusw.springboot.lsmMall.model.Member;
import idusw.springboot.lsmMall.service.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private HomeService homeService;
    public HomeController(HomeService homeService){   // loosely-coupled <- Ioc Container, DI
         this.homeService = homeService;
    }

    @GetMapping(value = {"/", "/1"}) // Get Method 요청으로 처리하라는 annotation
    public String getRoot(){
        homeService.sayHello();
        // model : dto (data transfer object) - 데이터를 주고받기 위한 목적
        // -- model --> service -- model --> repository -> service -> controller -> view
        return "main/index"; // view
    }
    @GetMapping("/2")
    public String getIndex2(Model model){
        Member member = new Member();
        member.setId("lsm");
        member.setName("이상민");
        member.setEmail("asd@asd.asd");

        // spring에서 Ui를 통해  view에게 전달할 때 사용하는 객체: Model model
        model.addAttribute("member",member);
        // model ==  dto (data transfer object) - 데이터를 주고받기 위한 목적
        // -- dto --> service -- dto --> repository -> service -> controller -> view
        return "main/index2"; // view
    }

}
