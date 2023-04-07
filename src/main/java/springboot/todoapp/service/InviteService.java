package springboot.todoapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.todoapp.dto.InviteDto;
import springboot.todoapp.model.Invite;
import springboot.todoapp.repository.InviteRepository;
import springboot.todoapp.repository.OrgRepository;
import springboot.todoapp.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class InviteService {

    private final InviteRepository inviteRepository;
    private final UserRepository userRepository;
    private final OrgRepository orgRepository;


    public Invite copyInvite(Invite invite, InviteDto dto){
        if(dto.getId() != null){
            invite.setId(dto.getId());
        }
        invite.setInvitor(userRepository.findByUserId(dto.getInvitorId()).get());
        invite.setParticipant(userRepository.findByUserId(dto.getParticipantId()).get());
        invite.setOrg(orgRepository.findById(dto.getOrgId()).get());
        return inviteRepository.save(invite);
    }

}
