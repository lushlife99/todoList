package springboot.todoapp.controller.api;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springboot.todoapp.model.Org;
import springboot.todoapp.model.User;
import springboot.todoapp.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PutMapping("/login")
    public Org Login(@RequestBody User user, HttpServletResponse response) {
        System.out.println("UserController.Login");
        return userService.login(user, response);


    }

    @PostMapping("/join")
    public void join(@RequestBody User user, HttpServletRequest request)
    {
        userService.signUp(user);
    }

    @GetMapping("/{id}")
    public User test(@PathVariable Long id){
        System.out.println("UserController.test");
        return userService.getUser(id);
    }
}