package it.epicode.mobilemonitoring.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import it.epicode.gestione.dispositivi.models.DeviceType;

public interface DeviceTypeRepository extends JpaRepository<DeviceType, Long> {
	
	public Optional<DeviceType> findByName(String name);

}
