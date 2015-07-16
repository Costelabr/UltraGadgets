package Gadgets;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import Util.UtilCooldown;
import Util.UtilFireworks;

import com.floodeer.gadgets.Main;

public class DiamondParty
  implements Listener
{
  Main plugin = Main.getMain();
  
  private void startParty(final Player p)
  {
    final UtilFireworks f = new UtilFireworks();
    final Vector direction = Vector.getRandom();
    direction.setX(direction.getX() - 0.5D);
    direction.setY(0.6F);
    direction.setZ(direction.getZ() - 0.5D);
    final BukkitTask ftask = Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
    {
      public void run()
      {
        try
        {
          ItemStack paramDiamond = new ItemStack(Material.DIAMOND);
          final Item paramItemDrop = p.getWorld().dropItem(p.getEyeLocation().add(0.0D, 0.0D, 0.0D), paramDiamond);
          paramItemDrop.setVelocity(direction);
          paramItemDrop.setPickupDelay(Integer.MAX_VALUE);
          Bukkit.getScheduler().scheduleSyncDelayedTask(DiamondParty.this.plugin, new Runnable()
          {
            public void run()
            {
              paramItemDrop.remove();
            }
          }, 36L);
          f.playFirework(p.getWorld(), p.getLocation().add(0.0D, 2.8D, 0.0D), 
            FireworkEffect.builder()
            .withColor(Color.BLUE)
            .withColor(Color.AQUA)
            .withColor(Color.WHITE)
            .withFade(Color.WHITE)
            .with(FireworkEffect.Type.BURST)
            .build());
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    }, 1L, 5L);
    Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
    {
      public void run()
      {
        ftask.cancel();
      }
    }, 240L);
  }
  
  @EventHandler
  public void paramPlayerUseDiamondParty(PlayerInteractEvent paramPlayerUseDiamondPartyEvent)
  {
    Player paramPlayer = paramPlayerUseDiamondPartyEvent.getPlayer();
    Action paramAction = paramPlayerUseDiamondPartyEvent.getAction();
    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
      return;
    }
    ItemStack paramItem = paramPlayer.getItemInHand();
    if (this.plugin.getUtilBlock().usable(paramPlayerUseDiamondPartyEvent.getClickedBlock())) {
      return;
    }
    if (this.plugin.getItem().isGadgetItem(paramItem, this.plugin.getMessagesFile().DiamondPartyGadgetName)) {
      if (UtilCooldown.tryCooldown(paramPlayer, "DiamondParty", this.plugin.getConfigFile().DiamondPartyCooldown))
      {
        startParty(paramPlayer);
      }
      else
      {
        long cooldown = UtilCooldown.getCooldown(paramPlayer, "DiamondParty") / 1000L;
        plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "Diamond Party", "DiamondParty", cooldown);
        paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
      }
    }
  }
}