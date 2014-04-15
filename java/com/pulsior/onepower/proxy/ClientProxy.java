package com.pulsior.onepower.proxy;

import com.pulsior.onepower.client.ChannelGUI;

public class ClientProxy extends CommonProxy{

	@Override
	public void toggleChannelingGui() {
		ChannelGUI.instance().toggleVisible(true);
		System.out.println("Toggled in proxy");
	}

	@Override
	public void addElement() {}

}