package com.pulsior.onepower.keys;

import org.lwjgl.input.Keyboard;

import com.pulsior.onepower.TheOnePower;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class KeyV extends CustomBinding{
	
	public KeyV() {
		super("key.theonepower.channel", Keyboard.KEY_V, "key.theonepower.category");
	}

	@Override
	public void execute() {		
		TheOnePower.proxy.toggleChannelingGui();
	}

}
