package EventManager;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

import br.com.floodeer.ultragadgets.UltraGadgets;

public class EntitySpawnPriority implements Listener {
	
	UltraGadgets plugin = UltraGadgets.getMain(); 
	@EventHandler(priority = EventPriority.HIGHEST)
	public void spawn(CreatureSpawnEvent e) {
		if(e.getSpawnReason() == SpawnReason.CUSTOM) {
		e.setCancelled(false);	
		}
	}
}