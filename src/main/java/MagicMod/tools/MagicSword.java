package MagicMod.tools;

import net.minecraft.item.ItemSword;
import MagicMod.MagicMod;

public class MagicSword extends ItemSword {

	//コンストラクタ
	public MagicSword(ToolMaterial toolMaterial) {
		super(toolMaterial);
		setCreativeTab(MagicMod.magicModCreativeTab);
		setUnlocalizedName("MagicSword");
		setTextureName("magicmod:Magic_sword");
	}
}
