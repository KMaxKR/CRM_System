package crm.ks.CRM.service;

import crm.ks.CRM.entity.User;
import crm.ks.CRM.interfaces.UserServiceInterface;
import crm.ks.CRM.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserService implements UserDetailsService, UserServiceInterface {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with such username doesn't exists"));
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        if (userExistsByUsername(user.getUsername()) && userExistsByEmail(user.getEmail())){
            userRepository.save(user);
            log.info("User {} was updated", user.getUsername());
        }else {
            userRepository.save(user);
            log.info("User {}, doesn't exists in data base, and was added", user.getUsername());
        }
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public Boolean userExistsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean userExistsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
