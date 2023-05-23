package com.restapi.shop.presentationLayer;

import com.restapi.shop.pojo.User;
import com.restapi.shop.serviceLayer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop/users")
public class UserController {
    private final UserService service;
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User byId(@PathVariable("id") Integer id){
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        return new ResponseEntity<User>(service.add(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> edit(@PathVariable("id") Integer id,
                                     @RequestBody User user){
        return new ResponseEntity<User>(service.editUser(id,user),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id){
        return new ResponseEntity<String>("User successfully deleted",HttpStatus.OK);
    }
}
