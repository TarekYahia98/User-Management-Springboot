package user_management_app.com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import user_management_app.com.demo.model.User;
import user_management_app.com.demo.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<User> getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    public ResponseEntity<User> updateUser(Long id, User userDetails) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(userDetails.getName());
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setAddressStreet(userDetails.getAddressStreet());
            user.setAddressSuite(userDetails.getAddressSuite());
            user.setAddressCity(userDetails.getAddressCity());
            user.setAddressZipcode(userDetails.getAddressZipcode());
            user.setAddressGeoLat(userDetails.getAddressGeoLat());
            user.setAddressGeoLng(userDetails.getAddressGeoLng());
            user.setPhone(userDetails.getPhone());
            user.setWebsite(userDetails.getWebsite());
            user.setCompanyName(userDetails.getCompanyName());
            user.setCompanyCatchPhrase(userDetails.getCompanyCatchPhrase());
            user.setCompanyBs(userDetails.getCompanyBs());
            user.setAge(userDetails.getAge());
            user.setSalary(userDetails.getSalary());

            User updatedUser = userRepository.save(user);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }




    public ResponseEntity<Void> deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

