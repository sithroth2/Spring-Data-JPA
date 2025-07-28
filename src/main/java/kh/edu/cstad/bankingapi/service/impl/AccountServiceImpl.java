package kh.edu.cstad.bankingapi.service.impl;

import kh.edu.cstad.bankingapi.domain.Account;
import kh.edu.cstad.bankingapi.domain.AccountType;
import kh.edu.cstad.bankingapi.domain.Customer;
import kh.edu.cstad.bankingapi.dto.AccountResponse;
import kh.edu.cstad.bankingapi.dto.CreateAccountRequest;
import kh.edu.cstad.bankingapi.repository.AccountRepository;
import kh.edu.cstad.bankingapi.repository.AccountTypeRepository;
import kh.edu.cstad.bankingapi.repository.CustomerRepository;
import kh.edu.cstad.bankingapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountTypeRepository accountTypeRepository;
    private final CustomerRepository customerRepository;

    @Override
    public AccountResponse createAccount(CreateAccountRequest createAccountRequest) {

        Account account = new Account();
        //Validation account number
        //1. existed, null => auto generate, set to account
        if(createAccountRequest.accountNumber().isBlank()){
            String accNo;
            do{
                accNo = String.format("%09d", new Random(). nextInt(1_000_000_000));
            }while(accountRepository.existsByAccountNumber(createAccountRequest.accountNumber()));
            account.setAccountNumber(accNo);
        }else{
            if(accountRepository.existsByAccountNumber(createAccountRequest.accountNumber())){
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Account number already exists");
            }
            account.setAccountNumber(createAccountRequest.accountNumber());
        }

        //Validation on balance
        switch(createAccountRequest.currency()){
            case "USD" -> {
                if(createAccountRequest.balance().compareTo(BigDecimal.valueOf(5)) < 0){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Balance must be greater than 5");
                }
                account.setBalance(createAccountRequest.balance());
            }
         case "RIEL" -> {
                if(createAccountRequest.balance().compareTo(BigDecimal.valueOf(20000)) < 0){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Balance must be greater than 20000 riel");
                }
         }
        }
        // AccountTypeValidation
        AccountType accountType = accountTypeRepository.findByType(createAccountRequest.accountType())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Account type not found"));

        //Customer validation
        Customer customer = customerRepository.findByPhoneNumber(createAccountRequest.phoneNumber())
                        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Phone number not found"));

        account.setAccountType(accountType);
        account.setAccountName(createAccountRequest.accountName());
        account.setIsDeleted(false);
        account.setCurrency(createAccountRequest.currency());
        account.setBalance(createAccountRequest.balance());
        account.setCustomer(customer);

        accountRepository.save(account);
        return null;
    }
}
