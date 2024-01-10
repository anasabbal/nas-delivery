package com.nas.deliv.userservice.repository;

import com.nas.deliv.userservice.models.AccountInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountInformationRepository extends JpaRepository<AccountInformation, String> {
    Optional<AccountInformation> findByEmail(String email);
}
