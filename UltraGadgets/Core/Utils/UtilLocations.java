package Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Painting;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

public class UtilLocations
{
  public Entity[] getNearbyEntities(Location l, int radius)
  {
    int chunkRadius = radius < 16 ? 1 : (radius - radius % 16) / 16;
    HashSet<Entity> radiusEntities = new HashSet<>();
    for (int chX = 0 - chunkRadius; chX <= chunkRadius; chX++) {
      for (int chZ = 0 - chunkRadius; chZ <= chunkRadius; chZ++)
      {
        int x = (int)l.getX();int y = (int)l.getY();int z = (int)l.getZ();
        Entity[] arrayOfEntity;
        int j = (arrayOfEntity = new Location(l.getWorld(), x + chX * 16, y, z + chZ * 16).getChunk().getEntities()).length;
        for (int i = 0; i < j; i++)
        {
          Entity e = arrayOfEntity[i];
          if ((e.getLocation().distance(l) <= radius) && (e.getLocation().getBlock() != l.getBlock())) {
            radiusEntities.add(e);
          }
        }
      }
    }
    return (Entity[])radiusEntities.toArray(new Entity[radiusEntities.size()]);
  }
  
  public List<Location> getSphere(Location loc, int r, int h, boolean hollow, boolean sphere, int plus_y)
  {
    List<Location> circleblocks = new ArrayList<>();
    int cx = loc.getBlockX();
    int cy = loc.getBlockY();
    int cz = loc.getBlockZ();
    for (int x = cx - r; x <= cx + r; x++) {
      for (int z = cz - r; z <= cz + r; z++) {
        for (int y = sphere ? cy - r : cy; y < (sphere ? cy + r : cy + h); y++)
        {
          double dist = (cx - x) * (cx - x) + (cz - z) * (cz - z) + (sphere ? (cy - y) * (cy - y) : 0);
          if ((dist < r * r) && ((!hollow) || (dist >= (r - 1) * (r - 1))))
          {
            Location l = new Location(loc.getWorld(), x, y + plus_y, z);
            circleblocks.add(l);
          }
        }
      }
    }
    return circleblocks;
  }
  
  public Location getTargetBlock(Player paramPlayer, int paramInt)
  {
    Location localLocation = paramPlayer.getEyeLocation();
    Vector localVector = localLocation.getDirection().normalize();
    
    Block localBlock = null;
    for (int i = 0; i <= paramInt; i++)
    {
      localLocation.add(localVector);
      localBlock = localLocation.getBlock();
      if (localBlock.getType() != Material.AIR) {
        return localLocation;
      }
    }
    return localLocation;
  }
  
  public Player getTarget(Player player, int distanceX, int distanceY, int distanceZ, int finalDistance)
  {
    List<Entity> n = player.getNearbyEntities(distanceX, distanceY, distanceZ);
    ArrayList<Player> nearPlayers = new ArrayList<>();
    for (Entity e : n) {
      if ((e instanceof Player)) {
        nearPlayers.add((Player)e);
      }
    }
    Player target = null;
    BlockIterator bItr = new BlockIterator(player, finalDistance);
    while (bItr.hasNext())
    {
      Block block = bItr.next();
      int bx = block.getX();
      int by = block.getY();
      int bz = block.getZ();
      for (Player e : nearPlayers)
      {
        Location loc = e.getLocation();
        double ex = loc.getX();
        double ey = loc.getY();
        double ez = loc.getZ();
        if ((bx - 0.75D <= ex) && (ex <= bx + 1.75D) && (bz - 0.75D <= ez) && (ez <= bz + 1.75D) && (by - 1 <= ey) && (ey <= by + 2.5D))
        {
          target = e;
          break;
        }
      }
    }
    return target;
  }

  public List<Block> getBlocksInRadius(Location location, int radius, boolean hollow)
  {
    List<Block> blocks = new ArrayList<>();
    
    int bX = location.getBlockX();
    int bY = location.getBlockY();
    int bZ = location.getBlockZ();
    for (int x = bX - radius; x <= bX + radius; x++) {
      for (int y = bY - radius; y <= bY + radius; y++) {
        for (int z = bZ - radius; z <= bZ + radius; z++)
        {
          double distance = (bX - x) * (bX - x) + (bY - y) * (bY - y) + (bZ - z) * (bZ - z);
          if ((distance < radius * radius) && ((!hollow) || (distance >= (radius - 1) * (radius - 1))))
          {
            Location l = new Location(location.getWorld(), x, y, z);
            if (l.getBlock().getType() != org.bukkit.Material.BARRIER) {
              blocks.add(l.getBlock());
            }
          }
        }
      }
    }
    return blocks;
  }
  
  public List<Block> getNearbyBlocks(Location location, int radius) {
      List<Block> blocks = new ArrayList<Block>();
      for(int x = location.getBlockX() - radius; x <= location.getBlockX() + radius; x++) {
          for(int y = location.getBlockY() - radius; y <= location.getBlockY() + radius; y++) {
              for(int z = location.getBlockZ() - radius; z <= location.getBlockZ() + radius; z++) {
                 blocks.add(location.getWorld().getBlockAt(x, y, z));
              }
          }
      }
      return blocks;
  }
  
  
  public boolean checkEmptyArea(Location corner1, Location corner2)
  {
    if (corner1.getWorld() != corner2.getWorld()) {
      return false;
    }
    World world = corner1.getWorld();
    for (int x = corner1.getBlockX(); x <= corner2.getBlockX(); x++) {
      for (int y = corner1.getBlockY(); y <= corner2.getBlockY(); y++) {
        for (int z = corner1.getBlockZ(); z <= corner2.getBlockZ(); z++)
        {
          Location location = new Location(world, x, y, z);
          Block block = location.getBlock();
          if (block.getType() != Material.AIR) {
            return false;
          }
          Entity[] arrayOfEntity;
          int j = (arrayOfEntity = this.getNearbyEntities(location, 2)).length;
          for (int i = 0; i < j; i++)
          {
            Entity entity = arrayOfEntity[i];
            if (((entity instanceof ItemFrame)) || ((entity instanceof Painting))) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }
}