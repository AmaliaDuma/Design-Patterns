package amalia.labproject;

import amalia.labproject.service.DataService;
import amalia.labproject.view.View;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LabProjectApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(LabProjectApplication.class, args);
        DataService service = new DataService();
        View view = new View(service);
        view.run();
    }

}
