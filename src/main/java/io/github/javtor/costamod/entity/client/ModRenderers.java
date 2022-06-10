package io.github.javtor.costamod.entity.client;

import io.github.javtor.costamod.CostaMod;
import io.github.javtor.costamod.entity.ModEntities;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModRenderers {

    public static final EntityModelLayer MODEL_DIOMEDES_LAYER =
            new EntityModelLayer(new Identifier(CostaMod.MODID, "diomedes"), "main");

    public static void registerModRenderers() {

        EntityRendererRegistry.register(ModEntities.DIOMEDES, DiomedesEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(MODEL_DIOMEDES_LAYER, DiomedesEntityModel::getTexturedModelData);

    }
}
