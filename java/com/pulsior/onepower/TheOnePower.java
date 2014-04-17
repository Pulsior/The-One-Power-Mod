package com.pulsior.onepower;

import java.util.HashMap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import com.pulsior.onepower.block.PortalStoneBlock;
import com.pulsior.onepower.block.tileentity.PortalStoneBlockTileEntity;
import com.pulsior.onepower.channeling.Channel;
import com.pulsior.onepower.client.TickHandler;
import com.pulsior.onepower.client.gui.ChannelGUI;
import com.pulsior.onepower.client.renderer.PortalStoneBlockRenderer;
import com.pulsior.onepower.item.Callandor;
import com.pulsior.onepower.item.VoraSaAngreal;
import com.pulsior.onepower.keys.KeyBindings;
import com.pulsior.onepower.listener.EntityListener;
import com.pulsior.onepower.packet.PacketPipeline;
import com.pulsior.onepower.packet.channeling.PacketPlayerEmbraceSaidar;
import com.pulsior.onepower.proxy.CommonProxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = TheOnePower.MODID, name = TheOnePower.HUMAN_NAME, version = TheOnePower.VERSION)



public class TheOnePower
{
	@Mod.Instance
	public static TheOnePower instance;

	public static final PacketPipeline PACKET_PIPELINE = new PacketPipeline();
	public static final String MODID = "theonepower";
	public static final String VERSION = "0.01";
	public static final String HUMAN_NAME = "The One Power";
	@SidedProxy(clientSide = "com.pulsior.onepower.proxy.ClientProxy", serverSide = "com.pulsior.onepower.proxy.ServerProxy")
	public static CommonProxy proxy;

	public static Item callandor;

	public static CreativeTabs tab;
	private final HashMap<EntityPlayer, Channel> channelMap = new HashMap<EntityPlayer, Channel>();

	public TheOnePower(){

	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{	
		PACKET_PIPELINE.initialize();
		instance = this;
		tab = new CreativeTab();
		registerItems();
		GameRegistry.registerBlock(new PortalStoneBlock(), "blockPortalStone");
	}

	@EventHandler
	public void init(FMLInitializationEvent event){
		Crafting.init();    	    	
		GameRegistry.registerTileEntity(PortalStoneBlockTileEntity.class, "tileEntityPortalStone");
		MinecraftForge.EVENT_BUS.register(new EntityListener() );
		FMLCommonHandler.instance().bus().register(new TickHandler() );
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		PACKET_PIPELINE.postInitialize();
	}

	public void registerItems(){
		callandor = new Callandor();
		GameRegistry.registerItem(callandor, "itemCallandor");

		Item vora = new VoraSaAngreal();
		GameRegistry.registerItem(vora, "itemVoraSaAngreal");
	}

	/*
	 * Client side stuff
	 */

	/** Register event listener **/
	@SideOnly(Side.CLIENT)
	@EventHandler
	public void clientInit(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register( ChannelGUI.instance() );
		KeyBindings b = new KeyBindings();
		MinecraftForge.EVENT_BUS.register(b);
		FMLCommonHandler.instance().bus().register(b);

		ClientRegistry.bindTileEntitySpecialRenderer(PortalStoneBlockTileEntity.class, new PortalStoneBlockRenderer() );

	}



	public void addChannel(EntityPlayer player, float extraLevels, boolean sendPacket){
		channelMap.put(player, new Channel(player, extraLevels) );
		EntityPlayerMP mp = (EntityPlayerMP) player;

		if(sendPacket)
		{
			PACKET_PIPELINE.sendTo( new PacketPlayerEmbraceSaidar(extraLevels), mp);
		}
	}


	public Channel getChannel(EntityPlayer player){
		return channelMap.get(player);
	}
	




}