package com.nas.deliv.userservice.repository;

import com.nas.deliv.userservice.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    boolean existsCustomerByAccountInformation_Email(String email);
    Customer findByAccountInformation_Email(String email);
    Page<Customer> findAllByDeletedFalse(Pageable pageable);
}
