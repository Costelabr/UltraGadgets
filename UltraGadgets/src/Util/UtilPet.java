package Util;

import java.lang.reflect.Field;
import java.util.UUID;

import net.minecraft.server.v1_8_R1.EntityInsentient;
import net.minecraft.server.v1_8_R1.PathEntity;
import net.minecraft.server.v1_8_R1.PathfinderGoal;
import net.minecraft.server.v1_8_R1.PathfinderGoalFloat;
import net.minecraft.server.v1_8_R1.PathfinderGoalSelector;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R1.util.UnsafeList;
import org.bukkit.entity.LivingEntity;

public class UtilPet
{
  private static Field gsa;
  private static Field goalSelector;
  private static Field targetSelector;
  
  static
  {
    try
    {
      gsa = PathfinderGoalSelector.class.getDeclaredField("b");
      gsa.setAccessible(true);
      goalSelector = EntityInsentient.class.getDeclaredField("goalSelector");
      goalSelector.setAccessible(true);
      targetSelector = EntityInsentient.class.getDeclaredField("targetSelector");
      targetSelector.setAccessible(true);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  @SuppressWarnings({ "rawtypes", "deprecation" })
public static void criarPet(LivingEntity e, UUID toFollow)
  {
    try
    {
      Object nms_entity = ((CraftLivingEntity)e).getHandle();
      if ((nms_entity instanceof EntityInsentient))
      {
        PathfinderGoalSelector goal = (PathfinderGoalSelector)goalSelector.get(nms_entity);
        PathfinderGoalSelector target = (PathfinderGoalSelector)targetSelector.get(nms_entity);
        gsa.set(goal, new UnsafeList());
        gsa.set(target, new UnsafeList());
        goal.a(0, new PathfinderGoalFloat((EntityInsentient)nms_entity));
        goal.a(1, new PathfinderGoalWalktoTile((EntityInsentient)nms_entity, toFollow));
      }
      else
      {
        throw new IllegalArgumentException(e.getType().getName() + " is not an instance of an EntityInsentient.");
      }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }
  
  public static class PathfinderGoalWalktoTile
    extends PathfinderGoal
  {
    private EntityInsentient entity;
    private PathEntity path;
    private UUID p;
    
    public PathfinderGoalWalktoTile(EntityInsentient entitycreature, UUID p)
    {
      this.entity = entitycreature;
      this.p = p;
    }
    
    public boolean a()
    {
      if (Bukkit.getPlayer(this.p) == null) {
        return this.path != null;
      }
      Location targetLocation = Bukkit.getPlayer(this.p).getLocation();
      this.entity.getNavigation().m();
      this.entity.getNavigation();
      this.path = this.entity.getNavigation().a(targetLocation.getX() + 1.0D, targetLocation.getY(), targetLocation.getZ() + 1.0D);
      this.entity.getNavigation();
      if (this.path != null) {
        c();
      }
      return this.path != null;
    }
    
    public void c()
    {
      this.entity.getNavigation().a(this.path, 1.0D);
    }
  }
}
