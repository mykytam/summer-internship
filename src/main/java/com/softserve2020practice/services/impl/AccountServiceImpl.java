package com.softserve2020practice.services.impl;

import com.softserve2020practice.models.Account;
import com.softserve2020practice.repositories.AccountRepository;
import com.softserve2020practice.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        return null;
    }

    @Override
    public void addAccount(Account name) {

    }

    @Override
    public void updateAccount(Account name) {

    }

    @Override
    public void deleteAccount(Long id) {

    }
}
