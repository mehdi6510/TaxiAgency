package com.ashrafian.agency.service.impl;

import com.ashrafian.agency.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//    private UserRepository userRepository;
//
//
//    public UserServiceImpl(UserRepository userRepository, Mapper mapper) {
//        this.userRepository = userRepository;
//
//    }
//
//    @Override
//    public User getUserById(Long userId) throws ResourceNotFoundException {
//        logger.info("Try to find user with this id : {}", userId);
//        User user = userRepository.findById(userId).orElseThrow(() ->
//                new ResourceNotFoundException("User not found for this id :: " + userId));
//
//        logger.info("User loaded. User id : {}", userId);
//        logger.debug("Loaded user detail: {}", user);
//        return user;
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        logger.info("Try to load all users.");
//        List<User> users = userRepository.findAll();
//
//        logger.info("Users has been loaded. Size of result : {}", users.size());
//        logger.debug("Loaded users detail: {}", users);
//        return users;
//    }
//
//    @Override
//    public User createUser(User user) {
//        logger.info("Try to save user : {}", user);
//        userRepository.save(user);
//        logger.info("User saved : {}", user);
//        return user;
//    }
//
//    @Override
//    public User updateUser(Long userId, User userDetails) throws ResourceNotFoundException {
//        logger.info("Try to update user with this user id: {} and new detail: {}", userId, userDetails);
//        User oldUser = userRepository.findById(userId).orElseThrow(() ->
//                new ResourceNotFoundException("User not found for this id :: " + userId));
//        logger.info("Existing user data id db has been loaded with this details : {}", oldUser);
//
//
//        //mapper.fillUpdatingDetails(oldUser, userDetails);
//
//
//        User updatedUser = userRepository.save(oldUser);
//
//        logger.info("User updated with this details : {}", updatedUser);
//        return updatedUser;
//    }
//
//    @Override
//    public void deleteUser(Long userId) throws ResourceNotFoundException {
//        logger.info("Try to delete user with this user id: {}", userId);
//        User user = userRepository.findById(userId).orElseThrow(() ->
//                new ResourceNotFoundException("User not found for this id :: " + userId));
//        logger.info("Existing user has been loaded with this details : {}", user);
//
//        userRepository.delete(user);
//        logger.info("User deleted. Removing Date : {}", new Date());
//    }

}
