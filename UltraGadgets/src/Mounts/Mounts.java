package Mounts;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Color;
import org.bukkit.entity.Horse.Style;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import com.floodeer.gadgets.Main;

import Core.UtilPet;

public enum Mounts {
	
	NENHUM, FROZEN;
	
	
	private static final Main plugin = Main.getMain();
	public static void summonMount(Player p, Mounts type) {
		
		final UUID uniqueID = p.getUniqueId();
		
		switch (type) {
		case NENHUM:
		 MountHandler.pet.remove(p.getUniqueId());
		
		case FROZEN:
			
	     Horse paramEntityHorse = p.getWorld().spawn(p.getLocation(), Horse.class);	
	     paramEntityHorse.setStyle(Style.WHITE);
	     paramEntityHorse.setColor(Color.WHITE);
	     paramEntityHorse.setAdult();
	     paramEntityHorse.setCustomName(ChatColor.AQUA + p.getName() + "'s" + ChatColor.WHITE + "cavalo");
	     paramEntityHorse.setMetadata("FrozenHorse", new FixedMetadataValue(plugin, null));
	     paramEntityHorse.setTamed(true);
	     paramEntityHorse.setOwner(p);
		 paramEntityHorse.getInventory().setSaddle(new ItemStack(Material.DIAMOND_BARDING, 1));
		 UtilPet.criarPet(paramEntityHorse, uniqueID);
		 MountHandler.pet.put(p.getUniqueId(), paramEntityHorse);
			
		break;
		}
	}
}
