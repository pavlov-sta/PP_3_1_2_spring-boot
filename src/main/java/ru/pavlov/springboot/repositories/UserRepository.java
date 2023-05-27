package ru.pavlov.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pavlov.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findAllById(int id);
}
