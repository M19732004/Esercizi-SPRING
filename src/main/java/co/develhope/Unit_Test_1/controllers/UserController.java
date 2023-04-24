package co.develhope.Unit_Test_1.controllers;

import co.develhope.Unit_Test_1.entities.User;
import co.develhope.Unit_Test_1.repositories.UserRepository;
import co.develhope.Unit_Test_1.services.UserService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @PostMapping("")
    public @ResponseBody User create(@RequestBody User user){
        return userRepository.save(user);
    };
    @GetMapping("/")
    public List<User> getAll(){
        return userRepository.findAll();
    };
    @GetMapping("/{userId}")
    public User getSingle(@PathVariable long userId){
        Optional<User> user1=userRepository.findById(userId);
        if(user1.isPresent()){return user1.get();}
        else {
            return null;}
    };
    @PutMapping("/{userId}")
    public void updateSingle(@PathVariable long userId, @RequestBody @NotNull User user){
        user.setUserId(userId);
        userRepository.saveAndFlush(user);
    };
    @PutMapping("/{userId}/activation")
    public void setSingleActive(@PathVariable long userId, @RequestParam("activated") boolean activated){
        userService.setUserActivationStatus(userId,activated);
    };
    @DeleteMapping("/{userId}")
    public void deleteSingle(@PathVariable long userId){
        userRepository.deleteById(userId);
    };
}
