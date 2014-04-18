package com.pulsior.onepower.weave;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;

public interface IWeave {
	
	public double[] getFocusPointOffset(double x, double y, double z);
	public float getRequiredPower();
	public boolean execute(EntityPlayer caster);
	public List<Element> getElements();
	
	
	
	
}
