package EventManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import Utils.UtilLag;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class PluginListener
  implements Listener
{
  UltraGadgets plugin = UltraGadgets.getMain();
  
  public static void reloadPlugin(final Player reloader) {
	  final UltraGadgets plugin = UltraGadgets.getMain();
	  reloader.sendMessage("§eTentando recarregar... Aguarde um momento.");
	  try{
	  Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
		
		@Override
		public void run() {
			Bukkit.getServer().getPluginManager().disablePlugin(plugin);
			Bukkit.getServer().getPluginManager().enablePlugin(plugin);
			reloader.sendMessage("§aO plugin foi recarregado com sucesso!");
		}
	}, 3*20L);
	  
	  }catch(RuntimeException r) { 
		  r.printStackTrace();
		  reloader.sendMessage("§cFalha ao recarregar o plugin! Veja o console.");
	  }
  }
  
  public static void lagManager(Player sender) {
	  UltraGadgets plugin = UltraGadgets.getMain();
	  if(UtilLag.ServerisLag()) {
		  sender.sendMessage(plugin.getMessagesFile().prefix + " §cO servidor está atualmente á §6§l" + UtilLag.getTicksPerSecond() + " §c(TPS MÉDIO/RUIM)");
		  
	  }else{
		  sender.sendMessage(plugin.getMessagesFile().prefix + " §cO servidor está atualmente á §6§l" + UtilLag.getTicksPerSecond() + " §c(TPS BOM)");
	  }
  }
}