package springboot.todoapp.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.todoapp.model.Org;
import springboot.todoapp.model.User;
import springboot.todoapp.repository.OrgRepository;
import springboot.todoapp.repository.UserRepository;
import springboot.todoapp.service.OrgService;
import springboot.todoapp.service.UserService;
import springboot.todoapp.session.SessionManager;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {
    private final UserService userService;
    private final OrgService orgService;
    private final SessionManager sessionManager;
    private final UserRepository userRepository;
    @GetMapping(value = {"/login","/"})
    public String LoginPage(){
        return "LoginForm";
    }

    @GetMapping("/join")
    public String JoinPage(){return "JoinForm";}

    @RequestMapping("/Org/{id}")
    public String HomePage(@PathVariable Long id, Model model, HttpServletRequest request){
        User user = userService.certificationCheck(request);
        if(user == null){
            return "LoginForm";
        }

        model.addAttribute("org", orgService.getOrg(id));
        model.addAttribute("connection", user.getOrgList());
        User findUser = user = userRepository.findById(user.getId()).get();
        model.addAttribute("user", findUser);
        System.out.println("user.getOrgList().size() = " + findUser.getOrgList().size());
        return "Org";
    }

    @RequestMapping("/Org/Edit")
    public String EditPage(HttpServletRequest request, Model model){
        User user = userService.certificationCheck(request);
        if(user == null){
            return "LoginForm";
        }
        model.addAttribute(user);
        return "Edit";
    }
    @RequestMapping("/invite")
    public String InvitePage(HttpServletRequest request, Model model){
        User user = userService.certificationCheck(request);
        if(user == null){
            return "LoginForm";
        }
        model.addAttribute(user);
        return "Invite";
    }




}