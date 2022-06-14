package io.github.javtor.costamod.item.custom;

import io.github.javtor.costamod.CostaMod;
import io.github.javtor.costamod.item.ModItems;
import io.github.javtor.costamod.sound.ModSounds;
import io.github.javtor.costamod.util.AudioUtil;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Acordeon extends Item {
    public Acordeon(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            ItemStack stack = user.getStackInHand(hand);
            if (isCosteno(user)) {
                if(stack.hasNbt()) {
                    long remaining = stack.getNbt().getLong(CostaMod.MODID + ".remaining");
                    remaining = remaining / 1000;
                    user.sendMessage(new LiteralText(remaining+" segundos restantes"), true);
                } else {
                    playRandomVallenato(world, user, stack);
                }
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

    private void playRandomVallenato(World world, PlayerEntity user, ItemStack stack) {
        List<SoundEvent> vallenatos = ModSounds.VALLENATOS;
        Random rand = new Random();
        SoundEvent vallenato = vallenatos.get(rand.nextInt(vallenatos.size()));

        addVallenatoNbt(vallenato, stack);

        world.playSoundFromEntity(
                null,
                user,
                vallenato,
                SoundCategory.RECORDS,
                2f,
                1f
        );
    }

    private void addVallenatoNbt(SoundEvent vallenato, ItemStack stack) {
        CostaMod.LOGGER.info("Adding vallenato nbt");
        if(stack.getItem() == ModItems.ACORDEON) {
            NbtCompound nbtData = new NbtCompound();

            //InputStream vallenatoStream = AudioUtil.getVallenatoOggStream(vallenato.getId().getPath());
            long duration = 15000;
            /*try {
                duration = (long) AudioUtil.calculateOggDuration(vallenatoStream) +1;
            } catch (IOException e) {
                CostaMod.LOGGER.error("Error reading vallenato stream");
            }*/
            nbtData.putLong(CostaMod.MODID+".remaining", duration);

            MusicDiscItem item = ModMusicDiscItem.bySound(vallenato);
            if(item != null) {
                nbtData.putString(CostaMod.MODID+".song", item.getTranslationKey());
            }
            stack.setNbt(nbtData);
        }

    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient) {
            if(stack.hasNbt()) {
                long remaining = stack.getNbt().getLong(CostaMod.MODID+".remaining");
                remaining -= 50;
                stack.getNbt().putLong(CostaMod.MODID+".remaining", remaining);
                if(remaining <= 0) {
                    stack.setNbt(new NbtCompound());
                }
            }
        }
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return stack.hasNbt();
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(stack.hasNbt()) {
            String song = stack.getNbt().getString(CostaMod.MODID+".song");
            long remaining = stack.getNbt().getLong(CostaMod.MODID+".remaining");
            remaining = remaining / 1000;
            tooltip.add(new TranslatableText(song));
            tooltip.add(new LiteralText(remaining+" s"));
        }
    }
}
