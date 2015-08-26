package MagicMod.tools;

import net.minecraft.item.ItemHoe;
import MagicMod.MagicMod;

public class MagicHoe extends ItemHoe {

	//コンストラクタ
	public MagicHoe(ToolMaterial toolMaterial) {
		super(toolMaterial);
		setCreativeTab(MagicMod.magicModCreativeTab);
		setUnlocalizedName("MagicHoe");
		setTextureName("magicmod:Magic_hoe");
	}
}
