package com.pulsior.onepower.weave;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;

public interface IWeave {
	
	public float getRequiredPower();
	public boolean execute(EntityPlayer caster);
	public List<Element> getElements();
	
	
	
	
}
