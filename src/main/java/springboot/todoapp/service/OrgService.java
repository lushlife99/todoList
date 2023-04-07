package springboot.todoapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.todoapp.model.Org;
import springboot.todoapp.model.User;
import springboot.todoapp.model.UserOrgConnection;
import springboot.todoapp.repository.OrgRepository;
import springboot.todoapp.repository.UserOrgConnectionRepository;
import springboot.todoapp.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrgService {


    private final OrgRepository orgRepository;
    private final UserRepository userRepository;
    private final UserOrgConnectionRepository userOrgConnectionRepository;


    public Org getOrg(Long orgId){
        return orgRepository.findById(orgId).get();
    }

    public Org addOrg(User user){
        User findUser = userRepository.findByUserId(user.getUserId()).get();
        Org org = findUser.addOrg();
        UserOrgConnection userOrgConnection = new UserOrgConnection();
        userOrgConnection.setOrg(org);
        userOrgConnection.setUser(findUser);
        userOrgConnectionRepository.save(userOrgConnection);
        userRepository.save(findUser);
        return orgRepository.save(org);
    }

    public void updateOrg(Org org){
        Org findOrg = orgRepository.findById(org.getId()).get();
        orgRepository.save(findOrg.setOrg(org));
    }


}
