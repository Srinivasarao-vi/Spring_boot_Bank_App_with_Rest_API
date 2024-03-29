package com.spring.world.app.service;

import java.util.List;

import com.spring.world.app.DTO.AccountDTO;

public interface AccountService {
	
	AccountDTO addCustomer(AccountDTO accountDTO);
	AccountDTO findAccountById(long id);
	AccountDTO depositAmount(long id,double amount);
	AccountDTO withdrawAmount(long id,double amount);
	List<AccountDTO> findAllAccounts();
	void deleteAccount(long id);

}
