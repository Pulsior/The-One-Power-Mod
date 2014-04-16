package com.pulsior.onepower.packet.channeling;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

import com.pulsior.onepower.client.gui.ChannelGUI;
import com.pulsior.onepower.packet.AbstractPacket;

public class PacketUpdateChannelProperties extends AbstractPacket{
	
	float maxPower;
	float drawnPower;
	
	public PacketUpdateChannelProperties(){};
	
	public PacketUpdateChannelProperties(float maxPower, float drawnPower){
		this.maxPower = maxPower;
		this.drawnPower = drawnPower;
	}
	
	@Override
	public void encodeInto(ChannelHandlerContext context, ByteBuf buffer) {
		buffer.writeFloat(maxPower);
		buffer.writeFloat(drawnPower);
	}

	@Override
	public void decodeInto(ChannelHandlerContext context, ByteBuf buffer) {
		maxPower = buffer.readFloat();
		drawnPower = buffer.readFloat();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		ChannelGUI.instance().setMaxPower(maxPower);
		ChannelGUI.instance().setDrawnPower(drawnPower);
	}

	@Override
	public void handleServerSide(EntityPlayer player) {}

}
