package MagicMod.tools;

import net.minecraft.item.ItemPickaxe;
import MagicMod.MagicMod;

public class MagicPickaxe extends ItemPickaxe{

	//コンストラクタ
	public MagicPickaxe(ToolMaterial toolMaterial) {
		super(toolMaterial);
		setCreativeTab(MagicMod.magicModCreativeTab);
		setUnlocalizedName("MagicPickaxe");
		setTextureName("magicmod:Magic_pickaxe");
	}
}
