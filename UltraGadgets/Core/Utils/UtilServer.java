package Utils;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;

public class UtilServer {

	public static Collection<? extends Player> getPlayers() {
		return Bukkit.getServer().getOnlinePlayers();
	}

	public static Server getServer() {
		return Bukkit.getServer();
	}

}
