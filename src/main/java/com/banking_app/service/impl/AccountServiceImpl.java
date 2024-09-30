package com.banking_app.service.impl;

import com.banking_app.dto.AccountDto;
import com.banking_app.entity.Account;
import com.banking_app.mapper.AccountMapper;
import com.banking_app.repository.AccountRepository;
import com.banking_app.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {

       Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exist"));

       return AccountMapper.mapToAccountDto(account);
    }
}
