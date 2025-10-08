package crm.ks.CRM.service;

import crm.ks.CRM.entity.UserEntity;
import crm.ks.CRM.entity.authority.Authority;
import crm.ks.CRM.interfaces.UserServiceInterface;
import crm.ks.CRM.io.ProfileRequest;
import crm.ks.CRM.io.ProfileResponse;
import crm.ks.CRM.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserService implements UserDetailsService, UserServiceInterface {
    private final UserRepository userRepository;
    private final UniqueCodeService uniqueCodeService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with such username doesn't exists"));
    }

    @Override
    public ProfileResponse createUser(ProfileRequest user) {
        UserEntity newProfile = convertProfileRequestToEntity(user);
        newProfile = userRepository.save(newProfile);
        return convertEntityToProfileResponse(newProfile);
    }

    @Override
    public void updateUser(UserEntity user) {
        if (userExistsByUsername(user.getUsername()) && userExistsByEmail(user.getEmail())){
            userRepository.save(user);
            log.info("User {} was updated", user.getUsername());
        }else {
            userRepository.save(user);
            log.info("User {}, doesn't exists in data base, and was added", user.getUsername());
        }
    }

    @Override
    public void deleteUser(UserEntity user) {

    }

    @Override
    public Boolean userExistsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean userExistsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    private UserEntity convertProfileRequestToEntity(ProfileRequest request){
        return UserEntity.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(new BCryptPasswordEncoder(12).encode(request.getPassword()))
                .authority(Authority.USER)
                .img_url(null)
                .isEnable(false)
                .last_login(null)
                .unique_code(generateUniqueCode(Authority.USER))
                .verified(false)
                .build();
    }
    private ProfileResponse convertEntityToProfileResponse(UserEntity newProfile) {
        return null;
    }

    private String generateUniqueCode(Authority authority){
        StringBuilder unique_code = new StringBuilder();
        unique_code.append("#");
        if (authority.equals(Authority.ROOT)){
            unique_code.append("3");
        }else if (authority.equals(Authority.ADMIN)){
            unique_code.append("2");
        }else{
            unique_code.append("1");
        }
        unique_code.append(uniqueCodeService.generateUniqueThreeDigit());
        log.info("Generated unique code is {}", unique_code);
        return unique_code.toString();
    }

}
