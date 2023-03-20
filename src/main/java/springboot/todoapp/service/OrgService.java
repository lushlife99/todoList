package springboot.todoapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.todoapp.model.Org;
import springboot.todoapp.model.User;
import springboot.todoapp.model.UserOrgConnection;
import springboot.todoapp.repository.OrgRepository;
import springboot.todoapp.repository.UserOrgConnectionRepository;
import springboot.todoapp.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrgService {


    private final OrgRepository orgRepository;
    private final UserRepository userRepository;
    private final UserOrgConnectionRepository userOrgConnectionRepository;


    public Org getOrg(Integer orgId){
        return orgRepository.findById(orgId).get();
    }

    public Org addOrg(User user){
        Org org = user.addOrg();
        return orgRepository.save(org);
    }


}
