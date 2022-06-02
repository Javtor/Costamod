package io.github.javtor.costamod.entity.client.armor;

import io.github.javtor.costamod.CostaMod;
import io.github.javtor.costamod.item.custom.CostaArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CostaArmorModel extends AnimatedGeoModel<CostaArmorItem> {
    @Override
    public Identifier getModelLocation(CostaArmorItem object) {
        return new Identifier(CostaMod.MODID, "geo/costa_armor.geo.json");
    }

    @Override
    public Identifier getTextureLocation(CostaArmorItem object) {
        return new Identifier(CostaMod.MODID, "textures/models/armor/costa_armor_texture.png");
    }

    @Override
    public Identifier getAnimationFileLocation(CostaArmorItem animatable) {
        return new Identifier(CostaMod.MODID, "animations/costa_armor.animation.json");
    }
}
