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
	private Pin led1Pin = RaspiPin.GPIO_00;
	@Property
	private Pin led2Pin = RaspiPin.GPIO_01;
	@Property
	private Pin led3Pin = RaspiPin.GPIO_02;
	@Property
	private Pin led4Pin = RaspiPin.GPIO_03;
}
