package thecallunxz.wor.util;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;

public class WORClientUtil {
	
	public static boolean isJumpHeld() {
		return Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown();
	}
	
	private static boolean isForwardHeld() {
		return Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown();
	}
	
	private static boolean isBackHeld() {
		return Minecraft.getMinecraft().gameSettings.keyBindBack.isKeyDown();
	}
	
	private static boolean isLeftHeld() {
		return Minecraft.getMinecraft().gameSettings.keyBindLeft.isKeyDown();
	}
	
	private static boolean isRightHeld() {
		return Minecraft.getMinecraft().gameSettings.keyBindRight.isKeyDown();
	}
	
	public static void playerMoveRelative(EntityLivingBase player, float speed) {
		if(WORClientUtil.isForwardHeld()) {
			player.moveRelative(0, 0, speed, speed/4);
		}
		if(WORClientUtil.isBackHeld()) {
			player.moveRelative(0, 0, -speed, speed/4);
		}
		if(WORClientUtil.isLeftHeld()) {
			player.moveRelative(speed, 0, 0, speed/4);
		}
		if(WORClientUtil.isRightHeld()) {
			player.moveRelative(-speed, 0, 0, speed/4);
		}
	}
	
}
