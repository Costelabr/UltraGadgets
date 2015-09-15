package Gadgets;

import java.io.File;
import java.util.HashMap;
import java.util.Random;

import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldEvent;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitTask;

import ISong.NBSDecoder;
import ISong.RadioSongPlayer;
import ISong.Song;
import Utils.UtilBallEffect;
import Utils.UtilCooldown;
import Utils.UtilParticle;
import Utils.UtilTitles;
import Utils.UtilParticle.ParticleType;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class DiscoBall
  implements Listener
{
  UltraGadgets plugin = UltraGadgets.getMain();
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
protected void startDiscoBall(final Player p) {
    File f = new File(plugin.getDataFolder() + "/sons", "DiscoBall.nbs");
	if(!f.exists()) {
	if(p.isOp()) {
		p.sendMessage(plugin.getMessagesFile().prefix +  ChatColor.RED + " IllegalDirectoryLocationException:56 - Não foi possível encontrar a pasta /sons/DiscoBall.nbs");
	}else{
	p.sendMessage(plugin.getMessagesFile().prefix +  ChatColor.RED + " IDLE:56 - Reporte esse erro a um staff!");
	}
	System.out.print("************************** SEVERE **************************");
	System.out.print("Diretorio /sons/DiscoBall.nbs nao existe. Por favor certifique-se de extrair o arquivo sons.zip");
	System.out.print("*************************** SEVERE **************************");
	return;
 }
    final Location l = p.getLocation().add(0.0D, 6.0D, 0.0D);
    blocks.put(l, l.getBlock().getType());
    data.put(l, Byte.valueOf(l.getBlock().getData()));
    final Random random = new Random();
    plugin.getUtilBlock().setFakeBlock(Material.STAINED_GLASS.getId(), (byte)random.nextInt(15), l.getBlock().getLocation());
	Song s = NBSDecoder.parse(new File(plugin.getDataFolder() + "/sons", "DiscoBall.nbs"));
	new UtilBallEffect().startDisco(l.add(0.5, 0, 0.5), 35);
    final RadioSongPlayer sp = new RadioSongPlayer(s);
    if(plugin.getConfigFile().useCustomSounds) {
        if (sp.isPlaying()) {
        sp.destroy();
        sp.setPlaying(false);
        }
        sp.setPlaying(true);
       	 for(Entity ent : plugin.getUtilLocation().getNearbyEntities(l, 32)) {
       		if(ent instanceof Player) {
           sp.addPlayer((Player)ent);
       }
     }
    }else{
    playRecord(p, l, Material.RECORD_4);
    }
    l.getBlock().setMetadata("MetaBlocked", new FixedMetadataValue(plugin, "v1"));
    
    final BukkitTask taskerGG = Bukkit.getScheduler().runTaskTimer(plugin, new Runnable()
    {
	public void run()
      {
		plugin.getUtilBlock().setFakeBlock(Material.STAINED_GLASS.getId(), (byte)random.nextInt(15), l.getBlock().getLocation());
        new UtilParticle(ParticleType.FIREWORKS_SPARK, 0.10000000149011612D, 12, 3.30000001192092896D).sendToLocation(l);
        new UtilParticle(ParticleType.FIREWORKS_SPARK, 0.10000000149011612D, 12, 3.30000001192092896D).sendToLocation(l);
      }
    }, 1L, 3L);
    
    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
    {
	public void run()
      {
        l.getWorld().playEffect(l, Effect.STEP_SOUND, l.getBlock().getTypeId());
        blocks.remove(l);
        data.remove(l);
        stopRecord(p, l);
        taskerGG.cancel();
        plugin.getUtilBlock().setFakeBlock(Material.AIR.getId(), (byte)0, l.getBlock().getLocation());
        sp.setPlaying(false);
        sp.destroy(); 
      }
    }, 35*20L);
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
    if (plugin.getUtilBlock().usable(paramPlayerUseDiscoBallEvent.getClickedBlock())) {
      return;
    }
    if (plugin.getItem().isGadgetItem(paramItem, plugin.getMessagesFile().DiscoBallGadgetName)) {
      if (UtilCooldown.tryCooldown(paramPlayer, "DiscoBall", plugin.getConfigFile().DiscoBallCooldown))
      {
        startDiscoBall(paramPlayer);
      }
      else
      {
        long cooldown = UtilCooldown.getCooldown(paramPlayer, "DiscoBall") / 1000L;
        plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "Disco Ball", "DiscoBall", cooldown);
        paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
        UtilTitles.sendCooldownTitle(paramPlayer, 
        plugin.getMessagesFile().titleMessage,
        plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", Tipos.getPlayerGadget.get(paramPlayer)), 
        plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
      }
    }
  }
}
