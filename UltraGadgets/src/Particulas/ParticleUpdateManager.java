package Particulas;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

import com.floodeer.gadgets.Main;

import Core.UtilParticle;
import Core.UtilParticle.ParticleType;
import Core.UtilVelocity;
import EventManager.UpdateEvent;
import EventManager.UpdateType;

public class ParticleUpdateManager implements Listener{
	
	
	float radius = 2.0F;
	int particles = 14;
	float height = 0.0F;
	int step = 0;
	double angularVelocityX = 0.07853981633974483D;
	Main plugin = Main.getMain();
	
   @EventHandler
	public void paramUpdateEvent(UpdateEvent paramUpdateEvent) {
	  if (paramUpdateEvent.getType() == UpdateType.TICK) {
	   for(Player p : plugin.getUtilPartciles().otherType.keySet()) {
	    if(plugin.getUtilPartciles().otherType.get(p) == "Frozen") {
	       double d1 = this.step * this.angularVelocityX;
	        Location localLocation1 = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ());
	        Location localLocation2 = localLocation1;
	         localLocation1.add(0.0D, this.height, 0.0D);
	          for (int i = 0; i < this.particles; i++){
	            double d2 = Math.cos(i * 3.141592653589793D / 4.0D) * this.radius;
	             double d3 = this.height;
	              double d4 = Math.sin(i * 3.141592653589793D / 4.0D) * this.radius;
	                Vector localVector = new Vector(d2, d3, d4);
	                UtilVelocity.rotateVector(localVector, 0.0D, -d1, 0.0D);
	                localLocation2.add(localVector);
	                new UtilParticle(ParticleType.SNOW_SHOVEL, 0.0D, 1, 0.0D).sendToLocation(localLocation2);
	                localLocation2.subtract(localVector);
	              }
	              if (this.step % 2 == 0) {
	                this.height += 0.1F;
	                if (this.height > 1.9D) {
	                  new UtilParticle(ParticleType.SNOW_SHOVEL, 0.20000000298023224D, 30, 0.10000000149011612D).sendToLocation(localLocation1.add(0.0D, 2.5D, 0.0D));
	                  this.height = 0.0F;
	                }
	                this.radius -= 0.1F;
	                if (this.radius < 0.1F) {
	                  this.radius = 2.0F;
	                }
	              }
	              this.step += 1;
	            }else{
	              new UtilParticle(ParticleType.SNOW_SHOVEL, 0.10000000149011612D, 5, 0.20000000298023224D).sendToLocation(p.getLocation().add(0.0D, 1.0D, 0.0D));
	            }
	        }
	    }
	  }
	}