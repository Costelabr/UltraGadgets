package Gadgets;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Util.UtilCooldown;

import com.floodeer.gadgets.Main;

public class Vampire implements Listener {
	
	Main plugin = Main.getMain();
	
	@SuppressWarnings("deprecation")
	private void setVampire(final Player paramPlayer, long paramTime) {
	    ItemStack i = new ItemStack(Material.LEATHER_CHESTPLATE);
	    LeatherArmorMeta l = (LeatherArmorMeta)i.getItemMeta();
	    l.setColor(Color.BLACK);
	    i.setItemMeta(l);
	    ItemStack paramSkull = new ItemStack(Material.SKULL_ITEM, 1, (byte)1);
	    
		paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 10));
	    paramPlayer.getInventory().setHelmet(paramSkull);
	    paramPlayer.getInventory().setChestplate(i);
	    paramPlayer.playSound(paramPlayer.getLocation(), Sound.WITHER_IDLE, 1, -8);
	    paramPlayer.updateInventory();
	    if(plugin.getConfig().getBoolean("Vampiro-Pode-Voar")) {
	    	paramPlayer.setAllowFlight(true);
	    }
	    
	    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			
			@Override
			public void run() {
				paramPlayer.removePotionEffect(PotionEffectType.INVISIBILITY);
				paramPlayer.getInventory().setHelmet(null);
			    paramPlayer.getInventory().setChestplate(null);
			    paramPlayer.updateInventory();
			    if(plugin.getConfig().getBoolean("Vampiro-Pode-Voar")) {
			    	paramPlayer.setAllowFlight(false);
			    }
				
			}
		}, paramTime*20L);
	}
	
	@EventHandler
	public void paramPlayerUseVampir(PlayerInteractEvent paramPlayerUseVampireEvent) {
		
	    Player paramPlayer = paramPlayerUseVampireEvent.getPlayer();
	    Action paramAction = paramPlayerUseVampireEvent.getAction();
	    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
	      return;
	    }
	    ItemStack paramItem = paramPlayer.getItemInHand();
	    if (this.plugin.getUtilBlock().usable(paramPlayerUseVampireEvent.getClickedBlock())) {
	      return;
	    }
	    if (this.plugin.getItem().isGadgetItem(paramItem, this.plugin.getMessagesFile().VampireGadgetName)) {
	      if (UtilCooldown.tryCooldown(paramPlayer, "Vampire", this.plugin.getConfigFile().CookieCooldown))
	      {
	        setVampire(paramPlayer, 25);
	      }
	      else
	      {
	        long cooldown = UtilCooldown.getCooldown(paramPlayer, "Vampire") / 1000L;
	        plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "Vampire", "Vampire", cooldown);
	        paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
	      }
	    }
	  }
	}
