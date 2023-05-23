package com.restapi.shop.serviceLayer;

import com.restapi.shop.dataAccessLayer.UserRepository;
import com.restapi.shop.exceptions.UserNotFoundException;
import com.restapi.shop.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll(){
        return repository.findAll();
    }

    public User getById(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new UserNotFoundException("id: "+id)
        );
    }

    public User add(User user){
        return repository.save(user);
    }

    public User editUser(Integer id, User user){
        Optional<User> user1 = repository.findById(id);
        if(user1.isPresent()){
            User user2 = user1.get();
            user2.setName(user.getName());
            user2.setRole(user.getRole());
            user2.setPassword(user.getPassword());
            return repository.save(user2);
        }else {
            throw new UserNotFoundException("id: "+id);
        }
    }

    public void delete(Integer id){
        User user = repository.findById(id).orElseThrow(
                () -> new UserNotFoundException("id: "+id)
        );
        repository.delete(user);
    }

}
