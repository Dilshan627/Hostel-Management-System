package bo.custom.impl;

import bo.custom.LoginBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.impl.UserDAOImpl;
import dto.UserDTO;
import entity.User;


public class LoginBOImpl implements LoginBO {
    private final UserDAOImpl userDAO = DAOFactory.getInstance().getDAO(DAOType.USER);

    @Override
    public boolean save(UserDTO dto) throws Exception {
        return userDAO.save(new User(dto.getUserName(),dto.getPassword()));
    }
}
