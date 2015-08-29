package Hats;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum HatTipos {
	
  OBISIDIAN(Material.OBSIDIAN),  
  WOOL(Material.WOOL),  
  REDSTONE_BLOCK(Material.REDSTONE_BLOCK),  
  LAPIS_BLOCK(Material.LAPIS_BLOCK),  
  DIAMOND_BLOCK(Material.DIAMOND_BLOCK),  
  IRON_BLOCK(Material.IRON_BLOCK),  
  GOLD_BLOCK(Material.GOLD_BLOCK),  
  LOG(Material.LOG),  
  NETHER_BRICK(Material.NETHER_BRICK),  
  BEACON(Material.BEACON),  
  CACTUS(Material.CACTUS),  
  COAL_BLOCK(Material.COAL_BLOCK),  
  CLAY(Material.CLAY),  
  DISPENSER(Material.DISPENSER),  
  CHEST(Material.CHEST),  
  ENDERCHEST(Material.ENDER_CHEST),  
  GRASS(Material.GRASS),  
  GLASS(Material.GLASS),
  WORKBENCH(Material.WORKBENCH), 
  FURNACE(Material.FURNACE),  
  TNT(Material.TNT), 
  ENDER_STONE(Material.ENDER_STONE), 
  EMERALD_BLOCK(Material.EMERALD_BLOCK),
  PUPKIN(Material.JACK_O_LANTERN),  
  HOPPER(Material.HOPPER),  
  ICE(Material.ICE),
  TRAP(Material.TRAP_DOOR);
  
  private Material material;
  
  private HatTipos(Material paramMaterial){
    material = paramMaterial;
  }
  
  public ItemStack getItemStack()
  {
    return new ItemStack(this.material);
  }
  
  public Material getMaterial()
  {
    return this.material;
  }
  
  public String getName()
  {
    return this.material.toString().toLowerCase().replace("_", " ");
  }
}

