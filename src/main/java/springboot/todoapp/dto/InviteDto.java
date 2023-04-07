package springboot.todoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InviteDto {

    private Long id;
    private String invitorId;
    private String participantId;
    private Long orgId;

}
