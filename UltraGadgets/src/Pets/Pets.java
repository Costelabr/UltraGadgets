package Pets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.metadata.FixedMetadataValue;

import vR3.UtilPet_vR3;
import Utils.ParticleEffect;
import Utils.UtilParticle;
import Utils.UtilParticle.ParticleType;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class Pets
  implements Listener
{
  public static enum PetsType
  {
    COELHO,  GALINHA,  VACA, WOLF, PORCO, SLIME, SHEEP, NENHUM;
    
    protected static final UltraGadgets plugin = UltraGadgets.getMain();
    public static HashMap<UUID, Entity> pet = new HashMap<>();
    public static final Map<UUID, PetsType> booleanPet = new HashMap<>();
    public static final Map<UUID, Rabbit> booleanRabbit = new HashMap<>();
    public static final Map<UUID, Sheep> booleanSheep = new HashMap<>();
    public static final Map<UUID, Entity> booleanWolf = new HashMap<>();
    public static final Map<UUID, Slime > booleanSlime = new HashMap<>();
    public static final List<UUID> notCancel = new ArrayList<UUID>();
    
	
	private static void summonLove(final Location l) {
        double phi = 0;
        phi = Math.PI/8;                                 
        double x, y, z;    
		 for (double t = 0; t <= 2*Math.PI; t = t + Math.PI/16){
	          for (double i = 0; i <= 1; i = i + 1){
	           x = 0.4*(2*Math.PI-t)*0.5*Math.cos(t + phi + i*Math.PI);
	           y = 0.5*t;
	           z = 0.4*(2*Math.PI-t)*0.5*Math.sin(t + phi + i*Math.PI);
	           l.add(x, y, z);
	           new UtilParticle(ParticleType.HEART, 0.0D, 1, 1.0E-4D).sendToLocation(l);
	           l.subtract(x,y,z);
	          }
		 }
	}
	
    public static void setPet(Player uniquePlayer, PetsType pettype)
    {
      UUID uniqueID = uniquePlayer.getUniqueId();
  	  CraftWorld world = ((CraftWorld)uniquePlayer.getWorld());
      switch (pettype) {
     
      case GALINHA: 
        Chicken paramUniqueChiken = world.spawn(uniquePlayer.getLocation(), Chicken.class, CreatureSpawnEvent.SpawnReason.CUSTOM);
        notCancel.add(paramUniqueChiken.getUniqueId());
        paramUniqueChiken.setMetadata("ugPets", new FixedMetadataValue(plugin, "petFixed1"));
        paramUniqueChiken.setCustomNameVisible(true);
        booleanPet.put(uniqueID, GALINHA);
        pet.put(uniqueID, paramUniqueChiken);
        paramUniqueChiken.setCustomName(plugin.getMessagesFile().petNome.replaceAll("&", "§").replaceAll("<PLAYER>", uniquePlayer.getName())
          .replaceAll("<PET>", ((Entity)pet.get(uniqueID)).getName()));
        UtilPet_vR3.criarPet(paramUniqueChiken, uniqueID);
        summonLove(paramUniqueChiken.getLocation());
        break;
      case VACA: 
        Cow paramUniqueCow = world.spawn(uniquePlayer.getLocation(), Cow.class, CreatureSpawnEvent.SpawnReason.CUSTOM);
        paramUniqueCow.setCustomNameVisible(true);
        UtilPet_vR3.criarPet(paramUniqueCow, uniqueID);
        pet.put(uniqueID, paramUniqueCow);
        booleanPet.put(uniqueID, VACA);
        paramUniqueCow.setCustomName(plugin.getMessagesFile().petNome.replaceAll("&", "§").replaceAll("<PLAYER>", uniquePlayer.getName())
          .replaceAll("<PET>", ((Entity)pet.get(uniqueID)).getName()));
        paramUniqueCow.setMetadata("ugPets", new FixedMetadataValue(plugin, "petFixed2"));
        ParticleEffect.HEART.display(1.0F, 0.0F, 0.0F, 3.0F, 20, paramUniqueCow.getLocation(), 12.0D);
        break;
      case COELHO: 
        Rabbit paramUniqueRabit = world.spawn(uniquePlayer.getLocation(), Rabbit.class, CreatureSpawnEvent.SpawnReason.CUSTOM);
        paramUniqueRabit.setCustomNameVisible(true);
        UtilPet_vR3.criarPet(paramUniqueRabit, uniqueID);
        booleanPet.put(uniqueID, COELHO);
        pet.put(uniqueID, paramUniqueRabit);
        paramUniqueRabit.setCustomName(plugin.getMessagesFile().petNome.replaceAll("&", "§").replaceAll("<PLAYER>", uniquePlayer.getName()).replaceAll("<PET>", ((Entity)pet.get(uniqueID)).getName()));
        paramUniqueRabit.setMetadata("ugPets", new FixedMetadataValue(plugin, "petFixed3"));
        paramUniqueRabit.setRabbitType(Rabbit.Type.WHITE);
        booleanRabbit.put(uniqueID, paramUniqueRabit);
        summonLove(paramUniqueRabit.getLocation());
        break;
        
      case WOLF:
    	  Wolf paramUniqueWolf = world.spawn(uniquePlayer.getLocation(), Wolf.class, CreatureSpawnEvent.SpawnReason.CUSTOM);
    	  paramUniqueWolf.setCustomNameVisible(true);
    	  UtilPet_vR3.criarPet(paramUniqueWolf, uniqueID);
    	  paramUniqueWolf.setOwner(uniquePlayer);
    	  paramUniqueWolf.setAngry(true);
    	  paramUniqueWolf.setAdult();
    	  pet.put(uniqueID, paramUniqueWolf);
    	  booleanPet.put(uniqueID, WOLF);
    	  paramUniqueWolf.setCustomName(plugin.getMessagesFile().petNome.replaceAll("&", "§").replaceAll("<PLAYER>", uniquePlayer.getName()).replaceAll("<PET>", ((Entity)pet.get(uniqueID)).getName()));
    	  paramUniqueWolf.setMetadata("ugPets", new FixedMetadataValue(plugin, "petFixed4"));
    	  summonLove(paramUniqueWolf.getLocation());
          break;
          
      case PORCO:
    	  Pig paramUniquePig = world.spawn(uniquePlayer.getLocation(), Pig.class, CreatureSpawnEvent.SpawnReason.CUSTOM);
    	  paramUniquePig.setCustomNameVisible(true);
    	  paramUniquePig.setMetadata("ugPets", new FixedMetadataValue(plugin, "petFixed5"));
    	  paramUniquePig.setAdult();
    	  pet.put(uniqueID, paramUniquePig);
    	  booleanPet.put(uniqueID, PORCO);
    	  UtilPet_vR3.criarPet(paramUniquePig, uniqueID);
    	  paramUniquePig.setCustomName(plugin.getMessagesFile().petNome.replaceAll("&", "§").replaceAll("<PLAYER>", uniquePlayer.getName()).replaceAll("<PET>", ((Entity)pet.get(uniqueID)).getName()));
    	  summonLove(paramUniquePig.getLocation());
    	  
        break;
        
      case SLIME:
    	  Slime paramUniqueSlime = world.spawn(uniquePlayer.getLocation(), Slime.class, CreatureSpawnEvent.SpawnReason.CUSTOM);
    	  paramUniqueSlime.setCustomNameVisible(true);
    	  paramUniqueSlime.setMetadata("ugPets", new FixedMetadataValue(plugin, "petFixed6"));
    	  pet.put(uniqueID, paramUniqueSlime);
    	  booleanPet.put(uniqueID, SLIME);
    	  paramUniqueSlime.setSize(2);
    	  booleanSlime.put(uniqueID, paramUniqueSlime);
    	  UtilPet_vR3.criarPet(paramUniqueSlime, uniqueID);
    	  paramUniqueSlime.setCustomName(plugin.getMessagesFile().petNome.replaceAll("&", "§").replaceAll("<PLAYER>", uniquePlayer.getName()).replaceAll("<PET>", ((Entity)pet.get(uniqueID)).getName()));
    	  summonLove(paramUniqueSlime.getLocation());
    	  
        break;
      case NENHUM:
    	  booleanPet.remove(uniqueID);
    	  break;
    	  
      case SHEEP:
    	  Sheep paramUniqueSheep = world.spawn(uniquePlayer.getLocation(), Sheep.class, CreatureSpawnEvent.SpawnReason.CUSTOM);
    	  paramUniqueSheep.setCustomNameVisible(true);
    	  paramUniqueSheep.setMetadata("ugPets", new FixedMetadataValue(plugin, "petFixed6"));
    	  pet.put(uniqueID, paramUniqueSheep);
    	  booleanPet.put(uniqueID, SLIME);
    	  booleanSheep.put(uniqueID, paramUniqueSheep);
    	  UtilPet_vR3.criarPet(paramUniqueSheep, uniqueID);
    	  paramUniqueSheep.setCustomName(plugin.getMessagesFile().petNome.replaceAll("&", "§").replaceAll("<PLAYER>", uniquePlayer.getName()).replaceAll("<PET>", ((Entity)pet.get(uniqueID)).getName()));
    	  summonLove(paramUniqueSheep.getLocation());
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
    
    public static boolean isEntity(Player petOwner, EntityType entity)
    {
      if (pet.get(petOwner.getUniqueId()).getType() == entity) {
        return true;
      }
      return false;
    }
  }
  
  @EventHandler
  public void onPetDamage(EntityDamageEvent e)
  {
      if (e.getEntity().hasMetadata("ugPets")) {
        e.setCancelled(true);
      }
    }
  
  @EventHandler
  public void onPetTarget(EntityTargetLivingEntityEvent e) {
	  if(e.getEntity().hasMetadata("ugPets")) {
		  e.setCancelled(true);
	  }
  }
}