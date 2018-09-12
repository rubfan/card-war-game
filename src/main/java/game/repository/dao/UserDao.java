package game.repository.dao;

import game.model.AccountEntity;
import game.model.UserEntity;

/**
 * @author ruslan.gramatic
 */
public interface UserDao {
    String getTokenByUserId(UserEntity user);
    void logoutUser(String token);
    String createNewUser(UserEntity user);
    UserEntity getUserByToken(String token);
    UserEntity getUserById(Integer userId);
}
