package com.pulsior.onepower.channeling;

import com.pulsior.onepower.TheOnePower;
import com.pulsior.onepower.client.OverlayHandler;

public class Channel {
	
	/*The amount of power that can be drawn*/
	float basePower;
	float amountOfPower;
	
	public Channel(){
		/*Render GUI*/
		OverlayHandler.instance().toggleOverlay();

		basePower = 1.0F;
		amountOfPower = 0;
	}
	
	public float getMaxPower(){
		return basePower;
	}
	
	public void drawPower(){
		amountOfPower = amountOfPower + 0.005F * basePower;
		OverlayHandler.instance().updateLevelBar(amountOfPower);
	}
	
	public void close(){
		/*Remove GUI*/
		OverlayHandler.instance().toggleOverlay();
		/*Remove references*/
		TheOnePower.removeChannel();
	}
	
}

