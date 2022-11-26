package ua.lviv.lgs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import ua.lviv.lgs.service.StudentService;

@SpringBootApplication
@ComponentScan(basePackages = "ua.lviv.lgs.*")
@ComponentScan(basePackageClasses = {StudentService.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
