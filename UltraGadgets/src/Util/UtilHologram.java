package Util;

import java.util.HashMap;

import net.minecraft.server.v1_8_R1.EntityArmorStand;
import net.minecraft.server.v1_8_R1.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R1.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.v1_8_R1.WorldServer;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class UtilHologram
{
  Location loc;
  HashMap<Integer, EntityArmorStand> a;
  
  public UtilHologram(Location loc, String[] list)
  {
    this.loc = loc;
    this.a = new HashMap<>();
    double high = loc.getY();
    String[] arrayOfString;
    int j = (arrayOfString = list).length;
    for (int i = 0; i < j; i++)
    {
      String s = arrayOfString[i];
      setupArmorStands(s, high);
      high -= 0.3D;
    }
  }
  
  public void destory(Player p)
  {
    for (EntityArmorStand sa : this.a.values())
    {
      PacketPlayOutEntityDestroy de = new PacketPlayOutEntityDestroy(new int[] {
        sa.getId() });
      ((CraftPlayer)p).getHandle().playerConnection.sendPacket(de);
    }
  }
  
  public void sendPlayer(Player p)
  {
    for (EntityArmorStand stand : this.a.values())
    {
      PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving(
        stand);
      ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
    }
  }
  
  public void setupArmorStands(String name, double high)
  {
    WorldServer s = ((CraftWorld)this.loc.getWorld()).getHandle();
    EntityArmorStand a = null;
    if (a == null) {
      a = new EntityArmorStand(s);
    }
    a.setLocation(this.loc.getX(), high, this.loc.getZ(), 0.0F, 0.0F);
    a.setCustomName(name);
    a.setGravity(true);
    a.setInvisible(true);
    a.setCustomNameVisible(true);
    a.setSmall(true);
    this.a.put(Integer.valueOf(a.getId()), a);
  }
}