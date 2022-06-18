package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room implements SuperEntity {
    @Id
    @Column(name = "room_id")
    private String roomId;
    private String type;
    @Column(name = "monthly_rent")
    private double rent;
    private String qty;

    @OneToMany(mappedBy = "room")
    private List<Reserve> arrayList = new ArrayList();
}
