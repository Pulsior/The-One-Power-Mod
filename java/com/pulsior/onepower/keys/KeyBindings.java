package com.pulsior.onepower.keys;

import java.util.ArrayList;
import java.util.List;

import com.pulsior.onepower.TheOnePower;

import net.minecraft.client.gui.GuiChat;
import net.minecraftforge.client.event.MouseEvent;
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
		ClientRegistry.registerKeyBinding( CustomBinding.BINDING_F );
		ClientRegistry.registerKeyBinding( CustomBinding.BINDING_V );
		ClientRegistry.registerKeyBinding( CustomBinding.BINDING_R );
		bindings.add(CustomBinding.BINDING_F);
		bindings.add(CustomBinding.BINDING_R);
		bindings.add(CustomBinding.BINDING_V);
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

	@SubscribeEvent
	public void onMouseInput(MouseEvent event){
		int dwheel = event.dwheel;
		if(TheOnePower.getChannel() != null){
			if(dwheel > 0){
				TheOnePower.getChannel().scroll(-1);
				event.setCanceled(true);
			}
			else if(dwheel < 0){
				TheOnePower.getChannel().scroll(1);
				event.setCanceled(true);
			}
		}
		
	}

}
