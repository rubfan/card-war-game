package game.service.impl;

import game.dto.ResourceDto;
import game.model.ResourceEntity;
import game.repository.dao.ResourceDao;
import game.service.ResourceService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class ResourceServiceImpl implements ResourceService {

    @Inject
    ResourceDao resourseDao;

    @Override
    public List<ResourceDto> getAllResourceList() {
        final List<ResourceDto> resources = new LinkedList<>();
        resourseDao.getAllResourceList().forEach(resourceEntity ->  {
            resources.add(new ResourceDto(resourceEntity));
        });
        return resources;
    }

    public ResourceDto getResource(int resourceId) {
        return new ResourceDto(resourseDao.getResource(resourceId));
    }
}
