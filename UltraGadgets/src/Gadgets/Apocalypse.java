package Gadgets;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.server.v1_8_R3.EntityZombie;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Difficulty;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftZombie;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import Core.ParticleEffect;
import Core.Util18;
import Core.UtilCooldown;
import Core.UtilFireworkEffect;
import Core.UtilMath;

import com.floodeer.gadgets.Main;

public class Apocalypse implements Listener {
	
	Main plugin = Main.getMain();
	
	
	private String AttributeName = ChatColor.RED + "Ultra Zombie";
	public Zombie attributeGenericValues(Zombie paramZombie) {
		
		CraftZombie localZombie = ((CraftZombie)paramZombie);
		EntityZombie paramLiving = localZombie.getHandle();
		
		paramLiving.setBaby(false);
		paramLiving.setCustomNameVisible(true);
		paramLiving.setCustomName(AttributeName);
		return paramZombie;
	}
	
	
	@SuppressWarnings("deprecation")
	public void paramStartApocalypse(final Player paramPlayer) {
		
		final World paramWorld = paramPlayer.getWorld();
		final Location localLocation = paramPlayer.getLocation();
		final BukkitScheduler paramScheduler = Bukkit.getScheduler();
		
		final UtilFireworkEffect paramUtilFw = new UtilFireworkEffect();
		final Map<World, Long> time = new HashMap<World, Long>();
		final Map<World, Integer> difficulty = new HashMap<World, Integer>();
		time.put(paramWorld, paramWorld.getTime());
		paramWorld.setTime(22000);
		difficulty.put(paramWorld, paramWorld.getDifficulty().getValue());
		paramWorld.setDifficulty(Difficulty.HARD);
		paramWorld.playSound(localLocation, Sound.ENDERMAN_STARE, 120, -15F);
		paramWorld.setWeatherDuration(600);
		Util18.sendTitle(paramWorld.getPlayers().get(0), ChatColor.RED + "☠  Apocalypse ☠", ChatColor.RED + "Ativado por " + paramPlayer.getName() , 40, 80, 40);

		final BukkitTask task = paramScheduler.runTaskTimer(plugin, new Runnable() {
			
			@Override
			public void run() {
				final Location randomLocation = localLocation.add(UtilMath.random.nextInt(6), 1.3, UtilMath.random.nextInt(6));
				paramWorld.strikeLightningEffect(randomLocation);
				Zombie zombie = paramWorld.spawn(randomLocation, Zombie.class);
				attributeGenericValues(zombie);
				try{
					paramUtilFw.playFirework(paramPlayer.getWorld(), randomLocation.add(0, 2, 0), FireworkEffect.builder().withColor(Color.FUCHSIA).withColor(Color.WHITE).withFade(Color.WHITE).build());
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		}, 0, 40L);
		paramScheduler.scheduleSyncDelayedTask(plugin, new Runnable() {
			
			@Override
			public void run() {
				task.cancel();
				long it = time.get(paramWorld);
				int df = difficulty.get(paramWorld);
				paramWorld.setTime(it);
				paramWorld.setDifficulty(Difficulty.getByValue(df));
				paramWorld.setWeatherDuration(0);
				for(Entity ent : paramWorld.getEntities()) {
					if(ent instanceof Zombie) {
						if(ent.getName().equals(ChatColor.RED + "Ultra Zombie")) {
							ent.remove();
						}
					}
 				}
				try{
					paramUtilFw.playFirework(paramPlayer.getWorld(), paramPlayer.getLocation(), FireworkEffect.builder().withColor(Color.FUCHSIA).withColor(Color.WHITE).withFade(Color.WHITE).build());
		            ParticleEffect.EXPLOSION_HUGE.display(1.0F, 2.0F, 1.0F, 3.0F, 150, paramPlayer.getLocation(), 35.0D);
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
				
			}
		}, 30*20L);
	}
	
	//Desenvolvimento
	public void paramPlayerUseApocalypse(PlayerInteractEvent paramPlayerUseApocalypseEvent) {
	    Player paramPlayer = paramPlayerUseApocalypseEvent.getPlayer();
	    Action paramAction = paramPlayerUseApocalypseEvent.getAction();
	    if ((paramAction != Action.RIGHT_CLICK_AIR) && (paramAction != Action.RIGHT_CLICK_BLOCK)) {
	      return;
	    }
	    ItemStack paramItem = paramPlayer.getItemInHand();
	    if (this.plugin.getUtilBlock().usable(paramPlayerUseApocalypseEvent.getClickedBlock())) {
	      return;
	    }
	    if (this.plugin.getItem().isGadgetItem(paramItem, "teste")) {
	      if (UtilCooldown.tryCooldown(paramPlayer, "DiamondParty", this.plugin.getConfigFile().DiamondPartyCooldown))
	      {
	        paramStartApocalypse(paramPlayer);
	      }
	      else
	      {
	        long cooldown = UtilCooldown.getCooldown(paramPlayer, "DiamondParty") / 1000L;
	        plugin.getMessagesFile().sendCooldownMessage(paramPlayer, "Diamond Party", "DiamondParty", cooldown);
	        paramPlayer.playSound(paramPlayer.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
	        Util18.sendTitle(paramPlayer, 
	        plugin.getMessagesFile().titleMessage,
	        plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", Tipos.getPlayerGadget.get(paramPlayer)), 
	        plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
	      }
	    }
	  }
}
