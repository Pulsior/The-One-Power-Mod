package com.pulsior.onepower.packet.channeling;

import com.pulsior.onepower.TheOnePower;
import com.pulsior.onepower.client.gui.ChannelGUI;
import com.pulsior.onepower.packet.AbstractPacket;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

public class PacketPlayerEmbraceSaidar extends AbstractPacket{
	
	float extraLevels;
	
	public PacketPlayerEmbraceSaidar(){}
	
	public PacketPlayerEmbraceSaidar(float extraLevels){
		this.extraLevels = extraLevels;
	}

	@Override
	public void encodeInto(ChannelHandlerContext context, ByteBuf buffer) {
		buffer.writeFloat(extraLevels);
	}

	@Override
	public void decodeInto(ChannelHandlerContext context, ByteBuf buffer) {
		extraLevels = buffer.readFloat();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		ChannelGUI.instance().toggleVisible(false);
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		TheOnePower.instance.addChannel(player, extraLevels, false);
		
	}
	 

}
