package com.tiwson.spring_learning_02.service;

import com.tiwson.spring_learning_02.bean.Account;
import com.tiwson.spring_learning_02.dao.AccountDao;
import com.tiwson.spring_learning_02.dao.AccountDaoImpl;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> getAccount() {
                List<Account> list = accountDao.getAccount();
        return list;
    }
}
