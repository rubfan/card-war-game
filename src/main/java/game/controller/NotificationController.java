package game.controller;

import game.dto.NotificationDto;

import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface NotificationController {
    List<NotificationDto> getAllNotificationList();
}
