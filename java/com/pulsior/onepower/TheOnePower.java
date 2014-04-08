package com.pulsior.onepower;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.WorldSettings.GameType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

import com.pulsior.onepower.channeling.OverlayHandler;
import com.pulsior.onepower.item.Callandor;
import com.pulsior.onepower.item.VoraSaAngreal;
import com.pulsior.onepower.keys.KeyBindings;

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
    public static final String VERSION = "1.0";
    public static final String HUMAN_NAME = "The One Power";
    
    public static Item callandor;
    
    public static CreativeTabs tab;
 
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {	
    	instance = this;
    	tab = new CreativeTab();
    	registerItems(); 
     }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
    	Crafting.init();
    	
    }
    
    /** Register event listener **/
    @SideOnly(Side.CLIENT)
    @EventHandler
    public void clientInit(FMLInitializationEvent event){
    	MinecraftForge.EVENT_BUS.register( OverlayHandler.instance() );
    	FMLCommonHandler.instance().bus().register(new KeyBindings() );
    }
    
    public void registerItems(){
    	callandor = new Callandor();
    	GameRegistry.registerItem(callandor, "itemCallandor");
		
		Item vora = new VoraSaAngreal();
		GameRegistry.registerItem(vora, "itemVoraSaAngreal");
    }
    
    @EventHandler
    public void onClick(PlayerSleepInBedEvent event){
    	event.entityPlayer.setGameType(GameType.CREATIVE);
    }
}