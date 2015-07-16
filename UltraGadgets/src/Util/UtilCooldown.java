package Util;

import org.bukkit.entity.Player;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class UtilCooldown {
	
	private static Table<String, String, Long> cooldowns = HashBasedTable .create();

	/**
	 * 
	 * Atualizar o Cooldown
	 * 
	 * @param player
	 *            - Player que receberá o Cooldown
	 * @param key
	 *            - Key para atualiazr
	 * @param delay
	 *            - Numero de delay que irá receber novamente
	 * @return tempo final currentTimeMillis
	 */
	
	public static long getCooldown(Player player, String key) {
		return calculateRemainder(cooldowns.get(player.getName(), key));
	}

	/**
	 * 
	 * Atualizar o Cooldown
	 * 
	 * @param player
	 *            - Player que receberá o Cooldown
	 * @param key
	 *            - Key do Cooldown
	 *            
	 * @return Tempo
	 */
	
	public static long setCooldown(Player player, String key, long delay) {
		return calculateRemainder(cooldowns.put(player.getName(), key,
				System.currentTimeMillis() + delay));
	}
	
	/**
	 * 
	 * Tentar colocar um Cooldown
	 * 
	 * @param player
	 *            - Player que receberá o Cooldown
	 * @param key
	 *            - Key do Cooldown
	 * @param delay
	 *            - Tempo para atualizar
	 *            
	 * @return tempo final currentTimeMillis
	 */
	
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
}