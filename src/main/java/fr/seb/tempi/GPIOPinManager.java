package fr.seb.tempi;

import java.util.HashMap;
import java.util.Map;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;

public class GPIOPinManager {
	
	private static GPIOPinManager instance;
	
	private Map<Pin, GpioPinDigitalOutput> pins;
	
	private final GpioController gpio = GpioFactory.getInstance();
	
	private GPIOPinManager() {
		pins = new HashMap<Pin, GpioPinDigitalOutput>();
	}
	
	public static GPIOPinManager getInstance() {
		if(instance == null) {
			instance = new GPIOPinManager();
		}
		
		return instance;
	}
	
	public GpioPinDigitalOutput getPin(Pin pin) {
		if(!pins.containsKey(pin)) {
			GpioPinDigitalOutput provisionDigitalOutputPin = gpio.provisionDigitalOutputPin(pin, pin.getName(), PinState.LOW);
			pins.put(pin, provisionDigitalOutputPin);
		}
		return pins.get(pin);
	}
}
