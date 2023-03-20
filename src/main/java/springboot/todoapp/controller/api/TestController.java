package springboot.todoapp.controller.api;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class TestController {

    @PostMapping("/Sessiontest")
    public String test(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        Cookie cookie;
        try {
            cookie = Arrays.stream(cookies)
                    .filter(c -> c.getName().equals("mySessionId"))
                    .findAny()
                    .orElse(null);
        }
        catch (NullPointerException e){
            return "No";
        }

        if(cookie == null){
            return "No";
        }
        return "Yes";
    }
}
