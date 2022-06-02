package io.github.javtor.costamod.item;

import io.github.javtor.costamod.CostaMod;
import io.github.javtor.costamod.item.custom.Acordeon;
import io.github.javtor.costamod.item.custom.CostaArmorItem;
import io.github.javtor.costamod.item.custom.ModMusicDiscItem;
import io.github.javtor.costamod.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item ACORDEON = registerItem("acordeon",
            new Acordeon(new FabricItemSettings().group(ModItemGroup.COSTA)));

    public static final Item SOMBRERO_VUELTIAO = registerItem("sombrero_vueltiao",
            new CostaArmorItem(ModArmorMaterials.ACORDEON, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.COSTA)));

    public static final Item CAMISETA_JUNIOR = registerItem("camiseta_junior",
            new CostaArmorItem(ModArmorMaterials.ACORDEON, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.COSTA)));

    public static final Item CARACOLES_MUSIC_DISC = registerItem("caracoles_music_disc",
            new ModMusicDiscItem(7, ModSounds.CARACOLES,
                    new FabricItemSettings().group(ModItemGroup.COSTA).maxCount(1)));

    public static final Item LA_PLATA_MUSIC_DISC = registerItem("la_plata_music_disc",
            new ModMusicDiscItem(7, ModSounds.LA_PLATA,
                    new FabricItemSettings().group(ModItemGroup.COSTA).maxCount(1)));

    public static final Item SIN_MEDIR_MUSIC_DISC = registerItem("sin_medir_music_disc",
            new ModMusicDiscItem(7, ModSounds.SIN_MEDIR,
                    new FabricItemSettings().group(ModItemGroup.COSTA).maxCount(1)));

    public static final Item VALLE4_MUSIC_DISC = registerItem("valle4_music_disc",
            new ModMusicDiscItem(7, ModSounds.VALLE4,
                    new FabricItemSettings().group(ModItemGroup.COSTA).maxCount(1)));

    public static final Item VALLE5_MUSIC_DISC = registerItem("valle5_music_disc",
            new ModMusicDiscItem(7, ModSounds.VALLE5,
                    new FabricItemSettings().group(ModItemGroup.COSTA).maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(CostaMod.MODID, name), item);
    }

    public static void registerModItems() {
        CostaMod.LOGGER.info("Registering Mod Items for "+CostaMod.MODID);
    }
}
