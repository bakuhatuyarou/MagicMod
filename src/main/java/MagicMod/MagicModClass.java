package MagicMod;

import net.minecraft.block.Block;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "MagicMod", name = "MagicMod", version = "1.0")
public class MagicModClass {

	public static Block magicBlock;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		magicBlock = new MagicBlock();

		GameRegistry.registerBlock(magicBlock, "MagicBlock");

	}
}
