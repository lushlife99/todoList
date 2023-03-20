package springboot.todoapp.controller.api;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.todoapp.model.Org;
import springboot.todoapp.repository.BoardRepository;
import springboot.todoapp.service.BoardService;

@RestController
public class BoardController {

    @Autowired
    BoardService boardService;

    @PostMapping("/board/{orgId}")
    public Long addBoard(@PathVariable Integer orgId, HttpServletRequest request){
        System.out.println("orgId = " + orgId);
        return boardService.addBoard(orgId).getId();

    }

    @DeleteMapping("/board/{boardId}")
    public Long deleteBoard(@PathVariable Integer boardId, HttpServletRequest request){
        System.out.println("boardId = " + boardId);
        return boardService.deleteBoard(boardId);

    }

}
