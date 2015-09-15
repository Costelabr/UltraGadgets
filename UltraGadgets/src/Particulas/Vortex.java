package Particulas;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

import Update.SchedulerEvent;
import Update.SchedulerType;
import Utils.LocalUpdate;
import Utils.UtilParticle;
import Utils.UtilParticle.ParticleType;
import Utils.UtilVelocity;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class Vortex implements Listener {
	
	
	 UltraGadgets plugin = UltraGadgets.getMain();
		
	  private int particles = 130;
	  private int particlesPerIteration = 7;
	  private float size = 1.3F;
	  private float xFactor = 1.0F;
	  private float yFactor = 0.6F;
	  private float zFactor = 1.0F;
	  private float yOffset = 0.6F;
	  private double xRotation;
	  private double yRotation;
	  private double zRotation;
	  private int step;
	   
	   @EventHandler
	   public void vortexUpdater(SchedulerEvent paramUpdateEvent) {
	     if (paramUpdateEvent.getType() == SchedulerType.TICK) {
	       for (Player localPlayer : plugin.getUtilPartciles().newVortex.keySet()) {
	         if (plugin.getUtilPartciles().newVortex.get(localPlayer) == "VTEX") {
	           if (localPlayer.isValid()) {
	             if (LocalUpdate.isMoving(localPlayer)) {
	               Location localLocation = localPlayer.getLocation();
	               Vector localVector = new Vector();
	               for (int i = 0; i < particlesPerIteration; i++){
	                 step += 1;
	                 if (step > 600) {
	                   step = 0;
	                 }
	                 float f1 = 3.1415927F / particles * step;
	                 float f2 = (float) (Math.sin(f1 * 3.2182817F * particlesPerIteration / particles) * size);
	                 float f3 = f2 * 3.1415927F * f1;
	                 
	                 localVector.setX(xFactor * f2 * - Math.cos(f3));
	                 localVector.setZ(zFactor * f2 *  Math.sin(f3));
	                 localVector.setY(yFactor * Math.cos(f2 / 3.1415927F * f3) + yOffset);
	                 
	                 UtilVelocity.rotateVector(localVector, xRotation, yRotation, zRotation);
	                 new UtilParticle(ParticleType.FLAME, 0.0D, 2, 0.0D).sendToLocation(localLocation.add(localVector));
	                 
	                 localLocation.subtract(localVector);
	               }
	             }
	             else if (!localPlayer.isInsideVehicle())
	             {
	               new UtilParticle(ParticleType.FLAME, 0.10000000149011612D, 4, 0.30000001192092896D).sendToLocation(localPlayer.getLocation().add(0.0D, 1.0D, 0.0D));
	             }
	           }
	         }
	       }
	     }
	   }
	 }
