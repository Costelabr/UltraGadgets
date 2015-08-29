package Utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import br.com.floodeer.ultragadgets.UltraGadgets;

public class IFallingBlocks implements Listener {

	static final List<FallingBlock> arrayBlock = new ArrayList<>();
	static final UltraGadgets plugin = UltraGadgets.getMain();

	/**
	 * 
	 * @param player - Sumon
	 * @param area - Area máxima de blocos
	 * @param effectArea - Área que irá atingir entidades
	 * @param vectorMultiplyY - Vector bumb até Y
	 * @param socoY - Blocos Vector bumb até Y
	 */
	
	public static void spawnFalling(final Player player, final int area, final int effectArea, final double vectorMultiplyY, final double socoY) {
		final Location loc = player.getLocation();
		loc.getWorld().playSound(loc, Sound.IRONGOLEM_HIT, 2.0F, -15.0F);
		new BukkitRunnable() {
			int inter = 1;

			@SuppressWarnings("deprecation")
			public void run() {
				if (this.inter == area) {
					cancel();
				}
				for (Block b : plugin.getUtilLocation().getBlocksInRadius(loc.clone().add(0.0D, -1.0D, 0.0D), this.inter, true)) {
					if ((b.getLocation().getBlockY() == loc.getBlockY() - 1)
							&& (b.getType() != org.bukkit.Material.AIR)
							&& (b.getType() != org.bukkit.Material.SIGN_POST)
							&& (b.getType() != org.bukkit.Material.CHEST)
							&& (b.getType() != org.bukkit.Material.STONE_PLATE)
							&& (b.getType() != org.bukkit.Material.WOOD_PLATE)
							&& (b.getType() != org.bukkit.Material.WALL_SIGN)
							&& (b.getType() != org.bukkit.Material.WALL_BANNER)
							&& (b.getType() != org.bukkit.Material.STANDING_BANNER)
							&& (b.getType() != org.bukkit.Material.CROPS)
							&& (b.getType() != org.bukkit.Material.LONG_GRASS)
							&& (b.getType() != org.bukkit.Material.SAPLING)
							&& (b.getType() != org.bukkit.Material.DEAD_BUSH)
							&& (b.getType() != org.bukkit.Material.RED_ROSE)
							&& (b.getType() != org.bukkit.Material.RED_MUSHROOM)
							&& (b.getType() != org.bukkit.Material.BROWN_MUSHROOM)
							&& (b.getType() != org.bukkit.Material.TORCH)
							&& (b.getType() != org.bukkit.Material.LADDER)
							&& (b.getType() != org.bukkit.Material.VINE)
							&& (b.getType() != org.bukkit.Material.DOUBLE_PLANT)
							&& (b.getType() != org.bukkit.Material.PORTAL)
							&& (b.getType() != org.bukkit.Material.CACTUS)
							&& (b.getType() != org.bukkit.Material.WATER)
							&& (b.getType() != org.bukkit.Material.STATIONARY_WATER)
							&& (b.getType() != org.bukkit.Material.LAVA)
							&& (b.getType() != org.bukkit.Material.STATIONARY_LAVA)
							&& (net.minecraft.server.v1_8_R3.Block.getById(b.getTypeId()).getMaterial().isSolid())
							&& (b.getType().getId() != 43)
							&& (b.getType().getId() != 44)
							&& (b.getRelative(BlockFace.UP).getType() == org.bukkit.Material.AIR)) {
						FallingBlock fb = loc.getWorld().spawnFallingBlock(b.getLocation().clone().add(0.0D, 1.100000023841858D, 0.0D), b.getType(), b.getData());
						fb.setVelocity(new Vector(0.0F,socoY, 0.0F));
						fb.setDropItem(false);
						arrayBlock.add(fb);
					    player.setVelocity(new Vector(0, 1.2, 0));
						for (Entity ent : fb.getNearbyEntities(effectArea, 1.0D, effectArea)) {
							if ((ent != player && (ent.getType() != EntityType.FALLING_BLOCK))) {
								if(ent.hasMetadata("NPC") && ent.hasMetadata("ugPets")) {
								ent.setVelocity(new Vector(0.0D, vectorMultiplyY, 0.0D));
								}
							}
						}
					}
				}
				this.inter += 1;
			}
		}.runTaskTimer(plugin, 0L, 1L);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBlockChangeState(EntityChangeBlockEvent e) {
		if (arrayBlock.contains(e.getEntity())) {
			e.setCancelled(true);
			arrayBlock.remove(e.getEntity());
			FallingBlock fb = (FallingBlock) e.getEntity();
			fb.getWorld().playEffect(fb.getLocation(), Effect.STEP_SOUND, fb.getBlockId(), fb.getBlockData());
			e.getEntity().remove();
		}
	}
}
