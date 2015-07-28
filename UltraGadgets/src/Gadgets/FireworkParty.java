package Gadgets;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import Core.UtilFirework;
import Core.Util18;
import Core.UtilCooldown;

import com.floodeer.gadgets.Main;

public class FireworkParty
  implements Listener
{
  Main plugin = Main.getMain();
  
  @EventHandler
  public void paramPlayerUseFirework(PlayerInteractEvent paramPlayerUseFireworkEvent)
  {
    Player paramPlayer = paramPlayerUseFireworkEvent.getPlayer();
    Action paramAction = paramPlayerUseFireworkEvent.getAction();
    ItemStack paramItemClicked = paramPlayer.getItemInHand();
    Location paramLocation = paramPlayer.getLocation();
    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
      return;
    }
    if (this.plugin.getItem().isGadgetItem(paramItemClicked, this.plugin.getMessagesFile().FireworkPartyGadgetName))
    {
      paramPlayerUseFireworkEvent.setCancelled(true);
      if (this.plugin.getUtilBlock().usable(paramPlayerUseFireworkEvent.getClickedBlock())) {
        return;
      }
      if (UtilCooldown.tryCooldown(paramPlayer, "FDF", this.plugin.getConfigFile().FireworkPartyCooldown))
      {
        List<Location> paramParty = this.plugin.getUtilLocation().getSphere(paramLocation, 7, 1, true, false, 0);
        for (final Location loc : paramParty)
        {
          final int taskId = Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
          {
            public void run()
            {
              UtilFirework.spawnRandomFirework(loc);
            }
          }, 0L, 60L).getTaskId();
          
          Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
          {
            public void run()
            {
              Bukkit.getScheduler().cancelTask(taskId);
            }
          }, 160L);
        }
      }
      else
      {
        long cooldown = UtilCooldown.getCooldown(paramPlayer, "FDF") / 1000L;
        plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "Firework Party", "FDF", cooldown);
        paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
        Util18.sendTitle(paramPlayer, 
        plugin.getMessagesFile().titleMessage,
        plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", Tipos.getPlayerGadget.get(paramPlayer)), 
        plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
      }
    }
  }
}
