package it.epicode.gestione.dispositivi.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.gestione.dispositivi.models.Device;

@Transactional
public interface DeviceRepository extends JpaRepository<Device, Long> {
	
	public List<Device> findByDeviceTypeName(String deviceTypeName);
	
	public Page<Device> findByDeviceTypeName(String deviceTypeName, Pageable pageable);
	
	public Page<Device> findByDeviceTypeNameIgnoreCase(String deviceTypeName, Pageable pageable);
	
	public Optional<Device> findByImei(String serialHw);
	
	public Optional<Device> findByImeiIgnoreCase(String serialHw);


	public void deleteByImei(String imei);

}
