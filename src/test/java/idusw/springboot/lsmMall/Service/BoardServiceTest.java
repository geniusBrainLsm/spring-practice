package idusw.springboot.lsmMall.Service;

import idusw.springboot.lsmMall.model.BlogDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardServiceTest {
    //@Autowired BoardRepository boardRepository;
    @Test
    public void initBlogs() {
        BlogDTO blogDTO = BlogDTO.builder()
                .title()
                //todo: 이것도
                .build();

        //blogRepository.save()
    }

}
