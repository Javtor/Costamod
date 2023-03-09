package com.github.javtor.costamod.item.custom;

import com.github.javtor.costamod.CostaMod;
import com.github.javtor.costamod.item.ModItems;
import com.github.javtor.costamod.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Acordeon extends Item {
    public Acordeon(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        //if the world is not client
        if (!pLevel.isClientSide) {
            if (isCosteno(pPlayer)) {
                ItemStack stack = pPlayer.getItemInHand(pUsedHand);
                // If a vallenato is playing, just show the message of how much is left in the song and its name
                if (stack.hasTag() && stack.getTag().contains(CostaMod.MOD_ID + ".remaining")) {
                    assert stack.getTag() != null;
                    long remaining = stack.getTag().getLong(CostaMod.MOD_ID + ".remaining");
                    String record = stack.getTag().getString(CostaMod.MOD_ID + ".record");
                    pPlayer.displayClientMessage(Component.nullToEmpty("Quedan " + remaining / 20 + " segundos de " + record), true);
                } else {
                    playRandomVallenato(pLevel, pPlayer, stack);
                }

            } else {
                pPlayer.displayClientMessage(Component.nullToEmpty("No eres lo suficientemente costeño"), true);
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    private boolean isCosteno(Player pPlayer) {
        return pPlayer.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.SOMBRERO_VUELTIAO.get() &&
                pPlayer.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.CAMISETA_JUNIOR.get();

    }

    private void playRandomVallenato(Level pLevel, Player pPlayer, ItemStack pStack) {
        List<RegistryObject<SoundEvent>> vallenatos = ModSounds.VALLENATOS;
        int random = (int) (Math.random() * vallenatos.size());
        SoundEvent vallenato = vallenatos.get(random).get();

        addVallenatoNbt(vallenato, pStack);

        //show the player which song is playing
        if(pStack.hasTag() && pStack.getTag().contains(CostaMod.MOD_ID + ".record")){
            String record = pStack.getTag().getString(CostaMod.MOD_ID + ".record");
            pPlayer.displayClientMessage(Component.nullToEmpty(record), true);
        }

        pLevel.playSound(null, pPlayer, vallenato, pPlayer.getSoundSource(), 2.0F, 1.0F);
    }

    private void addVallenatoNbt(SoundEvent vallenato, ItemStack stack) {
        CostaMod.LOGGER.info("Adding vallenato to nbt");
        if (stack.is(ModItems.ACORDEON.get())) {
            long duration = 15 * 20;
            stack.getOrCreateTag().putLong(CostaMod.MOD_ID + ".remaining", duration);
            RecordItem record = RecordItem.getBySound(vallenato);
            if (record != null) {
                stack.getOrCreateTag().putString(CostaMod.MOD_ID + ".record", record.getDisplayName().toString());
            }
        }
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!pLevel.isClientSide) {
            if (pStack.hasTag()) {
                assert pStack.getTag() != null;
                if (pStack.getTag().contains(CostaMod.MOD_ID + ".remaining")) {
                    long remaining = pStack.getTag().getLong(CostaMod.MOD_ID + ".remaining");
                    if (remaining > 0) {
                        pStack.getTag().putLong(CostaMod.MOD_ID + ".remaining", remaining - 1);
                    } else {
                        pStack.getTag().remove(CostaMod.MOD_ID + ".remaining");
                        pStack.getTag().remove(CostaMod.MOD_ID + ".record");
                    }
                }
            }
        }
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return (pStack.hasTag() && pStack.getTag().contains(CostaMod.MOD_ID + ".remaining")) || super.isFoil(pStack);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (pStack.hasTag()) {
            assert pStack.getTag() != null;
            if (pStack.getTag().contains(CostaMod.MOD_ID + ".remaining")) {
                long remaining = pStack.getTag().getLong(CostaMod.MOD_ID + ".remaining");
                pTooltipComponents.add(Component.nullToEmpty("Playing: " + pStack.getTag().getString(CostaMod.MOD_ID + ".record")));
                pTooltipComponents.add(Component.nullToEmpty("Remaining: " + remaining / 20 + "s"));
            }
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
