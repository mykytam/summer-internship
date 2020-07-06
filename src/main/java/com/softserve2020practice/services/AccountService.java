package com.softserve2020practice.services;

import com.softserve2020practice.models.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAllAccounts();

    void addAccount(Account name);

    void updateAccount(Account name);

    void deleteAccount(Long id);
}
