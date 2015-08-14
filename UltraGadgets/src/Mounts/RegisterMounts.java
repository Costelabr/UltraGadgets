package Mounts;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import Menus.MountMenu;

public class RegisterMounts {
	
	public static void registerMouts(JavaPlugin plugin) {
		PluginManager p = Bukkit.getPluginManager();
		
		p.registerEvents(new MountHandler(), plugin);
		p.registerEvents(new Frozen(), plugin);
		p.registerEvents(new Infernal(), plugin);
		p.registerEvents(new MountMenu(), plugin);
	}

}
