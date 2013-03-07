package fr.seb.tempi.services.gpio;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;

public interface GPIOService {
	void writePinState(Pin pin, PinState state);
}
