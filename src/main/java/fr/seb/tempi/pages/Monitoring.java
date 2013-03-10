package fr.seb.tempi.pages;

import java.util.Calendar;
import java.util.List;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

import fr.seb.tempi.components.TemperatureChart;
import fr.seb.tempi.entities.TemperatureMeasure;
import fr.seb.tempi.services.data.TemperatureMeasureService;


public class Monitoring {

	@Inject
	private TemperatureMeasureService temperatureMeasureService;
	
	@SuppressWarnings("unused")
	@Component(parameters={"temperatureMeasures=temperatureMeasures"})
	private TemperatureChart chart;
	
	private List<TemperatureMeasure> temperatureMeasures;
	
	@InjectComponent
	private Zone chartZone;
	
	public List<TemperatureMeasure> getTemperatureMeasures() {
		if(temperatureMeasures == null) {
			temperatureMeasures = temperatureMeasureService.list();
		}
		return temperatureMeasures;
	}

	@SuppressWarnings("unused")
	@CommitAfter
	private Object onActionFromAddMeasure() {
		for (int i = 0; i < 3; i++) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, randRange(-800, 0));
			
			temperatureMeasureService.add(randRange(17.0, 30.0), calendar.getTime());
		}
		return chartZone.getBody();
	}
	
	@SuppressWarnings("unused")
	private Object onActionFromLast24h() {
		temperatureMeasures = temperatureMeasureService.listLast24h();
		return chartZone.getBody();
	}
	
	@SuppressWarnings("unused")
	private Object onActionFromLastMonth() {
		temperatureMeasures = temperatureMeasureService.listLastMonth();
		return chartZone.getBody();
	}
	
	@SuppressWarnings("unused")
	private Object onActionFromLastYear() {
		temperatureMeasures = temperatureMeasureService.listLastYear();
		return chartZone.getBody();
	}
	
	@SuppressWarnings("unused")
	private Object onActionFromEverything() {
		temperatureMeasures = temperatureMeasureService.list();
		return chartZone.getBody();
	}
	
    private double randRange(double min, double max) {
    	return min + (double)Math.random() * (max - min);
    }
    
    private int randRange(int min, int max) {
    	return (int) (min + Math.random() * (max - min));
    }
    
}
