package io.github.javtor.costamod.entity;

import io.github.javtor.costamod.CostaMod;
import io.github.javtor.costamod.entity.custom.DiomedesEntity;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModEntities {



    public static final EntityType<DiomedesEntity> DIOMEDES = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(CostaMod.MODID, "diomedes"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, DiomedesEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.95f))
                    .trackRangeChunks(8)
                    .build()
    );

    public static void registerModEntities() {
        CostaMod.LOGGER.info("Registering entities");
        FabricDefaultAttributeRegistry.register(DIOMEDES, DiomedesEntity.createDiomedesAttributes());

    }
}
