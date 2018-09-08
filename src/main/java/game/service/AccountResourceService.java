package game.service;

import game.dto.AccountResourceDto;

import java.util.List;

public interface AccountResourceService {
    List<AccountResourceDto> getAccountResourceList(Integer accountId);

}
