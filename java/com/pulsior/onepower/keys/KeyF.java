package com.pulsior.onepower.keys;

import org.lwjgl.input.Keyboard;

import com.pulsior.onepower.channeling.OverlayHandler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class KeyF extends CustomBinding{

	public KeyF() {
		super("key.theonepower.embrace_saidar", Keyboard.KEY_F, "key.theonepower.category");
	}

	@Override
	public void execute() {
		OverlayHandler.instance().toggleButtons();
	}

}
