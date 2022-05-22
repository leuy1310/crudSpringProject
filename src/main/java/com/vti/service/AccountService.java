package com.vti.service;

import com.vti.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface AccountService extends UserDetailsService {

    public Account getAccountByUserName(String username);
}
