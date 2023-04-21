package com.UsersMVC.users.services;

import com.UsersMVC.users.models.User;
import com.UsersMVC.users.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository peopleRepository;
    public UserServiceImpl(UserRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }
    @Override
    public List<User> index() {
        return peopleRepository.index();
    }
    @Override
    public User show(int id) {return peopleRepository.show(id);}
    @Override
    @Transactional
    public void save(@Valid User person) {
        peopleRepository.save(person);
    }
    @Override
    @Transactional
    public void update(int id, User person) {
        peopleRepository.update(id, person);
    }
    @Override
    @Transactional
    public void delete(int id) {
        peopleRepository.delete(id);
    }
}

