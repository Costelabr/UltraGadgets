package Gadgets;

import java.util.Random;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import Utils.IFallingBlocks;
import Utils.UtilCooldown;
import Utils.UtilMath;
import Utils.UtilTitles;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class Soco implements Listener {
	
   UltraGadgets plugin = UltraGadgets.getMain();
   
   
   public int random(int min, int max) {

	    Random rand = new Random();

	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
   
   @EventHandler
	  public void paramPlayerUseSoco(PlayerInteractEvent paramPlayerUseSocoEvent)
	  {
	    final Player paramPlayer = paramPlayerUseSocoEvent.getPlayer();
	    Action paramAction = paramPlayerUseSocoEvent.getAction();
	    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
	      return;
	    }
	    ItemStack paramItem = paramPlayer.getItemInHand();
	    if (plugin.getUtilBlock().usable(paramPlayerUseSocoEvent.getClickedBlock())) {
	      return;
	    }
	    if (plugin.getItem().isGadgetItem(paramItem, plugin.getMessagesFile().socoGadgetName)) {
	    if (UtilCooldown.tryCooldown(paramPlayer, "Soco", plugin.getConfigFile().supersocoCooldown)){
			 IFallingBlocks.spawnFalling(paramPlayer, random(4,10), 1, random(2, 5), UtilMath.randomRange(0.5, 1.5));
	      }else{
	        long cooldown = UtilCooldown.getCooldown(paramPlayer, "Soco") / 1000L;
	        plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "Soco", "Soco", cooldown);
	        paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
	        UtilTitles.sendCooldownTitle(paramPlayer, 
	        plugin.getMessagesFile().titleMessage,
	        plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", Tipos.getPlayerGadget.get(paramPlayer)), 
	        plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
	      }
	  }
	 }
}
