package com.pulsior.onepower.keys;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.settings.KeyBinding;

@SideOnly(Side.CLIENT)
public abstract class CustomBinding extends KeyBinding{

	public static final CustomBinding BINDING_F = new KeyF();
	public static final CustomBinding BINDING_V = new KeyV();
	
	public CustomBinding(String p_i45001_1_, int p_i45001_2_, String p_i45001_3_) {
		super(p_i45001_1_, p_i45001_2_, p_i45001_3_);
	}
	
	public abstract void execute();

}
