package fr.seb.tempi.services.gpio.impl;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;

import fr.seb.tempi.services.gpio.GPIOService;

public class FakeGPIOServiceImpl implements GPIOService {

	public void writePinState(Pin pin, PinState state) {
	}

	public boolean getPinState(Pin pin) {
		return false;
	}

}
