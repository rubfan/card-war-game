package game.service;

import game.dto.AccountResourceDto;
import java.util.List;

/**
 * @author Evgen.Kaliba
 */
public interface AccountResourceService {
    List<AccountResourceDto> getAccountResourceList(Integer accountId);
    void clearAccountResourceList(Integer accountId);
}
