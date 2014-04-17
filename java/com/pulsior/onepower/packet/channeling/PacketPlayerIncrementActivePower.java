package com.pulsior.onepower.packet.channeling;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

import com.pulsior.onepower.data.PlayerData;
import com.pulsior.onepower.packet.AbstractPacket;

public class PacketPlayerIncrementActivePower extends AbstractPacket{
	
	@Override
	public void encodeInto(ChannelHandlerContext context, ByteBuf buffer) {}

	@Override
	public void decodeInto(ChannelHandlerContext context, ByteBuf buffer) {}

	@Override
	public void handleClientSide(EntityPlayer player) {}

	@Override
	public void handleServerSide(EntityPlayer player) {
		PlayerData data = PlayerData.getCustomData(player);
		data.replenishPower(0.1F);
	}

}
