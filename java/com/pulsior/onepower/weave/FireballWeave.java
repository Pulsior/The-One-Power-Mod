package com.pulsior.onepower.weave;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.pulsior.onepower.TheOnePower;
import com.pulsior.onepower.packet.channeling.PacketPlayerRenderParticle;

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
	public double[] getFocusPointOffset(double x, double y, double z){
		return new double[]{x+2, y+2, z}; 
	}

	@Override
	public boolean execute(EntityPlayer caster) {
		World world = caster.getEntityWorld();
		if (!world.isRemote)
		{			
			TheOnePower.PACKET_PIPELINE.sendTo(new PacketPlayerRenderParticle(), (EntityPlayerMP) caster);
			double posX = caster.posX;
			double posY = caster.posY;
			double posZ = caster.posZ;
			
			double[] offset = getFocusPointOffset(posX, posY, posZ);
			posX += offset[0];
			posY += offset[1];
			posZ += offset[2];
			
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
			return true;
		}

		return false;
	}

	@Override
	public List<Element> getElements() {
		return elements;
	}

}
