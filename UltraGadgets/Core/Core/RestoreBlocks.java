package Core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class RestoreBlocks
{
  public static HashMap<UUID, ArrayList<Save>> saves = new HashMap<>();
  
  public static void init(Player paramPlayer)
  {
    if (!saves.containsKey(paramPlayer.getUniqueId())) {
      saves.put(paramPlayer.getUniqueId(), new ArrayList<Save>());
    }
  }
  
  public static void save(Player paramPlayer, Location paramLocation)
  {
    init(paramPlayer);
    saves.get(paramPlayer.getUniqueId()).add(new Save(paramLocation.getBlock()));
  }
  
  public static void restore(Player paramPlayer)
  {
    Iterator<Save> localIterator = saves.get(paramPlayer.getUniqueId()).iterator();
    while (localIterator.hasNext())
    {
      Save localSave = (Save)localIterator.next();
      localSave.restore();
    }
    saves.get(paramPlayer.getUniqueId()).clear();
    saves.remove(paramPlayer.getUniqueId());
  }
}