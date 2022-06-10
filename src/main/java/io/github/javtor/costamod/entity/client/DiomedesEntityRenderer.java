package io.github.javtor.costamod.entity.client;

import io.github.javtor.costamod.CostaMod;
import io.github.javtor.costamod.entity.custom.DiomedesEntity;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class DiomedesEntityRenderer extends BipedEntityRenderer<DiomedesEntity, DiomedesEntityModel> {
    public DiomedesEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new DiomedesEntityModel(ctx.getPart(ModRenderers.MODEL_DIOMEDES_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(DiomedesEntity mobEntity) {
        return new Identifier(CostaMod.MODID, "textures/entity/diomedes.png");
    }
}
