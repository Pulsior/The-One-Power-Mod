package com.pulsior.onepower.keys;

import org.lwjgl.input.Keyboard;

import com.pulsior.onepower.TheOnePower;
import com.pulsior.onepower.packet.channeling.PacketPlayerCastWeave;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class KeyF extends CustomBinding{

	public KeyF() {
		super("key.theonepower.embrace_saidar", Keyboard.KEY_F, "key.theonepower.category");
	}

	@Override
	public void execute() {
		TheOnePower.PACKET_PIPELINE.sendToServer( new PacketPlayerCastWeave() );
	}

}
