package game.service.impl;

import game.dto.AchievementDto;
import game.model.AchievementEntity;
import game.repository.dao.AchievementDao;
import game.service.AchievementService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author alexey.kostash
 */

public class AchievementServiceImpl implements AchievementService {

    @Inject
    private AchievementDao achievementDao;

    @Override
    public List<AchievementDto> getAllAchievementList() {
        final List<AchievementDto> achievementDtoList = new ArrayList<>();
        List<AchievementEntity> allAchievementList = achievementDao.getAllAchievementList();
        allAchievementList.forEach(achievementEntity -> {
            achievementDtoList.add(new AchievementDto(){
                {
                    setId(achievementEntity.getId());
                    setName(achievementEntity.getName());
                    setDescription(achievementEntity.getDescription());
                }
            });
        });
        return achievementDtoList;
    }
}
