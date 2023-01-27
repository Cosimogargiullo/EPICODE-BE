package entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="students")
@Getter
@Setter
@ToString
public class Student {

	// columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "fullname")
	private String fullname;
	
	private LocalDate birthdate;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private int address_id;
	
}
