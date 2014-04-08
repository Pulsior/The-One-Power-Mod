package com.pulsior.onepower.channeling;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import com.pulsior.onepower.TheOnePower;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class OverlayHandler extends Gui{

	public static boolean renderElements = false;
	public static boolean renderGlow = false;


	private ResourceLocation iconsRl = new ResourceLocation(TheOnePower.MODID, "textures/gui/atlas-icons.png");
	private ResourceLocation glowRl =  new ResourceLocation(TheOnePower.MODID, "textures/gui/glow.png");
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
			}

		}    
	}

	public void toggleGlow(){
		renderGlow = ! renderGlow;
		if( ! renderGlow) renderElements = false;
	}

	public void toggleButtons(){
		if(renderGlow) renderElements = ! renderElements;				
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
		ScaledResolution r = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
		mc.renderEngine.bindTexture( iconsRl );
		int x = r.getScaledWidth() - 18;
		int y = r.getScaledHeight() / 2 - 85;
		this.drawTexturedModalRect(x, y, 247, 0, 9, 173);
	}

}
