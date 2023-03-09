package com.github.javtor.costamod.event;

import com.github.javtor.costamod.CostaMod;
import com.github.javtor.costamod.entity.client.armor.CostaArmorRenderer;
import com.github.javtor.costamod.item.custom.CostaArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = CostaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {

    @SubscribeEvent
    public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event) {
        CostaMod.LOGGER.info("Registering armor renderers");
        GeoArmorRenderer.registerArmorRenderer(CostaArmorItem.class,
                () -> new CostaArmorRenderer());
    }
}
