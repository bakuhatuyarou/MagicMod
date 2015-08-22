package MagicMod;

import java.util.Random;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
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
	public static Block magicOre;

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
		
		//MagicOre追加
		magicOre = new MagicOre ();
		GameRegistry.registerBlock(magicOre, "MagicOre");
		LanguageRegistry.addName(magicOre, "MagicOre");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event){

		//イベント登録
		MinecraftForge.ORE_GEN_BUS.register(this);

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

	@SubscribeEvent
	public void generateOrePre(OreGenEvent.Pre event){

		WorldGenerator bedrockGen = new WorldGenMinable(magicOre, 9);
		if(TerrainGen.generateOre(event.world, event.rand,bedrockGen, event.worldX, event.worldZ , OreGenEvent.GenerateMinable.EventType.CUSTOM))
			genStandardOre1(event.world, event.worldX, event.worldZ, 20, bedrockGen, 0, 96, event.rand);
	}
	protected void genStandardOre1(World world, int x, int z, int size, WorldGenerator generator, int minY, int maxY, Random rnd){
		int l;

		if(maxY < minY){
			l = minY;
			minY = maxY;
			maxY = l;
		}else if(maxY == minY){
			if(minY < 255){
				++maxY;
			}else{
				--minY;
			}
		}

		for(l = 0; l < size; ++l){
			generator.generate(world, rnd, x+rnd.nextInt(16), rnd.nextInt(maxY - minY) + minY, z+rnd.nextInt(16));
		}
	}
}
