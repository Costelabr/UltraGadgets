package Pets;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.metadata.FixedMetadataValue;

import Util.ParticleEffect;
import Util.UtilPet;

import com.floodeer.gadgets.Main;

public class Pets
  implements Listener
{
  public static enum PetsType
  {
    COELHO,  GALINHA,  VACA, NENHUM;
    
    protected static final Main plugin = Main.getMain();
    public static HashMap<UUID, Entity> pet = new HashMap<>();
    public static final Map<UUID, PetsType> booleanPet = new HashMap<>();
    public static final Map<UUID, Rabbit> booleanRabbit = new HashMap<>();
    
    public static void setPet(Player uniquePlayer, PetsType pettype)
    {
      UUID uniqueID = uniquePlayer.getUniqueId();
      switch (pettype)
      {
      case GALINHA: 
        Chicken paramUniqueChiken = (Chicken)uniquePlayer.getWorld().spawn(uniquePlayer.getLocation(), Chicken.class);
        paramUniqueChiken.setCustomNameVisible(true);
        booleanPet.put(uniqueID, GALINHA);
        pet.put(uniqueID, paramUniqueChiken);
        paramUniqueChiken.setCustomName(plugin.getMessagesFile().petNome.replaceAll("&", "§").replaceAll("<PLAYER>", uniquePlayer.getName())
          .replaceAll("<PET>", ((Entity)pet.get(uniqueID)).getName()));
        UtilPet.criarPet(paramUniqueChiken, uniqueID);
        ParticleEffect.HEART.display(1.0F, 0.0F, 0.0F, 3.0F, 20, paramUniqueChiken.getLocation(), 12.0D);
        paramUniqueChiken.setMetadata("petChicken", new FixedMetadataValue(plugin, "petFixed1"));
        break;
      case VACA: 
        Cow paramUniqueCow = (Cow)uniquePlayer.getWorld().spawn(uniquePlayer.getLocation(), Cow.class);
        paramUniqueCow.setCustomNameVisible(true);
        UtilPet.criarPet(paramUniqueCow, uniqueID);
        pet.put(uniqueID, paramUniqueCow);
        booleanPet.put(uniqueID, VACA);
        paramUniqueCow.setCustomName(plugin.getMessagesFile().petNome.replaceAll("&", "§").replaceAll("<PLAYER>", uniquePlayer.getName())
          .replaceAll("<PET>", ((Entity)pet.get(uniqueID)).getName()));
        paramUniqueCow.setMetadata("petCow", new FixedMetadataValue(plugin, "petFixed2"));
        ParticleEffect.HEART.display(1.0F, 0.0F, 0.0F, 3.0F, 20, paramUniqueCow.getLocation(), 12.0D);
        break;
      case COELHO: 
        Rabbit paramUniqueRabit = (Rabbit)uniquePlayer.getWorld().spawn(uniquePlayer.getLocation(), Rabbit.class);
        paramUniqueRabit.setCustomNameVisible(true);
        UtilPet.criarPet(paramUniqueRabit, uniqueID);
        booleanPet.put(uniqueID, VACA);
        pet.put(uniqueID, paramUniqueRabit);
        paramUniqueRabit.setCustomName(plugin.getMessagesFile().petNome.replaceAll("&", "§").replaceAll("<PLAYER>", uniquePlayer.getName()).replaceAll("<PET>", ((Entity)pet.get(uniqueID)).getName()));
        paramUniqueRabit.setMetadata("petRabbit", new FixedMetadataValue(plugin, "petFixed3"));
        paramUniqueRabit.setRabbitType(Rabbit.Type.WHITE);
        booleanRabbit.put(uniqueID, paramUniqueRabit);
        ParticleEffect.HEART.display(1.0F, 0.0F, 0.0F, 3.0F, 20, paramUniqueRabit.getLocation(), 12.0D);
        break;
        
      case NENHUM:
    	  break;
      }
    }
    
    public static boolean HasPet(Player paramPlayer)
    {
      if (booleanPet.containsKey(paramPlayer.getUniqueId())) {
        return true;
      }
      return false;
    }
    
    public static void removePet(Player paramPlayer)
    {
      if (HasPet(paramPlayer))
      {
        if (pet.get(paramPlayer.getUniqueId()) == null) {
          return;
        }
        ((Entity)pet.get(paramPlayer.getUniqueId())).remove();
        setPet(paramPlayer, NENHUM);
        pet.remove(paramPlayer.getUniqueId());
      }
    }
    
    public static boolean isEntity(Player petOwner, Entity entity)
    {
      if (pet.get(petOwner.getUniqueId()) == entity) {
        return true;
      }
      return false;
    }
  }
  
  @EventHandler
  public void onPetDamage(EntityDamageEvent e)
  {
    if ((e.getEntity() instanceof Chicken))
    {
      Chicken localChicken = (Chicken)e.getEntity();
      if (localChicken.hasMetadata("petChicken")) {
        e.setCancelled(true);
      }
    }
    if ((e.getEntity() instanceof Cow))
    {
      Cow localCow = (Cow)e.getEntity();
      if (localCow.hasMetadata("petCow")) {
        e.setCancelled(true);
      }
    }
    if ((e.getEntity() instanceof Rabbit))
    {
      Rabbit localRabbit = (Rabbit)e.getEntity();
      if (localRabbit.hasMetadata("petRabbit")) {
        e.setCancelled(true);
      }
    }
  }
}
