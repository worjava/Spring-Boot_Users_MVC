package com.UsersMVC.users.repositories;


import com.UsersMVC.users.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> index() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
    @Override
    public User show(int id) {return entityManager.find(User.class, id);}
    public void save(User person) {entityManager.persist(person);}
    @Override
    public void update(int id, User user) {
        User user1 = entityManager.find(User.class, id);
        if (user1 != null) {
            user1.setEmail(user.getEmail());
            user1.setAge(user.getAge());
            user1.setName(user.getName());
            entityManager.merge(user);

        }
    }
    @Override
    public void delete(int id) {
        User person = entityManager.find(User.class, id);
        if (person != null) {
            entityManager.remove(person);
        }
    }
}
