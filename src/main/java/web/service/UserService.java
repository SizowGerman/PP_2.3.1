package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(long id);
    void save(User user);
    void delete(long id);
    void update(User user);

}
