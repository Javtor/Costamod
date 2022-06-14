package io.github.javtor.costamod.world.gen;

import io.github.javtor.costamod.entity.ModEntities;
import io.github.javtor.costamod.entity.custom.DiomedesEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.mixin.object.builder.SpawnRestrictionAccessor;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;

public class ModEntitySpawn {

    public static void addEntitySpawn(){
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.BEACH),
                SpawnGroup.MONSTER, ModEntities.DIOMEDES, 100, 1, 1);

        SpawnRestrictionAccessor.callRegister(ModEntities.DIOMEDES, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, DiomedesEntity::canSpawn);
    }
}
