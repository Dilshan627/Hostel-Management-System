package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reserve implements SuperEntity {
    @Id
    @Column(name = "res_id")
    private String resId;
    private Date date;
    @Column(name = "key_money")
    private double keyMoney;

    @ManyToOne
    @Column(name = "student_id")
    private Student studentId;

    @ManyToOne
    @Column(name = "room_id")
    private Room roomId;

    @ManyToOne
    @JoinColumn(name = "student_student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "room_room_id")
    private Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
