package game.service;

import game.dto.ResourceDto;

import java.util.List;

public interface ResourceService {
    List<ResourceDto> getAllResourceList();

    ResourceDto getResource(int resourceId);
}
