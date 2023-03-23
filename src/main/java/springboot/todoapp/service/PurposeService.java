package springboot.todoapp.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.todoapp.model.Board;
import springboot.todoapp.model.Org;
import springboot.todoapp.model.Purpose;
import springboot.todoapp.repository.BoardRepository;
import springboot.todoapp.repository.PurposeRepository;

import java.util.Optional;

@Service
public class PurposeService {

    @Autowired
    private PurposeRepository purposeRepository;

    @Autowired
    private BoardRepository boardRepository;

    public Org addPurpose(Integer boardId){
        Board board = boardRepository.findById(boardId).get();
        Purpose purpose = new Purpose();
        purpose.setTitle("untitled purpose");
        purpose.setContext(".");
        purpose.setBoard(board);
        return purposeRepository.save(purpose).getBoard().getOrg();
    }

    public Org updatePurpose(Purpose purpose){
        Purpose purpose1 = purposeRepository.findById(purpose.getId().intValue()).get();
        purpose1.setTitle(purpose.getTitle());
        purpose1.setContext(purpose.getContext());
        return purposeRepository.save(purpose1).getBoard().getOrg();
    }

    public Org deletePurpose(Integer purposeId){
        System.out.println("PurposeService.deletePurpose");
        Purpose purpose = purposeRepository.findById(purposeId).get();
        Org org  = purpose.getBoard().getOrg();
        purposeRepository.deleteById(purposeId);
        return org;
    }
}
