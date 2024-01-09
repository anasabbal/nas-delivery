package com.nas.deliv.userservice.service.account;


import com.nas.deliv.userservice.models.AccountInformation;
import com.nas.deliv.userservice.repository.AccountInformationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountInformationServiceImpl implements AccountInformationService{

    private final AccountInformationRepository accountInformationRepository;

    @Override
    public AccountInformation getByEmail(String email) {
        return null;
    }
}
