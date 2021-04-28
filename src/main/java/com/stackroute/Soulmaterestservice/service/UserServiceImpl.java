package com.stackroute.Soulmaterestservice.service;

import com.stackroute.Soulmaterestservice.exception.RecordNotFoundException;
import com.stackroute.Soulmaterestservice.model.User;
import com.stackroute.Soulmaterestservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User AddorUpdateUser(User user) {
        if(user.getId()==0){
        user=userRepository.save(user);
            return user;
        }
    else{
      Optional<User> user1=userRepository.findById(user.getId());
     if(user1.isPresent()){
       User newuser= user1.get();
       newuser.getFirstname();
       newuser.getLastname();
       newuser.getId();
       newuser.getGender();
       newuser.getAge();
       newuser=userRepository.save(newuser);
       return newuser;
     }
     else{
     user=userRepository.save(user);
     return user;
     }
        }
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User searchByAgeAndGender(int age, String gender) {
        System.out.println("getEmployeesByAgeandGender");

        return null;
    }

    @Override
    public Optional<User> getUserById(int id) throws RecordNotFoundException {
        System.out.println("getEmployeesById");
        Optional<User> user=userRepository.findById(id);
        if(user.isPresent()){
            userRepository.findById(id);
        }
        else{
            throw new RecordNotFoundException("Record not Found");
        }
        return user;
    }

    @Override
    public List<User> searchUserByName(String name) {

        return userRepository.getAllUsersByName(name);
    }


    public void deleteUserbyId(int id) throws RecordNotFoundException {

        System.out.println("deleteEmployeesById");
     Optional<User> user=userRepository.findById(id);
    if(user.isPresent()){
     userRepository.deleteById(id);
    }
     else{
       throw new RecordNotFoundException("Record not Found");
     }
 }


}
