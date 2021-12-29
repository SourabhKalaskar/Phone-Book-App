package in.ashokit.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
@Data
@Entity
@Table(name="CONTACT_DETAILS")
public class Contact {
	
	@Id
	@GeneratedValue
	@Column(name="CONTACT_ID")
	private Integer contactId;
	
	@Column(name="CONTACT_NAME")
	private String contactName;
	
	@Column(name="CONTACT_EMAIL")
	private String contactEmail;
	
	@Column(name="CONTACT_NUMBER")
	private Long contactNumber;
	
	@Column(name="ACTIVE_SW")
	private String activeSw;
	
	@Column(name="CREATED_DATE")
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name="UPDATED_DATE")
	@CreationTimestamp
	private LocalDate updatedDate;
}
