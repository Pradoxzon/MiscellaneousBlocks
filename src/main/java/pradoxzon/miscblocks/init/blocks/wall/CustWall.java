package pradoxzon.miscblocks.init.blocks.wall;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class CustWall extends BlockWall
{
	public static final PropertyEnum<CustWall.EnumType> VARIANT = PropertyEnum.<CustWall.EnumType>create("variant", CustWall.EnumType.class);
	
	public CustWall(String name, String texture, float hardness, float resistance, String tool, int harvestLevel)
	{
		super(Block.REGISTRY.getObject(new ResourceLocation(texture)));
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(hardness);
		setResistance(resistance);
		setHarvestLevel(tool, harvestLevel);
		setCreativeTab(CreativeTabs.DECORATIONS);
	}
	
	public String getLocalizedName()
	{
		return this.getUnlocalizedName();
	}
	
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	{
		items.add(new ItemStack(this));
	}
	
	public int damageDropped(IBlockState state)
	{
		return 0;
	}
	
	public static enum EnumType implements IStringSerializable
    {
        OAK(0, "oak", "oak");
        //BIRCH(1, "birch", "birch");

        private static final CustWall.EnumType[] META_LOOKUP = new CustWall.EnumType[values().length];
        private final int meta;
        private final String name;
        private final String unlocalizedName;

        private EnumType(int meta, String name, String unlocalizedName)
        {
            this.meta = meta;
            this.name = name;
            this.unlocalizedName = unlocalizedName;
        }

        public int getMetadata()
        {
            return this.meta;
        }

        public String toString()
        {
            return this.name;
        }

        public static CustWall.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName()
        {
            return this.name;
        }

        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }

        static
        {
            for (CustWall.EnumType woodwall$enumtype : values())
            {
                META_LOOKUP[woodwall$enumtype.getMetadata()] = woodwall$enumtype;
            }
        }
    }
}
