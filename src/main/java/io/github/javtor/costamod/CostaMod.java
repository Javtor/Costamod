package io.github.javtor.costamod;

import io.github.javtor.costamod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CostaMod implements ModInitializer {
	public static final String MODID = "costamod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing CostaMod");
		ModItems.registerModItems();
	}
}
