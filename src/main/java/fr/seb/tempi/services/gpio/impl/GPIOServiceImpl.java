package fr.seb.tempi.services.gpio.impl;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;

import fr.seb.tempi.GPIOPinManager;
import fr.seb.tempi.services.gpio.GPIOService;

public class GPIOServiceImpl implements GPIOService {

	public void writePinState(Pin pin, PinState state) {
		GPIOPinManager.getInstance().getPin(pin).setState(state);
	}

	public boolean getPinState(Pin pin) {
		return GPIOPinManager.getInstance().getPin(pin).getState().isHigh();
	}

}
