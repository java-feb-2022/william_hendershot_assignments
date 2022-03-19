package com.codingdojo.exam_prep.mvc.services;

import java.util.Optional;

import com.codingdojo.exam_prep.mvc.models.LoginUser;
import com.codingdojo.exam_prep.mvc.models.User;
import com.codingdojo.exam_prep.mvc.repositories.UserRepository;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class UserService {
    
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }
    
    public void validate(User newUser, BindingResult result) {

        if (userRepository.findByEmail(newUser.getEmail()).isPresent()){
            result.rejectValue("email", "Unique Email", "Email has already been used!");
        }

        if (!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match the Password!");
        }

    }

    public User register(User newUser) {

        String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashedPassword);
        return userRepository.save(newUser);
    }

    public User authenticate(LoginUser newLogin, BindingResult result) {
        
        Optional<User> user = userRepository.findByEmail(newLogin.getEmail());
        if (!user.isPresent()) {
            result.rejectValue("email", "Login Email", "Email does not match");
            return null;
        }

        if (!BCrypt.checkpw(newLogin.getPassword(), user.get().getPassword())) {
            result.rejectValue("password", "Login Password", "Password does not match");
            return null;
        }
        return user.get();
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User get(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }

        return null;
    }

    public User getByEmail(User user) {
        Optional<User> u = userRepository.findByEmail(user.getEmail());
        if (u.isPresent()) {
            return u.get();
        }
        return null;
    }
}
