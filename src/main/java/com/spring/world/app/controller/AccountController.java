package com.spring.world.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.world.app.DTO.AccountDTO;
import com.spring.world.app.entity.Account;
import com.spring.world.app.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	private AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
//addCustomer
	@PostMapping("/add")
	public ResponseEntity<AccountDTO> addCustomer(@RequestBody AccountDTO accountDTO) {
		AccountDTO addCustomer = accountService.addCustomer(accountDTO);
		return new ResponseEntity<AccountDTO>(addCustomer, HttpStatus.CREATED);
	}
//findAccountDetails
	@GetMapping("/{id}")
	public ResponseEntity<AccountDTO> findAccountById(@PathVariable long id) {
		AccountDTO findaccoun = accountService.findAccountById(id);
		return ResponseEntity.ok(findaccoun);
	}
//depositAmount
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDTO> depositAmount(@PathVariable long id,@RequestBody Map<String, Double> req) {
		AccountDTO findaccoun = accountService.depositAmount(id, req.get("baleance"));
		return ResponseEntity.ok(findaccoun);
	}
//withdrawAmount	
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDTO> withdrawAmount(@PathVariable long id,@RequestBody Map<String, Double> req) {
		AccountDTO findaccoun = accountService.withdrawAmount(id, req.get("baleance"));
		return ResponseEntity.ok(findaccoun);
	}
	
//find all Account 
	
	@GetMapping("/all")
	public ResponseEntity<List<AccountDTO>> findAllAccounts() {
		List<AccountDTO> findAllAccounts = accountService.findAllAccounts();
		return ResponseEntity.ok(findAllAccounts);
	}
	
//	deleteAccount
	
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<String> deleteAccount(@PathVariable long id) {
		accountService.deleteAccount(id);
		return ResponseEntity.ok("Account is Deteleted"+id);
	}
	

}
