package com.pulsior.onepower.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import com.pulsior.onepower.TheOnePower;
import com.pulsior.onepower.keys.CustomBinding;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class OverlayHandler extends Gui{

	public static boolean renderElements = false;
	public static boolean renderGlow = false;
	KeyBinding f = CustomBinding.BINDING_F;
	
	private ResourceLocation iconsRl = new ResourceLocation(TheOnePower.MODID, "textures/gui/atlas-icons.png");
	private ResourceLocation glowRl =  new ResourceLocation(TheOnePower.MODID, "textures/gui/glow.png");
	public float full = 0F;
	private static OverlayHandler instance;

	Minecraft mc = Minecraft.getMinecraft();

	private OverlayHandler(){

	}

	public static OverlayHandler instance(){

		if(instance == null){
			instance = new OverlayHandler();
		}

		return instance;
	}


	@SubscribeEvent
	public void onRender(RenderGameOverlayEvent event){

		if(event.type == ElementType.CROSSHAIRS){

			if(renderElements){
				renderElements();
			}

			if(renderGlow){
				renderSaidarGlow();
				renderLevelBar();
				
				if( f.getIsKeyPressed() && full < TheOnePower.getChannel().getMaxPower() ){
					TheOnePower.getChannel().drawPower();
				}
				
			}

		}    
	}
	
	public void toggleOverlay(){
		renderGlow = ! renderGlow;
		renderElements = ! renderElements;
		if( ! renderElements){
			full = 0F;
		}
	}

	public boolean isSaidarEmbraced(){
		return renderGlow;
	}

	public boolean isChanneling(){
		return renderElements;
	}

	private void renderElements(){						
		final int SIZE = 32;

		ScaledResolution r = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);	

		int x = r.getScaledWidth() / 2 - 78;
		int y = (int) ( 0.05 * (double) r.getScaledHeight() );
		
		mc.renderEngine.bindTexture( iconsRl ) ;

		int space = 0;

		for(int i = 0; i < 5 * SIZE; i = i + SIZE){
			this.drawTexturedModalRect(x + space + i , y, i, 0, SIZE, SIZE);
			space = space + 3;				
		}
	}
	
	/**
	 * Render golden glow on screen
	 */
	
	private void renderSaidarGlow()
	{
		ScaledResolution r = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);	
		int par1 = r.getScaledWidth();
		int par2 = r.getScaledHeight();
		
		/*Enable transparency*/
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColor4f(1F, 1F, 1F, 0.2F);

		Minecraft.getMinecraft().getTextureManager().bindTexture(glowRl);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(0.0D, (double)par2, -90.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV((double)par1, (double)par2, -90.0D, 1.0D, 1.0D);
		tessellator.addVertexWithUV((double)par1, 0.0D, -90.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
		tessellator.draw();

		/*Disable transparency*/
		GL11.glDisable(GL11.GL_BLEND);

	}
	
	/**
	 * Render the saidar level indicating bar
	 */
	
	private void renderLevelBar(){
		final int BAR_LENGTH = 173;
		final int BAR_WIDTH = 9;
		final int CONTENT_LENGTH = (int)(full * BAR_LENGTH);
		
		ScaledResolution r = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
		mc.renderEngine.bindTexture( iconsRl );
		int x = r.getScaledWidth() - 18;
		int y = r.getScaledHeight() / 2 - 85;
		
		int cx = x - 1;
		int cy = y + 171 - CONTENT_LENGTH;
		
		if(cy < y){
			cy = y;
		}
		
		this.drawTexturedModalRect(cx, cy, 256-2*BAR_WIDTH, 0, BAR_WIDTH, CONTENT_LENGTH);
		this.drawTexturedModalRect(x, y, 256-BAR_WIDTH, 0, BAR_WIDTH, BAR_LENGTH);
		
	}
	
	/**
	 * Update the level bar
	 */
	
	public void updateLevelBar(float full){
		this.full = full;
	}

}
