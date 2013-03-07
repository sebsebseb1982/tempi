package fr.seb.tempi.pages;

import org.apache.tapestry5.annotations.Property;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;


/**
 * Start page of application tempi.
 */
public class Index
{
	@Property
	private Pin ledPin = RaspiPin.GPIO_00;
}
