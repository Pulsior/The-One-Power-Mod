package com.pulsior.onepower.weave;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.world.World;

public class SnowballWeave implements IWeave {

	List<Element> elements;
	
	public SnowballWeave(){
		elements = new ArrayList<Element>();
		elements.add(Element.AIR);
		elements.add(Element.WATER);
	}
	
	@Override
	public float getRequiredPower() {
		return 1.5F;
	}

	@Override
	public boolean execute(EntityPlayer caster) {
		World world = caster.getEntityWorld();
		if (!world.isRemote)
        {
            world.spawnEntityInWorld( new EntitySnowball(world, caster) );
        }
		
		return false;
	}

	@Override
	public List<Element> getElements() {
		return elements;
	}

}
