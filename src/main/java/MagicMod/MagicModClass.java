package MagicMod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="MagicMod",name="MagicMod",version="1.0")

public class MagicModClass {

	public static MagicModClass MagicMod;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){

		MagicMod = new MagicModClass();

				GameRegistry.registerBlock(MagicMod, "MagicModClass");

}
}

