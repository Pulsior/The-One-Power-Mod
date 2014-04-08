package com.pulsior.onepower.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

import com.pulsior.onepower.TheOnePower;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class VoraSaAngreal extends Item{

	public VoraSaAngreal(){
		super();
		setUnlocalizedName("itemVoraSaAngreal");
		setCreativeTab(TheOnePower.tab);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon("theonepower:sa'angreal vora");
	}
	
	
	
}
