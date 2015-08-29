package Commands;

import EventManager.PluginListener;
import Pets.PetManager;
import Pets.Pets;
import Utils.UtilJsonBuilder;
import Utils.Ward;
import Utils.UtilJsonBuilder.ClickAction;
import Utils.UtilJsonBuilder.HoverAction;
import br.com.floodeer.ultragadgets.UltraGadgets;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import vR3.UtilEnt_vR3;

public class UltraGadgetsCMD
  implements CommandExecutor
{
  UltraGadgets plugin = UltraGadgets.getMain();
  private String prefix = plugin.getMessagesFile().prefix + " ";
  
  private void sendHelp(Player player) {
	  UtilJsonBuilder gadgets = new UtilJsonBuilder("§6/ug gadgets §7- Menu de Gadgets").withClickEvent(ClickAction.SUGGEST_COMMAND, "/ug gadgets").withHoverEvent(HoverAction.SHOW_TEXT, "§6§lClique para preparar o comando!");
	  UtilJsonBuilder pets = new UtilJsonBuilder("§6/ug pets §7- Menu de Pets").withClickEvent(ClickAction.SUGGEST_COMMAND, "/ug pets").withHoverEvent(HoverAction.SHOW_TEXT, "§6§lClique para preparar o comando!");
	  UtilJsonBuilder particulas = new UtilJsonBuilder("§6/ug particulas §7- Menu de Partículas").withClickEvent(ClickAction.SUGGEST_COMMAND, "/ug particulas").withHoverEvent(HoverAction.SHOW_TEXT, "§6§lClique para preparar o comando!");
	  UtilJsonBuilder sparticulas = new UtilJsonBuilder("§6/ug sparticulas §7- Menu de Super Partículas").withClickEvent(ClickAction.SUGGEST_COMMAND, "/ug sparticulas").withHoverEvent(HoverAction.SHOW_TEXT, "§6§lClique para preparar o comando!");
	  UtilJsonBuilder fantasias = new UtilJsonBuilder("§6/ug fantasias §7- Menu de Fantasias").withClickEvent(ClickAction.SUGGEST_COMMAND, "/ug fantasias").withHoverEvent(HoverAction.SHOW_TEXT, "§6§lClique para preparar o comando!");
	  UtilJsonBuilder mount = new UtilJsonBuilder("§6/ug mounts §7- Menu de Montarias").withClickEvent(ClickAction.SUGGEST_COMMAND, "/ug mount").withHoverEvent(HoverAction.SHOW_TEXT, "§6§lClique para preparar o comando!");
	  UtilJsonBuilder petManager = new UtilJsonBuilder("§6/ug petManager §7- Menu do Pet").withClickEvent(ClickAction.SUGGEST_COMMAND, "/ug petManager").withHoverEvent(HoverAction.SHOW_TEXT, "§6§lClique para preparar o comando!");
	  UtilJsonBuilder wardrobe = new UtilJsonBuilder("§6/ug wardrobe §7- Menu Guarda-Roupa").withClickEvent(ClickAction.SUGGEST_COMMAND, "/ug wardrobe").withHoverEvent(HoverAction.SHOW_TEXT, "§6§lClique para preparar o comando!");
	  UtilJsonBuilder recarregar = new UtilJsonBuilder("§6/ug recarregar §7- Recarregar o plugin (Não muda configurações)").withClickEvent(ClickAction.SUGGEST_COMMAND, "/ug recarregar").withHoverEvent(HoverAction.SHOW_TEXT, "§6§lClique para preparar o comando!");
	  UtilJsonBuilder lag = new UtilJsonBuilder("§6/ug lag §7- Manager de lag do plugin (Não interfere outras tarefas)").withClickEvent(ClickAction.SUGGEST_COMMAND, "/ug lag").withHoverEvent(HoverAction.SHOW_TEXT, "§6§lClique para preparar o comando!");
	  UtilJsonBuilder credits = new UtilJsonBuilder("§6/ug creditos §7- Créditos do Plugin").withClickEvent(ClickAction.SUGGEST_COMMAND, "/ug creditos").withHoverEvent(HoverAction.SHOW_TEXT, "§6§lClique para preparar o comando!");
	  UtilEnt_vR3.sendJson(player, gadgets);
	  UtilEnt_vR3.sendJson(player, pets);
	  UtilEnt_vR3.sendJson(player, particulas);
	  UtilEnt_vR3.sendJson(player, sparticulas);
	  UtilEnt_vR3.sendJson(player, fantasias);
	  UtilEnt_vR3.sendJson(player, mount);
	  UtilEnt_vR3.sendJson(player, petManager);
	  UtilEnt_vR3.sendJson(player, recarregar);
	  UtilEnt_vR3.sendJson(player, lag);
	  UtilEnt_vR3.sendJson(player, wardrobe);
	  UtilEnt_vR3.sendJson(player, credits);
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
	 
	case "wardrobe":
		new Ward(p, plugin);
	break;
	
	case "petManager":
	PetManager pe = new PetManager();
	if(Pets.PetsType.HasPet(p)) { 
	pe.showManagerMenu(p);
	}else{
		p.sendMessage(plugin.getMessagesFile().errorPet);
	}
	break;
	
	case "creditos":
		p.sendMessage("§7[§9UltraGadgets§7] > §6Todos os direitos reservados Copyright ©");
		p.sendMessage("§7[§9UltraGadgets§7] > §6Desenvolvedor: §7Floodeer");
		p.sendMessage("§7[§9UltraGadgets§7] > §6RL: EULA & Termos de uso v1.0.5");
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
