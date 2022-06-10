package io.github.javtor.costamod.entity.client;

import io.github.javtor.costamod.entity.custom.DiomedesEntity;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.AbstractZombieModel;
import net.minecraft.client.render.entity.model.BipedEntityModel;

public class DiomedesEntityModel extends AbstractZombieModel<DiomedesEntity> {

    public DiomedesEntityModel(ModelPart modelPart) {
        super(modelPart);
    }

    @Override
    public boolean isAttacking(DiomedesEntity entity) {
        return entity.isAttacking();
    }

    public static TexturedModelData getTexturedModelData() {
        return TexturedModelData.
                of(BipedEntityModel.getModelData(Dilation.NONE, 0.0f), 64, 64);
    }
}
