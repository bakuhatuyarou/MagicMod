package MagicMod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

@Mod(modid = "MagicMod", name = "MagicMod", version = "1.0")
public class MagicMod {

	//クリエイティブタブ作成
	public static final CreativeTabs magicModCreativeTab = new MagicModCreativeTab("MagicMod");

	//Block
	public static Block magicBlock;
	public static Block magicMass;

	//Item
	public static Item magicDust;

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

		//MagicDust追加
		magicDust = new MagicDust();
		GameRegistry.registerItem(magicDust, "MagicDust");
		LanguageRegistry.addName(magicDust, "MagicDust");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		MinecraftForge.ORE_GEN_BUS.register(this);
	}
		＠SubscribeEvent
		public void generateOrePre(OreGenEvent.Pre event){
			WorldGenerator bedrockGen = new WorldGenMinable(Blocks.bedrock.getDefaultState(), 9);
			if(TerrainGen.generateOre(event.world, event.rand,bedrockGen, event.pos, OreGenEvent.GenerateMinable.EventType.CUSTOM))
				genStandardOre1(event.world, event.pos, 20, bedrockGen, 0, 96, event.rand);


		//MagicBlock定型レシピ追加
		GameRegistry.addRecipe(new ItemStack(magicBlock),
				"DGD",
				"GRG",
				"DGD",
				'D',Items.diamond,
				'G',Items.gold_ingot,
				'R',Blocks.redstone_block
				);
		GameRegistry.addRecipe(new ItemStack(magicMass),
				"MMM",
				"MDM",
				"MMM",
				'D',Items.diamond,
				'M',magicDust
				);
		}
}
