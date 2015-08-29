package Gadgets;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftSheep;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.SheepRegrowWoolEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;









import Update.SchedulerEvent;
import Update.SchedulerType;
import Utils.ParticleEffect;
import Utils.UtilCooldown;
import Utils.UtilTitles;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class ExplosiveSheep implements Listener {
	
	UltraGadgets plugin = UltraGadgets.getMain();
	List<Sheep> sheep = new ArrayList<Sheep>();
	
	public int random(Integer[] integers) {
		Random rand = new Random();
		return integers[rand.nextInt(integers.length)];
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onUpdate(SchedulerEvent e) {
		if(e.getType() == SchedulerType.TICKS_2) {
			int color = random(new Integer[] {1,3,7,9,5,4,6});
			for(Sheep s : sheep) {
				s.setColor(DyeColor.getByData((byte)color));
				s.getLocation().getWorld().playSound(s.getLocation(), Sound.SHEEP_IDLE, 5, -25);
			}
		}
	}
	
	public void createSheep(final Location l) {
		final Sheep s = l.getWorld().spawn(l, Sheep.class);
		sheep.add(s);
		((CraftSheep)s).getHandle().move(0, 0, 0);
		s.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 100, true));
		s.setCustomNameVisible(false);
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			
			@Override
			public void run() {
				s.getLocation().getWorld().playSound(s.getLocation(), Sound.EXPLODE, 5, -3F);
				ParticleEffect.EXPLOSION_NORMAL.display(0, 0, 0, 1, 200, s.getLocation(), 25);
				sheep.remove(s);
				s.remove();
			}
		}, 4*20);
	}
	
	
	 @EventHandler
	  public void paramPlayerUseExplosiveSheep(PlayerInteractEvent paramPlayerUseExplosiveSHeepEvent)
	  {
	    final Player paramPlayer = paramPlayerUseExplosiveSHeepEvent.getPlayer();
	    Action paramAction = paramPlayerUseExplosiveSHeepEvent.getAction();
	    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
	      return;
	    }
	    ItemStack paramItem = paramPlayer.getItemInHand();
	    if (plugin.getUtilBlock().usable(paramPlayerUseExplosiveSHeepEvent.getClickedBlock())) {
	      return;
	    }
	    if (plugin.getItem().isGadgetItem(paramItem, plugin.getMessagesFile().ExplosiveSheepName)) {
	      if(UtilCooldown.tryCooldown(paramPlayer, "ExplosiveSheep", plugin.getConfigFile().explosiveSheepCooldown)) {
	        createSheep(paramPlayer.getLocation());
	      }else{
	    	  long cooldown = UtilCooldown.getCooldown(paramPlayer, "ExplosiveSheep") / 1000L;
	          plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "Explosive Sheep", "ExplosiveSheep", cooldown);
	          paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
	          UtilTitles.sendCooldownTitle(paramPlayer, 
	          plugin.getMessagesFile().titleMessage,
	          plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", Tipos.getPlayerGadget.get(paramPlayer)), 
	          plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
	      }
	    }
	  }
	 
	 @EventHandler
	 public void damn(EntityDamageEvent e) {
		 if(e.getEntity() instanceof Sheep) {
			 Sheep s = (Sheep)e.getEntity();
			 if(sheep.contains(s)) {
				 e.setCancelled(true);
			 }
		 }
	 }
	 
	 @EventHandler(priority = EventPriority.MONITOR)
	 public void entityIsSheep(SheepRegrowWoolEvent e) {
		 if(e.getEntity() instanceof Sheep) {
			 Sheep s = (Sheep)e.getEntity();
			 if(sheep.contains(s)) {
				 e.setCancelled(true);
			 }
		 }
	 }
	 
	 @EventHandler(priority = EventPriority.MONITOR)
	 public void entityIsSheep2(PlayerShearEntityEvent e) {
		 if(e.getEntity() instanceof Sheep) {
			 Sheep s = (Sheep)e.getEntity();
			 if(sheep.contains(s)) {
				 e.setCancelled(true);
			 }
		 }
	 }
	 
	 @EventHandler(priority = EventPriority.MONITOR)
	 public void entityChange(EntityChangeBlockEvent e) {
		 if(e.getEntity() instanceof Sheep) {
			 if((e.getTo() == Material.DIRT) && (e.getBlock().getType() == Material.GLASS)) {
				 e.setCancelled(true);
			 }
		 }
	 }
}
