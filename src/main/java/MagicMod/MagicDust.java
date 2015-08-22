package MagicMod;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class MagicDust {
	
	public static Item MagicDust;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		
		//アイテムインスタンス化
		MagicDust = new Item()
		.setCreativeTab(MagicMod.magicModCreativeTab)
		.setUnlocalizedName("MagicDust")
		.setTextureName("magicmod:MagicDust")
		.setMaxStackSize(64)
		.setHasSubtypes(false)
		.setMaxDamage(0)
		.setFull3D();
		
		
		GameRegistry.registerItem(MagicDust, "MagicDust");
		
	}

}
