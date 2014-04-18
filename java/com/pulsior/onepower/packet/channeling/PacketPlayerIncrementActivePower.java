package com.pulsior.onepower.packet.channeling;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import com.pulsior.onepower.TheOnePower;
import com.pulsior.onepower.channeling.Channel;
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
		data.replenishPower(0.100000F);
		
		float maxPower = data.getMaxPower();
		float activePower = data.getActivePower();
		
		Channel channel = TheOnePower.instance.getChannel(player);

		if(channel != null)
		{
			channel.update();
		}

		TheOnePower.PACKET_PIPELINE.sendTo( new PacketUpdateChannelProperties( maxPower, activePower ), (EntityPlayerMP) player);
		
	}

}
