package com.github.javtor.costamod.sound;

import com.github.javtor.costamod.CostaMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CostaMod.MOD_ID);

    public static final RegistryObject<SoundEvent> CARACOLES = registerSound("caracoles");
    public static final RegistryObject<SoundEvent> LA_PLATA = registerSound("la_plata");
    public static final RegistryObject<SoundEvent> SIN_MEDIR = registerSound("sin_medir");
    public static final RegistryObject<SoundEvent> VALLE4 = registerSound("valle4");
    public static final RegistryObject<SoundEvent> VALLE5 = registerSound("valle5");

    public static final List<RegistryObject<SoundEvent>> VALLENATOS =
            List.of(CARACOLES, LA_PLATA, SIN_MEDIR, VALLE4, VALLE5);

    private static RegistryObject<SoundEvent> registerSound(String name) {
        return SOUNDS_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(CostaMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUNDS_EVENTS.register(eventBus);
    }
}
