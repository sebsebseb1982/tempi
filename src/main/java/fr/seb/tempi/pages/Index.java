package fr.seb.tempi.pages;

import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;


/**
 * Start page of application tempi.
 */
public class Index
{

	private GpioPinDigitalOutput myLed = GpioFactory.getInstance().provisionDigitalOutputPin(RaspiPin.GPIO_00,   // PIN NUMBER
			"My LED",           // PIN FRIENDLY NAME (optional)
			PinState.LOW);      // PIN STARTUP STATE (optional)
    void onActionFromIncrementAjax()
    {
    	
        // use pulse method to set the pin to the HIGH state for
        // an explicit length of time in milliseconds
        myLed.pulse(1000);
    }
}
