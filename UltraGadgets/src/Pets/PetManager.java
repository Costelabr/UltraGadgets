package Pets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Rabbit.Type;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.Event.Result;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import vR3.AnvilGUI_vR3;
import vR3.AnvilGUI_vR3.AnvilClickEvent;
import vR3.UtilEnt_vR3;
import Pets.Pets.PetsType;
import Utils.UtilJsonBuilder;
import Utils.UtilMenu;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class PetManager implements Listener {

	UltraGadgets plugin = UltraGadgets.getMain();
	UtilMenu petManager = new UtilMenu(plugin, plugin.getMessagesFile().PetManagerMenuName, 1);
	UtilMenu slimeSize = new UtilMenu(plugin, "§7Slime", 1);
	List<String> typesArray = new ArrayList<String>();
	List<String> color = new ArrayList<String>();

	public void showManagerMenu(Player p) {
	 if(p.hasPermission("ug.pets.renomear") || p.hasPermission("ug.pets.usar.todos") || p.hasPermission("ug.usar.todos")) {
	 petManager.setItem(0, plugin.getItemStack().newItemStack(Material.NAME_TAG, "§bRenomear Pet", Arrays.asList(new String[] { "§7Clique para alterar o nome do pet!" }), 1, (byte)0));
	}else{
	 petManager.setItem(0, plugin.getItemStack().noPermissionItem("§7Renomear Pet"));
	}
	 
	if(PetsType.isEntity(p, EntityType.RABBIT)) {
	 if(p.hasPermission("ug.pets.tipos") || p.hasPermission("ug.pets.usar.todos") || p.hasPermission("ug.usar.todos")) {
	  petManager.setItem(2, plugin.getItemStack().newItemStack(Material.ANVIL, "§bMudar o tipo do Pet", Arrays.asList(new String[] { "§7Clique para alterar o tipo do pet" }), 1, (byte)0));
	}else{
	 petManager.setItem(2, plugin.getItemStack().noPermissionItem("§7Mudar tipo de Pet"));
	}
	}else{
		petManager.setItem(2, plugin.getItemStack().newItemStack(Material.INK_SACK, "§cSeu pet não possui outros tipos.", Arrays.asList(new String[] { "§cO seu pet deve ser um coelho para fazer isso!" }), 1, (byte)8));
	}
	
	if(PetsType.isEntity(p, EntityType.SLIME)) {
	   if(p.hasPermission("ug.pets.tamanho") || p.hasPermission("ug.pets.usar.todos") || p.hasPermission("ug.usar.todos")) {
		   petManager.setItem(4, plugin.getItemStack().newItemStack(Material.SLIME_BALL, "§bMudar o tamanho do Pet", Arrays.asList(new String[] { "§7Clique para alterar o tamanho do seu pet!" }), 1, (byte)0));
	   }else{
		   petManager.setItem(4, plugin.getItemStack().noPermissionItem("§7Mudar tipo de Pet"));
	   } 
	}else{
		petManager.setItem(4, plugin.getItemStack().newItemStack(Material.INK_SACK, "§cSeu pet não possui outros tamanhos.", Arrays.asList(new String[] { "§cO seu pet deve ser um Slime para fazer isso!" }), 1, (byte)8));
	}
	
	if(PetsType.isEntity(p, EntityType.SHEEP)) {
		   if(p.hasPermission("ug.pets.cor") || p.hasPermission("ug.pets.usar.todos") || p.hasPermission("ug.usar.todos")) {
			   petManager.setItem(6, plugin.getItemStack().newItemStack(Material.WOOL, "§bMudar cor do Pet", Arrays.asList(new String[] { "§7Clique para alterar a cor do seu pet!" }), 1, (byte)1));
		   }else{
			   petManager.setItem(6, plugin.getItemStack().noPermissionItem("§7Mudar Cor do Pet"));
		   } 
		}else{
			petManager.setItem(6, plugin.getItemStack().newItemStack(Material.INK_SACK, "§cSeu pet não possiu outras cores", Arrays.asList(new String[] { "§cO seu pet deve ser uma Ovelha para fazer isso!" }), 1, (byte)8));
		}
	
	if(p.hasPermission("ug.pets.teleport")) {
		petManager.setItem(8, plugin.getItemStack().newItemStack(Material.ENDER_PEARL, "§bPet Teleport", Arrays.asList(new String[] { "§7Clique-Direito para teleportar até seu Pet", "§7Clique-Esquerdo para seu pet teleportar até você" }), 1, (byte)0));
	}else{
		petManager.setItem(6, plugin.getItemStack().noPermissionItem("§bPet Teleport"));
	}
	
	petManager.showMenu(p);
 }
	
	public void showSlimeMenu(Player p) {
		slimeSize.setItem(2, plugin.getItemStack().newItemStack(Material.SLIME_BALL, "§cTamanho 1", null, 1, (byte)0));
		slimeSize.setItem(3, plugin.getItemStack().newItemStack(Material.SLIME_BALL, "§cTamanho 2", null, 2, (byte)0));
		slimeSize.setItem(4, plugin.getItemStack().newItemStack(Material.SLIME_BALL, "§cTamanho 3", null, 3, (byte)0));
		slimeSize.setItem(5, plugin.getItemStack().newItemStack(Material.SLIME_BALL, "§cTamanho 4", null, 4, (byte)0));
		slimeSize.setItem(6, plugin.getItemStack().newItemStack(Material.SLIME_BALL, "§cTamanho 5", null, 5, (byte)0));
		
		slimeSize.showMenu(p);
	}
	 @EventHandler
	 public void handlerRightClickAtInventory(InventoryClickEvent e) {
	    if ((e.getInventory().getName().equalsIgnoreCase(plugin.getPetsMenu().invname)) 
	    	&& ((e.getWhoClicked() instanceof Player) 
	    		 && e.getClick() == ClickType.RIGHT)) {
	      int slotClicked = e.getSlot();
	      Player p = (Player)e.getWhoClicked();
	      e.setCancelled(true);
	      e.setResult(Result.DENY);
	      p.closeInventory();
	      if(!Pets.PetsType.HasPet(p)) {
	    	  p.sendMessage(plugin.getMessagesFile().errorPet);
	    	  return;
	      }
	      if(slotClicked != 12 && slotClicked != 13 && slotClicked != 14 &&
	    		  slotClicked != 21 && slotClicked != 22 && slotClicked != 23 && slotClicked != 30) return;
	      showManagerMenu(p);
	 }
	    if((e.getInventory().getName().equalsIgnoreCase(plugin.getMessagesFile().PetManagerMenuName)) &&
	     ((e.getWhoClicked() instanceof Player))) {
		     final Player p = (Player)e.getWhoClicked();
		     e.setCancelled(true);
		     e.setResult(Result.DENY);
		     p.closeInventory();
		     int slotClicked = e.getSlot();
		     
		    if(slotClicked == 0) {
		    	 if(p.hasPermission("ug.renomear") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
		    	 p.closeInventory();
		         p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
		         final AnvilGUI_vR3 gui = new AnvilGUI_vR3(p, new AnvilGUI_vR3.AnvilClickEventHandler() {
		          @Override
		            public void onAnvilClick(AnvilClickEvent event) {
		              if(event.getSlot() == AnvilGUI_vR3.AnvilSlot.OUTPUT){
		                 event.setWillClose(true);
		                  event.setWillDestroy(true);
		                  if(PetsType.HasPet(p)) {
		                     UtilJsonBuilder jn = new UtilJsonBuilder("§aVocê trocou o nome do seu pet!")
		                    .withHoverEvent(UtilJsonBuilder.HoverAction.SHOW_TEXT, "§lNome: §e§l" + event.getName().replaceAll("&", "§"));
		                    p.playSound(p.getLocation(), Sound.ANVIL_USE, 1.0F, 1.0F);
		                    (PetsType.pet.get(p.getUniqueId())).setCustomName(event.getName().replaceAll("&", "§")); 
		                     event.setWillClose(false);
		                     event.setWillDestroy(false);
		                     p.closeInventory();
			                   UtilEnt_vR3.sendJson(p, jn);
		                  }
		                  }else{
		                  event.setWillClose(false);
		                 event.setWillDestroy(false);
		            }
		          }
		         });
		         ItemStack i = new ItemStack(Material.NAME_TAG);
		         ItemMeta im = i.getItemMeta();
		         im.setDisplayName("Nome do Pet");
		         i.setItemMeta(im);
		        
		         gui.setSlot(AnvilGUI_vR3.AnvilSlot.INPUT_LEFT, i);
		        
		         gui.open();
		    }else{
		    	 p.sendMessage(plugin.getMessagesFile().petManagerError);
				 p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1F, -5F);
		    }
		   }
		    
		 if(p.hasPermission("ug.renomear") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {  
		 if(slotClicked == 2) { 
			 if(PetsType.isEntity(p, EntityType.RABBIT)) {
	    	 p.closeInventory();
	    	 typesArray.add("BLACK");
             typesArray.add("BLACK_AND_WHITE");
             typesArray.add("BROWN");
             typesArray.add("GOLD");
             typesArray.add("SALT_AND_PEPPER");
             typesArray.add("THE_KILLER_BUNNY");
             typesArray.add("WHITE");
             p.sendMessage("§bDigite o tipo de coelho para salvar!");
             p.sendMessage("§bTipos disponíveis: ");
             p.sendMessage("§eBLACK§a, §eBLACK_AND_WHITE§a, §eBROWN§a, §eGOLD,");
             p.sendMessage("§eSALT_AND_PEPPER§a, §eTHE_KILLER_BUNNY§a, §eWHITE§a");
	         p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
	         
	         final AnvilGUI_vR3 gui = new AnvilGUI_vR3(p, new AnvilGUI_vR3.AnvilClickEventHandler() {
	          @Override
	            public void onAnvilClick(AnvilClickEvent event) {
	              if(event.getSlot() == AnvilGUI_vR3.AnvilSlot.OUTPUT){
			             if(!typesArray.contains(event.getName())) {
			              p.sendMessage("§lO tipo §c" + event.getName() + " §f§lnão existe!");
			             return;
			         }
	                 event.setWillClose(true);
	                 event.setWillDestroy(true);
	                     UtilJsonBuilder jn = new UtilJsonBuilder("§aVocê trocou o tipo do seu pet!")
	                    .withHoverEvent(UtilJsonBuilder.HoverAction.SHOW_TEXT, "§lTipo: §e§l" + event.getName().replaceAll("&", "§"));
	                     p.playSound(p.getLocation(), Sound.ANVIL_USE, 1.0F, 1.0F);
	                     PetsType.booleanRabbit.get(p.getUniqueId()).setRabbitType(Type.valueOf(event.getName())); 
	                     event.setWillClose(false);
	                     event.setWillDestroy(false);
	                     p.closeInventory();
		                   UtilEnt_vR3.sendJson(p, jn);
	                  }else{
	                  event.setWillClose(false);
	                 event.setWillDestroy(false);
	            }
	          }
	         });
	         ItemStack i = new ItemStack(Material.ANVIL);
	         ItemMeta im = i.getItemMeta();
	         im.setDisplayName("Tipo do Pet");
	         i.setItemMeta(im);
	     
	         gui.setSlot(AnvilGUI_vR3.AnvilSlot.INPUT_LEFT, i);
	        
	         gui.open();
			}else{
				
			}
		 }
	 }else{
		 p.sendMessage(plugin.getMessagesFile().petManagerError);
		 p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1F, -5F);
	 }
		
		 if(slotClicked == 4) {
			 p.closeInventory();
			 showSlimeMenu(p);
		 }
		 
		 if(slotClicked == 6) { 
			 if(PetsType.isEntity(p, EntityType.SHEEP)) {
	    	 p.closeInventory();
	         p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
	 		 color.add("Preto");
			 color.add("Azul Escuro");
			 color.add("Azul Claro");
			 color.add("Vermelho");
			 color.add("Amarelo");
			 color.add("Verde");
			 color.add("Laranja");
			 color.add("Rosa");
			 color.add("Branco");
			 color.add("Roxo");
			 color.add("Cinza");
			 color.add("Marrom");
             p.sendMessage("§bDigite a cor para salvar!");
             p.sendMessage("§bCores disponíveis: ");
             p.sendMessage("§ePreto§a, §eAzul Escuro§a, §eVermelho§a, §eAmarelo, §eCinza§a");
             p.sendMessage("§eVerde§a, §eLaranja§a, §eRosa§a, §eBranco§a, §eRoxo§a, §eMarrom§a");
			          
	         final AnvilGUI_vR3 gui = new AnvilGUI_vR3(p, new AnvilGUI_vR3.AnvilClickEventHandler() {
	          @Override
	            public void onAnvilClick(AnvilClickEvent event) {
	              if(event.getSlot() == AnvilGUI_vR3.AnvilSlot.OUTPUT){
			             if(!color.contains(event.getName())) {
			              p.sendMessage("§lCor §c" + event.getName() + " §f§lnão existe ou não está disponível!");
			             return;
			         }
			         Sheep s = (Sheep) PetsType.booleanSheep.get(p.getUniqueId());
			         if(event.getName().equalsIgnoreCase("Preto")) {
			        	 s.setColor(DyeColor.BLACK);
			         }
			         else if(event.getName().equalsIgnoreCase("Azul Escuro")) {
			        	 s.setColor(DyeColor.BLUE);
			         }
			         else if(event.getName().equalsIgnoreCase("Vermelho")) {
			        	 s.setColor(DyeColor.RED);
			         }
			         else if(event.getName().equalsIgnoreCase("Verde")) {
			        	 s.setColor(DyeColor.GREEN);
			         }
			         else if(event.getName().equalsIgnoreCase("Laranja")) {
			        	 s.setColor(DyeColor.ORANGE);
			         }
			         else if(event.getName().equalsIgnoreCase("Rosa")) {
			        	 s.setColor(DyeColor.PINK);
			         }
			         else if(event.getName().equalsIgnoreCase("Roxo")) {
			        	 s.setColor(DyeColor.MAGENTA);
			         }
			         else if(event.getName().equalsIgnoreCase("Azul Claro")) {
			        	 s.setColor(DyeColor.LIGHT_BLUE);
			         }
			         else if(event.getName().equalsIgnoreCase("Amarelo")) {
			        	 s.setColor(DyeColor.YELLOW);
			         }
			         else if(event.getName().equalsIgnoreCase("Branco")) {
			        	 s.setColor(DyeColor.WHITE);
			         }
			         
	                 event.setWillClose(true);
	                 event.setWillDestroy(true);
	                     UtilJsonBuilder jn = new UtilJsonBuilder("§aVocê trocou a cor do seu pet!")
	                    .withHoverEvent(UtilJsonBuilder.HoverAction.SHOW_TEXT, "§lCor: §e§l" + event.getName().replaceAll("&", "§"));
	                     p.playSound(p.getLocation(), Sound.ANVIL_USE, 1.0F, 1.0F);
	                     event.setWillClose(false);
	                     event.setWillDestroy(false);
	                     p.closeInventory();
		                 UtilEnt_vR3.sendJson(p, jn);
	                  }else{
	                  event.setWillClose(false);
	                 event.setWillDestroy(false);
	            }
	          }
	         });
	         ItemStack i = new ItemStack(Material.WOOL);
	         ItemMeta im = i.getItemMeta();
	         im.setDisplayName("Cor do Pet");
	         i.setItemMeta(im);
	     
	         gui.setSlot(AnvilGUI_vR3.AnvilSlot.INPUT_LEFT, i);
	        
	         gui.open();
			}else{
				
			}
		 }
		 
		 if(slotClicked == 8) {
			if(e.getClick() == ClickType.LEFT) {
				Entity entidade = (Entity)PetsType.pet.get(p.getUniqueId());
				entidade.teleport(p.getLocation());
			}else{
			Location l = PetsType.pet.get(p.getUniqueId()).getLocation();
			p.teleport(l);
			}
		 }
	 }
	    
	    if((e.getInventory().getName().equalsIgnoreCase("§7Slime") &&
	   	     ((e.getWhoClicked() instanceof Player)))) {
	    	int slotClicked = e.getSlot();
	    	e.setCancelled(true);
	    	Player p = (Player)e.getWhoClicked();
	    	p.closeInventory();
	    	if(slotClicked == 2) {
	        PetsType.booleanSlime.get(p.getUniqueId()).setSize(1);	
	        p.playSound(p.getLocation(), Sound.ANVIL_USE, 1.0F, 1.0F);
	        UtilJsonBuilder jn = new UtilJsonBuilder("§aVocê trocou o tamanho do seu Pet!")
            .withHoverEvent(UtilJsonBuilder.HoverAction.SHOW_TEXT, "§lTamanho: §e§l1");
	        UtilEnt_vR3.sendJson(p, jn);
	    }
	    if(slotClicked == 3) {
		    PetsType.booleanSlime.get(p.getUniqueId()).setSize(2);
	        p.playSound(p.getLocation(), Sound.ANVIL_USE, 1.0F, 1.0F);
	        UtilJsonBuilder jn = new UtilJsonBuilder("§aVocê trocou o tamanho do seu Pet!")
            .withHoverEvent(UtilJsonBuilder.HoverAction.SHOW_TEXT, "§lTamanho: §e§l2");
	        UtilEnt_vR3.sendJson(p, jn);
		}
    	if(slotClicked == 4) {
	        PetsType.booleanSlime.get(p.getUniqueId()).setSize(3);	
	        p.playSound(p.getLocation(), Sound.ANVIL_USE, 1.0F, 1.0F);
	        UtilJsonBuilder jn = new UtilJsonBuilder("§aVocê trocou o tamanho do seu Pet!")
            .withHoverEvent(UtilJsonBuilder.HoverAction.SHOW_TEXT, "§lTamanho: §e§l3");
	        UtilEnt_vR3.sendJson(p, jn);
	    }
	    if(slotClicked == 5) {
		   PetsType.booleanSlime.get(p.getUniqueId()).setSize(4);
	        p.playSound(p.getLocation(), Sound.ANVIL_USE, 1.0F, 1.0F);
	        UtilJsonBuilder jn = new UtilJsonBuilder("§aVocê trocou o tamanho do seu Pet!")
            .withHoverEvent(UtilJsonBuilder.HoverAction.SHOW_TEXT, "§lTamanho: §e§l4");
	        UtilEnt_vR3.sendJson(p, jn);
		}
    	if(slotClicked == 6) {
	        PetsType.booleanSlime.get(p.getUniqueId()).setSize(5);	
	        p.playSound(p.getLocation(), Sound.ANVIL_USE, 1.0F, 1.0F);
	        UtilJsonBuilder jn = new UtilJsonBuilder("§aVocê trocou o tamanho do seu Pet!")
            .withHoverEvent(UtilJsonBuilder.HoverAction.SHOW_TEXT, "§lTamanho: §e§l5");
	        UtilEnt_vR3.sendJson(p, jn);
	    }
	  }
   }
 }