package com.banking_app.service;

import com.banking_app.dto.AccountDto;

public interface AccountService {

    AccountDto createAccount(AccountDto account);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);
}
