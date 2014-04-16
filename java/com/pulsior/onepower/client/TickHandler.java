package com.pulsior.onepower.client;

import com.pulsior.onepower.TheOnePower;
import com.pulsior.onepower.packet.channeling.PacketPlayerIncrementActivePower;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;

public class TickHandler{

	int tick = 0;
	int levelCounter = 0;

	@SubscribeEvent
	public void onClientTick(TickEvent event){
		
		if(event.phase == TickEvent.Phase.START && event.side == Side.CLIENT && event.type == TickEvent.Type.PLAYER){			
			updateTick();
			updateLevelCounter();
		}
	}

	public void updateTick(){
		tick++;

		if(tick == 20){
			tick = 0;
		}
	}

	public void updateLevelCounter(){
		levelCounter++;

		if(levelCounter == 10){
			levelCounter = 0;
			TheOnePower.PACKET_PIPELINE.sendToServer(new PacketPlayerIncrementActivePower() );
		}
	}

	public int getTick(){
		return tick;
	}

}
