package Particulas;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ParticleSetup implements Listener {
	  
	  public static void setupParticles(JavaPlugin javaPl) {
		  PluginManager pm = Bukkit.getServer().getPluginManager();
		  pm.registerEvents(new Nuvem(), javaPl);
		  pm.registerEvents(new Frozen(), javaPl);
		  pm.registerEvents(new Vortex(), javaPl);
		  
	  }
	  
}
