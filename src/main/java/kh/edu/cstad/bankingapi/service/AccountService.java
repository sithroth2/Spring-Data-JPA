package kh.edu.cstad.bankingapi.service;

import kh.edu.cstad.bankingapi.domain.Account;
import kh.edu.cstad.bankingapi.dto.AccountResponse;
import kh.edu.cstad.bankingapi.dto.CreateAccountRequest;

public interface AccountService {
    AccountResponse createAccount(CreateAccountRequest createAccountRequest);

}
