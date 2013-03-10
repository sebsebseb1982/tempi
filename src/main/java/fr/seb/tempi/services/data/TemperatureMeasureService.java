package fr.seb.tempi.services.data;

import java.util.Date;
import java.util.List;

import fr.seb.tempi.entities.TemperatureMeasure;

public interface TemperatureMeasureService {
	void add(double value, Date timeStamp);
	List<TemperatureMeasure> list();
	List<TemperatureMeasure> listBetween2Dates(Date date1, Date date2);
	List<TemperatureMeasure> listLast24h();
	List<TemperatureMeasure> listLastMonth();
	List<TemperatureMeasure> listLastYear();
}
