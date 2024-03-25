package idusw.springboot.lsmMall.service;


import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl2 implements  HomeService {

    @Override
    public void sayHello() {
        for(int i=0; i<5; i++)
            System.out.println("service - say hello");
    }
}
