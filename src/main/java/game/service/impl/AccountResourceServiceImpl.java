package game.service.impl;

import game.dto.AccountResourceDto;
import game.repository.dao.AccountResourceDao;
import game.service.AccountResourceService;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class AccountResourceServiceImpl implements AccountResourceService {

    @Inject
    public AccountResourceDao accountResourceDao;

    @Override
    public List<AccountResourceDto> getAccountResourceList(Integer accountId) {
        final List<AccountResourceDto> accountResourceList = new LinkedList<>();

        return null;
    }


}
