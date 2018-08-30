package game.service.impl;

import game.dto.UserDto;
import game.model.UserEntity;
import game.repository.dao.UserDao;
import game.service.UserService;

import javax.inject.Inject;
import java.util.UUID;

/**
 * @author ruslan.gramatic
 */
public class UserServiceImpl implements UserService {

    @Inject
    public UserDao userDao;

    @Override
    public String getTokenByUserId(UserDto user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setPassword(user.getPassword());
        return userDao.getTokenByUserId(userEntity);
    }

    @Override
    public void logoutUser(String token) {
        userDao.logoutUser(token);
    }

    @Override
    public String createNewUser(UserDto user) {
        UserEntity newUser = new UserEntity();
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword());
        newUser.setToken(UUID.randomUUID().toString());
        return userDao.createNewUser(newUser);
    }

    @Override
    public UserDto getUserByToken(String token) {
        UserEntity userEntity = userDao.getUserByToken(token);
        return new UserDto(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getPassword(),
                userEntity.getToken()
        );
    }
}
