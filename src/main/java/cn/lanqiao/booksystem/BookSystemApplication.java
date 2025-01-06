package cn.lanqiao.booksystem;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@MapperScan("cn.lanqiao.booksystem.mapper")
public class BookSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookSystemApplication.class, args);

    }
}
