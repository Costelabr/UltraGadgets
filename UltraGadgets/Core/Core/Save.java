package Core;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import Core.UtilParticle.ParticleType;

import com.floodeer.gadgets.Main;

public class Save
{
  private Location location;
  private Material type;
  private byte data;
  Main plugin = Main.getMain();
  
  @SuppressWarnings("deprecation")
public Save(Block paramBlock)
  {
	plugin.getUtilBlock().blockToRestore.add(paramBlock);
    this.location = paramBlock.getLocation();
    this.type = paramBlock.getType();
    this.data = paramBlock.getData();
  }
  
  @SuppressWarnings("deprecation")
public void restore()
  {
    Block localBlock = this.location.getBlock();
    new UtilParticle(ParticleType.SMOKE_NORMAL, 0.10000000149011612D, 2, 0.3D).sendToLocation(this.location);
    plugin.getUtilBlock().blockToRestore.remove(localBlock);
    localBlock.setType(this.type);
    localBlock.setData(this.data);
  }
}
