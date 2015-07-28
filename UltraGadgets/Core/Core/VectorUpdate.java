package Core;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.floodeer.gadgets.Main;

import Gadgets.VectorTNT;

public class VectorUpdate extends BukkitRunnable{

	protected HashMap<UUID, Vector> velocities;
	protected HashMap<UUID, Location> positions;
	protected HashMap<UUID, Boolean> onGround;
	Main plugin = Main.getMain();

	@SuppressWarnings("deprecation")
	public void UpdateVelocities() {
		VectorTNT v = new VectorTNT();
		for(Player localPlayer : v.toVector) {
		Vector localVector1 = localPlayer.getVelocity().clone();
		UUID localUUID = localPlayer.getUniqueId();
		if ((this.velocities.containsKey(localUUID)) && (this.onGround.containsKey(localUUID)) && (!localPlayer.isOnGround()) && (!localPlayer.isInsideVehicle())) {
			Vector localVector2 = (Vector) this.velocities.get(localUUID);
			Vector localVector3;
			if (!((Boolean) this.onGround.get(localUUID)).booleanValue()) {
				localVector3 = localVector2.clone();
				localVector3.subtract(localVector1);
				double d1 = localVector3.getY();
				if ((d1 > 0.0D) && ((localVector1.getY() < -0.01D) || (localVector1.getY() > 0.01D))) {
					Location localLocation = localPlayer.getLocation().clone();
					double d2 = 1.0D;
					while (localLocation.getBlockY() >= 0) {
						Block localBlock = localLocation.getBlock();
						d2 = 0.3D;
						if (localBlock.getType() != Material.AIR) {
							break;
						}
						localLocation.setY(localLocation.getY() - 1.0D);
					}
					localVector1.setY(localVector2.getY() - d1 * d2);
					int k = (localVector1.getX() >= -0.001D) && (localVector1.getX() <= 0.001D) ? 0 : 1;
					int m = (localVector2.getX() >= -0.001D) && (localVector2.getX() <= 0.001D) ? 0 : 1;
					if ((k != 0) && (m != 0)) {
						localVector1.setX(localVector2.getX());
					}
					int n = (localVector1.getZ() >= -0.001D) && (localVector1.getZ() <= 0.001D) ? 0 : 1;
					int i1 = (localVector2.getZ() >= -0.001D) && (localVector2.getZ() <= 0.001D) ? 0 : 1;
					if ((n != 0) && (i1 != 0)) {
						localVector1.setZ(localVector2.getZ());
					}
					localPlayer.setVelocity(localVector1.clone());
				}
			} else if (((localPlayer instanceof Player)) && (this.positions.containsKey(localUUID))) {
				localVector3 = localPlayer.getLocation().toVector();
				Vector localVector4 = ((Location) this.positions.get(localUUID))
						.toVector();
				Vector localVector5 = localVector3.subtract(localVector4);
				localVector1.setX(localVector5.getX());
				localVector1.setZ(localVector5.getZ());
			}
			localPlayer.setVelocity(localVector1.clone());
		}
		this.velocities.put(localUUID, localVector1.clone());
		this.onGround.put(localUUID, Boolean.valueOf(localPlayer.isOnGround()));
		this.positions.put(localUUID, localPlayer.getLocation());
	}
}

	@Override
	public void run() {
		UpdateVelocities();
		new VectorUpdate().runTaskLater(this.plugin, 1L);
		
	}
}
