package fr.seb.tempi.services.data.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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

	@SuppressWarnings("unchecked")
	public List<TemperatureMeasure> list() {
		Criteria createCriteria = session.createCriteria(TemperatureMeasure.class);
		createCriteria.addOrder(Order.asc("created"));
		return createCriteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<TemperatureMeasure> listBetween2Dates(Date date1, Date date2) {
		Criteria createCriteria = session.createCriteria(TemperatureMeasure.class);
		createCriteria.addOrder(Order.asc("created"));
		createCriteria.add(Restrictions.between("created", date1, date2));
		return createCriteria.list();
	}

	public List<TemperatureMeasure> listLast24h() {
		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.DAY_OF_YEAR, -1);
		return listBetween2Dates(yesterday.getTime(), new Date());
	}

	public List<TemperatureMeasure> listLastMonth() {
		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.MONTH, -1);
		return listBetween2Dates(yesterday.getTime(), new Date());
	}

	public List<TemperatureMeasure> listLastYear() {
		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.YEAR, -1);
		return listBetween2Dates(yesterday.getTime(), new Date());
	}
}
