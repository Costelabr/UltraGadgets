package Mounts;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Color;
import org.bukkit.entity.Horse.Style;
import org.bukkit.entity.Horse.Variant;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import com.floodeer.gadgets.UltraGadgets;

import Core.UtilPet;

public enum Mounts {
	
	NENHUM, FROZEN, INFERNO;
	
	
	private static final UltraGadgets plugin = UltraGadgets.getMain();
	public static void summonMount(Player p, Mounts type) {
		
		final UUID uniqueID = p.getUniqueId();
		
		switch (type) {
		case NENHUM:
		 MountHandler.pet.remove(p.getUniqueId());
		
		case FROZEN:
			
	     Horse paramEntityFrozen = p.getWorld().spawn(p.getLocation(), Horse.class);	
	     paramEntityFrozen.setStyle(Style.WHITE);
	     paramEntityFrozen.setColor(Color.WHITE);
	     paramEntityFrozen.setAdult();
	     paramEntityFrozen.setCustomName(ChatColor.AQUA + p.getName() + "'s" + ChatColor.WHITE + " Frozen Horse");
	     paramEntityFrozen.setMetadata("FrozenHorse", new FixedMetadataValue(plugin, null));
	     paramEntityFrozen.setTamed(true);
	     paramEntityFrozen.setOwner(p);
		 paramEntityFrozen.getInventory().setSaddle(new ItemStack(Material.DIAMOND_BARDING, 1));
		 UtilPet.criarPet(paramEntityFrozen, uniqueID);
		 MountHandler.pet.put(p.getUniqueId(), paramEntityFrozen);
			break;
			
		case INFERNO: 
			
		Horse paramEntityInferno = p.getWorld().spawn(p.getLocation(), Horse.class);
		paramEntityInferno.setVariant(Variant.SKELETON_HORSE);
	    paramEntityInferno.setAdult();
		paramEntityInferno.setMetadata("InfernalHorse", new FixedMetadataValue(plugin, null));
		paramEntityInferno.setTamed(true);
	    paramEntityInferno.setCustomName(ChatColor.AQUA + p.getName() + "'s" + ChatColor.WHITE + " Infernal Horse");
		paramEntityInferno.setOwner(p);
		paramEntityInferno.getInventory().setSaddle(new ItemStack(Material.DIAMOND_BARDING, 1));
		UtilPet.criarPet(paramEntityInferno, uniqueID);
		MountHandler.pet.put(p.getUniqueId(), paramEntityInferno);
			
		break;
		}
	}
}
