package net.sniffth.create_cabin_crafts.item.saws;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CustomSaw extends Item {
    public CustomSaw(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        ItemStack item = itemStack.copy();
        item.setDamageValue(item.getDamageValue() + 1);
        if (item.getDamageValue() >= item.getMaxDamage()) {
            return ItemStack.EMPTY;
        }
        return item;
    }
}
