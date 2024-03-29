package com.spring.world.app.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
	
	private long accountId;
	private String accountHolderName;
	private double baleance;
	private boolean active;

}
