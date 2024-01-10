package com.nas.deliv.userservice.service.account;

import com.nas.deliv.userservice.command.AccountInformationUpdatedCommand;
import com.nas.deliv.userservice.models.AccountInformation;

public interface AccountInformationService {
    AccountInformation getByEmail(String email);
    AccountInformation update(String customerId, final AccountInformationUpdatedCommand command);
}
