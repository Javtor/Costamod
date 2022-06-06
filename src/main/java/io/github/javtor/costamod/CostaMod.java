package io.github.javtor.costamod;

import io.github.javtor.costamod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class CostaMod implements ModInitializer {
	public static final String MODID = "costamod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing CostaMod");
		ModItems.registerModItems();

		GeckoLib.initialize();
	}
}
