package thecallunxz.wor.items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import thecallunxz.wor.util.WORClientUtil;
import thecallunxz.wor.util.WingSyncHandler;

import java.lang.reflect.Field;

public class ItemWings extends ItemBase implements IBauble {

	public static Field floatingTickCount = null;
	
	private int flightTime;
	private int maxFlightTime;
	private boolean flying;
	private double flightAcceleration;
	private float horizontalSpeed;
	
	public ItemWings(String name, int maxFlightTime, double flightAcceleration, float horizontalSpeed) {
		super(name);
		this.maxFlightTime = maxFlightTime;
		this.flightAcceleration = flightAcceleration;
		this.horizontalSpeed = horizontalSpeed;
		
		flightTime = maxFlightTime;
		flying = false;
		
		try {
			floatingTickCount = ReflectionHelper.findField(NetHandlerPlayServer.class,  "floatingTickCount", "field_147365_f");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if(player.getEntityWorld().isRemote) {
			if(WORClientUtil.isJumpHeld()) {
				if(flying) {
					WORClientUtil.playerMoveRelative(player, horizontalSpeed); //Flying horizontal speed
					if(flightTime > 0) { //Flying
						if(!WingSyncHandler.isPlayerFlying((EntityPlayer) player)) {
							WingSyncHandler.setPlayerFlying((EntityPlayer) player);
						}
						player.motionY = MathHelper.clamp(player.motionY + (0.06 * Math.abs(player.motionY - 3.5)), -2, flightAcceleration*10);
						flightTime--;
					} else if (!player.onGround && player.motionY < 0.0D) {  //Gliding
						if(!WingSyncHandler.isPlayerGliding((EntityPlayer) player)) {
							WingSyncHandler.setPlayerGliding((EntityPlayer) player);
						}
						player.motionY *= 0.7D;
			        }
				} else if(player.motionY < 0.2) { //Allows vanilla jumping before flying
					flying = true;
					player.onGround = false;
				}
			} else if(WingSyncHandler.isPlayerFlying((EntityPlayer) player) && flying) {
				WingSyncHandler.setPlayerGliding((EntityPlayer) player);
			} else if(WingSyncHandler.isPlayerGliding((EntityPlayer) player) && flying) {
				if(!player.isSneaking()) {
					player.motionY *= 0.9D;
				} else {
					WingSyncHandler.setPlayerIdle((EntityPlayer) player);
					flying = false;
				}
			}
			if(flying) {
				//WORClientUtil.playerMoveRelative(player, horizontalSpeed); //Flying horizontal speed
			}
			if(player.onGround) { //Walking
				if(!WingSyncHandler.isPlayerIdle((EntityPlayer) player)) {
					WingSyncHandler.setPlayerIdle((EntityPlayer) player);
				}
				flightTime = maxFlightTime;
				flying = false;
			}
		} else {
			player.fallDistance = 0; //No fall damage
			if (player instanceof EntityPlayerMP) {
				try { //Stop flying kick
					floatingTickCount.setInt(((EntityPlayerMP) player).connection, 0);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.BODY;
	}
}