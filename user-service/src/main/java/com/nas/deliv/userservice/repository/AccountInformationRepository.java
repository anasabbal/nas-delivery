package com.nas.deliv.userservice.repository;

import com.nas.deliv.userservice.models.AccountInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountInformationRepository extends JpaRepository<AccountInformation, String> {
}
