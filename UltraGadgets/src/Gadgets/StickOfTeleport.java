package Gadgets;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import Util.ParticleEffect;
import Util.UtilCooldown;

import com.floodeer.gadgets.Main;

public class StickOfTeleport
  implements Listener
{
  Main plugin = Main.getMain();
  
  @EventHandler
  public void paramPlayerUseTeleport(PlayerInteractEvent paramPlayerUseEyeOfTeleportEvent)
  {
    Player paramPlayer = paramPlayerUseEyeOfTeleportEvent.getPlayer();
    Action paramAction = paramPlayerUseEyeOfTeleportEvent.getAction();
    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
      return;
    }
    ItemStack paramItem = paramPlayer.getItemInHand();
    if (this.plugin.getUtilBlock().usable(paramPlayerUseEyeOfTeleportEvent.getClickedBlock())) {
      return;
    }
    if (this.plugin.getItem().isGadgetItem(paramItem, this.plugin.getMessagesFile().StickOfTpGadgetName))
    {
      Location l = this.plugin.getUtilLocation().getTargetBlock(paramPlayer, this.plugin.getConfig().getInt("Area-Maxima-TpStick"));
      Block paramBlock = l.getBlock();
      if (!this.plugin.getUtilBlock().isVisible(paramBlock)) {
        return;
      }
      if (!this.plugin.getUtilBlock().solid(paramBlock)) {
        return;
      }
      if (UtilCooldown.tryCooldown(paramPlayer, "Teleport", this.plugin.getConfigFile().StickOfTpCooldown))
      {
        Location location = new Location(paramBlock.getWorld(), paramBlock.getX(), paramBlock.getY() + 1, paramBlock.getZ());
        paramPlayer.teleport(location);
        ParticleEffect.PORTAL.display(0.0F, 0.0F, 0.0F, 3.0F, 120, location, 100.0D);
        paramBlock.getWorld().playSound(paramBlock.getLocation(), Sound.ENDERMAN_TELEPORT, 3.0F, 0.0F);
      }
      else
      {
        long cooldown = UtilCooldown.getCooldown(paramPlayer, "Teleport") / 1000L;
        plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "Stick of Teleport", "Teleport", cooldown);
        paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
      }
    }
  }
}
