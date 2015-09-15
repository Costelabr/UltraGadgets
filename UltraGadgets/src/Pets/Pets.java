package Pets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.minecraft.server.v1_8_R3.GenericAttributes;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftVillager;
import org.bukkit.entity.*;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.FixedMetadataValue;

import vR3.UtilPet_vR3;
import Utils.UtilParticle;
import Utils.UtilParticle.ParticleType;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class Pets
  implements Listener
{
	
  public static enum PetsType
  {
    COELHO,  GALINHA,  VACA, WOLF, PORCO, ZOMBIE, SHEEP, CREEPER, VILLAGER, ENDERMAN, NENHUM;
    
    protected static final UltraGadgets plugin = UltraGadgets.getMain();
    public static HashMap<UUID, Entity> pet = new HashMap<>();
    public static final Map<UUID, PetsType> booleanPet = new HashMap<>();
    public static final Map<UUID, Rabbit> booleanRabbit = new HashMap<>();
    public static final Map<UUID, Sheep> booleanSheep = new HashMap<>();
    public static final Map<UUID, Entity> booleanWolf = new HashMap<>();
    public static final Map<UUID, Zombie> booleanZombie = new HashMap<>();
    public static final Map<UUID, Creeper> booleanCreeper = new HashMap<>();
    public static final Map<UUID, Creeper> creeperInfernal = new HashMap<>();
    public static final Map<UUID, Villager> villagerType = new HashMap<>();
    public static final Map<UUID, Enderman> endermanManager = new HashMap<>();
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
        paramUniqueChiken.setMetadata("ugPets", new FixedMetadataValue(plugin, null));
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
        paramUniqueCow.setMetadata("ugPets", new FixedMetadataValue(plugin, null));
        summonLove(paramUniqueCow.getLocation());
        break;
      case COELHO: 
        Rabbit paramUniqueRabit = world.spawn(uniquePlayer.getLocation(), Rabbit.class, CreatureSpawnEvent.SpawnReason.CUSTOM);
        paramUniqueRabit.setCustomNameVisible(true);
        UtilPet_vR3.criarPet(paramUniqueRabit, uniqueID);
        booleanPet.put(uniqueID, COELHO);
        pet.put(uniqueID, paramUniqueRabit);
        paramUniqueRabit.setCustomName(plugin.getMessagesFile().petNome.replaceAll("&", "§").replaceAll("<PLAYER>", uniquePlayer.getName()).replaceAll("<PET>", ((Entity)pet.get(uniqueID)).getName()));
        paramUniqueRabit.setMetadata("ugPets", new FixedMetadataValue(plugin, null));
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
    	  paramUniqueWolf.setMetadata("ugPets", new FixedMetadataValue(plugin, null));
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
        
      case ZOMBIE:
    	  Zombie paramUniqueZombie = world.spawn(uniquePlayer.getLocation(), Zombie.class, CreatureSpawnEvent.SpawnReason.CUSTOM);
    	  paramUniqueZombie.setCustomNameVisible(true);
    	  paramUniqueZombie.setMetadata("ugPets", new FixedMetadataValue(plugin, null));
    	  pet.put(uniqueID, paramUniqueZombie);
    	  booleanPet.put(uniqueID, ZOMBIE);
    	  UtilPet_vR3.criarPet(paramUniqueZombie, uniqueID);
    	  paramUniqueZombie.setCustomName(plugin.getMessagesFile().petNome.replaceAll("&", "§").replaceAll("<PLAYER>", uniquePlayer.getName()).replaceAll("<PET>", ((Entity)pet.get(uniqueID)).getName()));
    	  summonLove(paramUniqueZombie.getLocation());
    	  
        break;
      case NENHUM:
    	  booleanPet.remove(uniqueID);
    	  break;
    	  
      case SHEEP:
    	  Sheep paramUniqueSheep = world.spawn(uniquePlayer.getLocation(), Sheep.class, CreatureSpawnEvent.SpawnReason.CUSTOM);
    	  paramUniqueSheep.setCustomNameVisible(true);
    	  paramUniqueSheep.setMetadata("ugPets", new FixedMetadataValue(plugin, null));
    	  pet.put(uniqueID, paramUniqueSheep);
    	  booleanPet.put(uniqueID, SHEEP);
    	  booleanSheep.put(uniqueID, paramUniqueSheep);
    	  UtilPet_vR3.criarPet(paramUniqueSheep, uniqueID);
    	  paramUniqueSheep.setCustomName(plugin.getMessagesFile().petNome.replaceAll("&", "§").replaceAll("<PLAYER>", uniquePlayer.getName()).replaceAll("<PET>", ((Entity)pet.get(uniqueID)).getName()));
    	  summonLove(paramUniqueSheep.getLocation());
    	  break;
    	  
      case CREEPER:
    	  Creeper paramUniqueCreeper = world.spawn(uniquePlayer.getLocation(), Creeper.class, CreatureSpawnEvent.SpawnReason.CUSTOM);
    	  paramUniqueCreeper.setCustomNameVisible(true);
    	  paramUniqueCreeper.setMetadata("ugPets", new FixedMetadataValue(plugin, null));
    	  pet.put(uniqueID, paramUniqueCreeper);
    	  booleanPet.put(uniqueID, CREEPER);
    	  booleanCreeper.put(uniqueID, paramUniqueCreeper);
    	  UtilPet_vR3.criarPet(paramUniqueCreeper, uniqueID);
    	  paramUniqueCreeper.setCustomName(plugin.getMessagesFile().petNome.replaceAll("&", "§").replaceAll("<PLAYER>", uniquePlayer.getName()).replaceAll("<PET>", ((Entity)pet.get(uniqueID)).getName()));
    	  summonLove(paramUniqueCreeper.getLocation());
    	  break;
    	  
      case VILLAGER:
    	  Villager paramUniqueVillager = world.spawn(uniquePlayer.getLocation(), Villager.class, CreatureSpawnEvent.SpawnReason.CUSTOM);
    	  paramUniqueVillager.setCustomNameVisible(true);
    	  paramUniqueVillager.setProfession(Profession.PRIEST);
    	  paramUniqueVillager.setMetadata("ugPets", new FixedMetadataValue(plugin, null));
    	  pet.put(uniqueID, paramUniqueVillager);
    	  booleanPet.put(uniqueID, VILLAGER);
    	  villagerType.put(uniqueID, paramUniqueVillager);
    	  UtilPet_vR3.criarPet(paramUniqueVillager, uniqueID);
    	  ((CraftVillager)paramUniqueVillager).getHandle().getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.4);
    	  paramUniqueVillager.setCustomName(plugin.getMessagesFile().petNome.replaceAll("&", "§").replaceAll("<PLAYER>", uniquePlayer.getName()).replaceAll("<PET>", ((Entity)pet.get(uniqueID)).getName()));
    	  summonLove(paramUniqueVillager.getLocation());
    	  break;
    	  
    case ENDERMAN:
  	  Enderman paramUniqueEnderman = world.spawn(uniquePlayer.getLocation(), Enderman.class, CreatureSpawnEvent.SpawnReason.CUSTOM);
  	  paramUniqueEnderman.setCustomNameVisible(true);
  	  paramUniqueEnderman.setMetadata("ugPets", new FixedMetadataValue(plugin, null));
  	  pet.put(uniqueID, paramUniqueEnderman);
  	  booleanPet.put(uniqueID, ENDERMAN);
  	  endermanManager.put(uniqueID, paramUniqueEnderman);
  	  UtilPet_vR3.criarPet(paramUniqueEnderman, uniqueID);
  	  MaterialData md = new MaterialData(Material.DIAMOND_ORE);
  	  paramUniqueEnderman.setCarriedMaterial(md);
  	  paramUniqueEnderman.setCustomName(plugin.getMessagesFile().petNome.replaceAll("&", "§").replaceAll("<PLAYER>", uniquePlayer.getName()).replaceAll("<PET>", ((Entity)pet.get(uniqueID)).getName()));
  	  summonLove(paramUniqueEnderman.getLocation());
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
  public void onOpenVillager(PlayerInteractEntityEvent e) {
	  if(e.getRightClicked() instanceof Villager) {
		  Villager v = (Villager)e.getRightClicked();
		  if(v.hasMetadata("ugPets")) {
			  e.setCancelled(true);
		  }
	  }
  }
  
  @EventHandler
  public void endermanTeleport(EntityTeleportEvent e) {
	  if(e.getEntity() instanceof Enderman) {
		if(e.getEntity().hasMetadata("ugPets")) {
		e.setCancelled(true);  
		}
	  }
  }
}