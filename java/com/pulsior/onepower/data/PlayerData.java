package com.pulsior.onepower.data;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

/**
 * Class to save mod-related player data.
 */
public class PlayerData implements IExtendedEntityProperties{

	public static final String PLAYER_DATA_TAG = "playerDataTheOnePower";
	public static final String MAX_POWER = "playerMaxPower";
	public static final String ACTIVE_POWER = "playerActivePower";
	private final EntityPlayer player;

	private float activePower;
	private float maxPower;

	public PlayerData(EntityPlayer player){
		this.player = player;
		this.maxPower = 10F;
		this.activePower = maxPower;
		player.registerExtendedProperties(PLAYER_DATA_TAG, this);
		System.out.println("DataConstructor");
	}

	public static void register(EntityPlayer player){
		player.registerExtendedProperties(PlayerData.PLAYER_DATA_TAG, new PlayerData(player) );
		System.out.println("dataregistered");
	}

	public static PlayerData getCustomData(EntityPlayer player){
		PlayerData data = (PlayerData) player.getExtendedProperties(PLAYER_DATA_TAG);
		return data;
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound data = new NBTTagCompound();
		data.setFloat(MAX_POWER, maxPower);
		data.setFloat(ACTIVE_POWER, activePower);
		compound.setTag(PLAYER_DATA_TAG, data);
		System.out.println("data saved ");
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(PLAYER_DATA_TAG);
		this.maxPower = properties.getInteger(MAX_POWER);
		this.activePower = properties.getFloat(ACTIVE_POWER);
		System.out.println("dataloadd");
	}

	@Override
	public void init(Entity entity, World world) {

	}

	public float getMaxPower(){
		return maxPower;
	}
	
	public float getActivePower(){
		return activePower;
	}
	
	public void usePower(float usedPower){
		activePower -= usedPower;
	}

	public void replenishPower(float power){
		if(maxPower <= activePower + power){
			activePower += power;
		}
	}



}
