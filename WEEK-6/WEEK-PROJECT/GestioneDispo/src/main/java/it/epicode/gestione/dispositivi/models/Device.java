package it.epicode.gestione.dispositivi.models;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Device {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String imei;
	private Date statusChangeDate;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne(optional = false)
	private DeviceType deviceType;
	
	@ManyToOne
	private User user;

}
