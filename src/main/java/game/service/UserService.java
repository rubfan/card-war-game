package game.service;

import game.dto.UserDto;

/**
 * @author ruslan.gramatic
 */
public interface UserService {
    String getTokenByUserId(UserDto user);
    void logoutUser(String token);
    String createNewUser(UserDto user);
    UserDto getUserByToken(String token);
}
