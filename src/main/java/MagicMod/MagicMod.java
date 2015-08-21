package MagicMod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

@Mod(modid = "MagicMod", name = "MagicMod", version = "1.0")
public class MagicMod {

	public static Block magicBlock;
	public static Block MagicMass;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		magicBlock = new MagicBlock();

		GameRegistry.registerBlock(magicBlock, "MagicBlock");

		MagicMass = new MagicMass();

		GameRegistry.registerBlock(MagicMass, "MagicMass");

	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event){

		//レシピ追加
		GameRegistry.addRecipe(new ItemStack(magicBlock),
				"DGD",
				"GRG",
				"DGD",
				'D',Items.diamond,
				'G',Items.gold_ingot,
				'R',Blocks.redstone_block
				);
		GameRegistry.addRecipe(new ItemStack(MagicMass),
				"DD",
				"DD",
				'D',Blocks.dirt
				);
	}

}
