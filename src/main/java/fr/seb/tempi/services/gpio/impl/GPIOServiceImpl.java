package fr.seb.tempi.services.gpio.impl;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;

import fr.seb.tempi.services.gpio.GPIOService;

public class GPIOServiceImpl implements GPIOService {

	public void writePinState(Pin pin, PinState state) {
        final GpioController gpio = GpioFactory.getInstance();
        gpio.provisionDigitalOutputPin(pin, state);
	}

}
