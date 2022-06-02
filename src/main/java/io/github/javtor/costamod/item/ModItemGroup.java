package io.github.javtor.costamod.item;

import io.github.javtor.costamod.CostaMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup COSTA = FabricItemGroupBuilder.build(
            new Identifier(CostaMod.MODID, "costa"),
            () -> new ItemStack(ModItems.ACORDEON)
    );

}
