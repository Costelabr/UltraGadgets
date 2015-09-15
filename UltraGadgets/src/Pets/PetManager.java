package Pets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit.Type;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import vR3.AnvilGUI_vR3;
import vR3.AnvilGUI_vR3.AnvilClickEvent;
import vR3.UtilEnt_vR3;
import Pets.Pets.PetsType;
import Update.SchedulerEvent;
import Update.SchedulerType;
import Utils.ParticleEffect;
import Utils.UtilJsonBuilder;
import Utils.UtilMath;
import Utils.UtilMenu;
import Utils.UtilParticle;
import br.com.floodeer.ultragadgets.UltraGadgets;

public class PetManager implements Listener {

	UltraGadgets plugin = UltraGadgets.getMain();
	UtilMenu petManager = new UtilMenu(plugin, plugin.getMessagesFile().PetManagerMenuName, 1);
	UtilMenu creepermanager = new UtilMenu(plugin, "§7Creeper", 1);
	UtilMenu villagerManager = new UtilMenu(plugin, "§7Villager Profissão", 1);
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
	
	if(PetsType.isEntity(p, EntityType.CREEPER)) {
	   if(p.hasPermission("ug.pets.creeperManager") || p.hasPermission("ug.pets.usar.todos") || p.hasPermission("ug.usar.todos")) {
		   petManager.setItem(4, plugin.getItemStack().newItemStack(Material.TNT, "§bConfigurar Creeper", Arrays.asList(new String[] { "§7Clique para configurar seu Creeper!" }), 1, (byte)0));
	   }else{
		   petManager.setItem(4, plugin.getItemStack().noPermissionItem("§7Mudar tipo de Pet"));
	   } 
	}else{
		petManager.setItem(4, plugin.getItemStack().newItemStack(Material.INK_SACK, "§cSeu pet não possui outros tamanhos.", Arrays.asList(new String[] { "§cO seu pet deve ser um Slime para fazer isso!" }), 1, (byte)8));
	}
	
	if(PetsType.isEntity(p, EntityType.VILLAGER)) {
	   if(p.hasPermission("ug.pets.villagerManager") || p.hasPermission("ug.pets.usar.todos") || p.hasPermission("ug.usar.todos")) {
		   petManager.setItem(4, plugin.getItemStack().newItemStack(Material.WHEAT, "§bConfigurar Villager", Arrays.asList(new String[] { "§7Clique para configurar seu Villager" }), 1, (byte)0));
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
		petManager.setItem(8, plugin.getItemStack().noPermissionItem("§bPet Teleport"));
	}
	
	petManager.showMenu(p);
 }
	
	public void showCreeperMenu(Player p) {
		creepermanager.setItem(2, plugin.getItemStack().newItemStack(Material.BLAZE_POWDER, "§cInfernal Creeper", null, 1, (byte)0));
		creepermanager.setItem(4, plugin.getItemStack().newItemStack(Material.MONSTER_EGG, "§cLight Creeper", null, 2, (byte)50));
		creepermanager.setItem(6, plugin.getItemStack().newItemStack(Material.TNT, "§cExplosive Creeper", null, 3, (byte)0));
		
		creepermanager.showMenu(p);
	}
	
	public void showVillagerMenu(Player p) {
		villagerManager.setItem(0, plugin.getItemStack().newItemStack(Material.WHEAT, "Fazendeiro", null, 1, (byte)0));
		villagerManager.setItem(2, plugin.getItemStack().newItemStack(Material.BOOKSHELF, "Bibliotecário", null, 2, (byte)0));
		villagerManager.setItem(4, plugin.getItemStack().newItemStack(Material.WOOD_DOOR, "Padre", null, 3, (byte)0));
		villagerManager.setItem(6, plugin.getItemStack().newItemStack(Material.IRON_INGOT, "Ferreiro", null, 4, (byte)0));
		villagerManager.setItem(8, plugin.getItemStack().newItemStack(Material.MUTTON, "Açougueiro", null, 5, (byte)0));
		villagerManager.showMenu(p);
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
	      if(e.getCurrentItem().getType() != Material.AIR) {
	      p.closeInventory();
	      }
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
		    	 if(p.hasPermission("ug.pets.renomear") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {
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
				 p.closeInventory();
		    }
		   }
		    
		 if(slotClicked == 2) { 
			 if(p.hasPermission("ug.pets.tipos") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {  
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
				p.sendMessage("§cPet inválido para completar ação!");
			}
	 }else{
		 p.sendMessage(plugin.getMessagesFile().petManagerError);
		 p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1F, -5F);
		 p.closeInventory();
	 }
	}
		
		 if(slotClicked == 4) {
			 if(e.getCurrentItem().getType() == Material.TNT){
			 if(p.hasPermission("ug.pets.creeperManager") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {  
			 p.closeInventory();
			 showCreeperMenu(p);
			}else{
			p.sendMessage(plugin.getMessagesFile().petManagerError);
			p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1F, -5F);
			p.closeInventory();
			}
		}
			 if(e.getCurrentItem().getType() == Material.WHEAT){
			 if(p.hasPermission("ug.pets.villagerManager") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {  
			 p.closeInventory();
			 showVillagerMenu(p);
			}else{
			p.sendMessage(plugin.getMessagesFile().petManagerError);
			p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1F, -5F);
			p.closeInventory();
			}
		}
	}
		 if(slotClicked == 6) { 
			 if(p.hasPermission("ug.pets.cor") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {  
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
			 }
		 
		 }else{
			 p.sendMessage(plugin.getMessagesFile().petManagerError);
			 p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1F, -5F);
			 p.closeInventory();
	}
}
		 
		 if(slotClicked == 8) {
			 if(p.hasPermission("ug.pets.teleport") || (p.hasPermission("ug.pets.usar.todos") || (p.hasPermission("ug.usar.todos")))) {  
			if(e.getClick() == ClickType.LEFT) {
				Entity entidade = (Entity)PetsType.pet.get(p.getUniqueId());
				entidade.teleport(p.getLocation());
			}else{
			Location l = PetsType.pet.get(p.getUniqueId()).getLocation();
			p.teleport(l);
			}
		 }else{
			 p.sendMessage(plugin.getMessagesFile().petManagerError);
			 p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1F, -5F);
			 p.closeInventory();
		 }
	}
}
	    
	    if((e.getInventory().getName().equalsIgnoreCase("§7Creeper") &&
	   	     ((e.getWhoClicked() instanceof Player)))) {
	    	int slotClicked = e.getSlot();
	    	e.setCancelled(true);
	    	Player p = (Player)e.getWhoClicked();
	    	p.closeInventory();
	    	if(slotClicked == 2) {
	    		if(!infernal.contains(PetsType.booleanCreeper.get(p.getUniqueId()))) {
	    			infernal.add(PetsType.booleanCreeper.get(p.getUniqueId()));
	    		}else{	
	    			infernal.remove(PetsType.booleanCreeper.get(p.getUniqueId()));
	    		}
	    	}

	    	if(slotClicked == 4) {
	    		if(!PetsType.booleanCreeper.get(p.getUniqueId()).isPowered()) {
	    		PetsType.booleanCreeper.get(p.getUniqueId()).setPowered(true);
	    		}else{
	    			PetsType.booleanCreeper.get(p.getUniqueId()).setPowered(false);
	    		}
	       }
	    	if(slotClicked == 6) {
	    		if(!explosivo.contains(PetsType.booleanCreeper.get(p.getUniqueId()))) {
	    			explosivo.add(PetsType.booleanCreeper.get(p.getUniqueId()));
	    		}else{
	    			explosivo.remove(PetsType.booleanCreeper.get(p.getUniqueId()));
	    		}
	    	}
	   }
	    
	    if((e.getInventory().getName().equals("§7Villager Profissão") && ((e.getWhoClicked() instanceof Player)))) {
	    	int slotClicked = e.getSlot();
	    	e.setCancelled(true);
	    	Player p = (Player)e.getWhoClicked();
	    	p.closeInventory();
	    	p.playSound(p.getLocation(), Sound.ANVIL_USE, 1, 1);
	    	Villager v = PetsType.villagerType.get(p.getUniqueId());
	    	if(slotClicked == 0) {
	    	v.setProfession(Profession.FARMER);
	    	}
	    	if(slotClicked == 2) {
	    	v.setProfession(Profession.LIBRARIAN);
	    	}
	    	if(slotClicked == 4) {
	    	v.setProfession(Profession.PRIEST);
	    	}
	    	if(slotClicked == 6) {
	    	v.setProfession(Profession.BLACKSMITH);
	    	}
	    	if(slotClicked == 8) {
	    	v.setProfession(Profession.BUTCHER);
	    	}
	    }
	 }
	 public static List<Creeper> infernal = new ArrayList<Creeper>();
	 public static List<Creeper> explosivo = new ArrayList<Creeper>();
	 private double i = 0.0D;
	 private double newY;
	 double slice = 0.15707963267948966D;
	 double slice2 = 0.06283185307179587D;
	 double radius = 1.3D;
	 @EventHandler
	 public void update(SchedulerEvent event) {
		 if(event.getType() == SchedulerType.TICK) {
			 for(Creeper e : infernal) {
			 Location l = e.getLocation().add(0.0D, 1.5D, 0.0D);
				double angle = this.slice * this.i;
				double angle2 = this.slice2 * this.i;
				this.newY = (l.getY() + this.radius * Math.cos(angle2));
				double newX = l.getX() + this.radius * Math.cos(angle);
				double newZ = l.getZ() + this.radius * Math.sin(angle);
				Location loc = new Location(e.getWorld(), newX, this.newY, newZ);
				        
				new UtilParticle(UtilParticle.ParticleType.FLAME, 0.06D, 2, 0.05D).sendToLocation(loc);
				        new UtilParticle(UtilParticle.ParticleType.SMOKE_LARGE, 0.0D, 1, 0.0D).sendToLocation(loc);
				        if (this.i % 2.0D == 0.0D) {
				          new UtilParticle(UtilParticle.ParticleType.LAVA, 0.0D, 1, 0.0D).sendToLocation(loc);
				        }
				  this.i += 1.5D;
				  if (this.i >= 1000.0D) {
				    this.i = 0.0D;
				  }
			 }
		 }
	 }
	 
	 @EventHandler
	 public void updateExplosive(SchedulerEvent event) {
		 if(event.getType() == SchedulerType.SLOWER) {
		 for(Creeper e : explosivo) {
			 e.getWorld().playSound(e.getLocation(), Sound.EXPLODE, 1, 1);
			  ParticleEffect.EXPLOSION_HUGE.display(0, UtilMath.random.nextInt(1), 0, 5.0F, 120, e.getLocation(), 35.0D);
		  }
		}
	 }
 }