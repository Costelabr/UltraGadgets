package Gadgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.server.v1_8_R3.EntityArmorStand;
import net.minecraft.server.v1_8_R3.NBTTagCompound;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftArmorStand;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import br.com.floodeer.ultragadgets.UltraGadgets;
import Utils.Direction;
import Utils.UtilCooldown;
import Utils.UtilTitles;

public class Rainbow implements Listener {
	
	UltraGadgets plugin = UltraGadgets.getMain();
	private final Map<Player, List<Entity>> entitiesMap = new HashMap<Player, List<Entity>>();
	private final List<World> hasRainbow = new ArrayList<>();
	
	private void l(Location location, Material material, short durability, List<Entity> entities, Direction direction) {
	    Location l = location.clone();
	    a(l, material, durability, 2, 4, entities, direction);
	    a(l, material, durability, 3, 2, entities, direction);
	    a(l, material, durability, 4, 1, entities, direction);
	    a(l, material, durability, 10, 1, entities, direction);
	    a(l, material, durability, 1, 1, entities, direction);
	    b(l, material, durability, 10, 1, false, entities, direction);
	    b(l, material, durability, 4, 1, false, entities, direction);
	    b(l, material, durability, 3, 2, false, entities, direction);
	    b(l, material, durability, 2, 4, false, entities, direction);
	 }
	  
	  private void a(Location location, Material material, short durability, int items, int lines, List<Entity> entities, Direction direction) {
	    b(location, material, durability, items, lines, true, entities, direction);
	  }
	  
	  private void b(Location location, Material material, short durability, int items, int lines, boolean add, List<Entity> entities, Direction direction) {
	    World world = location.getWorld();
	    for (int i = 0; i < lines; i++) {
	      location.add(0.0D, (add ? 1 : -1) * 0.8D, 0.0D);
	      for (int j = 0; j < items; j++) {
	        location = location.add((direction == Direction.EAST ? 1 : -1) * -0.37D, 0.0D, (direction == Direction.NORTH ? 1 : -1) * -0.37D);
	        ArmorStand a  = (ArmorStand)((CraftWorld)world).spawn(location, ArmorStand.class, SpawnReason.CUSTOM);
	        a.setSmall(true);
	        ((CraftArmorStand)a).getHandle().setCustomNameVisible(false);
			EntityArmorStand standford = ((CraftArmorStand)a).getHandle();
			NBTTagCompound compound = new NBTTagCompound();
			compound.setBoolean("invulnerable", true);
			compound.setBoolean("PersistenceRequired", true);
			compound.setBoolean("Invisible", true);
			compound.setBoolean("NoGravity", true);
			standford.a(compound);
	        Item item = world.dropItem(location, plugin.getItemStack().create(material, (byte)durability));
	        item.setPickupDelay(Integer.MAX_VALUE);
	        item.setVelocity(new Vector(0, 0, 0));
	        a.setPassenger(item);
	        entities.add(a);
	        entities.add(item);
	      }
	    }
	  }
	  
	 @SuppressWarnings("deprecation")
	private List<Entity> createRainbow(Location location, Direction direction) {
	    Location copy = location.clone();
	    List<Entity> entities = new ArrayList<>();
	    byte[] colors = {
	    DyeColor.PINK.getWoolData(), 
	    DyeColor.PURPLE.getWoolData(),
	    DyeColor.LIGHT_BLUE.getWoolData(), 
	    DyeColor.LIME.getWoolData(),
	    DyeColor.YELLOW.getWoolData(),
	    DyeColor.ORANGE.getWoolData(),
        DyeColor.RED.getWoolData() 
    };
	    byte[] bytes;
	    int j = (bytes = colors).length;
	    for (int i = 0; i < j; i++) {
	      byte color = bytes[i];
	      l(copy.add(0.0D, 0.37D, 0.0D), Material.WOOL, color, entities, direction);
	    }
	    return entities;
	  }
	 
	 private boolean worldContainsRainbow(Player localPlayerWorld) {
		 World world = (World)localPlayerWorld.getWorld();
		 if(hasRainbow.contains(world)) {
			 localPlayerWorld.sendMessage(ChatColor.RED + "Já existe um Rainbow ativado neste mundo!");
			 return true;
		 }
		 return false;
	 }
	  
	  @EventHandler
	  public void paramPlayerActiveRainbow(PlayerInteractEvent paramPlayerActiveRainbowEvent)
	  {
	    final Player paramPlayer = paramPlayerActiveRainbowEvent.getPlayer();
	    Action paramAction = paramPlayerActiveRainbowEvent.getAction();
	    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
	      return;
	    }
	    ItemStack paramItem = paramPlayer.getItemInHand();
	    if (this.plugin.getUtilBlock().usable(paramPlayerActiveRainbowEvent.getClickedBlock())) {
	      return;
	    }
	    if (this.plugin.getItem().isGadgetItem(paramItem, plugin.getMessagesFile().rainbowGadgetName)) {
	    	if(worldContainsRainbow(paramPlayer)) {
	    		return;
	    	}
		    if(UtilCooldown.tryCooldown(paramPlayer, "Rainbow", plugin.getConfigFile().rainbowCooldown)) {
	        List<Entity> entitiesL = createRainbow(paramPlayer.getLocation(), Direction.getCardinalDirection(paramPlayer));
	        hasRainbow.add(paramPlayer.getWorld());
	        entitiesMap.put(paramPlayer, entitiesL);
	        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
				
				@Override
				public void run() {
					List<Entity> entities = entitiesMap.get(paramPlayer);
				    if (entities != null) {
				      for (Entity entity : entities) {
				        entity.remove();
				      }
				      hasRainbow.remove(paramPlayer.getWorld());
				    }
				}
			}, 20*20L);
	    }else{
	        long cooldown = UtilCooldown.getCooldown(paramPlayer, "Rainbow") / 1000L;
	        plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "Rainbow", "Rainbow", cooldown);
	        paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
	        UtilTitles.sendCooldownTitle(paramPlayer, 
	        plugin.getMessagesFile().titleMessage,
	        plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", Tipos.getPlayerGadget.get(paramPlayer)), 
	        plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
	 }
    }
  }
}
