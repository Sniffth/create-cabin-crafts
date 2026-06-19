package net.sniffth.create_cabin_crafts.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.sniffth.create_cabin_crafts.CreateCABINCrafts;

public class CABINCraftsTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(CreateCABINCrafts.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> MACHINE = createTag("cabin_machines");
        public static final TagKey<Item> LEAVES_FOR_RUBBER = createTag("leaves_for_rubber");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(CreateCABINCrafts.MODID, name));
        }
    }
}
