package entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student implements SuperEntity {
    @Id
    @Column(name = "student_id")
    private String studentId;
    private String name;
    private String address;
    @Column(name = "contact_no")
    private String contact;
    private Date dob;
    private String gender;

    @OneToMany(mappedBy = "student")
    private List<Reserve> arrayList = new ArrayList();
}
