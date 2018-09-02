package game.repository.dao;

import game.model.AchievementEntity;

import java.util.List;

public interface AchievementDao {
    List<AchievementEntity> getAllAchievementList();
}
