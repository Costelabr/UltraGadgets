package Gadgets;

import java.util.HashMap;
import java.util.Random;

import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldEvent;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitTask;

import Core.Util18;
import Core.UtilCooldown;
import Core.UtilParticle;
import Core.UtilParticle.ParticleType;

import com.floodeer.gadgets.Main;

public class DiscoBall
  implements Listener
{
  Main plugin = Main.getMain();
  private HashMap<Location, Material> blocks = new HashMap<>();
  private HashMap<Location, Byte> data = new HashMap<>();
  
  @SuppressWarnings("deprecation")
private void playRecord(Player p, Location loc, Material record)
  {
    ((CraftPlayer)p).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldEvent(1005, new BlockPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()), record.getId(), false));
  }
  
  private void stopRecord(Player p, Location loc)
  {
    ((CraftPlayer)p).getHandle().playerConnection.sendPacket(new PacketPlayOutWorldEvent(1005, new BlockPosition(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()), 0, false));
  }
  
  @SuppressWarnings("deprecation")
protected void startDiscoBall(final Player p)
  {
    final Location l = p.getLocation().add(0.0D, 3.0D, 0.0D);
    this.blocks.put(l, l.getBlock().getType());
    this.data.put(l, Byte.valueOf(l.getBlock().getData()));
    final Random random = new Random();
    l.getBlock().setType(Material.STAINED_GLASS);
    playRecord(p, l, Material.RECORD_4);
    l.getBlock().setMetadata("MetaBlocked", new FixedMetadataValue(this.plugin, "v1"));
    
    final BukkitTask taskerGG = Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
    {
	public void run()
      {
        l.getBlock().setData((byte)random.nextInt(15));
        new UtilParticle(ParticleType.FIREWORKS_SPARK, 2.0D, 50, 5.0D).sendToLocation(l);
      }
    }, 1L, 8L);
    
    Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
    {
	public void run()
      {
        l.getWorld().playEffect(l, Effect.STEP_SOUND, l.getBlock().getTypeId());
        l.getBlock().setType((Material)DiscoBall.this.blocks.get(l));
        l.getBlock().setData(((Byte)DiscoBall.this.data.get(l)).byteValue());
        DiscoBall.this.blocks.remove(l);
        DiscoBall.this.data.remove(l);
        DiscoBall.this.stopRecord(p, l);
        taskerGG.cancel();
      }
    }, 500L);
  }
  
  @EventHandler
  public void paramPlayerUseDiscoBall(PlayerInteractEvent paramPlayerUseDiscoBallEvent)
  {
    Player paramPlayer = paramPlayerUseDiscoBallEvent.getPlayer();
    Action paramAction = paramPlayerUseDiscoBallEvent.getAction();
    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
      return;
    }
    ItemStack paramItem = paramPlayer.getItemInHand();
    if (this.plugin.getUtilBlock().usable(paramPlayerUseDiscoBallEvent.getClickedBlock())) {
      return;
    }
    if (this.plugin.getItem().isGadgetItem(paramItem, this.plugin.getMessagesFile().DiscoBallGadgetName)) {
      if (UtilCooldown.tryCooldown(paramPlayer, "DiscoBall", this.plugin.getConfigFile().DiscoBallCooldown))
      {
        startDiscoBall(paramPlayer);
      }
      else
      {
        long cooldown = UtilCooldown.getCooldown(paramPlayer, "DiscoBall") / 1000L;
        plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "Disco Ball", "DiscoBall", cooldown);
        paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
        Util18.sendTitle(paramPlayer, 
        plugin.getMessagesFile().titleMessage,
        plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", Tipos.getPlayerGadget.get(paramPlayer)), 
        plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
      }
    }
  }
}
