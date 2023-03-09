package com.github.javtor.costamod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab COSTAMOD_TAB = new CreativeModeTab("costamod") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ACORDEON.get());
        }
    };
}
