package com.pulsior.onepower;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import com.pulsior.onepower.block.PortalStoneBlock;
import com.pulsior.onepower.block.PortalStoneBlockTileEntity;
import com.pulsior.onepower.block.renderer.PortalStoneBlockRenderer;
import com.pulsior.onepower.channeling.Channel;
import com.pulsior.onepower.client.OverlayHandler;
import com.pulsior.onepower.item.Callandor;
import com.pulsior.onepower.item.VoraSaAngreal;
import com.pulsior.onepower.keys.KeyBindings;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
 
@Mod(modid = TheOnePower.MODID, name = TheOnePower.HUMAN_NAME, version = TheOnePower.VERSION)



public class TheOnePower
{
	@Mod.Instance
    public static TheOnePower instance;
	
    public static final String MODID = "theonepower";
    public static final String VERSION = "0.01";
    public static final String HUMAN_NAME = "The One Power";
    
    private static Channel activeChannel;
    public static Item callandor;
    
    public static CreativeTabs tab;
 
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {	
    	instance = this;
    	tab = new CreativeTab();
    	registerItems();
    	GameRegistry.registerBlock(new PortalStoneBlock(), "blockPortalStone");
     }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
    	Crafting.init();    	    	
    	GameRegistry.registerTileEntity(PortalStoneBlockTileEntity.class, "tileEntityPortalStone");
    }
    
    /** Register event listener **/
    @SideOnly(Side.CLIENT)
    @EventHandler
    public void clientInit(FMLInitializationEvent event){
    	MinecraftForge.EVENT_BUS.register( OverlayHandler.instance() );
    	KeyBindings b = new KeyBindings();
    	MinecraftForge.EVENT_BUS.register(b);
    	FMLCommonHandler.instance().bus().register(b);
    	
    	ClientRegistry.bindTileEntitySpecialRenderer(PortalStoneBlockTileEntity.class, new PortalStoneBlockRenderer() );
    	
    }
    
    public void registerItems(){
    	callandor = new Callandor();
    	GameRegistry.registerItem(callandor, "itemCallandor");
		
		Item vora = new VoraSaAngreal();
		GameRegistry.registerItem(vora, "itemVoraSaAngreal");
    }
    
    public static void newChannel(){
    	//activeChannel = new Channel();
    	
    }
    
    public static Channel getChannel(){
    	return activeChannel;
    }
    
    public static void removeChannel(){
    	activeChannel = null;
    }
    
    
}