package com.pulsior.onepower.client;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class TickHandler{

	int tick = 1;
	
	@SubscribeEvent
	public void onServerTick(TickEvent event){
		updateTick();
	}
	
	public void updateTick(){
		tick++;
		if(tick == 21){
			tick = 1;
		}
	}
	
	public int getTick(){
		return tick;
	}
	
}
