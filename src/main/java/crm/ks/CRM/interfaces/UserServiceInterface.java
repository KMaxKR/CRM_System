package crm.ks.CRM.interfaces;

import crm.ks.CRM.entity.User;

public interface UserServiceInterface {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(User user);

    Boolean userExistsByUsername(String username);
    Boolean userExistsByEmail(String email);
}
