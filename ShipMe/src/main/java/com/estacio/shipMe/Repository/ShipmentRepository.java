package com.estacio.shipMe.Repository;

import java.util.List;

import com.estacio.shipMe.Model.Shipment;

public interface ShipmentRepository {
	
	public Shipment save(Shipment shipment);
	public List<Shipment> list();
	public void delete(Long id);

}
