package Gadgets;

import java.util.ArrayList;
import java.util.HashMap;

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

import Utils.UtilCooldown;
import Utils.UtilMath;
import Utils.UtilTitles;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class DiscoArmor implements Listener {

	  UltraGadgets plugin = UltraGadgets.getMain();
	  ArrayList<Player> discoPlayer = new ArrayList<Player>();
	  HashMap<Player, Integer> armorValue = new HashMap<Player, Integer>();
	  public void summonArmor(final Player paramPlayer) {
	  discoPlayer.add(paramPlayer);
      ItemStack i = plugin.getItemStack().buildColoredArmor(Material.LEATHER_BOOTS, Color.RED);
      ItemStack i2 = plugin.getItemStack().buildColoredArmor(Material.LEATHER_CHESTPLATE, Color.RED);
      ItemStack i3 = plugin.getItemStack().buildColoredArmor(Material.LEATHER_LEGGINGS, Color.RED);
      ItemStack i4 = plugin.getItemStack().buildColoredArmor(Material.LEATHER_HELMET, Color.RED);
      paramPlayer.getInventory().setBoots(i);
      paramPlayer.getInventory().setChestplate(i2);
      paramPlayer.getInventory().setLeggings(i3);
      paramPlayer.getInventory().setHelmet(i4);
	 int taskArmor = Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
		
		@Override
		public void run() {
	      for (ItemStack localItemStack : paramPlayer.getInventory().getArmorContents())  {
	        if ((localItemStack.getItemMeta() instanceof LeatherArmorMeta))  {
	          LeatherArmorMeta localLeatherArmorMeta = (LeatherArmorMeta)localItemStack.getItemMeta();
	    	  Color c = Color.fromRGB(UtilMath.random.nextInt(255), UtilMath.random.nextInt(255), UtilMath.random.nextInt(255));
	          localLeatherArmorMeta.setColor(c);
	          localItemStack.setItemMeta(localLeatherArmorMeta);
	        }
	      }
	    }
	}, 1, 2L).getTaskId();
	  armorValue.put(paramPlayer, taskArmor);
	  Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
		
		@Override
		public void run() {
			discoPlayer.remove(paramPlayer);
			paramPlayer.getInventory().setArmorContents(null);
			Bukkit.getScheduler().cancelTask(armorValue.get(paramPlayer));
			
		}
	}, 25*20L);
  }
	  
	  
	  @EventHandler
	  public void paramPlayerActiveDiscoArmour(PlayerInteractEvent paramPlayerActiveDiscoArmor)
	  {
	    final Player paramPlayer = paramPlayerActiveDiscoArmor.getPlayer();
	    Action paramAction = paramPlayerActiveDiscoArmor.getAction();
	    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
	      return;
	    }
	    ItemStack paramItem = paramPlayer.getItemInHand();
	    if (this.plugin.getUtilBlock().usable(paramPlayerActiveDiscoArmor.getClickedBlock())) {
	      return;
	    }
	    if (this.plugin.getItem().isGadgetItem(paramItem, this.plugin.getMessagesFile().discoArmorName)) {
	      if (UtilCooldown.tryCooldown(paramPlayer, "DiscoArmor", this.plugin.getConfigFile().discoArmorCooldown))
	      {
	        paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 25*20, 1));
	        paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 25*20, 2));
	        summonArmor(paramPlayer);
	      }else{
	        long cooldown = UtilCooldown.getCooldown(paramPlayer, "DiscoArmor") / 1000L;
	        plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "DiscoArmor", "DiscoArmor", cooldown);
	        paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
	        UtilTitles.sendCooldownTitle(paramPlayer, 
	        plugin.getMessagesFile().titleMessage,
	        plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", Tipos.getPlayerGadget.get(paramPlayer)), 
	        plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
	      }
	    }
	  }
}
