package entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Room implements SuperEntity {
    @Id
    @Column(name = "room_id")
    private String roomId;
    private String type;
    @Column(name = "monthly_rent")
    private String rent;
    private int qty;

   @OneToMany(mappedBy = "room")
    private List<Reserve> list = new ArrayList();

    public Room(String roomId, String type, String rent, int qty) {
        this.roomId = roomId;
        this.type = type;
        this.rent = rent;
        this.qty = qty;
    }
}
