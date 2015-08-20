package Pets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Wolf;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Core.UtilAnvilGUI;
import Core.UtilJsonBuilder;
import Core.UtilMenu;
import Core.UtilAnvilGUI.AnvilClickEvent;
import Exception.PetTypeException;
import Pets.Pets.PetsType;

import com.floodeer.gadgets.UltraGadgets;

public class PlayerInteractPetEvent
  implements Listener
{
  UltraGadgets plugin;
  private HashMap<Player, String> mapOfString;
  HashMap<Player, Entity> playerPet;
  ArrayList<Player> hashOfPlayer;
  ArrayList<Player> arraySlime;
  ArrayList<Player> arrayType;
  UtilMenu petMenu;
  List<String> typesArray;
  List<String> sizeArray;
  
  public PlayerInteractPetEvent()
  {
    this.plugin = UltraGadgets.getMain();
    this.mapOfString = new HashMap<>();
    this.playerPet = new HashMap<>();
    this.hashOfPlayer = new ArrayList<>();
    this.arrayType = new ArrayList<>();
    this.petMenu = new UtilMenu(this.plugin, "§6§lPet Manager", 1);
    this.arraySlime = new ArrayList<Player>();
    this.sizeArray = new ArrayList<String>();
    
    this.petMenu.setItem(0, this.plugin.getItemStack().newItemStack(Material.NAME_TAG, "§eMudar nome do Pet", Arrays.asList(new String[] { "§7Clique para alterar o nome do pet" }), 1, (byte)0));
    
    this.petMenu.setItem(2, this.plugin.getItemStack().newItemStack(Material.ANVIL, "§eMudar tipo do pet", Arrays.asList(new String[] { "§7Clique para alterar o tipo de pet" }), 1, (byte)0));
    
    this.petMenu.setItem(4, this.plugin.getItemStack().newItemStack(Material.SLIME_BALL, "§eMudar tamanho do Pet", Arrays.asList(new String[] { "§7Clique para alterar o tamanho do Pet" }), 1, (byte)0));
    
    this.typesArray = new ArrayList<>();
  }
  
  @EventHandler
  public void onPlayerInteractPetEvent(PlayerInteractEntityEvent e)
  {
    if ((e.getRightClicked() instanceof Chicken))
    {
      Chicken localChicken = (Chicken)e.getRightClicked();
      if ((localChicken.hasMetadata("petChicken")) && PetsType.HasPet(e.getPlayer()) &&
        (e.getPlayer().isSneaking())) {
        this.petMenu.showMenu(e.getPlayer());
        this.playerPet.put(e.getPlayer(), localChicken);
      }
    }
    if ((e.getRightClicked() instanceof Cow))
    {
      Cow localCow = (Cow)e.getRightClicked();
      if ((localCow.hasMetadata("petCow")) && PetsType.HasPet(e.getPlayer()) &&
        (e.getPlayer().isSneaking()))
      {
        this.petMenu.showMenu(e.getPlayer());
        this.playerPet.put(e.getPlayer(), localCow);
      }
    }
    if ((e.getRightClicked() instanceof Rabbit))
    {
      Rabbit localRabbit = (Rabbit)e.getRightClicked();
      if ((localRabbit.hasMetadata("petRabbit")) && PetsType.HasPet(e.getPlayer()) &&
        (e.getPlayer().isSneaking()))
      {
      
        this.petMenu.showMenu(e.getPlayer());
        this.playerPet.put(e.getPlayer(), localRabbit);
      }
    }
    if((e.getRightClicked() instanceof Wolf)) {
    	Wolf localWolf = (Wolf)e.getRightClicked();
    	if((localWolf.hasMetadata("petWolf")) && PetsType.HasPet(e.getPlayer()) && 
    		e.getPlayer().isSneaking()) {
    		this.petMenu.showMenu(e.getPlayer());
    		this.playerPet.put(e.getPlayer(), localWolf);
    	}
    }
        if((e.getRightClicked() instanceof Pig)) {
        	Pig localPig = (Pig)e.getRightClicked();
        	if((localPig.hasMetadata("petPorco")) && PetsType.HasPet(e.getPlayer()) && 
        		e.getPlayer().isSneaking()) {
        		this.petMenu.showMenu(e.getPlayer());
        		this.playerPet.put(e.getPlayer(), localPig);
        }
       }
            if((e.getRightClicked() instanceof Slime)) {
            	Slime localSlime = (Slime)e.getRightClicked();
            	if((localSlime.hasMetadata("petSlime")) && PetsType.HasPet(e.getPlayer()) && 
            		e.getPlayer().isSneaking()) {
            		this.petMenu.showMenu(e.getPlayer());
            		this.playerPet.put(e.getPlayer(), localSlime);
            }
        }
   }
  
  @EventHandler
  public void playerUseChat(AsyncPlayerChatEvent e)
    throws PetTypeException
  {
    Player p = e.getPlayer();
    if (this.hashOfPlayer.contains(p))
    {
      this.mapOfString.put(p, e.getMessage().replaceAll("&", "§"));
      e.setCancelled(true);
      UtilJsonBuilder jn = new UtilJsonBuilder("§cVocê trocou o nome do seu pet!")
        .withHoverEvent(UtilJsonBuilder.HoverAction.SHOW_TEXT, "§lNome: §e§l" + e.getMessage().replaceAll("&", "§"));
      ((CraftPlayer)p).getHandle().playerConnection.sendPacket(new PacketPlayOutChat(ChatSerializer.a(jn.toString())));
      p.playSound(p.getLocation(), Sound.ANVIL_USE, 1.0F, 1.0F);
      this.hashOfPlayer.remove(p);
      ((Entity)this.playerPet.get(p)).setCustomName((String)this.mapOfString.get(p));
    }
    if (this.arrayType.contains(p))
    {
      this.typesArray.add("BLACK");
      this.typesArray.add("BLACK_AND_WHITE");
      this.typesArray.add("BROWN");
      this.typesArray.add("GOLD");
      this.typesArray.add("SALT_AND_PEPPER");
      this.typesArray.add("THE_KILLER_BUNNY");
      this.typesArray.add("WHITE");
      e.setCancelled(true);
      this.mapOfString.put(p, e.getMessage());
      this.arrayType.remove(p);
      if (Pets.PetsType.HasPet(p))
      {
        if (!this.typesArray.contains(this.mapOfString.get(p)))
        {
          p.sendMessage(this.plugin.getMensagensConfig().getString("Coelho-Tipo-Error").replaceAll("<TIPO>", (String)this.mapOfString.get(p)));
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
          return;
        }
        try
        {
          ((Rabbit)Pets.PetsType.booleanRabbit.get(p.getUniqueId())).setRabbitType(Rabbit.Type.valueOf((String)this.mapOfString.get(p)));
          p.playSound(p.getLocation(), Sound.ANVIL_USE, 1.0F, 1.0F);
          UtilJsonBuilder jn = new UtilJsonBuilder(new String[] { "§cVocê mudou o tipo do seu pet!" })
            .withHoverEvent(UtilJsonBuilder.HoverAction.SHOW_TEXT, "§lTipo: §e§l" + (String)this.mapOfString.get(p));
          ((CraftPlayer)p).getHandle().playerConnection.sendPacket(new PacketPlayOutChat(ChatSerializer.a(jn.toString())));
        }
        catch (Exception ex)
        {
          p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
          throw new PetTypeException("Impossível encontrar o tipo de pet " + (String)this.mapOfString.get(p));
        }
      }
    }
    if(this.arraySlime.contains(p)) {
    	this.sizeArray.add("1");
    	this.sizeArray.add("2");
    	this.sizeArray.add("3");
    	e.setCancelled(true);
    	this.mapOfString.put(p, e.getMessage());
    	this.arrayType.remove(p);
    	if(Pets.PetsType.HasPet(p)) {
    		if(!this.sizeArray.contains(this.mapOfString.get(p))) {
    	       p.sendMessage("§cTamanho inválido!");
    	       p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
    	       return;
    		}try{
              (Pets.PetsType.booleanSlime.get(p.getUniqueId())).setSize(Integer.valueOf(this.mapOfString.get(p)));
              p.playSound(p.getLocation(), Sound.ANVIL_USE, 1.0F, 1.0F);
              UtilJsonBuilder jn = new UtilJsonBuilder(new String[] { "§cVocê mudou o tamanho do seu pet" })
                .withHoverEvent(UtilJsonBuilder.HoverAction.SHOW_TEXT, "§lTamanho §e§l" + (String)this.mapOfString.get(p));
              ((CraftPlayer)p).getHandle().playerConnection.sendPacket(new PacketPlayOutChat(ChatSerializer.a(jn.toString())));
            }
            catch (Exception ex)
            {
              p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
              throw new PetTypeException("Impossível encontrar o tipo de pet " + (String)this.mapOfString.get(p));
            }
          }
        }
    }
  
  @EventHandler
  public void onClickInParticlesMenu(InventoryClickEvent e)
  {
    if ((e.getInventory().getName().equalsIgnoreCase("§6§lPet Manager")) && ((e.getWhoClicked() instanceof Player)))
    {
      final Player p = (Player)e.getWhoClicked();
      e.setCancelled(true);
      e.setResult(Result.DENY);
      int slot = e.getSlot();
      if (slot == 0)
      {
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
        final UtilAnvilGUI gui = new UtilAnvilGUI(p, new UtilAnvilGUI.AnvilClickEventHandler() {
         @Override
           public void onAnvilClick(AnvilClickEvent event) {
             if(event.getSlot() == UtilAnvilGUI.AnvilSlot.OUTPUT){
                event.setWillClose(true);
                 event.setWillDestroy(true);
                 if(PetsType.HasPet(p)) {
                    UtilJsonBuilder jn = new UtilJsonBuilder("§cVocê trocou o nome do seu pet!")
                    .withHoverEvent(UtilJsonBuilder.HoverAction.SHOW_TEXT, "§lNome: §e§l" + event.getName().replaceAll("&", "§"));
                   ((CraftPlayer)p).getHandle().playerConnection.sendPacket(new PacketPlayOutChat(ChatSerializer.a(jn.toString())));
                   p.playSound(p.getLocation(), Sound.ANVIL_USE, 1.0F, 1.0F);
                   (playerPet.get(p)).setCustomName(event.getName().replaceAll("&", "§")); 
                    event.setWillClose(false);
                    event.setWillDestroy(false);
                    p.closeInventory();
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
       
        gui.setSlot(UtilAnvilGUI.AnvilSlot.INPUT_LEFT, i);
       
        gui.open();
}
      if (slot == 2)
      {
    	if(!PetsType.booleanRabbit.containsKey(p.getUniqueId())) {
            p.sendMessage("§lO seu pet deve ser um coelho para completar essa ação.");
    		return;
    	}
        this.arrayType.add(p);
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
        p.sendMessage("§lDigite no chat o tipo de coelho para salvar!");
        p.sendMessage("§lTipos disponíveis: ");
        p.sendMessage("§eBLACK§a, §eBLACK_AND_WHITE§a, §eBROWN§a, §eGOLD,");
        p.sendMessage("§eSALT_AND_PEPPER§a, §eTHE_KILLER_BUNNY§a, §eWHITE§a");
      }
      if(slot == 4)
      {
    	  if(!PetsType.booleanSlime.containsKey(p.getUniqueId())) {
    		p.sendMessage("§lO seu pet deve ser um Slime para completar essa ação.");
      		return;
    	  }
    	  this.arraySlime.add(p);
          p.closeInventory();
          p.playSound(p.getLocation(), Sound.ANVIL_LAND, 1.0F, 1.0F);
          p.sendMessage("§lDigite no chat o tamanho do Pet para salvar!");
          p.sendMessage("§lTamanhos disponíveis: ");
          p.sendMessage("§e1§a, §e2§a, §e3§a");
      }
    }
  }
}
