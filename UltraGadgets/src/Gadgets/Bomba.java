package Gadgets;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import Core.ParticleEffect;
import Core.Util18;
import Core.UtilCooldown;
import Core.UtilLocations;
import Core.UtilMath;

import com.floodeer.gadgets.Main;

public class Bomba
  implements Listener
{
  Main plugin = Main.getMain();
  List<Location> saveParam = new ArrayList<Location>();
  
  @EventHandler
  public void paramPlayerUseBomb(PlayerInteractEvent paramPlayerUseBomb)
  {
    final Player paramPlayer = paramPlayerUseBomb.getPlayer();
    Action paramAction = paramPlayerUseBomb.getAction();
    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
      return;
    }
    ItemStack paramItem = paramPlayer.getItemInHand();
    if (this.plugin.getUtilBlock().usable(paramPlayerUseBomb.getClickedBlock())) {
      return;
    }
    if (this.plugin.getItem().isGadgetItem(paramItem, this.plugin.getMessagesFile().BombaGadgetName)) {
      if (UtilCooldown.tryCooldown(paramPlayer, "Bomba", this.plugin.getConfigFile().BombaCooldown))
      {
        ItemStack paramBomba = new ItemStack(Material.CLAY_BALL);
        final Item paramItemDrop = paramPlayer.getWorld().dropItem(paramPlayer.getEyeLocation().add(0.0D, 0.0D, 0.0D), paramBomba);
        paramItemDrop.setVelocity(paramPlayer.getEyeLocation().getDirection().multiply(0.8D).normalize());
        paramItemDrop.setPickupDelay(Integer.MAX_VALUE);
        final BukkitTask repeatingID = Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
        {
          public void run()
          {
            paramItemDrop.getWorld().playSound(paramItemDrop.getLocation(), Sound.BURP, 2.5F, 12.0F);
          }
        }, 1L, 8L);
        
        Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
        {
          public void run()
          {
            Bomba.this.saveParam.add(paramItemDrop.getLocation());
            repeatingID.cancel();
            ParticleEffect.EXPLOSION_HUGE.display(1.0F, 1.0F, 1.0F, 3.0F, 18, paramItemDrop.getLocation(), 35.0D);
            paramItemDrop.getWorld().playSound(paramItemDrop.getLocation(), Sound.EXPLODE, 5.0F, 1.0F);
            UtilLocations near = new UtilLocations();
            Entity[] arrayOfEntity;
            int j = (arrayOfEntity = near.getNearbyEntities(paramItemDrop.getLocation(), 10)).length;
            for (int i = 0; i < j; i++)
            {
              Entity nears = arrayOfEntity[i];
              if ((nears instanceof Player))
              {
                Player pn = (Player)nears;
                double d1 = paramItemDrop.getLocation().getX() - paramPlayer.getLocation().getX();
                double d2 = paramItemDrop.getLocation().getY() - paramPlayer.getLocation().getY();
                double d3 = paramItemDrop.getLocation().getZ() - paramPlayer.getLocation().getZ();
                double d4 = Math.atan2(d3, d1);
                double d5 = Math.atan2(Math.sqrt(d3 * d3 + d1 * d1), d2) + 3.141592653589793D;
                double d6 = Math.sin(d5) * Math.cos(d4);
                double d7 = Math.sin(d5) * Math.sin(d4);
                double d8 = Math.cos(d5);
                
                Vector localVector = new Vector(d6, d8, d7);
                paramPlayer.setVelocity(localVector.multiply(1.321483642374632D).add(new Vector(0.0D, 1.4397268432482635D, 0.0D)));
                pn.setVelocity(new Vector(UtilMath.random.nextInt(5), UtilMath.random.nextInt(2), UtilMath.random.nextInt(5)));
              }
            }
            byte b = (byte) 15;
            Location localLocation = paramItemDrop.getLocation();
            for (Block localBlock : plugin.getUtilBlock().getInRadius(localLocation, 3.5D).keySet()) {
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
       
            paramItemDrop.remove();
          }
        }, 100L);
      }
      else
      {
        long cooldown = UtilCooldown.getCooldown(paramPlayer, "Bomba") / 1000L;
        plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "Bomba", "Bomba", cooldown);
        paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
        
        Util18.sendTitle(paramPlayer, 
        plugin.getMessagesFile().titleMessage,
        plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", Tipos.getPlayerGadget.get(paramPlayer)), 
        plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
      }
    }
  }
}
