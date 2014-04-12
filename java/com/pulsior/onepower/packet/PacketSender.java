package com.pulsior.onepower.packet;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.EnumMap;

import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;

public class PacketSender extends FMLIndexedMessageToMessageCodec<IPacket>{
	
	public static PacketSender instance = new PacketSender();
	private EnumMap<Side, FMLEmbeddedChannel> channels = NetworkRegistry.INSTANCE.newChannel("OPpackethandler", instance);
	
	
	private PacketSender() {
		//this.addDiscriminator(0, PacketEmbraceSaidar.class);
    }
	

    @Override
    public void encodeInto(ChannelHandlerContext ctx, IPacket packet, ByteBuf data) throws Exception {
        packet.writeBytes(data);
    }

    @Override
    public void decodeInto(ChannelHandlerContext ctx, ByteBuf data, IPacket packet) {
    	System.out.println("Packet");
        packet.readBytes(data);
    }
    
    public void sendPacketToServer(IPacket packet){
    	channels.get(Side.CLIENT).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
    	channels.get(Side.CLIENT).writeOutbound(packet);
    }
	
}
