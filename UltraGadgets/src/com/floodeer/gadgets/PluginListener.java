package com.floodeer.gadgets;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;

import Pets.Pets.PetsType;
import Util.UtilLag;

public class PluginListener
  implements Listener
{
  Main plugin = Main.getMain();
  
  public static void reloadPlugin(final Player reloader) {
	  final Main plugin = Main.getMain();
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
	  Main plugin = Main.getMain();
	  if(UtilLag.ServerisLag()) {
		  sender.sendMessage(plugin.getMessagesFile().prefix + " §cO servidor está atualmente á §6§l" + UtilLag.getTicksPerSecond() + " §c(TPS MÉDIO/RUIM)");
		  
	  }else{
		  sender.sendMessage(plugin.getMessagesFile().prefix + " §cO servidor está atualmente á §6§l" + UtilLag.getTicksPerSecond() + " §c(TPS BOM)");
	  }
  }
  
  @EventHandler
  public void onService(PluginDisableEvent e) {
	  if(e.getPlugin().equals(plugin)) 
	  {
		  for(Player p : Bukkit.getOnlinePlayers()) {
			  if(p == null) return;
			  if(PetsType.HasPet(p)) {
				  PetsType.removePet(p);
			  }
		  }
	  }
  }
}