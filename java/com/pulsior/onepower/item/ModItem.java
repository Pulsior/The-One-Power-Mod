package com.pulsior.onepower.item;

import com.pulsior.onepower.TheOnePower;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public enum ModItem {
	
	CALLANDOR("itemCallandor"),
	VORA("itemVoraSaAngreal");
	
	String itemName;
	
	ModItem(String itemName){
		this.itemName = itemName;
	}
	
	public Item getItem(){
		return GameRegistry.findItem(TheOnePower.MODID, itemName);
	}
	
	
}
