package io.github.javtor.costamod.sound;

import io.github.javtor.costamod.CostaMod;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class ModSounds {

    public static SoundEvent ENTITY_DIOMEDES_AMBIENT = registerSoundEvent("entity_diomedes_ambient");
    public static SoundEvent ENTITY_DIOMEDES_HURT = registerSoundEvent("entity_diomedes_hurt");
    public static SoundEvent ENTITY_DIOMEDES_DEATH = registerSoundEvent("entity_diomedes_death");

    public static SoundEvent CARACOLES = registerSoundEvent("caracoles");
    public static SoundEvent LA_PLATA = registerSoundEvent("la_plata");
    public static SoundEvent SIN_MEDIR = registerSoundEvent("sin_medir");
    public static SoundEvent VALLE4 = registerSoundEvent("valle4");
    public static SoundEvent VALLE5 = registerSoundEvent("valle5");

    public static List<SoundEvent> VALLENATOS =
            List.of(new SoundEvent[]{CARACOLES, LA_PLATA, SIN_MEDIR, VALLE4, VALLE5});

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(CostaMod.MODID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }
}
