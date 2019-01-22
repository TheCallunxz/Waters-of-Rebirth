/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 *
 * File Created @ [Aug 27, 2014, 8:55:00 PM (GMT)]
 */
package thecallunxz.wor.render.layers;

import javax.annotation.Nonnull;

import org.lwjgl.opengl.GL11;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import baubles.api.render.IRenderBauble;
import baubles.api.render.IRenderBauble.RenderType;
import baubles.common.Config;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thecallunxz.wor.items.ItemWings;
import thecallunxz.wor.models.ModelWings;

public class LayerWings implements LayerRenderer<EntityPlayer> {
	
	private static final ResourceLocation WINGS_TEXTURE = new ResourceLocation("wor:textures/wings/test_wing.png");
	private final RenderPlayer renderer;

	public LayerWings(RenderPlayer renderer) {
		this.renderer = renderer;
	}
	
	@Override
	public void doRenderLayer(@Nonnull EntityPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {

		IBaublesItemHandler inv = BaublesApi.getBaublesHandler(player);
		
		float yaw = player.prevRotationYawHead + (player.rotationYawHead - player.prevRotationYawHead) * partialTicks;
		float yawOffset = player.prevRenderYawOffset + (player.renderYawOffset - player.prevRenderYawOffset) * partialTicks;
		float pitch = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * partialTicks;
		
		boolean wingsEquipped = false;
		ItemWings wings;
		
		for (int i = 0; i < inv.getSlots(); ++i) {
			if(inv.getStackInSlot(i).getItem() instanceof ItemWings) {
				wings = (ItemWings) inv.getStackInSlot(i).getItem();
				wingsEquipped = true;
				break;
			}
		}

		if(wingsEquipped) {
			ModelWings wingModel = new ModelWings();
			GlStateManager.pushMatrix();
			GlStateManager.enableCull();
			renderer.bindTexture(WINGS_TEXTURE);
			wingModel.render(player, scale, partialTicks);
			GlStateManager.disableCull();
			GlStateManager.popMatrix();
		}
	}

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
}