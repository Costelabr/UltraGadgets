package Utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;


/**
 * Impedir '@SuppressWarnings' em classes.
 * 
 */

public class Deprecated {
	
	@SuppressWarnings("deprecation")
	public static void updateInventory(Player player) {
		player.updateInventory();
	}
	
	@SuppressWarnings("deprecation")
	public static int getByID(Material material) {
		int i = material.getId();
		return i;
	}
}
