package com.pulsior.onepower.packet.channeling;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntitySmokeFX;
import net.minecraft.entity.player.EntityPlayer;

import com.pulsior.onepower.packet.AbstractPacket;

public class PacketPlayerRenderParticle extends AbstractPacket {

	@Override
	public void encodeInto(ChannelHandlerContext context, ByteBuf buffer) {	}

	@Override
	public void decodeInto(ChannelHandlerContext context, ByteBuf buffer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		
		EntityFX candleFlame = new EntitySmokeFX(player.getEntityWorld(), player.posX + 3, player.posY + 2, player.posZ, 0.0D, 0.0D, 0.0D);
		Minecraft.getMinecraft().effectRenderer.addEffect(candleFlame);
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		// TODO Auto-generated method stub

	}

}
