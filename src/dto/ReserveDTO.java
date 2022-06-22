package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReserveDTO {
    private String resId;
    private String date;
    private String student;
    private String room;
    private String status;
}
