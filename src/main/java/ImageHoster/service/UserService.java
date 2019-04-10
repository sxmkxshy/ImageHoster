package ImageHoster.service;

import ImageHoster.model.User;
import ImageHoster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Call the registerUser() method in the UserRepository class to persist the user record in the database
    public void registerUser(User newUser) {
        //Complete the method
        userRepository.registerUser(newUser);
    }

    //Since we do not have any user in the database, therefore the user with username 'upgrad' and password 'password' is hard-coded
    //This method returns true if the username is 'upgrad' and password is 'password'
    public User login(User user) {
        User existingUser = userRepository.checkUser(user.getUsername(), user.getPassword());
        if (existingUser != null) {
            return existingUser;
        } else {
            return null;

        }
    }

}
