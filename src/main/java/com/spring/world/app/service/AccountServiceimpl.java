package com.spring.world.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.world.app.DTO.AccountDTO;
import com.spring.world.app.entity.Account;
import com.spring.world.app.mapper.AccountMapper;
import com.spring.world.app.repository.AccountRepository;

@Service
public class AccountServiceimpl implements AccountService {

	private AccountRepository accountRepository;

	public AccountServiceimpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDTO addCustomer(AccountDTO accountDTO) {
		Account mapptoAccount = AccountMapper.mapptoAccount(accountDTO);
		Account accountdetails = accountRepository.save(mapptoAccount);
		return AccountMapper.mapptoAccountDTO(accountdetails);
	}

	@Override
	public AccountDTO findAccountById(long id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account Dose not Exists"));
		return AccountMapper.mapptoAccountDTO(account);
	}

	@Override
	public AccountDTO depositAmount(long id, double amount) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account Dose not Exists"));

		if (account.isActive()) {
			Double total = account.getBaleance() + amount;
			account.setBaleance(total);
		} else {
			throw new RuntimeException("Account Dose not Active");
		}
		Account Savedaccount = accountRepository.save(account);
		return AccountMapper.mapptoAccountDTO(Savedaccount);
	}

	@Override
	public AccountDTO withdrawAmount(long id, double amount) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account Dose not Exists"));

		if (account.isActive()) {
			Double total = account.getBaleance() - amount;
			account.setBaleance(total);
		} else {
			throw new RuntimeException("Account Dose not Active");
		}
		Account Savedaccount = accountRepository.save(account);
		return AccountMapper.mapptoAccountDTO(Savedaccount);
	}

	@Override
	public List<AccountDTO> findAllAccounts() {
		List<Account> findAll = accountRepository.findAll();
		List<AccountDTO> collect = findAll.stream()
				.map((acc)-> AccountMapper.mapptoAccountDTO(acc))
				.collect(Collectors.toList());

		return collect;
	}

	@Override
	public void deleteAccount(long id) {
		accountRepository.deleteById(id);
		
	}

}
