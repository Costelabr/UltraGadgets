package Util;

import java.util.HashSet;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class UtilItem
{
  private static HashSet<Material> _axeSet = new HashSet<>();
  private static HashSet<Material> _swordSet = new HashSet<>();
  private static HashSet<Material> _maulSet = new HashSet<>();
  private static HashSet<Material> pickSet = new HashSet<>();
  private static HashSet<Material> diamondSet = new HashSet<>();
  private static HashSet<Material> goldSet = new HashSet<>();
  
  public boolean isGadgetItem(ItemStack is, String nome)
  {
    try
    {
      if (!is.hasItemMeta()) {
        return false;
      }
      if (!is.getItemMeta().hasDisplayName()) {
        return false;
      }
      if (is.getItemMeta().getDisplayName().equalsIgnoreCase(nome)) {
        return true;
      }
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static boolean isAxe(ItemStack paramItemStack)
  {
    if (paramItemStack == null) {
      return false;
    }
    if (_axeSet.isEmpty())
    {
      _axeSet.add(Material.WOOD_AXE);
      _axeSet.add(Material.STONE_AXE);
      _axeSet.add(Material.IRON_AXE);
      _axeSet.add(Material.GOLD_AXE);
      _axeSet.add(Material.DIAMOND_AXE);
    }
    return _axeSet.contains(paramItemStack.getType());
  }
  
  public static boolean isSword(ItemStack paramItemStack)
  {
    if (paramItemStack == null) {
      return false;
    }
    if (_swordSet.isEmpty())
    {
      _swordSet.add(Material.WOOD_SWORD);
      _swordSet.add(Material.STONE_SWORD);
      _swordSet.add(Material.IRON_SWORD);
      _swordSet.add(Material.GOLD_SWORD);
      _swordSet.add(Material.DIAMOND_SWORD);
    }
    return _swordSet.contains(paramItemStack.getType());
  }
  
  public static boolean isShovel(ItemStack paramItemStack)
  {
    if (paramItemStack == null) {
      return false;
    }
    if (_maulSet.isEmpty())
    {
      _maulSet.add(Material.WOOD_SPADE);
      _maulSet.add(Material.STONE_SPADE);
      _maulSet.add(Material.IRON_SPADE);
      _maulSet.add(Material.GOLD_SPADE);
      _maulSet.add(Material.DIAMOND_SPADE);
    }
    return _maulSet.contains(paramItemStack.getType());
  }
  
  public HashSet<Material> scytheSet = new HashSet<>();
  
  public boolean isHoe(ItemStack paramItemStack)
  {
    if (paramItemStack == null) {
      return false;
    }
    if (this.scytheSet.isEmpty())
    {
      this.scytheSet.add(Material.WOOD_HOE);
      this.scytheSet.add(Material.STONE_HOE);
      this.scytheSet.add(Material.IRON_HOE);
      this.scytheSet.add(Material.GOLD_HOE);
      this.scytheSet.add(Material.DIAMOND_HOE);
    }
    return this.scytheSet.contains(paramItemStack.getType());
  }
  
  public boolean isPickaxe(ItemStack paramItemStack)
  {
    if (paramItemStack == null) {
      return false;
    }
    if (pickSet.isEmpty())
    {
      pickSet.add(Material.WOOD_PICKAXE);
      pickSet.add(Material.STONE_PICKAXE);
      pickSet.add(Material.IRON_PICKAXE);
      pickSet.add(Material.GOLD_PICKAXE);
      pickSet.add(Material.DIAMOND_PICKAXE);
    }
    return pickSet.contains(paramItemStack.getType());
  }
  
  public boolean isDiamond(ItemStack paramItemStack)
  {
    if (paramItemStack == null) {
      return false;
    }
    if (diamondSet.isEmpty())
    {
      diamondSet.add(Material.DIAMOND_SWORD);
      diamondSet.add(Material.DIAMOND_AXE);
      diamondSet.add(Material.DIAMOND_SPADE);
      diamondSet.add(Material.DIAMOND_HOE);
    }
    return diamondSet.contains(paramItemStack.getType());
  }
  
  public static boolean isGold(ItemStack paramItemStack)
  {
    if (paramItemStack == null) {
      return false;
    }
    if (goldSet.isEmpty())
    {
      goldSet.add(Material.GOLD_SWORD);
      goldSet.add(Material.GOLD_AXE);
    }
    return goldSet.contains(paramItemStack.getType());
  }
  
  public static boolean isBow(ItemStack paramItemStack)
  {
    if (paramItemStack == null) {
      return false;
    }
    return paramItemStack.getType() == Material.BOW;
  }
  
  public static boolean isWeapon(ItemStack paramItemStack)
  {
    return (isAxe(paramItemStack)) || (isSword(paramItemStack));
  }
  
  public static boolean isMat(ItemStack paramItemStack, Material paramMaterial)
  {
    if (paramItemStack == null) {
      return false;
    }
    return paramItemStack.getType() == paramMaterial;
  }
  
  public static boolean isRepairable(ItemStack paramItemStack)
  {
    return paramItemStack.getType().getMaxDurability() > 0;
  }
}
