package website.okunoda.secondtokill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("website.okunoda.secondtokill.pojo")
@ComponentScan("website.okunoda.*")
public class SecondToKillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondToKillApplication.class, args);
    }

}
