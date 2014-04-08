package com.pulsior.onepower.recipe;

import com.pulsior.onepower.item.Callandor;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class CallandorRecipe implements IRecipe{

	@Override
	public boolean matches(InventoryCrafting var1, World var2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting var1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRecipeSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return new ItemStack( new Callandor() );
	}

}
