package pradoxzon.miscblocks.init;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import pradoxzon.miscblocks.Reference;
import pradoxzon.miscblocks.init.blocks.wall.CustWall;

public class BlockInit
{
	public static Block oak_wall;
	public static Block birch_wall;
	
	public static void init()
	{
		oak_wall = new CustWall("oak_wall", "planks", 2.5f, 4.5f, "axe", 0);
		birch_wall = new CustWall("birch_wall", "planks", 2.5f, 4.5f, "axe", 0);
	}
	
	public static void register()
	{
		registerBlock(oak_wall);
		registerBlock(birch_wall);
	}
	
	public static void registerBlock(Block block)
	{
		ForgeRegistries.BLOCKS.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(item);
	}
	
	public static void registerRenders()
	{
		registerWallRender(oak_wall);
		registerWallRender(birch_wall);
	}
	
	public static void registerRender(Block block)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(Item.getItemFromBlock(block), 0, 
				new ModelResourceLocation(Reference.MODID + ":" + block.getUnlocalizedName().substring(5)));
	}
	
	public static void registerWallRender(Block block)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, 
				new ModelResourceLocation(Reference.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	}
}
