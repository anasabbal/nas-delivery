package com.nas.deliv.brandservice.repository;

import com.nas.deliv.brandservice.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
    boolean existsByCeo(String ceo);
    boolean existsById(String companyId);
}
