package springboot.todoapp.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import springboot.todoapp.repository.OrgRepository;

@RestController
public class OrgController {

    @Autowired
    OrgRepository orgRepository;

}
