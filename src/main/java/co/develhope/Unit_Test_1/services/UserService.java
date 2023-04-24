package co.develhope.Unit_Test_1.services;

import co.develhope.Unit_Test_1.entities.User;
import co.develhope.Unit_Test_1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User setUserActivationStatus(long userId,boolean isActive){
        Optional<User> user1=userRepository.findById(userId);
        if(!user1.isPresent()) return null;
        user1.get().setIsActive(isActive);
        return userRepository.saveAndFlush(user1.get());
    };
}
