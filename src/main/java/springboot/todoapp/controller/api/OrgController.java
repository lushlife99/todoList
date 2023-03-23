package springboot.todoapp.controller.api;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springboot.todoapp.model.Org;
import springboot.todoapp.repository.OrgRepository;
import springboot.todoapp.service.OrgService;

@RestController
@RequiredArgsConstructor
public class OrgController {


    private final OrgRepository orgRepository;
    private final OrgService orgService;


    @PutMapping("/org")
    public void updateOrg(@RequestBody Org org){
        System.out.println("OrgController.updateOrg");
        orgService.updateOrg(org);
    }
}
