package EventManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import Pets.Pets;
import Gadgets.Tipos;
import Mounts.MountHandler;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class WorldChange implements Listener {
	
	UltraGadgets plugin = UltraGadgets.getMain();
	
	@EventHandler
	public void playerChangeWorld(PlayerChangedWorldEvent e) {
		Player p = (Player)e.getPlayer();
		
		if(plugin.getConfig().getBoolean("Remover-Itens-Ao-Trocar-De-Mundo")) {
			if(plugin.getUtilPartciles().hasEffect(p)) {
				plugin.getUtilPartciles().stopAll(p);
			}
			if(Pets.PetsType.HasPet(p)) {
				Pets.PetsType.removePet(p);
			}
			if(MountHandler.HasPet(p)) {
				MountHandler.removePlayerMount(p);
			}
			if(Tipos.playerHasGadget(p)) {
				Tipos.setGadget(p, Tipos.NENHUM);
				Bukkit.getScheduler().cancelTask(JoinEvent.run.get(p));
			}
			if(plugin.getDisguiseMenu().hasDisguise(p)) {
				plugin.getDisguiseMenu().removeAllDisguises(p);
			}
		}
	}
}
