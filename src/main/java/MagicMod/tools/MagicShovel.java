package MagicMod.tools;

import net.minecraft.item.ItemSpade;
import MagicMod.MagicMod;

public class MagicShovel extends ItemSpade {

	//コンストラクタ
	public MagicShovel(ToolMaterial toolMaterial) {
		super(toolMaterial);
		setCreativeTab(MagicMod.magicModCreativeTab);
		setUnlocalizedName("MagicShovel");
		setTextureName("magicmod:Magic_shovel");
	}
}
