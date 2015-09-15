package Gadgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import Utils.UtilCooldown;
import Utils.UtilMath;
import Utils.UtilTitles;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class Poop implements Listener {
	
	UltraGadgets plugin = UltraGadgets.getMain();
	private final Map<Player, Item> bombsItem = new HashMap<>();
	private final Map<Player, List<Item>> entitiesMap = new HashMap<>();
	
	public void poop(final Player player) {
	
		World world = player.getWorld();
	    Location location = player.getLocation();
	    final Item item = world.dropItem(location, plugin.getItemStack().create(Material.INK_SACK, (byte)3));
	    item.setVelocity(location.getDirection().multiply(1));
	    item.setPickupDelay(Integer.MAX_VALUE);
	    world.playSound(location, Sound.FUSE, 10.0F, 5.0F);
	    new BukkitRunnable() {
	      public void run() {
	        if (!item.isDead()) {
	          Location location = item.getLocation();
	          World world = location.getWorld();
	          item.remove();
	          world.createExplosion(location, 0.0F);
	          List<Item> entities = new ArrayList<>();
	          for (int i = 0; i < UtilMath.random.nextInt(41) + 40; i++) {
	            Item poop = world.dropItem(location, plugin.getItemStack().create(Material.INK_SACK, (byte)3));
	            float x = -0.8F + (float)(Math.random() * 2.6D);
	            float y = -0.4F + (float)(Math.random() * 1.8D);
	            float z = -0.8F + (float)(Math.random() * 2.6D);
	            poop.setVelocity(new Vector(x, y, z));
	            poop.setPickupDelay(Integer.MAX_VALUE);
	            entities.add(poop);
	          }
	          for (int i = 0; i < UtilMath.random.nextInt(21) + 20; i++) {
	            Item poop = world.dropItem(location, plugin.getItemStack().create(Material.WOOL, (byte)12));
	            float x = -0.8F + (float)(Math.random() * 2.6D);
	            float y = -0.4F + (float)(Math.random() * 1.8D);
	            float z = -0.8F + (float)(Math.random() * 2.6D);
	            poop.setVelocity(new Vector(x, y, z));
	            poop.setPickupDelay(Integer.MAX_VALUE);
	            entities.add(poop);
	          }
	          entitiesMap.put(player, entities);
	        }
	      }
	    }.runTaskLater(plugin, 80L);
	    bombsItem.put(player, item);
	    Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
			
			@Override
			public void run() {
				removeAndExplode(player);
			}
		}, 8*20L);
	  }
	
	public void removeAndExplode(Player player) {
		Item bomb = bombsItem.remove(player);
		if ((bomb != null) && (!bomb.isDead())) {
		   bomb.getLocation().getWorld().createExplosion(bomb.getLocation().getX(), bomb.getLocation().getY(), bomb.getLocation().getZ(), 5F, false, false); 
		   bomb.remove();
		}
		 List<Item> entities = entitiesMap.remove(player);
		  if (entities != null) {
		  for (Item entity : entities) {
		    if (!entity.isDead()) {
		      entity.getLocation().getWorld().createExplosion(entity.getLocation().getX(), entity.getLocation().getY(), entity.getLocation().getZ(), 5F, false, false); 
		      entity.remove();
		      
		 }
	  }
    }
  }
	
	  @EventHandler
	  public void paramPlayerActivePoopBomb(PlayerInteractEvent paramPlayerActivePoopBomb)
	  {
	    final Player paramPlayer = paramPlayerActivePoopBomb.getPlayer();
	    Action paramAction = paramPlayerActivePoopBomb.getAction();
	    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
	      return;
	    }
	    ItemStack paramItem = paramPlayer.getItemInHand();
	    if (this.plugin.getUtilBlock().usable(paramPlayerActivePoopBomb.getClickedBlock())) {
	      return;
	    }
	    if (this.plugin.getItem().isGadgetItem(paramItem, plugin.getMessagesFile().poopGadgetName)) {
	    	if (UtilCooldown.tryCooldown(paramPlayer, "Epoop", plugin.getConfigFile().poopCooldown)) {
	        poop(paramPlayer);
	 	   }else{
		      long cooldown = UtilCooldown.getCooldown(paramPlayer, "Epoop") / 1000L;
		      plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "Epoop", "Epoop", cooldown);
		      paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
		      UtilTitles.sendCooldownTitle(paramPlayer, 
		      plugin.getMessagesFile().titleMessage,
		      plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", Tipos.getPlayerGadget.get(paramPlayer)), 
		      plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
	     }
	 }
  }
}
