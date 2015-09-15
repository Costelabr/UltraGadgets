package Gadgets;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import br.com.floodeer.ultragadgets.UltraGadgets;

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
	
	@EventHandler
	public void throwPlayer(PlayerInteractEvent paramPlayerThrowPlayerEvent) {
		if(paramPlayerThrowPlayerEvent.getAction() != Action.LEFT_CLICK_AIR) return;
		Player paramPlayer = paramPlayerThrowPlayerEvent.getPlayer();
		for(Player localPlayers : Bukkit.getOnlinePlayers()) {
			if(localPlayers.isInsideVehicle()) {
			  if(localPlayers.getVehicle() == paramPlayer) {
				  localPlayers.eject();
				  localPlayers.setVelocity(paramPlayer.getEyeLocation().getDirection().normalize().add(new Vector(0.5, 0.08, 0.5)));
			  }
		   }
		}
	}
}
 