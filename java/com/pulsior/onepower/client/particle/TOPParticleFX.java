package com.pulsior.onepower.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

public class TOPParticleFX extends EntityFX{

	public TOPParticleFX(World par1World, double par2, double par4,
			double par6) {
		super(par1World, par2, par4, par6);
	}

	@Override
	public void renderParticle(Tessellator par1Tessellator, float par2,
			float par3, float par4, float par5, float par6, float par7) {

		float f6 = (float)this.particleTextureIndexX / 16.0F;
		float f7 = f6 + 0.0624375F;
		float f8 = (float)this.particleTextureIndexY / 16.0F;
		float f9 = f8 + 0.0624375F;
		float f10 = 0.1F * this.particleScale;
		if (this.particleIcon != null)
		{
			f6 = this.particleIcon.getMinU();
			f7 = this.particleIcon.getMaxU();
			f8 = this.particleIcon.getMinV();
			f9 = this.particleIcon.getMaxV();
		}

		float f11 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)par2 - interpPosX);
		float f12 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)par2 - interpPosY);
		float f13 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)par2 - interpPosZ);
		par1Tessellator.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
		par1Tessellator.addVertexWithUV((double)(f11 - par3 * f10 - par6 * f10), (double)(f12 - par4 * f10), (double)(f13 - par5 * f10 - par7 * f10), (double)f7, (double)f9);
		par1Tessellator.addVertexWithUV((double)(f11 - par3 * f10 + par6 * f10), (double)(f12 + par4 * f10), (double)(f13 - par5 * f10 + par7 * f10), (double)f7, (double)f8);
		par1Tessellator.addVertexWithUV((double)(f11 + par3 * f10 + par6 * f10), (double)(f12 + par4 * f10), (double)(f13 + par5 * f10 + par7 * f10), (double)f6, (double)f8);
		par1Tessellator.addVertexWithUV((double)(f11 + par3 * f10 - par6 * f10), (double)(f12 - par4 * f10), (double)(f13 + par5 * f10 - par7 * f10), (double)f6, (double)f9);
	}

}
