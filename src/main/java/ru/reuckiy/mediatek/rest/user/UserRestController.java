package ru.reuckiy.mediatek.rest.user;

import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.reuckiy.mediatek.model.User;
import ru.reuckiy.mediatek.repository.UserRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController {
    private final UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public @ResponseBody
    List<User> getAll() {
        return this.userRepository.findAll();
    }

    @GetMapping("{id}")
    public User getOneUser(@PathVariable("id") User nUser) {
        return nUser;
    }

    @PostMapping
    public User createUser(@RequestBody User nUser) {
        return userRepository.save(nUser);
    }

    @PutMapping("{id}")
    public User updateUser(@PathVariable("id") User nUserFromDb,
                           @RequestBody User nUser) {
        BeanUtils.copyProperties(nUser, nUserFromDb, "id");
        return userRepository.save(nUserFromDb);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") User nUser) {
        userRepository.delete(nUser);

    }

}
