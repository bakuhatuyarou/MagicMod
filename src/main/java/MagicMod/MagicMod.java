package MagicMod;

import java.util.Random;

import MagicMod.blocks.MagicBlock;
import MagicMod.blocks.MagicDiamondBlock;
import MagicMod.blocks.MagicMass;
import MagicMod.blocks.MagicOre;
import MagicMod.items.MagicDiamond;
import MagicMod.items.MagicDust;
import MagicMod.items.MagicWand;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
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

	@SidedProxy(clientSide = "MagicMod.ClientProxy", serverSide = "MagicMod.CommonProxy")
	public static CommonProxy proxy;

	//クリエイティブタブ作成
	public static final CreativeTabs magicModCreativeTab = new MagicModCreativeTab("MagicMod");

	//Block
	public static Block magicBlock;
	public static Block magicMass;
	public static Block magicOre;
	public static Block magicDiamondBlock;

	//Item
	public static Item magicDust;
	public static Item magicWand;
	public static Item magicDiamond;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		//Messageの登録呼び出し
		PacketHandler.init();

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

		//MagicWand追加
		magicWand = new MagicWand();
		GameRegistry.registerItem(magicWand, "MagicWand");
		LanguageRegistry.addName(magicWand, "MagicWand");
		
		//MagicDiamond追加
		magicDiamond = new MagicDiamond();
		GameRegistry.registerItem(magicDiamond, "MagicDiamond");
		LanguageRegistry.addName(magicDiamond, "MagicDiamond");
		
		//MagicDiamondBlock追加
		magicDiamondBlock = new MagicDiamondBlock ();
		GameRegistry.registerBlock(magicDiamondBlock, "MagicDiamondBlock");
		LanguageRegistry.addName(magicDiamondBlock, "MagicDiamondBlock");
				
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event){

		//鉱石生成イベント登録
		MinecraftForge.ORE_GEN_BUS.register(this);

		//二箇所に登録するので、先にインスタンスを生成しておく。
		EntityPropertiesEventHandler entityPropertiesEventHandler = new EntityPropertiesEventHandler();
		//Forge Eventの登録。EntityEvent.EntityConstructingとLivingDeathEventとEntityJoinWorldEvent
		MinecraftForge.EVENT_BUS.register(entityPropertiesEventHandler);
		//FML Eventの登録。PlayerRespawnEvent
		FMLCommonHandler.instance().bus().register(entityPropertiesEventHandler);

		//MagicBlock定型レシピ追加
		GameRegistry.addRecipe(new ItemStack(magicBlock),
				"DGD",
				"GMG",
				"DGD",
				'D',Items.diamond,
				'G',Items.gold_ingot,
				'M',magicMass
				);
		GameRegistry.addRecipe(new ItemStack(magicMass),
				"MMM",
				"MDM",
				"MMM",
				'D',Items.diamond,
				'M',magicDust
				);
		GameRegistry.addRecipe(new ItemStack(magicWand),
				" DM",
				" GD",
				"G  ",
				'D',Items.diamond,
				'M',magicBlock,
				'G',Blocks.gold_block
				);
		GameRegistry.addRecipe(new ItemStack(magicDiamond),
				"MmM",
				"mDm",
				"MmM",
				'D',Items.diamond,
				'M',magicDust,
				'm',magicMass
				);
		GameRegistry.addRecipe(new ItemStack(magicDiamondBlock),
				"MMM",
				"MMM",
				"MMM",
				'M',magicDiamond
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
