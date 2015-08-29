package Particulas;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import Utils.LocalUpdate;
import Utils.ParticleEffect;
import Utils.UtilParticle;
import Utils.UtilParticle.ParticleType;
import Utils.UtilVelocity;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class UtilParticleType
{
  UltraGadgets plugin = UltraGadgets.getMain();
  HashMap<Player, Integer> animatedHelixID = new HashMap<>();
  HashMap<Player, Integer> intID = new HashMap<>();
  HashMap<Player, Integer> intIDspheric = new HashMap<>();
  HashMap<Player, Integer> radar = new HashMap<>();
  HashMap<Player, Integer> Helix = new HashMap<>();
  HashMap<Player, Integer> otherroration = new HashMap<>();
  HashMap<Player, Integer> circleofparticle = new HashMap<>();
  public HashMap<Player, String> otherType = new HashMap<>();
  
  public void spiraleEffect(final Player p, final ParticleEffect type)
  {
    if (!intID.containsKey(p))
    {
      int sp = Bukkit.getServer().getScheduler().runTaskTimer(plugin, new Runnable()
      {
        float i = 0.0F;
        
        public void run()
        {
          for (int k = 0; k < 1; k++)
          {
            Location l = p.getLocation();
            double x = Math.sin(i * 3.7F);
            double y = Math.cos(i * 3.7F);
            double z = i * 0.4F;
            Vector v = new Vector(x, z, y);
            l.add(v);
            type.display(0.0F, 0.0F, 0.0F, 3.0F, 1, l, 25.0D);
          }
          i += 0.1F;
          if (i > 5.0F) {
            i = 0.0F;
          }
        }
      }, 1L, 1L).getTaskId();
      intID.put(p, Integer.valueOf(sp));
    }
  }
  
  public void rorationEffect(final Player p, final ParticleEffect type)
  {
    if (!intIDspheric.containsKey(p))
    {
      int rt = Bukkit.getServer().getScheduler().runTaskTimer(plugin, new Runnable()
      {
        float j = 0.0F;
        
        public void run()
        {
          Location loc = p.getLocation();
          loc.setY(loc.getY() + 1.9D + 0.03D);
          for (int k = 0; k < 1.0F; k++)
          {
            loc.add(Math.cos(j) * 0.6000000238418579D, j * 0.01F, Math.sin(j) * 
              0.6000000238418579D);
            type.display(0.0F, 0.0F, 0.0F, 3.0F, 1, loc, 25.0D);
          }
          j += 0.2F;
          if (j > 50.0F) {
            j = 0.0F;
          }
        }
      }, 1L, 1L).getTaskId();
      intIDspheric.put(p, Integer.valueOf(rt));
    }
  }
  
  public void radarEffect(final Player p, final ParticleEffect type)
  {
    if (!radar.containsKey(p))
    {
      int superS = Bukkit.getServer().getScheduler().runTaskTimer(plugin, new Runnable()
      {
        float j = 0.0F;
        
        public void run()
        {
          Location loc = p.getLocation();
          loc.setY(loc.getY() + 2.0D);
          for (int k = 0; k < 5.0F; k++)
          {
            loc.setX(loc.getX() + 
              Math.sin(j * 0.17453292519943295D) * 
              0.20000000298023224D);
            loc.setY(loc.getY());
            
            loc.setZ(loc.getZ() + 
              Math.cos(j * 0.17453292519943295D) * 
              0.20000000298023224D);
            
            type.display(0.0F, 0.0F, 0.0F, 3.0F, 1, loc, 25.0D);
            
            j += 0.3F;
          }
          if (j >= 360.0F) {
            j = 0.0F;
          }
        }
      }, 1L, 1L).getTaskId();
      radar.put(p, Integer.valueOf(superS));
    }
  }
  
  public void SpiralEffect(final Player p, final ParticleEffect particle)
  {
    if (!Helix.containsKey(p))
    {
      int helix = Bukkit.getServer().getScheduler().runTaskTimer(plugin, new Runnable()
      {
        double xRotation;
        double yRotation;
        double zRotation = 5.0D;
        double angularVelocityX = 0.015707963267948967D;
        double angularVelocityY = 0.018479956785822312D;
        double angularVelocityZ = 0.02026833970057931D;
        float radius = 1.5F;
        float step = 0.0F;
        double xSubtract;
        double ySubtract;
        double zSubtract;
        boolean enableRotation = true;
        int particles = 20;
        
        public void run()
        {
          Location location = p.getLocation();
          location.add(0.0D, 1.0D, 0.0D);
          location.subtract(xSubtract, ySubtract, zSubtract);
          double inc = 6.283185307179586D / particles;
          double angle = step * inc;
          Vector v = new Vector();
          v.setX(Math.cos(angle) * radius);
          v.setZ(Math.sin(angle) * radius);
          UtilVelocity.rotateVector(v, xRotation, yRotation, 
            zRotation);
          if (enableRotation) {
            UtilVelocity.rotateVector(v, angularVelocityX * 
              step, angularVelocityY * step, 
              angularVelocityZ * step);
          }
          particle.display(0.0F, 0.0F, 0.0F, 3.0F, 1, location.add(v), 50.0D);
          step += 1.0F;
        }
      }, 1L, 1L).getTaskId();
      Helix.put(p, Integer.valueOf(helix));
    }
  }
  
  public void startHelix(final Player p, final ParticleType type)
  {
    if (!animatedHelixID.containsKey(p)) {	
      int continue1 = Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
          double phi = 0;
          public void run(){
           phi = phi + Math.PI/8;                                 
          double x, y, z;                
          
      	if(!LocalUpdate.isNotMoving(p)) {
       	new UtilParticle(type, 0.10000000149011612D, 4, 0.30000001192092896D).sendToLocation(p.getLocation().add(0.0D, 1.0D, 0.0D));
       	
       	}else{      
          Location l = p.getLocation();
          for (double t = 0; t <= 2*Math.PI; t = t + Math.PI/16){
          for (double i = 0; i <= 1; i = i + 1){
           x = 0.4*(2*Math.PI-t)*0.5*Math.cos(t + phi + i*Math.PI);
           y = 0.5*t;
           z = 0.4*(2*Math.PI-t)*0.5*Math.sin(t + phi + i*Math.PI);
           l.add(x, y, z);
           new UtilParticle(type, 0.0D, 1, 1.0E-4D).sendToLocation(l);
           l.subtract(x,y,z);
           }
          }
         }
       }
      }, 0L, 5L).getTaskId();
      
      animatedHelixID.put(p, Integer.valueOf(continue1));
 	
    }
   }
  
  public void rorationOtherType(final Player p, final ParticleType ptype)
  {
    if (!intIDspheric.containsKey(p))  {
      int rt = Bukkit.getServer().getScheduler().runTaskTimer(plugin, new Runnable()
      {
        float j = 0.0F;
    	
        public void run()
        {

            Location loc = p.getLocation();
            loc.setY(loc.getY() + 1.9D + 0.03D);
            for (int k = 0; k < 1.0F; k++)
            {
              loc.add(Math.cos(j) * 0.6000000238418579D, j * 0.01F, Math.sin(j) * 
                0.6000000238418579D);
            
              
              new UtilParticle(ptype, 0.0D, 1, 1.0E-4D).sendToLocation(loc);
            }
        
          j += 0.2F;
          if (j > 50.0F) {
            j = 0.0F;
          }
        }
      }, 1L, 1L).getTaskId();
      otherroration.put(p, Integer.valueOf(rt));
    }
  }
  
  public void circleOfParticles(final Player p, final ParticleEffect pe) {
	  if(!circleofparticle.containsKey(p)) {
	 int c = Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
			
		  double cosI = 0;
			@Override
			public void run() {
		      	if(!LocalUpdate.isNotMoving(p)) {
		      	 	new UtilParticle(ParticleType.DRIP_WATER, 0.10000000149011612D, 21, 0.30000001192092896D).sendToLocation(p.getLocation().add(0.0D, 1.0D, 0.0D));
		      		new UtilParticle(ParticleType.WATER_SPLASH, 0.10000000149011612D, 21, 0.30000001192092896D).sendToLocation(p.getLocation().add(0.0D, 1.0D, 0.0D));
		           	}else{  
				  final Location l = p.getLocation();
				 cosI += Math.PI/10;
				 for(double t = 0; t <= 2*Math.PI; t += Math.PI/40) {
					double x = 1.5*Math.cos(t)*Math.sin(cosI);
					double y = 1.5*Math.cos(cosI) + 1.5;
					double z = 1.5*Math.sin(t)*Math.sin(cosI);
					l.add(x,y,z);
					pe.display(0.0F, 0.0F, 0.0F, 0.0F, 1, l, 25.0D);
					l.subtract(x,y,z);
				 }
			}
		  }
		}, 0L, 6L).getTaskId();
      circleofparticle.put(p, c);
	 }
  }
  
  public boolean hasEffect(Player p)
  {
    if (intID.containsKey(p))
    {
      p.sendMessage(plugin.getMensagensConfig().getString("Particula-Ja-Ativada").replaceAll("&", "§"));
      return true;
    }
    if (intIDspheric.containsKey(p))
    {
     p.sendMessage(plugin.getMensagensConfig().getString("Particula-Ja-Ativada").replaceAll("&", "§"));
      return true;
    }
    if (radar.containsKey(p))
    {
      p.sendMessage(plugin.getMensagensConfig().getString("Particula-Ja-Ativada").replaceAll("&", "§"));
      return true;
    }
    if(Helix.containsKey(p)) {
        p.sendMessage(plugin.getMensagensConfig().getString("Particula-Ja-Ativada").replaceAll("&", "§"));
        return true;
      }
    if(animatedHelixID.containsKey(p)) {
        p.sendMessage(plugin.getMensagensConfig().getString("Particula-Ja-Ativada").replaceAll("&", "§"));
        return true;
      }
    if(otherroration.containsKey(p)) {
        p.sendMessage(plugin.getMensagensConfig().getString("Particula-Ja-Ativada").replaceAll("&", "§"));
        return true;
      }
    if(otherType.containsKey(p)) {
        p.sendMessage(plugin.getMensagensConfig().getString("Particula-Ja-Ativada").replaceAll("&", "§"));
        return true;
    }
    if(circleofparticle.containsKey(p)) {
        p.sendMessage(plugin.getMensagensConfig().getString("Particula-Ja-Ativada").replaceAll("&", "§"));
        return true;
    }
	return false;
  }
  
  public void stopAll(Player p)
  {
    if (intID.containsKey(p))
    {
      Bukkit.getServer().getScheduler().cancelTask(((Integer)intID.get(p)).intValue());
      p.sendMessage(plugin.getMensagensConfig().getString("Particula-Ja-Ativada").replaceAll("&", "§"));
      intID.remove(p);
    }
    if (intIDspheric.containsKey(p))
    {
      Bukkit.getServer().getScheduler().cancelTask(((Integer)intIDspheric.get(p)).intValue());
      p.sendMessage(plugin.getMensagensConfig().getString("Particula-Desativadas").replaceAll("&", "§"));
      intIDspheric.remove(p);
    }
    if (radar.containsKey(p))
    {
      Bukkit.getServer().getScheduler().cancelTask(((Integer)radar.get(p)).intValue());
      p.sendMessage(plugin.getMensagensConfig().getString("Particula-Desativadas").replaceAll("&", "§"));
      radar.remove(p);
    }
    if (Helix.containsKey(p))
    {
      Bukkit.getServer().getScheduler().cancelTask(((Integer)Helix.get(p)).intValue());
      p.sendMessage(plugin.getMensagensConfig().getString("Particula-Desativadas").replaceAll("&", "§"));
      Helix.remove(p);
    }
    if (animatedHelixID.containsKey(p))
    {
      Bukkit.getServer().getScheduler().cancelTask(((Integer)animatedHelixID.get(p)).intValue());
      p.sendMessage(plugin.getMensagensConfig().getString("Particula-Desativadas").replaceAll("&", "§"));
      animatedHelixID.remove(p);
    }
    if(otherroration.containsKey(p)) {
        Bukkit.getServer().getScheduler().cancelTask(((Integer)otherroration.get(p)).intValue());
        p.sendMessage(plugin.getMensagensConfig().getString("Particula-Desativadas").replaceAll("&", "§"));
        otherroration.remove(p);
    }
    if(otherType.containsKey(p)) {
    	 p.sendMessage(plugin.getMensagensConfig().getString("Particula-Desativadas").replaceAll("&", "§"));
         otherType.remove(p);
    }
    if(circleofparticle.containsKey(p)) {
   	 p.sendMessage(plugin.getMensagensConfig().getString("Particula-Desativadas").replaceAll("&", "§"));
     Bukkit.getServer().getScheduler().cancelTask(((Integer)circleofparticle.get(p)).intValue());
        circleofparticle.remove(p);
   }
  }
}