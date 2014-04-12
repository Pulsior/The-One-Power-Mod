package com.pulsior.onepower.packet.channeling;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

import com.pulsior.onepower.TheOnePower;
import com.pulsior.onepower.packet.AbstractPacket;
import com.pulsior.onepower.weave.Element;

import cpw.mods.fml.common.network.ByteBufUtils;

public class PacketPlayerAddElement extends AbstractPacket {

	Element element;
	
	public PacketPlayerAddElement(){};
	
	public PacketPlayerAddElement(Element element) {
		this.element = element;
	}

	@Override
	public void encodeInto(ChannelHandlerContext context, ByteBuf buffer) {
		ByteBufUtils.writeUTF8String(buffer, element.toString());

	}

	@Override
	public void decodeInto(ChannelHandlerContext context, ByteBuf buffer) {
		String elementAsString = ByteBufUtils.readUTF8String(buffer);
		element = Element.valueOf(elementAsString);
	}

	@Override
	public void handleClientSide(EntityPlayer player) {

	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		TheOnePower.instance.getChannel(player).addElement(element);
	}

}
