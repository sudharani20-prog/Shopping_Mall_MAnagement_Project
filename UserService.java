package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    public UserRepository urepo;

    // //inserting data
    public User addUser(User u) {
        return urepo.save(u);
    }

    // //display
    public List<User> getUser() {
        return urepo.findAll();
    }

    // //delete data
    public void deleteUser(int id) {
        urepo.deleteById(id);
    }

    // //Update
    public User updateUser(User u) {
        // Checks if the user exists before updating
        if (urepo.existsById(u.getId())) {
            return urepo.save(u);
        }
        return null; 
    }

    // //Login verification logic
    public User login(User user) {
        // Finds a user matching the provided credentials
        return urepo.findAll().stream()
                .filter(u -> u.getName().equals(user.getName()) && u.getPassword().equals(user.getPassword()))
                .findFirst()
                .orElse(null);
    }

    // //Logout logic
    public boolean logOut() {
        // Return true to indicate successful logout handling on the service side
        return true;
    }
}