package pl.camp.it.ApartHouseRegistration.DAO;

import pl.camp.it.ApartHouseRegistration.model.User;

public interface IUserDAO {
    User getUserByLogin(String login);

    void addUser(User user);
}
