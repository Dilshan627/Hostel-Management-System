package bo.custom.impl;

import bo.custom.AccountBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.UserDAOImpl;
import dto.UserDTO;
import entity.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountBOImpl implements AccountBO {
    private final UserDAOImpl userDAO = DAOFactory.getInstance().getDAO(DAOType.USER);

    @Override
    public boolean save(UserDTO dto) throws Exception {
        return userDAO.save(new User(dto.getUserName(),dto.getPassword()));
    }

    @Override
    public List<UserDTO> search(String id) throws IOException {
        List<User> search = userDAO.search(id);
        List<UserDTO> userDto = new ArrayList<>();
        for (User user : search) {
            userDto.add(new UserDTO(user.getUserName(), user.getPassword()));
        }
        return userDto;
    }

    @Override
    public boolean update(UserDTO dto) throws Exception {
       return userDAO.update(new User(dto.getUserName(),dto.getPassword()));
    }

    @Override
    public boolean delete(String code) throws Exception {
        return userDAO.delete(code);
    }
}
