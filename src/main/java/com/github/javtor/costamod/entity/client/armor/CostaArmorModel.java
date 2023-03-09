package com.github.javtor.costamod.entity.client.armor;

import com.github.javtor.costamod.CostaMod;
import com.github.javtor.costamod.item.custom.CostaArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.example.client.EntityResources;
import software.bernie.example.item.GeckoArmorItem;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CostaArmorModel extends AnimatedGeoModel<CostaArmorItem> {
    @Override
    public ResourceLocation getModelResource(CostaArmorItem object) {
        CostaMod.LOGGER.info("Getting model resource");
        return new ResourceLocation(CostaMod.MOD_ID,
                "geo/costa_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CostaArmorItem object) {
        CostaMod.LOGGER.info("Getting texture resource");
        return new ResourceLocation(CostaMod.MOD_ID,
                "textures/models/armor/costa_armor_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CostaArmorItem animatable) {
        CostaMod.LOGGER.info("Getting animation resource");
        return new ResourceLocation(CostaMod.MOD_ID,
                "animations/costa_armor.animation.json");
    }
}