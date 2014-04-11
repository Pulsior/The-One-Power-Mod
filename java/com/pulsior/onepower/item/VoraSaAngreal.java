package com.pulsior.onepower.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.pulsior.onepower.TheOnePower;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class VoraSaAngreal extends Item{

	public VoraSaAngreal(){
		super();
		setUnlocalizedName("itemVoraSaAngreal");
		setCreativeTab(TheOnePower.tab);
	}
	
	/*
	 * Embrace saidar on item use
	 */
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par3EntityPlayer, World par2World, int par4, int par5, int par6, int par7, float par8, float par9, float par10 ){
		if(TheOnePower.getChannel() == null){
			TheOnePower.newChannel();
		}
		else{
			TheOnePower.getChannel().close();
		}
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon("theonepower:sa'angreal vora");
	}
	
	
	
}
