package Util;

import Exception.BlockReRollException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.scheduler.BukkitRunnable;

public class RollBlocks
  extends BukkitRunnable
{
  public static HashMap<Location, Material> blocks = new HashMap<>();
  private static HashMap<Location, Byte> data = new HashMap<>();
  public static HashMap<Location, Integer> counters = new HashMap<>();
  private static Random random = new Random();
  private static List<Material> unpaintable = new ArrayList<>();
  
  public void loadupUnPaintableList()
  {
    try
    {
      unpaintable.add(Material.SIGN);
      unpaintable.add(Material.SIGN_POST);
      unpaintable.add(Material.WALL_SIGN);
      unpaintable.add(Material.SKULL);
      unpaintable.add(Material.SKULL_ITEM);
      unpaintable.add(Material.LAVA);
      unpaintable.add(Material.LADDER);
      unpaintable.add(Material.WATER);
      unpaintable.add(Material.CACTUS);
      unpaintable.add(Material.CHEST);
      unpaintable.add(Material.FURNACE);
      unpaintable.add(Material.WOOD_DOOR);
      unpaintable.add(Material.IRON_DOOR);
      unpaintable.add(Material.TRAP_DOOR);
      unpaintable.add(Material.IRON_TRAPDOOR);
      unpaintable.add(Material.CHEST);
      unpaintable.add(Material.POTATO);
      unpaintable.add(Material.CARROT);
      unpaintable.add(Material.DEAD_BUSH);
      unpaintable.add(Material.TORCH);
      unpaintable.add(Material.JUKEBOX);
      unpaintable.add(Material.PISTON_BASE);
      unpaintable.add(Material.ENDER_PORTAL_FRAME);
      unpaintable.add(Material.OBSIDIAN);
      unpaintable.add(Material.LADDER);
      unpaintable.add(Material.WORKBENCH);
      unpaintable.add(Material.BANNER);
      unpaintable.add(Material.ANVIL);
      unpaintable.add(Material.FURNACE);
      unpaintable.add(Material.FENCE_GATE);
      unpaintable.add(Material.FENCE);
      unpaintable.add(Material.WOOD_DOOR);
      unpaintable.add(Material.TRAP_DOOR);
      unpaintable.add(Material.TRAPPED_CHEST);
      unpaintable.add(Material.ENCHANTMENT_TABLE);
      unpaintable.add(Material.ENCHANTED_BOOK);
      unpaintable.add(Material.BEACON);
      unpaintable.add(Material.LADDER);
      unpaintable.add(Material.MINECART);
      unpaintable.add(Material.WEB);
      unpaintable.add(Material.REDSTONE_WIRE);
      unpaintable.add(Material.REDSTONE_TORCH_OFF);
      unpaintable.add(Material.REDSTONE_TORCH_ON);
      unpaintable.add(Material.NOTE_BLOCK);
    }
    catch (Exception ex)
    {
      throw new BlockReRollException("[RollBlocks]: Foi interrompido devido á alguma incompatibilidade.");
    }
  }
  
  public void run()
  {
    List<Location> list = new ArrayList<>();
    for (Location location : blocks.keySet())
    {
      counters.put(location, Integer.valueOf(((Integer)counters.get(location)).intValue() + 1));
      if (((Integer)counters.get(location)).intValue() >= 120)
      {
        list.add(location);
        unPaintBlock(location);
        return;
      }
    }
  }
  
  @SuppressWarnings("deprecation")
public void paintBlock(Location location)
  {
    if (unpaintable.contains(location.getBlock().getType())) {
      return;
    }
    if (blocks.containsKey(location)) {
      return;
    }
    blocks.put(location, location.getBlock().getType());
    data.put(location, Byte.valueOf(location.getBlock().getData()));
    counters.put(location, Integer.valueOf(0));
    location.getBlock().setType(Material.STAINED_CLAY);
    
    location.getBlock().setData((byte)random.nextInt(15));
  }
  
  @SuppressWarnings("deprecation")
public void unPaintBlock(Location location)
  {
    location.getBlock().setType((Material)blocks.get(location));
    location.getBlock().setData(((Byte)data.get(location)).byteValue());
    blocks.remove(location);
    data.remove(location);
  }
  
  public HashMap<Location, Material> getBlocks()
  {
    return blocks;
  }
}