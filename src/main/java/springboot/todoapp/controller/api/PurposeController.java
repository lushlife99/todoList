package springboot.todoapp.controller.api;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springboot.todoapp.model.Org;
import springboot.todoapp.model.Purpose;
import springboot.todoapp.model.User;
import springboot.todoapp.service.PurposeService;
import springboot.todoapp.session.SessionManager;

@RestController
@RequiredArgsConstructor
public class PurposeController {

    private final PurposeService purposeService;

    private final SessionManager sessionManager;
    @PostMapping("/purpose")
    public Org addPurpose(@RequestBody Long boardId, HttpServletRequest request){
        return purposeService.addPurpose(boardId);

    }

    @DeleteMapping("/purpose/{purposeId}")
    public Org deletePurpose(@PathVariable Long purposeId, HttpServletRequest request){
        return purposeService.deletePurpose(purposeId);
    }

    @PutMapping("/purpose")
    public Org updatePurpose(@RequestBody Purpose purpose, HttpServletRequest request){
        return purposeService.updatePurpose(purpose);
    }
}
