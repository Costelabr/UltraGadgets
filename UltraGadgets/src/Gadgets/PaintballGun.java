package Gadgets;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;

import Utils.UtilMath;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class PaintballGun
  implements Listener
{
  List<EnderPearl> paramEnderball = new ArrayList<>();
  ArrayList<Location> l = new ArrayList<>();
  List<Player> paramTeleporter = new ArrayList<>();
  List<Player> otherCooldown = new ArrayList<>();
  UltraGadgets plugin = UltraGadgets.getMain();
  
  @EventHandler
  public void paramUsePaintballGun(PlayerInteractEvent paramPlayerUsePaintballGun)
  {
    final Player paramPlayer = paramPlayerUsePaintballGun.getPlayer();
    Action paramAction = paramPlayerUsePaintballGun.getAction();
    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
      return;
    }
    ItemStack paramItem = paramPlayer.getItemInHand();
    if (this.plugin.getItem().isGadgetItem(paramItem, this.plugin.getMessagesFile().PaintballGunGadgetName)) {
    	if(otherCooldown.contains(paramPlayer)) return;
        EnderPearl paramEnder = (EnderPearl)paramPlayer.launchProjectile(EnderPearl.class);
        paramEnder.getWorld().playSound(paramEnder.getLocation(), Sound.CHICKEN_EGG_POP, 1.5F, 1.2F);
        this.paramEnderball.add(paramEnder);
        otherCooldown.add(paramPlayer);
        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
			
			@Override
			public void run() {
				otherCooldown.remove(paramPlayer);
				
			}
		}, 5L);
      }
    }
  
  @EventHandler
  public void onPaint(ProjectileHitEvent event)
  {
    if (event.getEntity().getType() != EntityType.ENDER_PEARL) {
      return;
    }
    if (((event.getEntity().getShooter() instanceof Player)) && 
      (this.paramEnderball.contains(event.getEntity())))
    {
         byte b = (byte) UtilMath.random.nextInt(15);     
          Location localLocation = event.getEntity().getLocation().add(event.getEntity().getVelocity());
          localLocation.getWorld().playEffect(localLocation, Effect.STEP_SOUND, 49);
          for (Block localBlock : plugin.getUtilBlock().getInRadius(localLocation, 1.5D).keySet()) {
              if (plugin.getUtilBlock().solid(localBlock)) {
                if (!plugin.getUtilBlock().blockToRestore.contains(localBlock))
                {
                  if (localBlock.getType() != Material.WOOL) {
                	  plugin.getUtilBlock().setBlockToRestore(localBlock, 35, b, 4L, true, false, false);
                  }
                }
              }
            }
          }
  }
  
  @EventHandler
  public void playerDamageBySnowBall(EntityDamageByEntityEvent e)
  {
    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Snowball)))
    {
      EnderPearl ender = (EnderPearl)e.getEntity();
      if (this.paramEnderball.contains(ender)) {
        e.setCancelled(true);
      }
    }
  }
  
  @EventHandler
  public void playerTeleport(PlayerTeleportEvent e) {
	  if((e.getCause() == TeleportCause.ENDER_PEARL)) {
		  if(paramTeleporter.contains(e.getPlayer())) {
			  e.setCancelled(true);
			  paramTeleporter.remove(e.getPlayer());
		  }
		  if(e.getPlayer().getInventory().getItemInHand().getType() == Material.DIAMOND_BARDING) {
			  e.setCancelled(true);
		  }
	  }
  }
}
