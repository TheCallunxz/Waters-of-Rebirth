package thecallunxz.wor.util;

import java.util.HashMap;

import net.minecraft.entity.player.EntityPlayer;

public class WingSyncHandler {
	/*
	 *  0: Nothing
	 *  1: Flying
	 *  2: Gliding
	 */
	private static HashMap<EntityPlayer, Integer> playerFlyState = new HashMap<EntityPlayer, Integer>();
	
	public static boolean isPlayerIdle(EntityPlayer player) {
		if(!playerFlyState.containsKey(player)) {
			playerFlyState.put(player, 0);
			return false;
		}	
		return playerFlyState.get(player) == 0;
	}
	
	public static boolean isPlayerFlying(EntityPlayer player) {
		if(!playerFlyState.containsKey(player)) {
			playerFlyState.put(player, 0);
			return false;
		}	
		return playerFlyState.get(player) == 1;
	}
	
	public static boolean isPlayerGliding(EntityPlayer player) {
		if(!playerFlyState.containsKey(player)) {
			playerFlyState.put(player, 0);
			return false;
		}	
		return playerFlyState.get(player) == 2;
	}
	
	public static void setPlayerIdle(EntityPlayer player) {
		playerFlyState.put(player, 0);
	}
	
	public static void setPlayerFlying(EntityPlayer player) {
		playerFlyState.put(player, 1);
	}
	
	public static void setPlayerGliding(EntityPlayer player) {
		playerFlyState.put(player, 2);
	}
}
