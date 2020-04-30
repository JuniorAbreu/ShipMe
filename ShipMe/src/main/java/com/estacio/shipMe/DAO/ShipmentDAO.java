package com.estacio.shipMe.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estacio.shipMe.Model.Shipment;
import com.estacio.shipMe.Repository.ShipmentRepository;

@Transactional
@Repository("shipmentDAO")
public class ShipmentDAO  extends AbstractDAO<Shipment> implements ShipmentRepository {

	public ShipmentDAO() {
		super(Shipment.class);
	}

	@Override
	public Shipment save(Shipment shipment) {
		return super.merge(shipment);
	}
	
	@Override
	public List<Shipment> list() {
		return super.list();
	}
	
	@Override
	public void delete(Long id) {
		super.delete(new Shipment(), id);
	}

}
