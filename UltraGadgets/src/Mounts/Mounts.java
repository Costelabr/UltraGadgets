package Mounts;

import java.util.UUID;

import net.minecraft.server.v1_8_R3.GenericAttributes;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Color;
import org.bukkit.entity.Horse.Style;
import org.bukkit.entity.Horse.Variant;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import vR3.UtilPet_vR3;
import br.com.floodeer.ultragadgets.UltraGadgets;

public enum Mounts {
	
	NENHUM, FROZEN, INFERNO;
	
	
	private static final UltraGadgets plugin = UltraGadgets.getMain();
	
	public static void summonMount(Player p, Mounts type) {
		
		final UUID uniqueID = p.getUniqueId();
		CraftWorld world = ((CraftWorld)p.getWorld());
		switch (type) {
		case NENHUM:
		 MountHandler.pet.remove(p.getUniqueId());
		
		case FROZEN:
			
	     Horse paramEntityFrozen = world.spawn(p.getLocation(), Horse.class, CreatureSpawnEvent.SpawnReason.CUSTOM);	
	     paramEntityFrozen.setStyle(Style.WHITE);
	     paramEntityFrozen.setColor(Color.WHITE);
	     paramEntityFrozen.setAdult();
	     paramEntityFrozen.setCustomName(ChatColor.AQUA + p.getName() + "'s" + ChatColor.WHITE + " Frozen Horse");
	     paramEntityFrozen.setMetadata("FrozenHorse", new FixedMetadataValue(plugin, null));
	     paramEntityFrozen.setTamed(true);
	     paramEntityFrozen.setOwner(p);
		 paramEntityFrozen.getInventory().setSaddle(new ItemStack(Material.DIAMOND_BARDING, 1));
		 UtilPet_vR3.criarPet(paramEntityFrozen, uniqueID);
		 MountHandler.pet.put(p.getUniqueId(), paramEntityFrozen);
		 break;
			
		case INFERNO: 
			
		Horse paramEntityInferno = world.spawn(p.getLocation(), Horse.class, CreatureSpawnEvent.SpawnReason.CUSTOM);
		paramEntityInferno.setVariant(Variant.SKELETON_HORSE);
	    paramEntityInferno.setAdult();
		paramEntityInferno.setMetadata("InfernalHorse", new FixedMetadataValue(plugin, null));
		paramEntityInferno.setTamed(true);
	    paramEntityInferno.setCustomName(ChatColor.AQUA + p.getName() + "'s" + ChatColor.WHITE + " Infernal Horse");
		paramEntityInferno.setOwner(p);
		paramEntityInferno.getInventory().setSaddle(new ItemStack(Material.DIAMOND_BARDING, 1));
		((CraftLivingEntity) paramEntityInferno).getHandle().getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.4);
		UtilPet_vR3.criarPet(paramEntityInferno, uniqueID);
		MountHandler.pet.put(p.getUniqueId(), paramEntityInferno);
		break;
		}
	}
}
