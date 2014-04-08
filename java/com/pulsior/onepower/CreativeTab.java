package com.pulsior.onepower;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab extends CreativeTabs{

	public CreativeTab()
	{
		super("theOnePowerTab");
	}

	@Override
	public Item getTabIconItem() {
		return GameRegistry.findItem("theonepower", "itemCallandor");
	}

}
