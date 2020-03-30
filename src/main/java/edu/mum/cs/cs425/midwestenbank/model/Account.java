package edu.mum.cs.cs425.midwestenbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="accounts")
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode  //from lombok
//@Table(uniqueConstraints={@UniqueConstraint(columnNames={"cust_id","acct_type"})})
public class Account {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountId;
	
	@NotNull(message = "Account Number required")
	@Digits(integer = 9, fraction = 0, message = "Invalid Account Number")
	@Column(name = "acc_num", nullable = false, unique = true)
	private long accountNumber;
	
	@Digits(integer = 9, fraction = 2, message = "Invalid Account Balance")
	private double balance;
	
	@OneToOne
	@NotNull(message = "Account Type required")
	@JoinColumn(name = "acc_type", nullable = false)
	private AccountType accountType;
	
	@ManyToOne
	@JoinColumn(name = "cust_id")
	private Customer customer;

	
	
	
	
}
