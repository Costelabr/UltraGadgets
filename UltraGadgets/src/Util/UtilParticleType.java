package Util;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import Util.UtilParticle.ParticleType;

import com.floodeer.gadgets.Main;

public class UtilParticleType
{
  Main plugin = Main.getMain();
  HashMap<Player, Integer> animatedHelixID = new HashMap<>();
  HashMap<Player, Integer> animatedHelixID2 = new HashMap<>();
  HashMap<Player, Integer> intID = new HashMap<>();
  HashMap<Player, Integer> intIDspheric = new HashMap<>();
  HashMap<Player, Integer> radar = new HashMap<>();
  HashMap<Player, Integer> Helix = new HashMap<>();
  HashMap<Player, Integer> otherroration = new HashMap<>();
  
  public void spiraleEffect(final Player p, final ParticleEffect type)
  {
    if (!this.intID.containsKey(p))
    {
      int sp = Bukkit.getServer().getScheduler().runTaskTimer(this.plugin, new Runnable()
      {
        float i = 0.0F;
        
        public void run()
        {
          for (int k = 0; k < 1; k++)
          {
            Location l = p.getLocation();
            double x = Math.sin(this.i * 3.7F);
            double y = Math.cos(this.i * 3.7F);
            double z = this.i * 0.4F;
            Vector v = new Vector(x, z, y);
            l.add(v);
            type.display(0.0F, 0.0F, 0.0F, 3.0F, 1, l, 25.0D);
          }
          this.i += 0.1F;
          if (this.i > 5.0F) {
            this.i = 0.0F;
          }
        }
      }, 1L, 1L).getTaskId();
      this.intID.put(p, Integer.valueOf(sp));
    }
  }
  
  public void rorationEffect(final Player p, final ParticleEffect type)
  {
    if (!this.intIDspheric.containsKey(p))
    {
      int rt = Bukkit.getServer().getScheduler().runTaskTimer(this.plugin, new Runnable()
      {
        float j = 0.0F;
        
        public void run()
        {
          Location loc = p.getLocation();
          loc.setY(loc.getY() + 1.9D + 0.03D);
          for (int k = 0; k < 1.0F; k++)
          {
            loc.add(Math.cos(this.j) * 0.6000000238418579D, this.j * 0.01F, Math.sin(this.j) * 
              0.6000000238418579D);
            type.display(0.0F, 0.0F, 0.0F, 3.0F, 1, loc, 25.0D);
          }
          this.j += 0.2F;
          if (this.j > 50.0F) {
            this.j = 0.0F;
          }
        }
      }, 1L, 1L).getTaskId();
      this.intIDspheric.put(p, Integer.valueOf(rt));
    }
  }
  
  public void radarEffect(final Player p, final ParticleEffect type)
  {
    if (!this.radar.containsKey(p))
    {
      int superS = Bukkit.getServer().getScheduler().runTaskTimer(this.plugin, new Runnable()
      {
        float j = 0.0F;
        
        public void run()
        {
          Location loc = p.getLocation();
          loc.setY(loc.getY() + 2.0D);
          for (int k = 0; k < 5.0F; k++)
          {
            loc.setX(loc.getX() + 
              Math.sin(this.j * 0.17453292519943295D) * 
              0.20000000298023224D);
            loc.setY(loc.getY());
            
            loc.setZ(loc.getZ() + 
              Math.cos(this.j * 0.17453292519943295D) * 
              0.20000000298023224D);
            
            type.display(0.0F, 0.0F, 0.0F, 3.0F, 1, loc, 25.0D);
            
            this.j += 0.3F;
          }
          if (this.j >= 360.0F) {
            this.j = 0.0F;
          }
        }
      }, 1L, 1L).getTaskId();
      this.radar.put(p, Integer.valueOf(superS));
    }
  }
  
  public void SpiralEffect(final Player p, final ParticleEffect particle)
  {
    if (!this.Helix.containsKey(p))
    {
      int helix = Bukkit.getServer().getScheduler().runTaskTimer(this.plugin, new Runnable()
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
          location.subtract(this.xSubtract, this.ySubtract, this.zSubtract);
          double inc = 6.283185307179586D / this.particles;
          double angle = this.step * inc;
          Vector v = new Vector();
          v.setX(Math.cos(angle) * this.radius);
          v.setZ(Math.sin(angle) * this.radius);
          UtilVelocity.rotateVector(v, this.xRotation, this.yRotation, 
            this.zRotation);
          if (this.enableRotation) {
            UtilVelocity.rotateVector(v, this.angularVelocityX * 
              this.step, this.angularVelocityY * this.step, 
              this.angularVelocityZ * this.step);
          }
          particle.display(0.0F, 0.0F, 0.0F, 3.0F, 1, location.add(v), 50.0D);
          this.step += 1.0F;
        }
      }, 1L, 1L).getTaskId();
      this.Helix.put(p, Integer.valueOf(helix));
    }
  }
  
  public void startHelix(final Player p)
  {
    if (!this.animatedHelixID.containsKey(p))
    {
      int continue1 = Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
      {
        int particles = 40;
        float radius = 2.0F;
        protected int i;
        int speed = 25;
        double height = 0.0D;
        int particles2 = 40;
        float radius2 = 2.0F;
        protected int i2;
        int speed2 = 25;
        double height2 = 0.0D;
        
        public void run()
        {
          Location localLocation1 = p.getLocation();
          Location localLocation2 = p.getLocation();
          
          double d1 = 6.283185307179586D * this.i / (this.particles * this.speed);
          double d2 = Math.cos(d1) * this.radius;
          double d3 = Math.sin(d1) * this.radius;
          localLocation1.add(d2, this.height, d3);
          new UtilParticle(ParticleType.FLAME, 0.0D, 1, 1.0E-4D).sendToLocation(localLocation1);
          localLocation1.subtract(d2, 0.0D, d3);
          this.i += this.speed;
          if (this.radius > 0.02D)
          {
            this.radius = ((float)(this.radius - 0.05D));
            this.height += 0.1D;
          }
          else
          {
            this.radius = 2.0F;
            this.height = 0.0D;
          }
          double d4 = 6.283185307179586D * this.i2 / (this.particles2 * this.speed2);
          double d5 = Math.cos(d4) * -this.radius2;
          double d6 = Math.sin(d4) * -this.radius2;
          Vector localVector = new Vector(d5, this.height2, d6);
          localLocation2.add(localVector);
          new UtilParticle(ParticleType.FLAME, 0.0D, 1, 1.0E-4D).sendToLocation(localLocation2);
          localLocation2.subtract(d2, 0.0D, d3);
          this.i2 += this.speed2;
          if (this.radius2 > 0.02D)
          {
            this.radius2 = ((float)(this.radius2 - 0.05D));
            this.height2 += 0.1D;
          }
          else
          {
            this.radius2 = 2.0F;
            this.height2 = 0.0D;
          }
        }
      }, 1L, 1L).getTaskId();
      this.animatedHelixID.put(p, Integer.valueOf(continue1));
    }
    if (this.animatedHelixID2.containsKey(p))
    {
      int continue2 = Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
      {
        int particles = 40;
        float radius = 2.0F;
        protected int i;
        int speed = 25;
        double height = 0.0D;
        int particles2 = 40;
        float radius2 = 2.0F;
        protected int i2;
        int speed2 = 25;
        double height2 = 0.0D;
        
        public void run()
        {
          Location paramLocation1 = p.getLocation();
          Location paramLocation2 = p.getLocation();
          
          double d1 = 6.283185307179586D * this.i / (this.particles * this.speed);
          double d2 = Math.cos(d1) * this.radius;
          double d3 = Math.sin(d1) * this.radius;
          paramLocation1.add(d2, this.height, d3);
          ParticleEffect.REDSTONE.display(0.0F, 0.0F, 0.0F, 0.0F, 3, paramLocation1, 25.0D);
          paramLocation1.subtract(d2, 0.0D, d3);
          this.i += this.speed;
          if (this.radius > 0.02D)
          {
            this.radius = ((float)(this.radius - 0.05D));
            this.height += 0.1D;
          }
          else
          {
            this.radius = 2.0F;
            this.height = 0.0D;
          }
          double d4 = 6.283185307179586D * this.i2 / (this.particles2 * this.speed2);
          double d5 = Math.cos(d4) * -this.radius2;
          double d6 = Math.sin(d4) * -this.radius2;
          Vector paramVectory = new Vector(d5, this.height2, d6);
          paramLocation2.add(paramVectory);
          ParticleEffect.REDSTONE.display(0.0F, 0.0F, 0.0F, 0.0F, 3, paramLocation2, 25.0D);
          paramLocation2.subtract(d2, 0.0D, d3);
          this.i2 += this.speed2;
          if (this.radius2 > 0.02D)
          {
            this.radius2 = ((float)(this.radius2 - 0.05D));
            this.height2 += 0.1D;
          }
          else
          {
            this.radius2 = 2.0F;
            this.height2 = 0.0D;
          }
        }
      }, 20L, 1L).getTaskId();
      this.animatedHelixID2.put(p, Integer.valueOf(continue2));
    }
  }
  
  public void rorationOtherType(final Player p, final ParticleType ptype)
  {
    if (!this.intIDspheric.containsKey(p))  {
      int rt = Bukkit.getServer().getScheduler().runTaskTimer(this.plugin, new Runnable()
      {
        float j = 0.0F;
    	
        public void run()
        {

            Location loc = p.getLocation();
            loc.setY(loc.getY() + 1.9D + 0.03D);
            for (int k = 0; k < 1.0F; k++)
            {
              loc.add(Math.cos(this.j) * 0.6000000238418579D, this.j * 0.01F, Math.sin(this.j) * 
                0.6000000238418579D);
            
              
              new UtilParticle(ptype, 0.0D, 1, 1.0E-4D).sendToLocation(loc);
            }
        
          this.j += 0.2F;
          if (this.j > 50.0F) {
            this.j = 0.0F;
          }
        }
      }, 1L, 1L).getTaskId();
      this.otherroration.put(p, Integer.valueOf(rt));
    }
  }
  
  
  public boolean hasEffect(Player p)
  {
    if (this.intID.containsKey(p))
    {
      p.sendMessage(plugin.getMensagensConfig().getString("Particula-Ja-Ativada").replaceAll("&", "§"));
      return true;
    }
    if (this.intIDspheric.containsKey(p))
    {
     p.sendMessage(plugin.getMensagensConfig().getString("Particula-Ja-Ativada").replaceAll("&", "§"));
      return true;
    }
    if (this.radar.containsKey(p))
    {
      p.sendMessage(plugin.getMensagensConfig().getString("Particula-Ja-Ativada").replaceAll("&", "§"));
      return true;
    }
    return false;
  }
  
  public void stopRotation(Player p)
  {
    if (this.intID.containsKey(p))
    {
      Bukkit.getServer().getScheduler().cancelTask(((Integer)this.intID.get(p)).intValue());
      p.sendMessage(plugin.getMensagensConfig().getString("Particula-Ja-Ativada").replaceAll("&", "§"));
      this.intID.remove(p);
    }
    if (this.intIDspheric.containsKey(p))
    {
      Bukkit.getServer().getScheduler().cancelTask(((Integer)this.intIDspheric.get(p)).intValue());
      p.sendMessage(plugin.getMensagensConfig().getString("Particula-Desativadas").replaceAll("&", "§"));
      this.intIDspheric.remove(p);
    }
    if (this.radar.containsKey(p))
    {
      Bukkit.getServer().getScheduler().cancelTask(((Integer)this.radar.get(p)).intValue());
      p.sendMessage(plugin.getMensagensConfig().getString("Particula-Desativadas").replaceAll("&", "§"));
      this.radar.remove(p);
    }
    if (this.Helix.containsKey(p))
    {
      Bukkit.getServer().getScheduler().cancelTask(((Integer)this.Helix.get(p)).intValue());
      p.sendMessage(plugin.getMensagensConfig().getString("Particula-Desativadas").replaceAll("&", "§"));
      this.Helix.remove(p);
    }
    if (this.animatedHelixID.containsKey(p))
    {
      Bukkit.getServer().getScheduler().cancelTask(((Integer)this.animatedHelixID.get(p)).intValue());
      p.sendMessage(plugin.getMensagensConfig().getString("Particula-Desativadas").replaceAll("&", "§"));
      this.animatedHelixID.remove(p);
      this.animatedHelixID2.remove(p);
    }
    if(this.otherroration.containsKey(p)) {
        Bukkit.getServer().getScheduler().cancelTask(((Integer)this.otherroration.get(p)).intValue());
        p.sendMessage(plugin.getMensagensConfig().getString("Particula-Desativadas").replaceAll("&", "§"));
        this.otherroration.remove(p);
    }
  }
}
