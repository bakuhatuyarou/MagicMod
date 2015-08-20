package MagicMod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class MagicModRecipe {
	
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
    }
 
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
 
        GameRegistry.addRecipe(new ItemStack(Blocks.MagicBlockCore),
                "#",
                "#",
                "#",
                '#', Blocks.dirt
        );
        

}
}
