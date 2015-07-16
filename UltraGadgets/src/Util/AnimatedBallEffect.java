package Util;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.util.Vector;

import Gadgets.Dj;

import com.floodeer.gadgets.Main;

public class AnimatedBallEffect
{
  public static enum Direction
  {
    UP,  DOWN,  BOTH;
  }
  
  Main plugin = Main.getMain();
  public float sphereRadius = 0.6F;
  public int max = 15;
  public ParticleEffect sphereParticle = ParticleEffect.CLOUD;
  public ParticleEffect lineParticle = ParticleEffect.REDSTONE;
  public Color lineColor = null;
  public int maxLines = 7;
  public int lineParticles = 100;
  public int sphereParticles = 50;
  public Direction direction = Direction.DOWN;
  int taskA;
  
  public void startDisco(final Location location, int cancelTime)
  {
    this.taskA = Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
    {
      public void run()
      {
        int mL = UtilMath.random.nextInt(AnimatedBallEffect.this.maxLines - 2) + 2;
        for (int m = 0; m < mL * 2; m++)
        {
          double x = UtilMath.random.nextInt(AnimatedBallEffect.this.max - AnimatedBallEffect.this.max * -1) + AnimatedBallEffect.this.max * -1;
          double y = UtilMath.random.nextInt(AnimatedBallEffect.this.max - AnimatedBallEffect.this.max * -1) + AnimatedBallEffect.this.max * -1;
          double z = UtilMath.random.nextInt(AnimatedBallEffect.this.max - AnimatedBallEffect.this.max * -1) + AnimatedBallEffect.this.max * -1;
          if (AnimatedBallEffect.this.direction == AnimatedBallEffect.Direction.DOWN) {
            y = UtilMath.random.nextInt(AnimatedBallEffect.this.max * 2 - AnimatedBallEffect.this.max) + AnimatedBallEffect.this.max;
          } else if (AnimatedBallEffect.this.direction == AnimatedBallEffect.Direction.UP) {
            y = UtilMath.random.nextInt(AnimatedBallEffect.this.max * -1 - AnimatedBallEffect.this.max * -2) + AnimatedBallEffect.this.max * -2;
          }
          Location target = location.clone().subtract(x, y, z);
          if (target == null)
          {
            Bukkit.getScheduler().cancelTask(AnimatedBallEffect.this.taskA);
            return;
          }
          Vector link = target.toVector().subtract(location.toVector());
          float length = (float)link.length();
          link.normalize();
          
          float ratio = length / AnimatedBallEffect.this.lineParticles;
          Vector v = link.multiply(ratio);
          Location loc = location.clone().subtract(v);
          for (int i = 0; i < AnimatedBallEffect.this.lineParticles; i++)
          {
            loc.add(v);
            if (((Boolean)Dj.discoBall.get("DiscoBall")).booleanValue()) {
              ParticleEffect.REDSTONE.display(0.0F, 0.0F, 0.0F, 3.0F, 1, loc, 25.0D);
            }
          }
        }
        for (int i = 0; i < AnimatedBallEffect.this.sphereParticles; i++)
        {
          Vector vector = UtilMath.getRandomVector().multiply(AnimatedBallEffect.this.sphereRadius);
          location.add(vector);
          if (((Boolean)Dj.discoBall.get("DiscoBall")).booleanValue()) {
            ParticleEffect.DRIP_LAVA.display(0.0F, 0.0F, 0.0F, 3.0F, 1, location, 25.0D);
          }
          location.subtract(vector);
        }
      }
    }, 1L, 1L).getTaskId();
    Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable()
    {
      public void run()
      {
        Bukkit.getScheduler().cancelTask(AnimatedBallEffect.this.taskA);
      }
    }, cancelTime * 20L);
  }
}
