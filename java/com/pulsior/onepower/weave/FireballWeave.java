package com.pulsior.onepower.weave;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class FireballWeave implements IWeave {

	List<Element> elements;

	//public double posX;
	//public double posY;
	//public double posZ;
	public double motionX;
	public double motionY;
	public double motionZ;
	public float rotationYaw;
	public float rotationPitch;
	public float prevRotationYaw;
	public float prevRotationPitch;
	public float yOffset;

	public FireballWeave(){
		elements = new ArrayList<Element>();
		elements.add(Element.FIRE);
		elements.add(Element.FIRE);
	}

	@Override
	public float getRequiredPower() {
		return 4.5F;
	}

	@Override
	public boolean execute(EntityPlayer caster) {
		World world = caster.getEntityWorld();
		if (!world.isRemote)
		{
			Vec3 look = caster.getLookVec();
			EntityLargeFireball fireball2 = new EntityLargeFireball(world, caster, 1, 1, 1);
			fireball2.setPosition(
					caster.posX + look.xCoord,
					caster.posY + look.yCoord + 1,
					caster.posZ + look.zCoord);
			fireball2.accelerationX = look.xCoord * 0.1;
			fireball2.accelerationY = look.yCoord * 0.1;
			fireball2.accelerationZ = look.zCoord * 0.1;
			world.spawnEntityInWorld(fireball2);

		}

		return false;
	}

	@Override
	public List<Element> getElements() {
		return elements;
	}

}
