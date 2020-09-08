package pl.camp.it.ApartHouseRegistration.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.ApartHouseRegistration.DAO.IUserDAO;
import pl.camp.it.ApartHouseRegistration.model.User;
import pl.camp.it.ApartHouseRegistration.service.IUserService;



@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDAO userDAO;
    @Override
    public boolean authenticate(User user) {
        User userFromDataBase = userDAO.getUserByLogin(user.getLogin());
        if(userFromDataBase == null){
        return false;
        }
        if(DigestUtils.md5Hex(user.getPassword()).equals(userFromDataBase.getPassword())){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public boolean registerUser(User user, String repeatedPassword) {
        if(!user.getPassword().equals(repeatedPassword)) {
            return false;
        }
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        this.userDAO.addUser(user);
        return true;
    }

}
