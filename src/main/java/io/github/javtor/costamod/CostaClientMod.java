package io.github.javtor.costamod;

import io.github.javtor.costamod.entity.client.ModRenderers;
import io.github.javtor.costamod.entity.client.armor.CostaArmorRenderer;
import io.github.javtor.costamod.item.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.entity.SpawnGroup;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class CostaClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        GeoArmorRenderer.registerArmorRenderer(new CostaArmorRenderer(), ModItems.SOMBRERO_VUELTIAO,
                ModItems.CAMISETA_JUNIOR);
        CostaMod.LOGGER.info("registering mod renderers");
        ModRenderers.registerModRenderers();

    }
}
