package vR3;

import java.lang.reflect.Field;
import java.util.UUID;

import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.PathfinderGoalFloat;
import net.minecraft.server.v1_8_R3.PathfinderGoalSelector;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R3.util.UnsafeList;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import Pets.Pets.PetsType;
import Update.SchedulerEvent;
import Update.SchedulerType;

public class UtilPet_vR3 implements Listener {
	
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
	    catch (Exception localException)
	    {
	      localException.printStackTrace();
	    }
	  }
	  
	  @EventHandler
	  public void petsUpdate(SchedulerEvent paramUpdateEvent)
	  {
	    if (paramUpdateEvent.getType() == SchedulerType.TICK) {
	      for (UUID localUUID : PetsType.pet.keySet()) {
	        if (((Entity) PetsType.pet.get(localUUID)).isValid()) {
	          UtilEnt_vR3.CreatureMove((Entity)PetsType.pet.get(localUUID), Bukkit.getPlayer(localUUID).getLocation().add(2.0D, 0.0D, 1.0D), 1.2F);
	        } else {
	       PetsType.pet.remove(localUUID);
	        }
	      }
	    }
	  }
	  
	@SuppressWarnings("deprecation")
	public static void criarPet(LivingEntity paramLivingEntity, UUID paramUUID)
	  {
		PetsType.pet.put(paramUUID, paramLivingEntity);
	    try
	    {
	      EntityLiving localEntityLiving = ((CraftLivingEntity)paramLivingEntity).getHandle();
	      if ((localEntityLiving instanceof EntityInsentient))
	      {
	        PathfinderGoalSelector localPathfinderGoalSelector1 = (PathfinderGoalSelector)goalSelector.get(localEntityLiving);
	        PathfinderGoalSelector localPathfinderGoalSelector2 = (PathfinderGoalSelector)targetSelector.get(localEntityLiving);
	        
	        gsa.set(localPathfinderGoalSelector1, new UnsafeList<>());
	        gsa.set(localPathfinderGoalSelector2, new UnsafeList<>());
	        
	        localPathfinderGoalSelector1.a(0, new PathfinderGoalFloat((EntityInsentient)localEntityLiving));
	      }
	      else
	      {
	        throw new IllegalArgumentException(paramLivingEntity.getType().getName() + " não parece fazer parte de EntityInsentient.");
	      }
	    }
	    catch (Exception localException)
	    {
	      localException.printStackTrace();
	    }
	  }
	}