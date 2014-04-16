package com.pulsior.onepower.keys;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiChat;
import net.minecraftforge.client.event.MouseEvent;

import com.pulsior.onepower.TheOnePower;
import com.pulsior.onepower.client.gui.ChannelGUI;
import com.pulsior.onepower.packet.channeling.PacketPlayerAddElement;

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
		int button = event.button;
		boolean buttonstate = event.buttonstate;
		ChannelGUI gui = ChannelGUI.instance();		
		
		if( gui.isEnabled() ){
			
			if(dwheel > 0){
				gui.scroll(-1);
				event.setCanceled(true);
			}
			
			else if(dwheel < 0){
				gui.scroll(1);
				event.setCanceled(true);
			}
			
			if(button == 2 && buttonstate){
				TheOnePower.PACKET_PIPELINE.sendToServer(new PacketPlayerAddElement( ChannelGUI.instance().getSelectedElement() ) );
			}
		}
		
	}

}
