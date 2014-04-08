package com.pulsior.onepower.keys;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiChat;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class KeyBindings {

	List<CustomBinding> bindings = new ArrayList<CustomBinding>();

	public KeyBindings(){
		CustomBinding KeyF = new KeyF();
		CustomBinding KeyV = new KeyV();
		ClientRegistry.registerKeyBinding( KeyF );
		ClientRegistry.registerKeyBinding( KeyV );
		bindings.add(KeyF);
		bindings.add(KeyV);
	}

	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) {

		if (!FMLClientHandler.instance().isGUIOpen(GuiChat.class)) {
			
			for(CustomBinding bind : bindings){
				if( bind.getIsKeyPressed() ){
					bind.execute();
				}
			}

		}
	}

}
