package com.pulsior.onepower;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.pulsior.onepower.item.ModItem;

import cpw.mods.fml.common.registry.GameRegistry;

public class Crafting {
	
	public static void init(){
		GameRegistry.addShapedRecipe(new ItemStack( ModItem.CALLANDOR.getItem() ), " x ", "xyx", "x x", 'x', Blocks.glass, 'y', Items.stone_sword ) ;
	}
	
}
