package fr.seb.tempi.pages;

import java.util.Calendar;

import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

import fr.seb.tempi.services.data.TemperatureMeasureService;

@Import(library={
		"context:js/Monitoring.js",
		"context:js/flotr-0.2.0-alpha.js",
		"context:js/lib/base64.js",
		"context:js/lib/canvas2image.js",
		"context:js/lib/canvastext.js",
		"context:js/lib/excanvas.js"
		},
		stylesheet="context:css/Monitoring.css")
public class Monitoring {

	
	@Environmental
	private JavaScriptSupport javaScriptSupport;
	
	@Inject
	private TemperatureMeasureService temperatureMeasureService;
	
	@SuppressWarnings("unused")
	@CommitAfter
	private void onActionFromAddMeasure() {
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, randRange(-100, 100));
		
		temperatureMeasureService.add(randRange(17.0, 30.0), calendar.getTime());
	}
	
    @AfterRender
    public void afterRender() {

    	StringBuilder javascript = new StringBuilder();
    	
    	javascript.append("var d2 = " + computeDataString() + ";");
    	
    	javascript.append("var f = Flotr.draw(");
	    	javascript.append("$('charts'),[ ");
		    	javascript.append("{data:d2, label:'Extérieur', lines:{fill:true}}");
	    	javascript.append("],{");
		    	javascript.append("xaxis:{");
			    	javascript.append("noTicks: 7,");
			    	javascript.append("tickFormatter: timestampHMTickFormatter");
		    	javascript.append("},");
		    	javascript.append("yaxis:{");
		    		javascript.append("noTicks: 3");
		    	javascript.append("}");
	    	javascript.append("}");
    	javascript.append(");");
    	
    	javaScriptSupport.addScript(javascript.toString());
    }
    
    private double randRange(double min, double max) {
    	return min + (double)Math.random() * (max - min);
    }
    
    private int randRange(int min, int max) {
    	return min + (int)Math.random() * (max - min);
    }

	private String computeDataString() {
		
		StringBuilder data = new StringBuilder();
		
		data.append("[");
//		for (TemperatureMeasure aMeasure : temperatureMeasureService.list()) {
//			data.append("[");
//			data.append(aMeasure.getCreated().getTime());
//			data.append(",");
//			data.append(aMeasure.getValue());
//			data.append("],");
//		}
		data.append("]");
		
		return data.toString();
	}
	
    
}
