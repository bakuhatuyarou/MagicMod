package MagicMod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "MagicMod", name = "MagicMod", version = "1.0")
public class MagicMod {

	//クリエイティブタブ作成
	public static final CreativeTabs magicModCreativeTab = new MagicModCreativeTab("MagicMod");

	//Block
	public static Block magicBlock;
	public static Block magicMass;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		//MagicBlock追加
		magicBlock = new MagicBlock();
		GameRegistry.registerBlock(magicBlock, "MagicBlock");
		LanguageRegistry.addName(magicBlock, "MagicBlock");

		//MagicMass追加
		magicMass = new MagicMass();
		GameRegistry.registerBlock(magicMass, "MagicMass");
		LanguageRegistry.addName(magicMass, "MagicMass");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event){

		//MagicBlock定型レシピ追加
		GameRegistry.addRecipe(new ItemStack(magicBlock),
				"DGD",
				"GRG",
				"DGD",
				'D',Items.diamond,
				'G',Items.gold_ingot,
				'R',Blocks.redstone_block
				);
	}
}
