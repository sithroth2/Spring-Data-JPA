package kh.edu.cstad.bankingapi.repository;

import kh.edu.cstad.bankingapi.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer, Integer > {

    List<Customer> findAllByIsDeletedFalse();
    @Modifying
    @Query(value ="""
    UPDATE Customer c
    SET c.isDeleted= TRUE 
    WHERE c.phoneNumber =?1
""")
    void disableByPhoneNumber(String phoneNumber);
    //find all
    List<Customer> findAll();
    Boolean existsByEmail(String email);

    Boolean existsByPhoneNumber (String phoneNumber);

Optional<Customer>findByPhoneNumberAndIsDeleted(String phoneNumber);
    Optional<Customer>findByPhoneNumber(String phoneNumber);
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByUuid(String uuid);
}
