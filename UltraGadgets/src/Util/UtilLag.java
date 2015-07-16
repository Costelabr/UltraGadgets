package Util;

import java.util.HashSet;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class UtilLag
{
  long _lastRun = -1L;
  int _count;
  static double _ticksPerSecond;
  double _ticksPerSecondAverage;
  long _lastAverage;
  HashSet<Player> _monitoring = new HashSet<>();
  
  public UtilLag(JavaPlugin paramJavaPlugin)
  {
    this._lastRun = System.currentTimeMillis();
    this._lastAverage = System.currentTimeMillis();
  }
  
  public static double getTicksPerSecond()
  {
    return _ticksPerSecond;
  }
  
  public static double getTPS()
  {
    return _ticksPerSecond;
  }
  
  public static boolean ServerisLag()
  {
    if (getTicksPerSecond() <= 18.0D)
    {
      System.out.print("[UltraGadgets] - Forçando a parar efeitos. (TPS RUIM)");
      return true;
    }
    return false;
  }
}