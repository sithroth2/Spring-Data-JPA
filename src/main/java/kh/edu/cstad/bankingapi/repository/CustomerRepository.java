package kh.edu.cstad.bankingapi.repository;

import kh.edu.cstad.bankingapi.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer, Integer > {

    //find all
    List<Customer> findAll();
    Boolean existsByEmail(String email);

    Boolean existsByPhoneNumber (String phoneNumber);

Optional<Customer>findByPhoneNumber(String phoneNumber);
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByUuid(String uuid);
}
