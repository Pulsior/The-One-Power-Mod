package com.pulsior.onepower.packet.channeling;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

import com.pulsior.onepower.client.gui.ChannelGUI;
import com.pulsior.onepower.packet.AbstractPacket;

public class PacketUpdateChannelProperties extends AbstractPacket{
	
	float maxPower;
	float activePower;
	
	public PacketUpdateChannelProperties(){};
	
	public PacketUpdateChannelProperties(float maxPower, float activePower){
		this.maxPower = maxPower;
		this.activePower = activePower;
	}
	
	@Override
	public void encodeInto(ChannelHandlerContext context, ByteBuf buffer) {
		buffer.writeFloat(maxPower);
		buffer.writeFloat(activePower);
	}

	@Override
	public void decodeInto(ChannelHandlerContext context, ByteBuf buffer) {
		maxPower = buffer.readFloat();
		activePower = buffer.readFloat();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		ChannelGUI.instance().setMaxPower(maxPower);
		ChannelGUI.instance().setActivePower(activePower);
	}

	@Override
	public void handleServerSide(EntityPlayer player) {}

}
