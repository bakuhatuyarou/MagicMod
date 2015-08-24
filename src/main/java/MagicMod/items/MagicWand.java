package MagicMod.items;

import MagicMod.MagicMod;
import net.minecraft.item.Item;

public class MagicWand extends Item{

	public MagicWand(){

		setCreativeTab(MagicMod.magicModCreativeTab);
		setUnlocalizedName("MagicWand");
		setTextureName("magicmod:MagicWand");
		setMaxStackSize(1);
		setHasSubtypes(false);
		setMaxDamage(0);
		setFull3D();
	}
}
