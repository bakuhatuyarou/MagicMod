package MagicMod;

import net.minecraft.item.Item;

public class MagicDiamond extends Item {
	
	public MagicDiamond(){
	
		setCreativeTab(MagicMod.magicModCreativeTab);
		setUnlocalizedName("MagicDust");
		setTextureName("magicmod:MagicDiamond");
		setMaxStackSize(64);
		setHasSubtypes(false);
		setMaxDamage(0);
		setFull3D();
    }

}
