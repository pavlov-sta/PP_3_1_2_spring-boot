package ru.pavlov.springboot.dao;

import ru.pavlov.springboot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    void add(User user);
    List<User> getAllUsers();

    User getUser(int id);

    void removeUser(int id);
    void updateUser(User user);
}
