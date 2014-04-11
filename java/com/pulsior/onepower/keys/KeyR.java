package com.pulsior.onepower.keys;

import org.lwjgl.input.Keyboard;

public class KeyR extends CustomBinding{
	
	public KeyR(){
		super("key.theonepower.hold_while_channeling", Keyboard.KEY_R, "key.theonepower.category");
	}

	@Override
	public void execute() {
	}
}
