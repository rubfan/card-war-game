package game.service.impl;

import game.dto.ResourceDto;
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
        resourseDao.getAllResourceList().forEach(roomEntity -> {
            resources.add(new ResourceDto(){{
                setId(roomEntity.getId());
                setName(roomEntity.getName());
                setDescription(roomEntity.getDescription());
            }});
        });
        return resources;
    }
}
