package com.pulsior.onepower.packet.channeling;

import com.pulsior.onepower.TheOnePower;
import com.pulsior.onepower.packet.AbstractPacket;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

public class PacketPlayerEmbraceSaidar extends AbstractPacket{

	public PacketPlayerEmbraceSaidar(){}

	@Override
	public void encodeInto(ChannelHandlerContext context, ByteBuf buffer) {}

	@Override
	public void decodeInto(ChannelHandlerContext context, ByteBuf buffer) {}

	@Override
	public void handleClientSide(EntityPlayer player) {}

	@Override
	public void handleServerSide(EntityPlayer player) {
		TheOnePower.instance.addChannel(player);
		System.out.println("Saidar was embraced by "+player.getGameProfile().getName());
		
	}
	 

}
