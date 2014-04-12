package com.pulsior.onepower.packet;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;


public abstract class AbstractPacket {
	
    /**
     * Encode the packet data into the ByteBuf stream.
     *
     * @param context    channel context
     * @param buffer the buffer to encode into
     */
    public abstract void encodeInto(ChannelHandlerContext context, ByteBuf buffer);

    /**
     * Decode the packet data from the ByteBuf stream.
     *
     * @param ctx    channel context
     * @param buffer the buffer to decode from
     */
    public abstract void decodeInto(ChannelHandlerContext context, ByteBuf buffer);

    /**
     * Handle a packet on the client side.
     *
     * @param player the player reference
     */
    public abstract void handleClientSide(EntityPlayer player);

    /**
     * Handle a packet on the server side.
     *
     * @param player the player reference
     */
    public abstract void handleServerSide(EntityPlayer player);
	
}
