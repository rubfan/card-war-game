package game.controller;

import game.dto.ResourceDto;

import java.util.List;

/**
 * @author ruslan.gramatic
 */
public interface ResourceController {
    List<ResourceDto> getAllResourceList();

    ResourceDto getResource(Integer resourceId);
}