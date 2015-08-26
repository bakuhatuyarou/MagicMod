package MagicMod.tools;

import net.minecraft.item.ItemAxe;
import MagicMod.MagicMod;

public class MagicAxe extends ItemAxe {

	//コンストラクタ
	public MagicAxe(ToolMaterial toolMaterial) {
		super(toolMaterial);
		setCreativeTab(MagicMod.magicModCreativeTab);
		setUnlocalizedName("MagicAxe");
		setTextureName("magicmod:Magic_axe");
	}

}
