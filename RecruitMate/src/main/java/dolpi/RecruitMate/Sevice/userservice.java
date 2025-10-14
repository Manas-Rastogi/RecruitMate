package dolpi.RecruitMate.Sevice;

import dolpi.RecruitMate.Entity.User;
import dolpi.RecruitMate.Repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;

@Service
public class userservice {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private Userrepository userrepository;

    //crate new user
    public User createnewuser(User body){
        String encodepassword=passwordEncoder.encode(body.getPassword());
        body.setPassword(encodepassword);
        String u=body.getUsertype();
        User savedUser= userrepository.save(body);
//           return ResponseEntity.ok(savedUser);

        return savedUser;
    }

    //find user
    public User finduser(String username) {
        User user = userrepository.findByUsername(username);
        if (user == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User not found with username: " + username
            );
        }
        return user;

    }

    public boolean existsByUsername(String username) {
        return userrepository.findByUsername(username) !=null;
    }


}
