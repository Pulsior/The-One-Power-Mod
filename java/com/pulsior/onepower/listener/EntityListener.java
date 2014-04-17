package com.pulsior.onepower.listener;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;

import com.pulsior.onepower.data.PlayerData;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EntityListener {
	
	@SubscribeEvent
	public void onEntityConstruct(EntityConstructing event){
		
		if (event.entity instanceof EntityPlayer && PlayerData.getCustomData( (EntityPlayer) event.entity) == null)
			PlayerData.register( (EntityPlayer) event.entity);
	}
	
}
