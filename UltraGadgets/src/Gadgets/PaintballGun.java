package Gadgets;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import Metodos.UtilMath;
import Util.UtilCooldown;

import com.floodeer.gadgets.Main;

public class PaintballGun
  implements Listener
{
  List<Snowball> paramSnowball = new ArrayList<>();
  ArrayList<Location> l = new ArrayList<>();
  Main plugin = Main.getMain();
  
  @EventHandler
  public void paramUsePaintballGun(PlayerInteractEvent paramPlayerUsePaintballGun)
  {
    Player paramPlayer = paramPlayerUsePaintballGun.getPlayer();
    Action paramAction = paramPlayerUsePaintballGun.getAction();
    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
      return;
    }
    ItemStack paramItem = paramPlayer.getItemInHand();
    if (this.plugin.getItem().isGadgetItem(paramItem, this.plugin.getMessagesFile().PaintballGunGadgetName)) {
      if (UtilCooldown.tryCooldown(paramPlayer, "PBG", 0L))
      {
        Snowball paramSnow = (Snowball)paramPlayer.launchProjectile(Snowball.class);
        paramSnow.getWorld().playSound(paramSnow.getLocation(), Sound.ITEM_PICKUP, 3.0F, 15.0F);
        this.paramSnowball.add(paramSnow);
      }
      else
      {
        long cooldowns = UtilCooldown.getCooldown(paramPlayer, "PBG") / 1000L;
        paramPlayer.sendMessage("§eVoce deve esperar §3" + cooldowns + " §esegundos para usar " + "§c§lPaintballGun " + "§enovamente");
        paramPlayer.playSound(paramPlayer.getLocation(), Sound.NOTE_PIANO, 2.0F, 15.0F);
      }
    }
  }
  
  @EventHandler
  public void onPaint(ProjectileHitEvent event)
  {
    if (event.getEntity().getType() != EntityType.SNOWBALL) {
      return;
    }
    if (((event.getEntity().getShooter() instanceof Player)) && 
      (this.paramSnowball.contains(event.getEntity())))
    {
         byte b = (byte) UtilMath.random.nextInt(15);
          Location localLocation = event.getEntity().getLocation().add(event.getEntity().getVelocity());
          for (Block localBlock : plugin.getUtilBlock().getInRadius(localLocation, 1.5D).keySet()) {
              if (plugin.getUtilBlock().solid(localBlock)) {
                if (!plugin.getUtilBlock().blockToRestore.contains(localBlock))
                {
                  if (localBlock.getType() != Material.CLAY) {
                	  plugin.getUtilBlock().setBlockToRestore(localBlock, 171, b, 4L, true, false, false);
                  }
                  if (localBlock.getType() != Material.CLAY_BRICK) {
                	  plugin.getUtilBlock().setBlockToRestore(localBlock, 159, b, 4L, true, false, false);
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
      Snowball snow = (Snowball)e.getDamager();
      if (this.paramSnowball.contains(snow)) {
        e.setCancelled(true);
      }
    }
  }
}
