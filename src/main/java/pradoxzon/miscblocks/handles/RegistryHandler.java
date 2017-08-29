package pradoxzon.miscblocks.handles;

import pradoxzon.miscblocks.init.BlockInit;
import pradoxzon.miscblocks.init.ItemInit;

public class RegistryHandler
{
	public static void Client()
	{
		ItemInit.register();
		BlockInit.registerRenders();
	}
	
	public static void Common()
	{
		ItemInit.init();
		BlockInit.init();
		BlockInit.register();
	}
}
