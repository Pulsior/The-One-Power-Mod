package com.pulsior.onepower.packet.channeling;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import com.pulsior.onepower.TheOnePower;
import com.pulsior.onepower.channeling.Channel;
import com.pulsior.onepower.client.ChannelGUI;
import com.pulsior.onepower.packet.AbstractPacket;

public class PacketPlayerDrawSaidar extends AbstractPacket{
	
	
	@Override
	public void encodeInto(ChannelHandlerContext context, ByteBuf buffer) {
		
	}

	@Override
	public void decodeInto(ChannelHandlerContext context, ByteBuf buffer) {
		
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		ChannelGUI.instance().decrementLevelBar();
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		Channel channel = TheOnePower.instance.getChannel(player);
		boolean canDrawMoreSaidar = channel.drawPower();
		if(! canDrawMoreSaidar){
			TheOnePower.PACKET_PIPELINE.sendTo(new PacketPlayerDrawSaidar(), (EntityPlayerMP) player);
		}
		
	}

}
