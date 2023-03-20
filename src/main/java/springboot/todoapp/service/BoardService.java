package springboot.todoapp.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.todoapp.model.Board;
import springboot.todoapp.model.Org;
import springboot.todoapp.repository.BoardRepository;
import springboot.todoapp.repository.OrgRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {


    private final BoardRepository boardRepository;

    private final OrgRepository orgRepository;


    public Org addBoard(Integer OrgId){
        Org org = orgRepository.findById(OrgId).get();
        Board board = new Board();
        List<Board> boardList = org.getBoard();
        boardList.add(board);
        board.setOrg(org);
        board.setTitle("untitle");
        boardRepository.save(board);
        return orgRepository.save(org);
    }


    public Long deleteBoard(Integer boardId){
        Long id = boardRepository.findById(boardId).get().getOrg().getId();
        boardRepository.deleteById(boardId);
        return id;

    }


}
