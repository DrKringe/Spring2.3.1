package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.Dao.DAOImpl;
import web.model.Users;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService{
    private final DAOImpl userDao;
    @Autowired
    public UsersServiceImpl(DAOImpl userDao) {
        this.userDao = userDao;
    }
    @Override
    public List<Users> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public Users getUserId(long id) {
        return userDao.getUserId(id);
    }

    @Override
    public void addUser(Users users) {
        userDao.addUser(users);
    }

    @Override
    public void updateUser(Users users) {
        userDao.updateUser(users);
    }

    @Override
    public Users removeUser(long id) {
        return userDao.removeUser(id);
    }
}
