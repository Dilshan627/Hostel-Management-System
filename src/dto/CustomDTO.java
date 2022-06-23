package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomDTO {
    private String name;
    private String address;
    private String contact;
    private String dob;
    private String gender;
    private String rooId;
    private String date;
}
