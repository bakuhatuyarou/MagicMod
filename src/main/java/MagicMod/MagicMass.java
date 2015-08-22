package MagicMod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MagicMass extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon TopIcon;

	@SideOnly(Side.CLIENT)
	private IIcon SideIcon;

	public MagicMass() {

		super(Material.rock);
		setCreativeTab(MagicMod.magicModCreativeTab);/*クリエイティブタブの選択*/
		setBlockName("MagicMass");/*システム名の設定*/
		setBlockTextureName("magicmod:MagicMass");/*ブロックのテクスチャの指定(複数指定の場合は消してください)*/
		/*以下のものは消しても結構です*/
		setHardness(2.0F);/*硬さ*/
		setResistance(2.5F);/*爆破耐性*/
		setStepSound(Block.soundTypeStone);/*ブロックの上を歩いた時の音*/
		/*setBlockUnbreakable();*//*ブロックを破壊不可に設定*/
		/*setTickRandomly(true);*//*ブロックのtick処理をランダムに。デフォルトfalse*/
		/*disableStats();*//*ブロックの統計情報を保存しない*/
		setLightOpacity(1);/*ブロックの透過係数。デフォルト０（不透過）*/
		setLightLevel(0.3F);/*明るさ 1.0F = 15*/
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float posX, float posY, float posZ){
		//TODO: ブロックを右クリックした際の動作
		return false;
	}

	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player){
		//TODO: ブロックを左クリックした際の動作
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighborBlock){
		//TODO: 周囲のブロックが更新された際の動作
	}

	@Override
	public int quantityDropped(int meta, int fortune, Random random){
		//TODO: ドロップするアイテムを返す
		return quantityDroppedWithBonus(fortune, random);
	}

	@Override
	public int quantityDropped(Random random){
		//TODO: ドロップさせる量を返す
		return 1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister){
		this.TopIcon = par1IconRegister.registerIcon("magicmod:MagicMass");
		this.SideIcon = par1IconRegister.registerIcon("magicmod:MagicMass");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2){
		if(par1 == 0 || par1 == 1){
				return TopIcon;
		}
		else{
				return SideIcon;
		}
	}

	public Item setCreativeTab(MagicModCreativeTab tabssample) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
