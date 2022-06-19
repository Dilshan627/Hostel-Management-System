package view.tm;


import lombok.*;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentTm {
    private String studentId;
    private String name;
    private String address;
    private String contact;
    private String dob;
    private String gender;
}
