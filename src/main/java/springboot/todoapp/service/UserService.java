package springboot.todoapp.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.session.StandardSession;
import org.springframework.stereotype.Service;
import springboot.todoapp.model.Org;
import springboot.todoapp.model.User;
import springboot.todoapp.model.UserOrgConnection;
import springboot.todoapp.repository.OrgRepository;
import springboot.todoapp.repository.UserOrgConnectionRepository;
import springboot.todoapp.repository.UserRepository;
import springboot.todoapp.session.SessionManager;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final OrgRepository orgRepository;

    private final UserOrgConnectionRepository connectionRepository;

    private final SessionManager sessionManager;

    private final BoardService boardService;

    public User getUser(Long id){
        return userRepository.findById(id).get();
    }

    public Org login(User user, HttpServletResponse response) {

        if (user.getUserId() == null || user.getPassword() == null) {
            return null;
        }
        Optional<User> findUser = userRepository.findByUserId(user.getUserId());
        sessionManager.createSession(findUser.get(), response);
        List<UserOrgConnection> orgList = findUser.get().getOrgList();
        return orgList.get(0).getOrg();

    }

    public User signUp(User user){
        if (user.getUsername() == null || user.getPassword() == null) {
            return null;
        }
        if(userRepository.findByUserId(user.getUserId()).isPresent()){
            return null;
        }
        else{
            Org org = user.addOrg();
            orgRepository.save(org);
            org = boardService.addBoard(org.getId());
            UserOrgConnection connection = new UserOrgConnection();
            connection.setUser(user);
            connection.setOrg(org);
            connectionRepository.save(connection);
            User signUpUser = userRepository.save(user);
            return signUpUser;
        }
    }

    public User certificationCheck(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        Cookie cookie;
        try {
            cookie = Arrays.stream(cookies)
                    .filter(c -> c.getName().equals("mySessionId"))
                    .findAny()
                    .orElse(null);
        }
        catch (NullPointerException e){
            return null;
        }
        return sessionManager.getSession(request);

    }

}