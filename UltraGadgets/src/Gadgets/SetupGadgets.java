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
		    pm.registerEvents(new DiscoArmor(), register); 
		    pm.registerEvents(new Soco(), register); 
		    pm.registerEvents(new Gravidade(), register); 
		    pm.registerEvents(new PartyPopper(), register);
		    pm.registerEvents(new Foguete(), register);
		    pm.registerEvents(new Rainbow(), register); 
		    pm.registerEvents(new Poop(), register);  
		}catch(RuntimeException gx) {
			throw new GadgetException("N�o foi poss�vel carregar os Gadgets.");
		}
	}

}
