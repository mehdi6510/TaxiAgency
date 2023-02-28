package com.ashrafian.agency.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/taxi-agency/api")
public class UserController {

//    private UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping(value = "/users/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
//        return ResponseEntity.ok().body(userService.getUserById(userId));
//    }
//
//    @GetMapping(value = "/users")
//    public ResponseEntity<List<User>> getAllUsers() {
//        return ResponseEntity.ok().body(userService.getAllUsers());
//    }
//
//    @PostMapping(value = "/users")
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        return ResponseEntity.ok().body(userService.createUser(user));
//    }
//
//    @PutMapping(value = "/users/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId, @RequestBody User userDetails)
//            throws ResourceNotFoundException {
//        User updatedUser = userService.updateUser(userId, userDetails);
//        return ResponseEntity.ok(updatedUser);
//    }
//
//    @DeleteMapping(value = "/users/{id}")
//    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
//        userService.deleteUser(userId);
//
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }

}
