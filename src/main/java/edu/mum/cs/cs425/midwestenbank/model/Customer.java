package edu.mum.cs.cs425.midwestenbank.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;


@Entity(name="customers")
//@Getter @Setter 
//@Accessors(fluent = true) @Getter @Setter @ToString //from lombok
@Data @NoArgsConstructor
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1246329298219211766L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id")
	private long customerId;
	
	@NotBlank(message = "Customer Number required")
	private String customerNumber;
	
	@NotBlank(message = "Firstname required")
	private String firstName;
	
	@NotBlank(message = "Lastname required")
	private String lastName;
	
	private String middleName;
	
	@Email(message = "Email Address is not valid")
	@NotBlank(message = "Email Address required")
	private String emailAddress;
	
	@NotBlank(message = "Contact Phone Number required")
	private String contactPhoneNumber;
	
	@NotNull(message = "Date of Birth required")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateOfBirth;
	
	@OneToMany(mappedBy = "customer")
	private Set<Account> accounts;

	/**
	 * @param customerNumber
	 * @param firstName
	 * @param lastName
	 * @param middleName
	 * @param emailAddress
	 * @param contactPhoneNumber
	 * @param dateOfBirth
	 */
	public Customer(@NotBlank(message = "Customer Number required") String customerNumber,
			@NotBlank(message = "Firstname required") String firstName,
			@NotBlank(message = "Lastname required") String lastName, String middleName,
			@Email(message = "Email Address is not valid") @NotBlank(message = "Email Address required") String emailAddress,
			@NotBlank(message = "Contact Phone Number required") String contactPhoneNumber,
			@NotNull(message = "Date of Birth required") LocalDate dateOfBirth) {
		super();
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.emailAddress = emailAddress;
		this.contactPhoneNumber = contactPhoneNumber;
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getFullName() {
		return lastName+", "+firstName+" "+middleName;
	}

	

	
	
	
	
	
}
