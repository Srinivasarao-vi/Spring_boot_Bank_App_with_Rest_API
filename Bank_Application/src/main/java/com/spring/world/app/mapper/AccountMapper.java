package com.spring.world.app.mapper;

import com.spring.world.app.DTO.AccountDTO;
import com.spring.world.app.entity.Account;

public class AccountMapper {
	
	public static AccountDTO mapptoAccountDTO(Account account ) {
		AccountDTO accountDTO=new AccountDTO(account.getAccountId(),
				account.getAccountHolderName(), account.getBaleance(),account.isActive());
		
		return accountDTO;
		
	}
	
	public static Account mapptoAccount(AccountDTO accountDTO ) {
		Account account=new Account(accountDTO.getAccountId(), 
				accountDTO.getAccountHolderName(), accountDTO.getBaleance(),accountDTO.isActive());
		
		return account;
		
	}

}
