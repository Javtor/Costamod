package com.github.javtor.costamod.item;

import com.github.javtor.costamod.CostaMod;
import com.github.javtor.costamod.item.custom.CostaArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
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

    public static final RegistryObject<Item> SOMBRERO_VUELTIAO =
            ITEMS.register("sombrero_vueltiao",
                    () -> new CostaArmorItem(ModArmorMaterials.ACORDEON, EquipmentSlot.HEAD,
                            new Item.Properties()));

    public static final RegistryObject<Item> CAMISETA_JUNIOR =
            ITEMS.register("camiseta_junior",
                    () -> new CostaArmorItem(ModArmorMaterials.ACORDEON, EquipmentSlot.CHEST,
                            new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
