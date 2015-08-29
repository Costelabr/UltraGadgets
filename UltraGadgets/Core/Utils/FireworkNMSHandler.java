package Utils;

import org.bukkit.Bukkit;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

public abstract class FireworkNMSHandler {
	
	
	public void playFirework(Location paramLocation, FireworkEffect paramFireworkEffect) {
		String version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
		if(version.equalsIgnoreCase("v1_8_R3")) {
		Entity localEntity = paramLocation.getWorld().spawnEntity(paramLocation, EntityType.FIREWORK);
		Firework localFirework = (Firework) localEntity;
		FireworkMeta localFireworkMeta = localFirework.getFireworkMeta();
		localFireworkMeta.addEffect(paramFireworkEffect);
		localFireworkMeta.setPower(1);
		localFirework.setFireworkMeta(localFireworkMeta);

		((org.bukkit.craftbukkit.v1_8_R3.entity.CraftFirework) localFirework).getHandle().expectedLifespan = 1;
		}
	}
}
