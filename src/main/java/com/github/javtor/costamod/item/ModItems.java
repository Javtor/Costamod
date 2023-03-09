package com.github.javtor.costamod.item;

import com.github.javtor.costamod.CostaMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CostaMod.MOD_ID);

    public static final RegistryObject<Item> ACORDEON =
            ITEMS.register("acordeon",
                    () -> new Item(new Item.Properties().tab(ModCreativeModeTab.COSTAMOD_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
