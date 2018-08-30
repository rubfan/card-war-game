package game.controller.impl;

import game.controller.UpgradeController;
import game.dto.AccountDto;
import game.dto.CardImpactDto;
import game.dto.UpgradeDto;
import game.model.AccountUpgradeEntity;
import game.model.UpgradeBuildingEntity;
import game.model.UpgradeEntity;
import game.repository.dao.AccountUpgradeDao;
import game.repository.dao.UpgradeBuildingDao;
import game.repository.dao.impl.AccountUpgradeDaoImpl;
import game.repository.dao.impl.UpgradeBuildingDaoImpl;
import game.repository.dao.impl.UpgradeDaoImpl;
import game.service.AccountUpgradeService;
import game.service.UpgradeBuildingService;
import game.service.UpgradeService;
import game.service.impl.AccountUpgradeServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("/upg")
public class UpgradeControllerImpl {

    @Inject
    UpgradeService upgradeDao;

    @GET
    @Path("/list")
    public List<UpgradeDto> getAllUpgradeList() {
        return (upgradeDao.getUpgrades(null, null));
    }


}