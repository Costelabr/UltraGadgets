package EventManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.floodeer.gadgets.UltraGadgets;

public class QuitEvent implements Listener {
	
	UltraGadgets plugin = UltraGadgets.getMain();
	
	@EventHandler
	public void onPlayerLeft(PlayerQuitEvent e) {
		Player p = (Player)e.getPlayer();
		if(plugin.getUtilPartciles().hasEffect(p)) {
			plugin.getUtilPartciles().stopAll(p); 
		}
		if(plugin.getDisguiseMenu().hasDisguise(p)) {
			plugin.getDisguiseMenu().removeAllDisguises(p);
		}
	}

}
