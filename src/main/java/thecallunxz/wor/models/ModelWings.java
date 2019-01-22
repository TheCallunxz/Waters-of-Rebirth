package thecallunxz.wor.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import thecallunxz.wor.util.WingSyncHandler;

public final class ModelWings extends ModelBase {
	public ModelRenderer root;
    public ModelRenderer leftWing;
    public ModelRenderer rightWing;

	public ModelWings() {
		this.textureWidth = 64;
        this.textureHeight = 32;
        this.leftWing = new ModelRenderer(this, 0, 0);
        this.leftWing.mirror = true;
        this.leftWing.setRotationPoint(0.0F, 0.0F, 2.5F);
        this.leftWing.addBox(0.0F, 0.0F, 0.0F, 20, 18, 0, 0.0F);
        this.rightWing = new ModelRenderer(this, 0, 0);
        this.rightWing.setRotationPoint(0.0F, 0.0F, 2.5F);
        this.rightWing.addBox(-20.0F, 0.0F, 0.0F, 20, 18, 0, 0.0F);
        this.root = new ModelRenderer(this, 0, 0);
        this.root.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.root.addBox(0.0F, 0.0F, 0.0F, 0, 0, 0, 0.0F);
        this.root.addChild(this.leftWing);
        this.root.addChild(this.rightWing);
	}

	public void render(EntityPlayer player, float scale, float partialTicks) {
		this.root.rotationPointZ = 0F;
		
		int period = 10;
		
		float flapAmount = 0;
		
		if(WingSyncHandler.isPlayerFlying(player)) {
			flapAmount = (float) Math.cos(2 * Math.PI * (1F/period) * ((player.ticksExisted % period) + partialTicks)) + 1;
			this.root.rotationPointY = 1F;
			this.leftWing.rotateAngleX += 0.25F;
			this.rightWing.rotateAngleX += 0.25F;
			this.leftWing.rotationPointX = -0.5F;
			this.rightWing.rotationPointX = 0.5F;
		} else if(WingSyncHandler.isPlayerGliding(player)){
			flapAmount = (float) Math.cos(2 * Math.PI * (1F/period) * 2.5F) + 1;
			this.root.rotationPointY = 2F;
			this.leftWing.rotateAngleX = 0.2F;
			this.rightWing.rotateAngleX = 0.2F;
			this.leftWing.rotationPointX = -1F;
			this.rightWing.rotationPointX = 1F;
		} else {
			period = 100;
			flapAmount = ((float) Math.cos(2 * Math.PI * (1F/period) * ((player.ticksExisted % period) + partialTicks)) + 1)/7.5F;
			this.root.rotationPointY = 0F;
			this.leftWing.rotateAngleX = 0.1F;
			this.rightWing.rotateAngleX = 0.1F;
			this.leftWing.rotateAngleZ = 0.1F;
			this.rightWing.rotateAngleZ = -0.1F;
			this.leftWing.rotationPointX = -0.5F;
			this.rightWing.rotationPointX = 0.5F;
		}
		this.leftWing.rotateAngleZ += -0.05F - flapAmount/1.5F;
		this.rightWing.rotateAngleZ += 0.05F + flapAmount/1.5F;
		this.leftWing.rotateAngleX += 0.05F + flapAmount/1.5F;
		this.rightWing.rotateAngleX += 0.05F + flapAmount/1.5F;
		
		if(player.isSneaking()) {
			this.root.rotationPointY += 4F;
			this.root.rotateAngleX += 0.5F;
			//this.leftWing.rotationPointY += 4F;
			//this.rightWing.rotationPointY += 4F;
			//this.leftWing.rotateAngleY += 0.5F;
			//this.rightWing.rotateAngleY -= 0.5F;
		}
		
		root.render(scale);
	}
}
