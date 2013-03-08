package fr.seb.tempi.services.data.impl;

import java.util.Collection;
import java.util.Date;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import fr.seb.tempi.entities.TemperatureMeasure;
import fr.seb.tempi.services.data.TemperatureMeasureService;

public class TemperatureMeasureServiceImpl implements TemperatureMeasureService {

    @Inject
    private Session session;
	
	public void add(double value, Date timeStamp) {
		TemperatureMeasure temperatureMeasure = new TemperatureMeasure();
		temperatureMeasure.setCreated(timeStamp);
		temperatureMeasure.setValue(value);
		session.persist(temperatureMeasure);
	}

	public Collection<TemperatureMeasure> list() {
		Criteria createCriteria = session.createCriteria(TemperatureMeasure.class);
		createCriteria.addOrder(Order.asc("created"));
		return createCriteria.list();
	}
}
