package com.pulsior.onepower.channeling;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import com.pulsior.onepower.TheOnePower;
import com.pulsior.onepower.data.PlayerData;
import com.pulsior.onepower.packet.channeling.PacketUpdateChannelProperties;
import com.pulsior.onepower.weave.Element;
import com.pulsior.onepower.weave.IWeave;
import com.pulsior.onepower.weave.WeaveType;

public class Channel {
	private EntityPlayer player;
	private float maxPower;
	private float activePower;
	private PlayerData data;
	private List<Element> elements = new ArrayList<Element>();

	public Channel(EntityPlayer player, float amplification){
		this.player = player;
		this.data = PlayerData.getCustomData(player);
		this.maxPower = data.getMaxPower();
		this.activePower = data.getActivePower();
	}

	public void cast(){
				
		for(WeaveType w : WeaveType.values() ){
			IWeave i = w.getIWeave();
			float requiredPower = i.getRequiredPower();

			if(requiredPower <= activePower && i.getElements().equals( elements) ){
				i.execute(player);
				activePower -= requiredPower;
				save();

			}
		}

		elements.clear();
	}
	
	public void save(){
		data.setMaxPower(maxPower);
		data.setActivePower(activePower);
		updateClient();
	}
	
	public void update(){
		this.maxPower = data.getMaxPower();
		this.activePower = data.getActivePower();
	}
	
	public void addElement(Element element){
		elements.add(element);
	}

	public float getMaxPower(){
		return maxPower;
	}

	public float getActivePower(){
		return activePower;
	}

	public void incrementActivePower(){
		if(activePower < maxPower){
			activePower += 0.1F;
		}
		
		if(activePower > maxPower){
			activePower = maxPower;
		}
		
	}

	/**
	 * Update the client level bar
	 */
	public void updateClient(){
		TheOnePower.PACKET_PIPELINE.sendTo(new PacketUpdateChannelProperties(maxPower, activePower), (EntityPlayerMP) player);
	}
}
