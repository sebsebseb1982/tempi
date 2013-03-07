package fr.seb.tempi.components;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;

import fr.seb.tempi.services.gpio.GPIOService;

public class GPOutButton {
	
	@Parameter(required=true)
	private Pin pin;
	
	@Parameter
	private boolean defautState;

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
		if(state == null) {
			return defautState;
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
