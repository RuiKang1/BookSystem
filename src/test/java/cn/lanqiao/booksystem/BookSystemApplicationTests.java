package cn.lanqiao.booksystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@SpringBootApplication(exclude= {SecurityAutoConfiguration.class })
class BookSystemApplicationTests {

    @Test
    void contextLoads() {
    }

}
