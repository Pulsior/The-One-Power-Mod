package com.pulsior.onepower.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.pulsior.onepower.TheOnePower;

public class PortalStoneBlock extends BlockContainer{

	public PortalStoneBlock() {
		super(Material.portal);
		this.setCreativeTab(TheOnePower.tab);
		this.setBlockBounds(0.4F, 0.0F, 0.4F, 1.5F, 2.0F, 1.5F);
	}

	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}

	@Override
	public int getRenderType(){
		return -1;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new PortalStoneBlockTileEntity();
		
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register){
		this.blockIcon = register.registerIcon("theonepower:portalstoneItem");
	}
	

}
