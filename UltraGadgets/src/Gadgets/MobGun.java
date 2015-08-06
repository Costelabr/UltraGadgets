package Gadgets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Endermite;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.Horse;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import Core.FireworkNMSHandler;
import Core.ParticleEffect;
import Core.Util18;
import Core.UtilCooldown;
import Core.UtilEnt;
import Core.UtilMath;

import com.floodeer.gadgets.UltraGadgets;
 
public class MobGun extends FireworkNMSHandler
  implements Listener
{
  UltraGadgets plugin = UltraGadgets.getMain();
  HashMap<Player, Double> _time = new HashMap<>();
  HashMap<Player, BukkitRunnable> _cdRunnable = new HashMap<>();
  List<Entity> _entity = new ArrayList<Entity>();
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void paramPlayerUseMobGun(PlayerInteractEvent paramPlayerUseMovGunEvent)
  {
    final Player p = paramPlayerUseMovGunEvent.getPlayer();
    final Vector dir = p.getLocation().getDirection();
    ItemStack item = paramPlayerUseMovGunEvent.getItem();
    Action action = paramPlayerUseMovGunEvent.getAction();
    if (item == null) {
      return;
    }
    if (!item.hasItemMeta()) {
      return;
    }
    if(!item.getItemMeta().hasDisplayName()) {
    	return;
    }
    if (!item.getItemMeta().getDisplayName().startsWith("§6§lMob Gun §f§l- §b§l")) {
        return;
      }
    String mobName = item.getItemMeta().getDisplayName().replace("§6§lMob Gun §f§l- §b§l", "").replace(" §7(Clique para trocar)", "");
    if ((action.equals(Action.RIGHT_CLICK_AIR)) || 
      (action.equals(Action.RIGHT_CLICK_BLOCK))) {
    if(UtilCooldown.tryCooldown(p, "MobGun", 5000)) {
      this._time.put(p, Double.valueOf(3.1D));
      this._cdRunnable.put(p, new BukkitRunnable()
      {
        public void run()
        {
          _time.put(p, Double.valueOf(((Double)_time.get(p)).doubleValue() - 0.1D));
          if (((Double)_time.get(p)).doubleValue() < 0.01D)
          {
            _time.remove(p);
            _cdRunnable.remove(p);
            cancel();
          }
        }
      });
      p.getWorld().playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 5, -8);
      ((BukkitRunnable)this._cdRunnable.get(p)).runTaskTimer(this.plugin, 2L, 2L);
      if (mobName.equals("Porco"))
      {
        final Pig pig = (Pig)p.getWorld().spawnEntity(p.getLocation(), EntityType.PIG);
        _entity.add(pig);
        pig.getLocation().setDirection(dir);
        
        final Integer task = 
        
          Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
          {
            public void run()
            {
              pig.setVelocity(dir);
              ParticleEffect.REDSTONE.display(0,  0,  0, 1, 50, pig.getLocation(), 50);
            }
          }, 4L, 4L).getTaskId());
        
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            LaunchRandomFirework(pig.getLocation());
            _entity.remove(pig);
            pig.remove();
            Bukkit.getScheduler().cancelTask(task.intValue());
          }
        }, 60L);
      }
      else if (mobName.equals("Villager"))
      {
        final Villager villager = (Villager)p.getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
        _entity.add(villager);
        villager.getLocation().setDirection(dir);
        
        final Integer task = 
        
          Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
          {
            public void run()
            {
              villager.setVelocity(dir);
              ParticleEffect.REDSTONE.display(0,  0,  0, 1, 50, villager.getLocation(), 50);
            }
          }, 4L, 4L).getTaskId());
        
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            LaunchRandomFirework(villager.getLocation());
            _entity.remove(villager);
            villager.remove();
            Bukkit.getScheduler().cancelTask(task.intValue());
          }
        }, 60L);
      }
      else if (mobName.equals("Ocelot"))
      {
        final Ocelot ocelot = (Ocelot)p.getWorld().spawnEntity(p.getLocation(), EntityType.OCELOT);
        _entity.add(ocelot);
        ocelot.getLocation().setDirection(dir);
        
        final Integer task = 
        
          Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
          {
            public void run()
            {
              ocelot.setVelocity(dir);
              ParticleEffect.REDSTONE.display(0,  0,  0, 1, 50, ocelot.getLocation(), 50);
            }
          }, 4L, 4L).getTaskId());
        
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            LaunchRandomFirework(ocelot.getLocation());
            _entity.remove(ocelot);
            ocelot.remove();
            Bukkit.getScheduler().cancelTask(task.intValue());
          }
        }, 60L);
      }
      else if (mobName.equals("Vaca"))
      {
        final Cow cow = (Cow)p.getWorld().spawnEntity(p.getLocation(), EntityType.COW);
        _entity.add(cow);
        cow.getLocation().setDirection(dir);
        
        final Integer task = 
        
          Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
          {
            public void run()
            {
              cow.setVelocity(dir);
              ParticleEffect.REDSTONE.display(0,  0,  0, 1, 50, cow.getLocation(), 50);
            }
          }, 4L, 4L).getTaskId());
        
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            LaunchRandomFirework(cow.getLocation());
            _entity.remove(cow);
            cow.remove();
            Bukkit.getScheduler().cancelTask(task.intValue());
          }
        }, 60L);
      }
      else if (mobName.equals("Creeper"))
      {
        final Creeper creeper = (Creeper)p.getWorld().spawnEntity(p.getLocation(), EntityType.CREEPER);
        _entity.add(creeper);
        creeper.getLocation().setDirection(dir);
        
        final Integer task = 
        
          Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
          {
            public void run()
            {
              creeper.setVelocity(dir);
              ParticleEffect.REDSTONE.display(0,  0,  0, 1, 50, creeper.getLocation(), 50);
            }
          }, 4L, 4L).getTaskId());
        
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            LaunchRandomFirework(creeper.getLocation());
            _entity.remove(creeper);
            creeper.remove();
            Bukkit.getScheduler().cancelTask(task.intValue());
          }
        }, 60L);
      }
      else if (mobName.equals("Aranha"))
      {
        final Spider spider = (Spider)p.getWorld().spawnEntity(p.getLocation(), EntityType.SPIDER);
        _entity.add(spider);
        spider.getLocation().setDirection(dir);
        
        final Integer task = 
        
          Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
          {
            public void run()
            {
              spider.setVelocity(dir);
              ParticleEffect.REDSTONE.display(0,  0,  0, 1, 50, spider.getLocation(), 50);
            }
          }, 4L, 4L).getTaskId());
        
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            LaunchRandomFirework(spider.getLocation());
            _entity.remove(spider);
            spider.remove();
            Bukkit.getScheduler().cancelTask(task.intValue());
          }
        }, 60L);
      }
      else if (mobName.equals("Lula"))
      {
        final Squid squid = (Squid)p.getWorld().spawnEntity(p.getLocation(), EntityType.SQUID);
        _entity.add(squid);
        squid.getLocation().setDirection(dir);
        
        final Integer task = 
        
          Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
          {
            public void run()
            {
              squid.setVelocity(dir);
              ParticleEffect.REDSTONE.display(0,  0,  0, 1, 50, squid.getLocation(), 50);
            }
          }, 4L, 4L).getTaskId());
        
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            LaunchRandomFirework(squid.getLocation());
            _entity.remove(squid);
            squid.remove();
            Bukkit.getScheduler().cancelTask(task.intValue());
          }
        }, 60L);
      }
      else if (mobName.equals("Galinha"))
      {
        final Chicken chicken = (Chicken)p.getWorld().spawnEntity(p.getLocation(), EntityType.CHICKEN);
        _entity.add(chicken);
        chicken.getLocation().setDirection(dir);
        
        final Integer task = 
        
          Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
          {
            public void run()
            {
              chicken.setVelocity(dir);
              ParticleEffect.REDSTONE.display(0,  0,  0, 1, 50, chicken.getLocation(), 50);
            }
          }, 4L, 4L).getTaskId());
        
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            LaunchRandomFirework(chicken.getLocation());
            _entity.remove(chicken);
            chicken.remove();
            Bukkit.getScheduler().cancelTask(task.intValue());
          }
        }, 60L);
      }
      else if (mobName.equals("Ovelha"))
      {
        final Sheep sheep = (Sheep)p.getWorld().spawnEntity(p.getLocation(), EntityType.SHEEP);
        _entity.add(sheep);
        sheep.getLocation().setDirection(dir);
        
        final Integer task = 
        
          Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
          {
            public void run()
            {
              sheep.setVelocity(dir);
              ParticleEffect.REDSTONE.display(0,  0,  0, 1, 50, sheep.getLocation(), 50);
            }
          }, 4L, 4L).getTaskId());
        
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            LaunchRandomFirework(sheep.getLocation());
            _entity.remove(sheep);
            sheep.remove();
            Bukkit.getScheduler().cancelTask(task.intValue());
          }
        }, 60L);
      }
      else if (mobName.equals("Lobo"))
      {
        final Wolf wolf = (Wolf)p.getWorld().spawnEntity(p.getLocation(), EntityType.WOLF);
        _entity.add(wolf);
        wolf.getLocation().setDirection(dir);
        
        final Integer task = 
        
          Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
          {
            public void run()
            {
              wolf.setVelocity(dir);
              ParticleEffect.REDSTONE.display(0,  0,  0, 1, 50, wolf.getLocation(), 50);
            }
          }, 4L, 4L).getTaskId());
        
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            LaunchRandomFirework(wolf.getLocation());
            _entity.remove(wolf);
            wolf.remove();
            Bukkit.getScheduler().cancelTask(task.intValue());
          }
        }, 60L);
      }
      else if (mobName.equals("Slime"))
      {
        final Slime slime = (Slime)p.getWorld().spawnEntity(p.getLocation(), EntityType.SLIME);
        _entity.add(slime);
        slime.getLocation().setDirection(dir);
        slime.setSize(3);
        
        final Integer task = 
        
          Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
          {
            public void run()
            {
              slime.setVelocity(dir);
              ParticleEffect.REDSTONE.display(0,  0,  0, 1, 50, slime.getLocation(), 50);
            }
          }, 4L, 4L).getTaskId());
        
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            LaunchRandomFirework(slime.getLocation());
            _entity.remove(slime);
            slime.remove();
            Bukkit.getScheduler().cancelTask(task.intValue());
          }
        }, 60L);
      }
      else if (mobName.equals("Magma Cube"))
      {
        final MagmaCube magmaCube = (MagmaCube)p.getWorld().spawnEntity(p.getLocation(), EntityType.MAGMA_CUBE);
        _entity.add(magmaCube);
        magmaCube.getLocation().setDirection(dir);
        magmaCube.setSize(2);
        
        final Integer task = 
        
          Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
          {
            public void run()
            {
              magmaCube.setVelocity(dir);
              ParticleEffect.REDSTONE.display(0,  0,  0, 1, 50, magmaCube.getLocation(), 50);
            }
          }, 4L, 4L).getTaskId());
        
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            LaunchRandomFirework(magmaCube.getLocation());
            _entity.remove(magmaCube);
            magmaCube.remove();
            Bukkit.getScheduler().cancelTask(task.intValue());
          }
        }, 60L);
      }
      else if (mobName.equals("Cavalo"))
      {
        final Horse horse = (Horse)p.getWorld().spawnEntity(p.getLocation(), EntityType.HORSE);
        _entity.add(horse);
        horse.getLocation().setDirection(dir);
        
        final Integer task = 
        
          Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
          {
            public void run()
            {
              horse.setVelocity(dir);
              ParticleEffect.REDSTONE.display(0,  0,  0, 1, 50, horse.getLocation(), 50);
            }
          }, 4L, 4L).getTaskId());
        
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            LaunchRandomFirework(horse.getLocation());
            _entity.remove(horse);
            horse.remove();
            Bukkit.getScheduler().cancelTask(task.intValue());
          }
        }, 60L);
      }
      else if (mobName.equals("Zumbi"))
      {
        final Zombie zombie = (Zombie)p.getWorld().spawnEntity(p.getLocation(), EntityType.ZOMBIE);
        _entity.add(zombie);
        zombie.getLocation().setDirection(dir);
        
        final Integer task = 
        
          Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
          {
            public void run()
            {
              zombie.setVelocity(dir);
              ParticleEffect.REDSTONE.display(0,  0,  0, 1, 50, zombie.getLocation(), 50);
            }
          }, 4L, 4L).getTaskId());
        
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            LaunchRandomFirework(zombie.getLocation());
            _entity.remove(zombie);
            zombie.remove();
            Bukkit.getScheduler().cancelTask(task.intValue());
          }
        }, 60L);
      }
      else if (mobName.equals("Esqueleto"))
      {
        final Skeleton skeleton = (Skeleton)p.getWorld().spawnEntity(p.getLocation(), EntityType.SKELETON);
        _entity.add(skeleton);
        skeleton.getLocation().setDirection(dir);
        
        final Integer task = 
        
          Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
          {
            public void run()
            {
              skeleton.setVelocity(dir);
              ParticleEffect.REDSTONE.display(0,  0,  0, 1, 50, skeleton.getLocation(), 50);
            }
          }, 4L, 4L).getTaskId());
        
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            LaunchRandomFirework(skeleton.getLocation());
            _entity.remove(skeleton);
            skeleton.remove();
            Bukkit.getScheduler().cancelTask(task.intValue());
          }
        }, 60L);
      }
      else if (mobName.equals("Vaca Cogumelo"))
      {
        final MushroomCow mushroomCow = (MushroomCow)p.getWorld().spawnEntity(p.getLocation(), EntityType.MUSHROOM_COW);
        _entity.add(mushroomCow);
        mushroomCow.getLocation().setDirection(dir);
        
        final Integer task = 
        
          Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
          {
            public void run()
            {
              mushroomCow.setVelocity(dir);
              ParticleEffect.REDSTONE.display(0,  0,  0, 1, 50, mushroomCow.getLocation(), 50);
            }
          }, 4L, 4L).getTaskId());
        
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            LaunchRandomFirework(mushroomCow.getLocation());
            _entity.remove(mushroomCow);
            mushroomCow.remove();
            Bukkit.getScheduler().cancelTask(task.intValue());
          }
        }, 60L);
      }
      else if (mobName.equals("Aranha Venenosa"))
      {
        final CaveSpider caveSpider = (CaveSpider)p.getWorld().spawnEntity(p.getLocation(), EntityType.CAVE_SPIDER);
        _entity.add(caveSpider);
        caveSpider.getLocation().setDirection(dir);
        
        final Integer task = 
        
          Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
          {
            public void run()
            {
              caveSpider.setVelocity(dir);
              ParticleEffect.REDSTONE.display(0,  0,  0, 1, 50, caveSpider.getLocation(), 50);
            }
          }, 4L, 4L).getTaskId());
        
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            LaunchRandomFirework(caveSpider.getLocation());
            _entity.remove(caveSpider);
            caveSpider.remove();
            Bukkit.getScheduler().cancelTask(task.intValue());
          }
        }, 60L);
      }
      else if (mobName.equals("Endermite"))
      {
        final Endermite endermite = (Endermite)p.getWorld().spawnEntity(p.getLocation(), EntityType.ENDERMITE);
        _entity.add(endermite);
        endermite.getLocation().setDirection(dir);
        
        final Integer task = 
        
          Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
          {
            public void run()
            {
              endermite.setVelocity(dir);
              ParticleEffect.REDSTONE.display(0,  0,  0, 1, 50, endermite.getLocation(), 50);
            }
          }, 4L, 4L).getTaskId());
        
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            LaunchRandomFirework(endermite.getLocation());
            _entity.remove(endermite);
            endermite.remove();
            Bukkit.getScheduler().cancelTask(task.intValue());
          }
        }, 60L);
      }
      else if (mobName.equals("Coelho"))
      {
        final Rabbit rabbit = (Rabbit)p.getWorld().spawnEntity(p.getLocation(), EntityType.RABBIT);
        _entity.add(rabbit);
        rabbit.getLocation().setDirection(dir);
        
        final Integer task = 
        
          Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
          {
            public void run()
            {
              rabbit.setVelocity(dir);
              ParticleEffect.REDSTONE.display(0,  0,  0, 1, 50, rabbit.getLocation(), 50);
            }
          }, 4L, 4L).getTaskId());
        
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            LaunchRandomFirework(rabbit.getLocation());
            _entity.remove(rabbit);
            rabbit.remove();
            Bukkit.getScheduler().cancelTask(task.intValue());
          }
        }, 60L);
      }
      else if (mobName.equals("Guardian"))
      {
        final Guardian guardian = (Guardian)p.getWorld().spawnEntity(p.getLocation(), EntityType.GUARDIAN);
        _entity.add(guardian);
        guardian.getLocation().setDirection(dir);
        
        final Integer task = 
        
          Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
          {
            public void run()
            {
              guardian.setVelocity(dir);
              ParticleEffect.REDSTONE.display(0,  0,  0, 1, 50, guardian.getLocation(), 50);
            }
          }, 4L, 4L).getTaskId());
        
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            LaunchRandomFirework(guardian.getLocation());
            _entity.remove(guardian);
            guardian.remove();
            Bukkit.getScheduler().cancelTask(task.intValue());
          }
        }, 60L);
      }
      else if (mobName.equals("Porco Zumbi"))
      {
        final PigZombie pigZombie = (PigZombie)p.getWorld().spawnEntity(p.getLocation(), EntityType.PIG_ZOMBIE);
        _entity.add(pigZombie);
        pigZombie.getLocation().setDirection(dir);
        
        final Integer task = 
        
          Integer.valueOf(Bukkit.getScheduler().runTaskTimer(this.plugin, new Runnable()
          {
            public void run()
            {
              pigZombie.setVelocity(dir);
              ParticleEffect.REDSTONE.display(0,  0,  0, 1, 50, pigZombie.getLocation(), 50);
            }
          }, 4L, 4L).getTaskId());
        
        Bukkit.getScheduler().runTaskLater(this.plugin, new Runnable()
        {
          public void run()
          {
            LaunchRandomFirework(pigZombie.getLocation());
            _entity.remove(pigZombie);
            pigZombie.remove();
            Bukkit.getScheduler().cancelTask(task.intValue());
          }
        }, 60L);
      }
    }else{
         long cooldown = UtilCooldown.getCooldown(p, "MobGun") / 1000L;
    	 plugin.getMessagesFile().sendCooldownMessage(p, "Mob Gun", "MobGun", 3000);
         p.playSound(p.getLocation(), Sound.valueOf(plugin.getConfig().getString("Som-Cooldown")), 1, 1);
         Util18.sendTitle(p, 
         plugin.getMessagesFile().titleMessage,
         plugin.getMessagesFile().subTitleMessage.replaceAll("<COOLDOWN>", String.valueOf(cooldown)).replaceAll("<GADGET>", "MobGun"), 
         plugin.getConfig().getInt("FadeIn-Title-Time"), plugin.getConfig().getInt("FadeStay-Title-Time"), plugin.getConfig().getInt("FadeOut-Title-Time"));
    }
   }
    else if ((action.equals(Action.LEFT_CLICK_AIR)) || 
      (action.equals(Action.LEFT_CLICK_BLOCK)))
    {
      p.updateInventory();
      ItemMeta itemMeta = item.getItemMeta();
      if (mobName.equals("Porco"))
      {
        itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lVillager §7(Clique para trocar)");
        item.setItemMeta(itemMeta);
      }
      else if (mobName.equals("Villager"))
      {
        itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lOcelot §7(Clique para trocar)");
        item.setItemMeta(itemMeta);
      }
      else if (mobName.equals("Ocelot"))
      {
        itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lVaca §7(Clique para trocar)");
        item.setItemMeta(itemMeta);
      }
      else if (mobName.equals("Vaca"))
      {
        itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lCreeper §7(Clique para trocar)");
        item.setItemMeta(itemMeta);
      }
      else if (mobName.equals("Creeper"))
      {
        itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lAranha §7(Clique para trocar)");
        item.setItemMeta(itemMeta);
      }
      else if (mobName.equals("Aranha"))
      {
        itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lLula §7(Clique para trocar)");
        item.setItemMeta(itemMeta);
      }
      else if (mobName.equals("Lula"))
      {
        itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lGalinha §7(Clique para trocar)");
        item.setItemMeta(itemMeta);
      }
      else if (mobName.equals("Galinha"))
      {
        itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lOvelha §7(Clique para trocar)");
        item.setItemMeta(itemMeta);
      }
      else if (mobName.equals("Ovelha"))
      {
        itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lLobo §7(Clique para trocar)");
        item.setItemMeta(itemMeta);
      }
      else if (mobName.equals("Lobo"))
      {
        itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lSlime §7(Clique para trocar)");
        item.setItemMeta(itemMeta);
      }
      else if (mobName.equals("Slime"))
      {
        itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lMagma Cube §7(Clique para trocar)");
        item.setItemMeta(itemMeta);
      }
      else if (mobName.equals("Magma Cube"))
      {
        itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lCavalo §7(Clique para trocar)");
        item.setItemMeta(itemMeta);
      }
      else if (mobName.equals("Cavalo"))
      {
        itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lZumbi §7(Clique para trocar)");
        item.setItemMeta(itemMeta);
      }
      else if (mobName.equals("Zumbi"))
      {
        itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lEsqueleto §7(Clique para trocar)");
        item.setItemMeta(itemMeta);
      }
      else if (mobName.equals("Esqueleto"))
      {
        itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lVaca Cogumelo §7(Clique para trocar)");
        item.setItemMeta(itemMeta);
      }
      else if (mobName.equals("Vaca Cogumelo"))
      {
        itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lAranha Venenosa §7(Clique para trocar)");
        item.setItemMeta(itemMeta);
      }
      else if (mobName.equals("Aranha Venenosa"))
      {
        itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lPorco Zumbi §7(Clique para trocar)");
        item.setItemMeta(itemMeta);
      }
      else if (mobName.equals("Porco Zumbi"))
      {
        itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lCoelho §7(Clique para trocar)");
        item.setItemMeta(itemMeta);
      }
      else if (mobName.equals("Coelho"))
      {
        itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lGuardian §7(Clique para trocar)");
        item.setItemMeta(itemMeta);
      }
      else if (mobName.equals("Guardian"))
      {
        itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lEndermite §7(Clique para trocar)");
        item.setItemMeta(itemMeta);
      }
      else if(mobName.equals("Endermite")) {
    	  itemMeta.setDisplayName("§6§lMob Gun §f§l- §b§lPorco §7(Clique para trocar)");
          item.setItemMeta(itemMeta);
      }
    }
  }
  
  public void LaunchRandomFirework(Location location)
  {

	  try {
	     ParticleEffect.EXPLOSION_NORMAL.display(0, 0, 0, 1, 250, location, 50);
	     Vector v = new Vector(UtilMath.randomRange(-0.5D, 0.5D), UtilMath.randomRange(0.50000000298023224D, 1.2D), UtilMath.randomRange(-0.5D, 0.5D));
	     UtilEnt.itemToRemove(location, Material.BONE, (byte)0, 2, true, v);
	     location.getWorld().playSound(location, Sound.EXPLODE, 5, 1);
		  playFirework(location, FireworkEffect.builder().withColor(Color.RED).with(Type.BALL_LARGE).withColor(Color.WHITE).withColor(Color.BLACK).withFade(Color.WHITE).build());
	} catch (Exception e) {		
		e.printStackTrace();
	}
  }
  
  @EventHandler
  public void onMob(EntityDamageEvent e) {
	  if(_entity.contains(e.getEntity())) {
		  e.setCancelled(true);
	  }
  }
  
  @EventHandler
  public void onDamage(EntityDamageByEntityEvent e) {
	  if(_entity.contains(e.getDamager())) {
		  e.setCancelled(true);
	  }
  }
  
  @EventHandler
  public void onTarget(EntityTargetLivingEntityEvent e) {
	  if(_entity.contains(e.getEntity())) {
		  e.setCancelled(true);
	  }
    }
  
  @EventHandler
  public void onFire(EntityCombustEvent e) {
	  if(_entity.contains(e.getEntity())) {
		  e.setCancelled(true);
	  }
  }
}
