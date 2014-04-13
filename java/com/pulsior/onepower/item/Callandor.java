package com.pulsior.onepower.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

import com.pulsior.onepower.TheOnePower;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Callandor extends ItemSword{

	public Callandor(){
		super(ToolMaterial.STONE);
		setUnlocalizedName("itemCallandor");
		setCreativeTab(TheOnePower.tab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon("theonepower:callandor");
	}


	/*
	 * Make sure the sword does not get damaged
	 */
	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		return true;
	}

	/*
	 * Embrace saidar on item use
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
		
		if(! par2World.isRemote )
		{
			TheOnePower.instance.addChannel(par3EntityPlayer, 150);
		}
		
		return par1ItemStack;
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, World par3World, int par4, int par5,
			int par6, int par7, float par8, float par9, float par10) {
		
		if(! par3World.isRemote )
		{
			TheOnePower.instance.addChannel(par2EntityPlayer, 150);
		}
		
		return true;
	}
	
	
	

}
