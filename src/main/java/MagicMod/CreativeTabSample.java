package MagicMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabSample extends CreativeTabs
{
	public CreativeTabSample(String label)
	{
		super(label);
	}
 
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		return MagicModCT.itemSample;
	}
 
	@Override
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel()
	{
		return "TabSample";
	}
 
}
