package ru.pavlov.springboot.services;

import ru.pavlov.springboot.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> getAllUsers();

    User getUser(int id);

    void removeUser(long id);
    void updateUser(User user);
}
