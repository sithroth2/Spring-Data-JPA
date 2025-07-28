package kh.edu.cstad.bankingapi.service;


import kh.edu.cstad.bankingapi.dto.CreateCustomerRequest;
import kh.edu.cstad.bankingapi.dto.CustomerResponse;
import kh.edu.cstad.bankingapi.dto.UpdateCustomerRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerService {

    List<CustomerResponse> findAllCustomer();

    /*
    * Create new customer
    *
    * */

    CustomerResponse createCustomer(CreateCustomerRequest createCustomerRequest);
    CustomerResponse updateCustomerByEmail(String email, UpdateCustomerRequest updateCustomerRequest);

    void deleteCustomerByUuid(String uuid);

}
