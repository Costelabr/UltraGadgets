package Core;

import org.bukkit.entity.Player;

import Gadgets.Tipos;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class UtilCooldown {
	
	private static Table<String, String, Long> cooldowns = HashBasedTable .create();

	public static long getCooldown(Player player, String key) {
		return calculateRemainder(cooldowns.get(player.getName(), key));
	}

	
	public static long setCooldown(Player player, String key, long delay) {
		return calculateRemainder(cooldowns.put(player.getName(), key,
				System.currentTimeMillis() + delay));
	}
	
	
	public static boolean tryCooldown(Player player, String key, long delay) {
		if (getCooldown(player, key) <= 0) {
			setCooldown(player, key, delay);
			return true;
		}
		return false;
	}

	private static long calculateRemainder(Long expireTime) {
		return expireTime != null ? expireTime - System.currentTimeMillis()
				: Long.MIN_VALUE;
	}
	
	public static boolean hasCooldown(Player player, Tipos ignoreType) {
		
		if(!(getCooldown(player, "Bomba") <= 0) &
		getCooldown(player, "Cookies") <= 0  &
		getCooldown(player, "DiamondParty") <= 0  &
		getCooldown(player, "DiscoBall") <= 0  &
		getCooldown(player, "Dj") <= 0  &
		getCooldown(player, "FDF") <= 0  &
		getCooldown(player, "FG") <= 0  &
		getCooldown(player, "Galinha") <= 0  &
		getCooldown(player, "FIRE") <= 0 &
		getCooldown(player, "SmokeBomb") <= 0 &
		getCooldown(player, "Teleport") <= 0 &
		getCooldown(player, "Vampire") <= 0 &
		getCooldown(player, "Wither") <= 0 &
		getCooldown(player, "Trampolim") <= 0 &
		(getCooldown(player, "RailShoots") <= 0)) {
		  return true;
		}
		return false;
  }
}