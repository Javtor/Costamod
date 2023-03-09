package com.github.javtor.costamod.item;

import com.github.javtor.costamod.CostaMod;
import com.github.javtor.costamod.item.custom.Acordeon;
import com.github.javtor.costamod.item.custom.CostaArmorItem;
import com.github.javtor.costamod.sound.ModSounds;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CostaMod.MOD_ID);

    public static final RegistryObject<Item> ACORDEON =
            ITEMS.register("acordeon",
                    () -> new Acordeon(new Item.Properties().tab(ModCreativeModeTab.COSTAMOD_TAB)));

    public static final RegistryObject<Item> SOMBRERO_VUELTIAO =
            ITEMS.register("sombrero_vueltiao",
                    () -> new CostaArmorItem(ModArmorMaterials.ACORDEON, EquipmentSlot.HEAD,
                            new Item.Properties()));

    public static final RegistryObject<Item> CAMISETA_JUNIOR =
            ITEMS.register("camiseta_junior",
                    () -> new CostaArmorItem(ModArmorMaterials.ACORDEON, EquipmentSlot.CHEST,
                            new Item.Properties()));

    public static final RegistryObject<Item> CARACOLES_MUSIC_DISC =
            ITEMS.register("caracoles_music_disc",
                    () -> new RecordItem(7, ModSounds.CARACOLES,
                            new Item.Properties().tab(ModCreativeModeTab.COSTAMOD_TAB).stacksTo(1), 320));

    public static final RegistryObject<Item> LA_PLATA_MUSIC_DISC =
            ITEMS.register("la_plata_music_disc",
                    () -> new RecordItem(7, ModSounds.LA_PLATA,
                            new Item.Properties().tab(ModCreativeModeTab.COSTAMOD_TAB).stacksTo(1), 320));

    public static final RegistryObject<Item> SIN_MEDIR_MUSIC_DISC =
            ITEMS.register("sin_medir_music_disc",
                    () -> new RecordItem(7, ModSounds.SIN_MEDIR,
                            new Item.Properties().tab(ModCreativeModeTab.COSTAMOD_TAB).stacksTo(1), 320));

    public static final RegistryObject<Item> VALLE4_MUSIC_DISC =
            ITEMS.register("valle4_music_disc",
                    () -> new RecordItem(7, ModSounds.VALLE4,
                            new Item.Properties().tab(ModCreativeModeTab.COSTAMOD_TAB).stacksTo(1), 320));

    public static final RegistryObject<Item> VALLE5_MUSIC_DISC =
            ITEMS.register("valle5_music_disc",
                    () -> new RecordItem(7, ModSounds.VALLE5,
                            new Item.Properties().tab(ModCreativeModeTab.COSTAMOD_TAB).stacksTo(1), 320));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
