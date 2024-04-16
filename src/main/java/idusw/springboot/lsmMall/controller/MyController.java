package idusw.springboot.lsmMall.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping(value = {"my","my/"})
    public String printHelloWorld(HttpServletRequest request){
        return "<h1>" + request.getParameter("fav") + "</h1>";
    }


}
