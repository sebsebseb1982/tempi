package fr.seb.tempi.components;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;

import fr.seb.tempi.services.gpio.GPIOService;

@Import(stylesheet="context:css/GPOutButton.css")
public class GPOutButton {
	
	@Parameter(required=true)
	private Pin pin;
	
	@Parameter
	private Boolean defautState;
	
	@Parameter(required=true)
	@Property
	private String label;

	@Persist
	private Boolean state;

	@Inject
	private GPIOService gpioService;
	
	@SuppressWarnings("unused")
	private void onActionFromChangeState() {
		state = !getState();
		gpioService.writePinState(pin, PinState.getState(state));
	}
	
	private boolean getState() {
		// Si l'état de la sortie n'a pas encore été fixé pour le composant bouton
		if(state == null) {
			// Si un état par défaut a été précisé
			if(defautState != null) {
				return defautState;
			} else {
				return gpioService.getPinState(pin);
			}
		} else {
			return state;
		}
	}
	
	public String getButtonStyle() {
		return getState() ? "btn-success" : "btn-danger";
	}
	
	public String getStateLabel() {
		return getState() ? "ON" : "OFF";
	}
}
