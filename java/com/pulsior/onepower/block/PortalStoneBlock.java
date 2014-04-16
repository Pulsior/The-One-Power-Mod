package com.pulsior.onepower.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.pulsior.onepower.TheOnePower;
import com.pulsior.onepower.block.tileentity.PortalStoneBlockTileEntity;

public class PortalStoneBlock extends BlockContainer{

	public PortalStoneBlock() {
		super(Material.rock);
		this.setCreativeTab(TheOnePower.tab);
		this.setBlockBounds(0.05F, 0.0F, 0.05F, 0.95F, 2.0F, 0.95F);
		this.setBlockName("blockPortalStone");
		this.setLightLevel( this.getLightValue() );
		this.setHardness(12000);
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
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new PortalStoneBlockTileEntity();
		
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register){
		this.blockIcon = register.registerIcon("theonepower:portalstoneitem");
	}
	

}
