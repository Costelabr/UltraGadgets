package Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import Update.SchedulerEvent;
import Update.SchedulerType;

public class LocalUpdate
  implements Listener
{
	  public static List<String> Moving = new ArrayList<>();
	  final HashMap<UUID, Location> lastBlockLocation = new HashMap<>();
	  
	  @EventHandler
	  public void ParticleAura(SchedulerEvent paramUpdateEvent)
	  {
	    if (paramUpdateEvent.getType() == SchedulerType.FASTEST) {
	      for (Player localPlayer : Bukkit.getOnlinePlayers())
	      {
	        Location localLocation1 = localPlayer.getLocation();
	        Location localLocation2 = (Location)this.lastBlockLocation.get(localPlayer.getUniqueId());
	        if (this.lastBlockLocation.get(localPlayer.getUniqueId()) == null)
	        {
	          this.lastBlockLocation.put(localPlayer.getUniqueId(), localLocation1);
	          localLocation2 = (Location)this.lastBlockLocation.get(localPlayer.getUniqueId());
	        }
	        this.lastBlockLocation.put(localPlayer.getUniqueId(), localPlayer.getLocation());
	        if ((localLocation2.getX() != localLocation1.getX()) || (localLocation2.getY() != localLocation1.getY()) || (localLocation2.getZ() != localLocation1.getZ()))
	        {
	          if (!Moving.contains(localPlayer.getName())) {
	            Moving.add(localPlayer.getName());
	          }
	        }
	        else if (Moving.contains(localPlayer.getName())) {
	          Moving.remove(localPlayer.getName());
	        }
	      }
	    }
	  }
	  
	  public static boolean isMoving(Player paramPlayer)
	  {
	    if (Moving.contains(paramPlayer.getName())) {
	      return false;
	    }
	    return true;
	  }
}