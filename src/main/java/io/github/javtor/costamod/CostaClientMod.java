package io.github.javtor.costamod;

import io.github.javtor.costamod.entity.client.armor.CostaArmorRenderer;
import io.github.javtor.costamod.item.ModItems;
import net.fabricmc.api.ClientModInitializer;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class CostaClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        GeoArmorRenderer.registerArmorRenderer(new CostaArmorRenderer(), ModItems.SOMBRERO_VUELTIAO,
                ModItems.CAMISETA_JUNIOR);

    }
}
