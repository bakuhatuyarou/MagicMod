package MagicMod;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MagicModCreativeTab {

	public static final CreativeTabs tabsSample = new CreativeTabSample("Sample");

	public static Item itemSample;

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		itemSample = (new MagicModCreativeTab(7000)).setCreativeTab(tabsSample);

		LanguageRegistry.addName(itemSample, "CreativeTabSample");
	}
}


