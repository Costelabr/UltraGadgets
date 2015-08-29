package Gadgets;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;

import Utils.ParticleEffect;
import Utils.UtilCooldown;
import Utils.UtilTitles;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class FunGun
  implements Listener
{
  List<EnderPearl> paramEnderPearl = new ArrayList<>();
  List<Snowball> paramSnowball = new ArrayList<>();
  List<Player> paramTeleporter = new ArrayList<>();
  UltraGadgets plugin = UltraGadgets.getMain();
  
  @EventHandler
  public void paramUseFunGun(PlayerInteractEvent paramPlayerUseFunGun)
  {
    Player paramPlayer = paramPlayerUseFunGun.getPlayer();
    Action paramAction = paramPlayerUseFunGun.getAction();
    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
      return;
    }
    ItemStack paramItem = paramPlayer.getItemInHand();
    if (this.plugin.getUtilBlock().usable(paramPlayerUseFunGun.getClickedBlock())) {
      return;
    }
    if (this.plugin.getItem().isGadgetItem(paramItem, this.plugin.getMessagesFile().FunGunGadgetName)) {
      if (UtilCooldown.tryCooldown(paramPlayer, "FG", this.plugin.getConfigFile().FunGunCooldown))
      {
        EnderPearl paramEnder = (EnderPearl)paramPlayer.launchProjectile(EnderPearl.class);
        Snowball paramSnow = (Snowball)paramPlayer.launchProjectile(Snowball.class);
        this.paramEnderPearl.add(paramEnder);
        this.paramSnowball.add(paramSnow);
        this.paramTeleporter.add(paramPlayer);
      }
      else
      {
        long cooldown = UtilCooldown.getCooldown(paramPlayer, "FG") / 1000L;
        plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "FunGun", "FG", cooldown);
        paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
        UtilTitles.sendCooldownTitle(paramPlayer, 
        plugin.getMessagesFile().titleMessage,
        plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", Tipos.getPlayerGadget.get(paramPlayer)), 
        plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
      }
    }
  }
  
  @EventHandler
  public void paramProject(ProjectileHitEvent paramProjectHit)
  {
    if ((paramProjectHit.getEntity() instanceof EnderPearl))
    {
      EnderPearl paramEnder = (EnderPearl)paramProjectHit.getEntity();
      if (this.paramEnderPearl.contains(paramEnder))
      {
        Location paramLocation = paramEnder.getLocation();
        
        ParticleEffect.FLAME.display(0.0F, 0.0F, 0.0F, 1.0F, 5, paramLocation, 20.0D);
        
        ParticleEffect.HEART.display(0.0F, 0.0F, 0.0F, 1.0F, 5, paramLocation, 20.0D);
        
        ParticleEffect.SMOKE_NORMAL.display(0.0F, 0.0F, 0.0F, 1.0F, 5, paramLocation, 20.0D);
        
        ParticleEffect.SMOKE_LARGE.display(0.0F, 0.0F, 0.0F, 1.0F, 5, paramLocation, 20.0D);
        
        ParticleEffect.CLOUD.display(0.0F, 0.0F, 0.0F, 1.0F, 5, paramLocation, 20.0D);
        
        ParticleEffect.LAVA.display(0.0F, 0.0F, 0.0F, 1.0F, 5, paramLocation, 20.0D);
        
        paramLocation.getWorld().playSound(paramLocation.getBlock().getLocation(), Sound.CAT_MEOW, 2.0F, 1.0F);
        
        paramLocation.getWorld().playSound(paramLocation.getBlock().getLocation(), Sound.WOLF_GROWL, 2.0F, 1.0F);
        this.paramEnderPearl.remove(paramEnder);
      }
    }
    if ((paramProjectHit.getEntity() instanceof Snowball))
    {
      Snowball snows = (Snowball)paramProjectHit.getEntity();
      if (this.paramSnowball.contains(snows))
      {
        Location paramLocation = snows.getLocation();
        
        ParticleEffect.FLAME.display(0.0F, 0.0F, 0.0F, 1.0F, 5, paramLocation, 20.0D);
        
        ParticleEffect.HEART.display(0.0F, 0.0F, 0.0F, 1.0F, 5, paramLocation, 20.0D);
        
        ParticleEffect.SMOKE_NORMAL.display(0.0F, 0.0F, 0.0F, 1.0F, 5, paramLocation, 20.0D);
        
        ParticleEffect.SMOKE_LARGE.display(0.0F, 0.0F, 0.0F, 1.0F, 5, paramLocation, 20.0D);
        
        ParticleEffect.CLOUD.display(0.0F, 0.0F, 0.0F, 1.0F, 5, paramLocation, 20.0D);
        
        ParticleEffect.LAVA.display(0.0F, 0.0F, 0.0F, 1.0F, 5, paramLocation, 20.0D);
        
        paramLocation.getWorld().playSound(paramLocation.getBlock().getLocation(), Sound.CAT_MEOW, 2.0F, 1.0F);
        
        paramLocation.getWorld().playSound(paramLocation.getBlock().getLocation(), Sound.WOLF_BARK, 2.0F, 1.0F);
        this.paramSnowball.remove(snows);
      }
    }
  }
  
  @EventHandler
  public void paramPlayerTeleport(PlayerTeleportEvent paramTp)
  {
    if ((paramTp.getCause() == PlayerTeleportEvent.TeleportCause.ENDER_PEARL) && 
      (this.paramTeleporter.contains(paramTp.getPlayer())))
    {
      paramTp.setCancelled(true);
      this.paramTeleporter.remove(paramTp.getPlayer());
    }
  }
  
  @EventHandler
  public void damage(EntityDamageByEntityEvent e)  {
  if(e.getDamager() instanceof Snowball) {
	  Snowball s = (Snowball) e.getDamager();
	  if(paramSnowball.contains(s)) {
		  e.setCancelled(true);
	  }
    }
  if(e.getDamager() instanceof EnderPearl) {
	  EnderPearl end = (EnderPearl)e.getDamager();
	  if(paramEnderPearl.contains(end)) {
		  e.setCancelled(true);
	  }
    }
  }
}
