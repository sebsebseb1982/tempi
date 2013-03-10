package fr.seb.tempi.components;

import java.util.List;

import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

import fr.seb.tempi.entities.TemperatureMeasure;

@Import(library={
		"context:js/TemperatureChart.js",
		"context:js/flotr-0.2.0-alpha.js",
		"context:js/lib/base64.js",
		"context:js/lib/canvas2image.js",
		"context:js/lib/canvastext.js",
		"context:js/lib/excanvas.js"
		},
		stylesheet="context:css/TemperatureChart.css")
public class TemperatureChart {
	
	@Environmental
	private JavaScriptSupport javaScriptSupport;
	
	@Parameter(required=true)
	private List<TemperatureMeasure> temperatureMeasures;
	
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
	
	private String computeDataString() {
		
		StringBuilder data = new StringBuilder();
		
		data.append("[");
		for (TemperatureMeasure aMeasure : temperatureMeasures) {
			data.append("[");
			data.append(aMeasure.getCreated().getTime());
			data.append(",");
			data.append(aMeasure.getValue());
			data.append("],");
		}
		data.append("]");
		
		return data.toString();
	}
}
