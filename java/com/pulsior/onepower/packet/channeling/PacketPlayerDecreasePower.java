package com.pulsior.onepower.packet.channeling;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

import com.pulsior.onepower.packet.AbstractPacket;

public class PacketPlayerDecreasePower extends AbstractPacket {
	
	float power; 
	
	public PacketPlayerDecreasePower(){};
	
	public PacketPlayerDecreasePower(float power){
		this.power = power;
	}
	
	@Override
	public void encodeInto(ChannelHandlerContext context, ByteBuf buffer) {
		buffer.writeFloat(power);
	}

	@Override
	public void decodeInto(ChannelHandlerContext context, ByteBuf buffer) {
		power = buffer.readFloat();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		
	}

	@Override
	public void handleServerSide(EntityPlayer player) {}

}
