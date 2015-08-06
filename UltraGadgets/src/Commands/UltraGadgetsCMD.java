package Commands;

import Core.UtilJsonBuilder;
import Core.UtilJsonBuilder.ClickAction;
import Core.UtilJsonBuilder.HoverAction;
import EventManager.PluginListener;

import com.floodeer.gadgets.UltraGadgets;

import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class UltraGadgetsCMD
  implements CommandExecutor
{
  UltraGadgets plugin = UltraGadgets.getMain();
  private String prefix = plugin.getMessagesFile().prefix + " ";
  
  private void sendHelp(Player paramToPlayer) {
	  UtilJsonBuilder gadgets = new UtilJsonBuilder("§6/ug gadgets §7- Menu de Gadgets").withClickEvent(ClickAction.SUGGEST_COMMAND, "/ug gadgets").withHoverEvent(HoverAction.SHOW_TEXT, "§6§lClique para preparar o comando!");
	  UtilJsonBuilder pets = new UtilJsonBuilder("§6/ug pets §7- Menu de Pets").withClickEvent(ClickAction.SUGGEST_COMMAND, "/ug pets").withHoverEvent(HoverAction.SHOW_TEXT, "§6§lClique para preparar o comando!");
	  UtilJsonBuilder particulas = new UtilJsonBuilder("§6/ug particulas §7- Menu de Partículas").withClickEvent(ClickAction.SUGGEST_COMMAND, "/ug particulas").withHoverEvent(HoverAction.SHOW_TEXT, "§6§lClique para preparar o comando!");
	  UtilJsonBuilder sparticulas = new UtilJsonBuilder("§6/ug sparticulas §7- Menu de Super Partículas").withClickEvent(ClickAction.SUGGEST_COMMAND, "/ug sparticulas").withHoverEvent(HoverAction.SHOW_TEXT, "§6§lClique para preparar o comando!");
	  UtilJsonBuilder fantasias = new UtilJsonBuilder("§6/ug fantasias §7- Menu de Fantasias").withClickEvent(ClickAction.SUGGEST_COMMAND, "/ug fantasias").withHoverEvent(HoverAction.SHOW_TEXT, "§6§lClique para preparar o comando!");
	  UtilJsonBuilder mount = new UtilJsonBuilder("§6/ug mounts §7- Menu de Montarias").withClickEvent(ClickAction.SUGGEST_COMMAND, "/ug mount").withHoverEvent(HoverAction.SHOW_TEXT, "§6§lClique para preparar o comando!");
	  UtilJsonBuilder recarregar = new UtilJsonBuilder("§6/ug recarregar §7- Recarregar o plugin (Não muda configurações)").withClickEvent(ClickAction.SUGGEST_COMMAND, "/ug recarregar").withHoverEvent(HoverAction.SHOW_TEXT, "§6§lClique para preparar o comando!");
	  UtilJsonBuilder lag = new UtilJsonBuilder("§6/ug lag §7- Manager de lag do plugin (Não interfere outras tarefas)").withClickEvent(ClickAction.SUGGEST_COMMAND, "/ug lag").withHoverEvent(HoverAction.SHOW_TEXT, "§6§lClique para preparar o comando!");
	  CraftPlayer player = ((CraftPlayer)paramToPlayer);
	  player.getHandle().playerConnection.sendPacket(new PacketPlayOutChat(ChatSerializer.a(gadgets.toString())));
	  player.getHandle().playerConnection.sendPacket(new PacketPlayOutChat(ChatSerializer.a(pets.toString())));
	  player.getHandle().playerConnection.sendPacket(new PacketPlayOutChat(ChatSerializer.a(particulas.toString())));
	  player.getHandle().playerConnection.sendPacket(new PacketPlayOutChat(ChatSerializer.a(sparticulas.toString())));
	  player.getHandle().playerConnection.sendPacket(new PacketPlayOutChat(ChatSerializer.a(fantasias.toString())));
	  player.getHandle().playerConnection.sendPacket(new PacketPlayOutChat(ChatSerializer.a(mount.toString())));
	  player.getHandle().playerConnection.sendPacket(new PacketPlayOutChat(ChatSerializer.a(recarregar.toString())));
	  player.getHandle().playerConnection.sendPacket(new PacketPlayOutChat(ChatSerializer.a(lag.toString())));
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (!(sender instanceof Player)) {
      return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("ultragadgets") || cmd.getName().equals("ug")) {
    	if(!p.hasPermission("ugadgets.comando")) {
    		p.sendMessage(prefix + "§cVocê não tem permissão para acessar os comandos desse plugin.");
    		return true;
    	}
    	
      if(args.length == 0) {
    	  p.sendMessage(prefix + "§cComando inválido.");
    	  sendHelp(p);
    	  return true;
      }
      switch (args[0]) {
      
    
	case "gadgets":
		plugin.getMenuManager().showMenu(p);
		break;
		
	case "pets":
		
        plugin.getPetsMenu().showPetMenu(p);
		
		break;
	case "particulas":
		plugin.getParticlesMenu().showParticlesMenu(p);
		
		break;
		
	case "sparticulas":
		plugin.getSuperMenu().showSuperMenu(p);
		break;
		
	case "fantasias":
		plugin.getDisguiseMenu().showDisguiseMenu(p);
		
		break;	
		
		
	case "mount":
		plugin.getMountsMenu().showMountMenu(p);
	 break;
		
	case "recarregar":
		if(!p.hasPermission("ug.recarregar")) {
    		p.sendMessage(prefix + "§cVocê não tem permissão para usar esse comando.");
    		return true;
		}
		PluginListener.reloadPlugin(p);
		
		break;
		
	case "lag":
		if(!p.hasPermission("ug.lag")) {
    		p.sendMessage(prefix + "§cVocê não tem permissão para usar esse comando.");
    		return true;
		}
		PluginListener.lagManager(p);
		break;	
		
	}
   }
    return false;
  }
}
