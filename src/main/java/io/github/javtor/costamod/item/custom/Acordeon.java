package io.github.javtor.costamod.item.custom;

import io.github.javtor.costamod.item.ModItems;
import io.github.javtor.costamod.sound.ModSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.*;

public class Acordeon extends Item {
    public Acordeon(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            if (isCosteno(user)) {
                playRandomVallenato(world, user);
            } else {
                user.sendMessage(new LiteralText("No eres lo suficientemente costeño"), true);
            }

        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    private boolean isCosteno(PlayerEntity player) {
        // Get all the equipment, aka the armor, currently held item, and offhand item
        List<Item> equipmentList = new ArrayList<>();
        player.getItemsEquipped().forEach((x) -> equipmentList.add(x.getItem()));

        // elements 2 to 6 are the armor so we take the sublist. Armorlist now only
        // contains the 4 armor slots
        List<Item> armorList = equipmentList.subList(2, 6);

        // Make sure the player is wearing all the armor. If they are, continue playing
        // the animation, otherwise stop
        return new HashSet<>(armorList).containsAll(Arrays.asList(ModItems.SOMBRERO_VUELTIAO,
                ModItems.CAMISETA_JUNIOR));
    }

    private void playRandomVallenato(World world, PlayerEntity user){
        List<SoundEvent> vallenatos = ModSounds.VALLENATOS;
        Random rand = new Random();
        SoundEvent vallenato = vallenatos.get(rand.nextInt(vallenatos.size()));
        world.playSoundFromEntity(
                null,
                user,
                vallenato,
                SoundCategory.RECORDS,
                2f,
                1f
        );
    }
}
