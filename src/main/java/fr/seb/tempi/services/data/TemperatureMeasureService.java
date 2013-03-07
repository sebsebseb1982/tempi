package fr.seb.tempi.services.data;

import java.util.Collection;
import java.util.Date;

import fr.seb.tempi.data.persistant.TemperatureMeasure;

public interface TemperatureMeasureService {
	void add(double value, Date timeStamp);
	Collection<TemperatureMeasure> list();
}
