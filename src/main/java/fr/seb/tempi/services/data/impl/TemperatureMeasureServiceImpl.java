package fr.seb.tempi.services.data.impl;

import java.util.Collection;
import java.util.Date;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import fr.seb.tempi.data.persistant.TemperatureMeasure;
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
		return session.createCriteria(TemperatureMeasure.class).list();
	}

}
