package com.github.javtor.costamod.item.custom;

import com.github.javtor.costamod.item.ModItems;
import com.github.javtor.costamod.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;

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
                playRandomVallenato(pLevel, pPlayer);
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

    private void playRandomVallenato(Level pLevel, Player pPlayer) {
        List<RegistryObject<SoundEvent>> vallenatos = ModSounds.VALLENATOS;
        int random = (int) (Math.random() * vallenatos.size());
        SoundEvent vallenato = vallenatos.get(random).get();
        pLevel.playSound(null, pPlayer, vallenato, pPlayer.getSoundSource(), 2.0F, 1.0F);
    }
}
