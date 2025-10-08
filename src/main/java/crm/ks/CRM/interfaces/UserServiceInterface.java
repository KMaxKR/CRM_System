package crm.ks.CRM.interfaces;

import crm.ks.CRM.entity.UserEntity;
import crm.ks.CRM.io.ProfileRequest;
import crm.ks.CRM.io.ProfileResponse;

public interface UserServiceInterface {
    ProfileResponse createUser(ProfileRequest user);
    void updateUser(UserEntity user);
    void deleteUser(UserEntity user);

    Boolean userExistsByUsername(String username);
    Boolean userExistsByEmail(String email);
}
