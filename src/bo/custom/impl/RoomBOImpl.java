package bo.custom.impl;

import bo.custom.RoomBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.RoomDAOImpl;
import dto.RoomDTO;
import entity.Room;

import java.util.ArrayList;

public class RoomBOImpl implements RoomBO {

    private final RoomDAOImpl roomDAO = DAOFactory.getInstance().getDAO(DAOType.ROOM);

    @Override
    public ArrayList<RoomDTO> getAll() throws Exception {
        ArrayList<Room> list = roomDAO.getAll();
        ArrayList<RoomDTO> arrayList = new ArrayList<>();
        for (Room room : list) {
            arrayList.add(new RoomDTO(room.getRoomId(), room.getType(), room.getRent(), room.getQty()));
        }
        return arrayList;
    }

    @Override
    public boolean add(RoomDTO roomDTO) throws Exception {
        return roomDAO.save(new Room(roomDTO.getRoomId(), roomDTO.getType(), roomDTO.getRent(), roomDTO.getQty()));
    }

    @Override
    public boolean update(RoomDTO roomDTO) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String code) throws Exception {
        return false;
    }
}
