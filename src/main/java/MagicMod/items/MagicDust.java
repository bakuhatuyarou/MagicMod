package MagicMod.items;

import MagicMod.MagicMod;
import net.minecraft.item.Item;

public class MagicDust extends Item{

	public MagicDust(){

		setCreativeTab(MagicMod.magicModCreativeTab);
		setUnlocalizedName("MagicDust");
		setTextureName("magicmod:MagicDust");
		setMaxStackSize(64);
		setHasSubtypes(false);
		setMaxDamage(0);
		setFull3D();
	}
}
