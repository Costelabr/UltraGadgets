package Particulas;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import br.com.floodeer.ultragadgets.UltraGadgets;
import Update.SchedulerEvent;
import Update.SchedulerType;
import Utils.UtilMath;
import Utils.UtilParticle;

public class Nuvem implements Listener {
	
	UltraGadgets plugin = UltraGadgets.getMain();
	   
	   @EventHandler
	   public void nuvemUpdater(SchedulerEvent paramUpdateEvent) {
	     if (paramUpdateEvent.getType() == SchedulerType.TICK) {
	  	   for(Player p : plugin.getUtilPartciles().otherType.keySet()) {
	  		    if(plugin.getUtilPartciles().otherType.get(p) == "Nuvem") {
	             Location localLocation = p.getLocation();      
	             localLocation.setY(p.getLocation().getY() + 3.700000047683716D);
	             new UtilParticle(UtilParticle.ParticleType.SNOW_SHOVEL, 0.0D, 2, 0.0D).sendToLocation(localLocation.add(UtilMath.randomRange(-0.6F, 0.6F), 0.0D, UtilMath.randomRange(-0.6F, 0.6F)));
	             new UtilParticle(UtilParticle.ParticleType.CLOUD, 0.0D, 4, 0.0D).sendToLocation(localLocation.add(UtilMath.randomRange(-0.7F, 0.7F), 0.0D, UtilMath.randomRange(-0.7F, 0.7F)));
	             new UtilParticle(UtilParticle.ParticleType.CLOUD, 0.0D, 4, 0.0D).sendToLocation(localLocation.add(UtilMath.randomRange(-0.7F, 0.7F), 0.0D, UtilMath.randomRange(-0.7F, 0.7F)));
	             localLocation.subtract(localLocation);
	           }
	         }
	     }
	   }
}
