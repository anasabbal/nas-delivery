package com.nas.deliv.userservice.service.account;

import com.nas.deliv.userservice.models.AccountInformation;

public interface AccountInformationService {
    AccountInformation getByEmail(String email);
}
