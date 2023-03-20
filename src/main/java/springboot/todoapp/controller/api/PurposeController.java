package springboot.todoapp.controller.api;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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
    public Long addPurpose(@RequestBody Integer boardId, HttpServletRequest request){
        return purposeService.addPurpose(boardId).getId();

    }

    @DeleteMapping("/purpose/{purposeId}")
    public Long deletePurpose(@PathVariable Integer purposeId, HttpServletRequest request){
        return purposeService.deletePurpose(purposeId);
    }

    @PutMapping("/purpose")
    public Long updatePurpose(@RequestBody Purpose purpose, HttpServletRequest request){
        return purposeService.updatePurpose(purpose);
    }
}
