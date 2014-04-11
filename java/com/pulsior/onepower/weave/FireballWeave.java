package com.pulsior.onepower.weave;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;

public class FireballWeave implements IWeave {

	List<Element> elements;
	
	public FireballWeave(){
		elements = new ArrayList<Element>();
		elements.add(Element.FIRE);
		elements.add(Element.FIRE);
	}
	
	@Override
	public float getRequiredPower() {
		return 5F;
	}

	@Override
	public boolean execute(EntityPlayer caster) {
		System.out.println("============");
		System.out.println("xxxxxxxxxxxxx");
		System.out.println("============");
		return false;
	}

	@Override
	public List<Element> getElements() {
		return elements;
	}

}
