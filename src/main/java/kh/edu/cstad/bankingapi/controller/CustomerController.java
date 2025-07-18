package kh.edu.cstad.bankingapi.controller;

import kh.edu.cstad.bankingapi.domain.Customer;
import kh.edu.cstad.bankingapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping("/customers")
    List<Customer> findAll(){
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    Customer findById(@PathVariable long id){
        return customerRepository.findById(id);
    }
}
