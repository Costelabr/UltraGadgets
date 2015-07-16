package Commands;

import com.floodeer.gadgets.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpenGadgets
  implements CommandExecutor
{
  Main plugin = Main.getMain();
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (!(sender instanceof Player)) {
      return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("gadgets")) {
      this.plugin.getMenuManager().gadgetMenu.showMenu(p);
    }
    return false;
  }
}
