package fr.seb.tempi.pages;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;


/**
 * Start page of application tempi.
 */
public class Index
{

    void onActionFromIncrementAjax()
    {
    	// create gpio controller instance
    	final GpioController gpio = GpioFactory.getInstance();
    	
    	GpioPinDigitalOutput myLed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00,   // PIN NUMBER
                "My LED",           // PIN FRIENDLY NAME (optional)
                PinState.LOW);      // PIN STARTUP STATE (optional)
    	
        // use pulse method to set the pin to the HIGH state for
        // an explicit length of time in milliseconds
        myLed.pulse(1000);
    }
}
