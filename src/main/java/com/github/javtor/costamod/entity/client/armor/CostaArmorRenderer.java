package com.github.javtor.costamod.entity.client.armor;

import com.github.javtor.costamod.CostaMod;
import com.github.javtor.costamod.item.custom.CostaArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class CostaArmorRenderer extends GeoArmorRenderer<CostaArmorItem> {
    public CostaArmorRenderer() {
        super(new CostaArmorModel());

        CostaMod.LOGGER.info("Creating armor renderer");

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorLeftLeg";
        this.leftLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";



    }
}