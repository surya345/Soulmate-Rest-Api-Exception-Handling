package com.stackroute.Soulmaterestservice.controller;

import com.stackroute.Soulmaterestservice.exception.RecordNotFoundException;
import com.stackroute.Soulmaterestservice.model.User;
import com.stackroute.Soulmaterestservice.service.UserService;
import com.stackroute.Soulmaterestservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User saveduser= userService.AddorUpdateUser(user);
        return new ResponseEntity<>(saveduser, HttpStatus.CREATED);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>((List<User>)userService.getAllUsers(),HttpStatus.OK);
    };

    @DeleteMapping(path = "/delete/{id}")
    public  String DeleteUser(Model model, @PathVariable("id") int id) throws RecordNotFoundException
    {

     userServiceImpl.deleteUserbyId(id);

        return "redirect:/";
    }

    @RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
 public String createorUpdateEmployee(User user){
     System.out.println("createOrUpdateEmployee ");
     userService.AddorUpdateUser(user);
     return "redirect:/";
 }
 @GetMapping("/users/id")
    public User userById(@PathVariable int id) throws RecordNotFoundException {
        Optional<User> user=userService.getUserById(id);
        return user.get();
 }
 @GetMapping("/users/name")
    public ResponseEntity<List<User>> UserByname(@RequestParam(value="name") String name){
        return new ResponseEntity<List<User>>((List<User>) userService.searchUserByName(name),HttpStatus.OK);
 }
 @GetMapping("/user/{age}/{gender}")
    public User searchByAgeAndGender(@PathVariable int age,@PathVariable String gender){
        return userService.searchByAgeAndGender(age, gender);
 }
 @PutMapping("/users/update{id}")
    public ResponseEntity<User> updateById(@PathVariable int id,@RequestBody User user){
        userService.AddorUpdateUser(user);
        return ResponseEntity.noContent().build();
 }

}
