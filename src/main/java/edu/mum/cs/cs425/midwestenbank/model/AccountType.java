package edu.mum.cs.cs425.midwestenbank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="account_types")
@Getter @Setter @ToString @NoArgsConstructor  //from lombok
public class AccountType {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountTypeId;
	
	@NotBlank(message = "Account Type required")
	private String accountTypeName;

	/**
	 * @param accountTypeName
	 */
	public AccountType(@NotBlank(message = "Account Type required") String accountTypeName) {
		super();
		this.accountTypeName = accountTypeName;
	}

	/**
	 * @param accountTypeId
	 */
	public AccountType(int accountTypeId) {
		super();
		this.accountTypeId = accountTypeId;
	}
	
	
	
	
}
