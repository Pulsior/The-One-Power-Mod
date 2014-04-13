package com.pulsior.onepower.channeling;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import com.pulsior.onepower.TheOnePower;
import com.pulsior.onepower.packet.channeling.PacketUpdateChannelProperties;
import com.pulsior.onepower.weave.Element;
import com.pulsior.onepower.weave.IWeave;
import com.pulsior.onepower.weave.WeaveType;

public class Channel {
	private EntityPlayer player;
	private float maxPower;
	private float drawnPower;
	private List<Element> elements = new ArrayList<Element>();
	
	public Channel(EntityPlayer player, float extraPower){
		this.player = player;
		this.maxPower = 10F + extraPower;
		this.drawnPower = 0F;
		updateClient();
	}
	
	public boolean drawPower(){
		float drawnPower = this.drawnPower + 0.005F * (maxPower / 1.5F);
		
		if(drawnPower <= maxPower){
			this.drawnPower = drawnPower;
			return true;
		}
		
		return false;
	}
	
	public void cast(){
		
		for(WeaveType w : WeaveType.values() ){
			IWeave i = w.getIWeave();
			float requiredPower = i.getRequiredPower();
			if(requiredPower <= drawnPower && i.getElements().equals( elements) ){
				i.execute(player);
				drawnPower -= requiredPower;
				updateClient();
			}
		}
		
		elements.clear();
	}
	
	public void addElement(Element element){
		elements.add(element);
	}
	
	public float getMaxPower(){
		return maxPower;
	}
	
	public float getDrawnPower(){
		return drawnPower;
	}
	
	/**
	 * Update the client level bar
	 */
	public void updateClient(){
		TheOnePower.PACKET_PIPELINE.sendTo(new PacketUpdateChannelProperties(maxPower, drawnPower), (EntityPlayerMP) player);
	}
}
