package Gadgets;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import Exception.GadgetException;

public class SetupGadgets {
	
	public static void registerGadgets(JavaPlugin register) {
		try{
			PluginManager pm = Bukkit.getPluginManager();
			pm.registerEvents(new Bomba(), register);
			pm.registerEvents(new CookieKookie(), register);
			pm.registerEvents(new DiamondParty(), register);
			pm.registerEvents(new DiscoBall(), register);
			pm.registerEvents(new FireworkParty(), register);
			pm.registerEvents(new FunGun(), register);
			pm.registerEvents(new Movire(), register);
			pm.registerEvents(new PaintballGun(), register);
			pm.registerEvents(new Paraquedas(), register);
			pm.registerEvents(new RailGun(), register);
			pm.registerEvents(new SmokeBomb(), register);
			pm.registerEvents(new StickOfTeleport(), register);
			pm.registerEvents(new Trampolim(), register);
			pm.registerEvents(new WitherShooter(), register);
		    pm.registerEvents(new Vampire(), register);
		    pm.registerEvents(new MobGun(), register);
		    pm.registerEvents(new VectorTNT(), register);
		    pm.registerEvents(new Cowboy(), register);
		    pm.registerEvents(new ExplosiveSheep(), register);
		}catch(RuntimeException gx) {
			throw new GadgetException("Não foi possível carregar os Gadgets.");
		}
	}

}
