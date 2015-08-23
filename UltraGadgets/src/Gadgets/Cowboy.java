package Gadgets;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import com.floodeer.gadgets.UltraGadgets;

public class Cowboy implements Listener {
	
	UltraGadgets plugin = UltraGadgets.getMain();
	
	@EventHandler
	public void paramPlayerUseCowBoy(PlayerInteractEntityEvent paramPlayerUseCowBoyEvent) {
		if(paramPlayerUseCowBoyEvent.getRightClicked() instanceof Player && paramPlayerUseCowBoyEvent.getPlayer() instanceof Player) {
			
			Player paramClicked = (Player)paramPlayerUseCowBoyEvent.getRightClicked();
			Player paramPlayer = (Player)paramPlayerUseCowBoyEvent.getPlayer();
			ItemStack paramItem = paramPlayer.getItemInHand();
			if(plugin.getItem().isGadgetItem(paramItem, plugin.getMessagesFile().CowboyGadgetName)) {
				paramClicked.setPassenger(paramPlayer);
			}
		}
	}
}
 