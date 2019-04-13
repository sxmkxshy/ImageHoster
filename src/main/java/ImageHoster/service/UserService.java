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

    //This method returns true if the username and password match with what is in the database
    public User login(User user) {
        User existingUser = userRepository.checkUser(user.getUsername(), user.getPassword());
        if (existingUser != null) {
            return existingUser;
        } else {
            return null;

        }
    }

    public boolean passwordChecker(User newUser) {
        String pwd = newUser.getPassword();
        int pwdScore = 0;

        //set the strength threshold of the password - this can be adjusted later if you want to add more criteria for a valid pwd
        int pwdRating = 3;

        if (pwd.matches("(?=.*[0-9]).*")) {
            pwdScore++;
        }

        //if it contains one lower case letter, add 2 to total score
        if (pwd.matches("(?=.*[a-z]).*") | pwd.matches("(?=.*[A-Z]).*")) {
            pwdScore++;
        }

        //if it contains one special character, add 2 to total score
        if (pwd.matches("(?=.*[~!@#$%^&*()_-]).*")) {
            pwdScore++;
        }

        if (pwdScore >= pwdRating) {
            return true;
        } else {
            return false;
        }

    }
}
