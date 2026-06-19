package net.sniffth.create_cabin_crafts.block;

import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.foundation.block.connected.*;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sniffth.create_cabin_crafts.CreateCABINCrafts;
import net.sniffth.create_cabin_crafts.block.machines.*;
import net.sniffth.create_cabin_crafts.item.CABINCraftsItems;

import java.util.function.Supplier;

import static com.simibubi.create.foundation.block.connected.CTSpriteShifter.getCT;
import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;

public class CABINCraftsBlocks {
    private static final CreateRegistrate REGISTRATE = CreateCABINCrafts.registrate();

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CreateCABINCrafts.MODID);
    private static final VoxelShape ANDESITE_SHAPE = Shapes.or(Block.box(0, 0, 3, 16, 16, 16),
            Block.box(3, 14, 3, 13, 18, 17));
    private static final VoxelShape BRASS_SHAPE = Shapes.or(Block.box(0, 0, 0, 16, 4, 16),
            Block.box(0, 0, 3, 16, 10, 13), Block.box(8, 3, 4, 16, 16, 16),
            Block.box(1, 10, 5, 7, 21, 11));
    private static final VoxelShape COPPER_SHAPE = Shapes.or(Block.box(0, 0, 0, 16, 4, 16),
            Block.box(1.9, 2, -2, 14.9, 10, 10), Block.box(6, 4, 6, 16, 20, 16),
            Block.box(0, 4, 6, 10, 24, 16));
    private static final VoxelShape GOLD_SHAPE = Shapes.or(Block.box(0, 0, 0, 16, 3, 16),
            Block.box(0, 3, 0, 12, 16, 8), Block.box(0, 3, 8, 10, 14, 16),
            Block.box(12, 3, 1, 16, 10, 16));
    private static final VoxelShape LEAD_SHAPE = Shapes.or(Block.box(0, 0, 1, 16, 2, 15),
            Block.box(1, 2, 7, 14, 14, 15), Block.box(0, 2, 0, 7, 9, 12),
            Block.box(10, 0, 8, 16, 11, 16), Block.box(7.5, 14, 8.5, 12.5, 21, 13.5));

    public static final DeferredBlock<Block> ANDESITE_MACHINE = registerBlock("andesite_machine",
            () -> new MachineBlock(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.METAL).isViewBlocking((state, world, pos) -> false).noOcclusion(), ANDESITE_SHAPE));
    public static final DeferredBlock<Block> COPPER_MACHINE = registerBlock("copper_machine",
            () -> new MachineBlock(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.METAL).isViewBlocking((state, world, pos) -> false).noOcclusion(), COPPER_SHAPE));
    public static final DeferredBlock<Block> GOLD_MACHINE = registerBlock("gold_machine",
            () -> new MachineBlock(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.METAL).isViewBlocking((state, world, pos) -> false).noOcclusion(), GOLD_SHAPE));
    public static final DeferredBlock<Block> BRASS_MACHINE = registerBlock("brass_machine",
            () -> new MachineBlock(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.METAL).isViewBlocking((state, world, pos) -> false).noOcclusion(), BRASS_SHAPE));
    public static final DeferredBlock<Block> LEAD_MACHINE = registerBlock("lead_machine",
            () -> new MachineBlock(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.METAL).isViewBlocking((state, world, pos) -> false).noOcclusion(), LEAD_SHAPE));
    public static final BlockEntry<CasingBlock> LEAD_CASING = REGISTRATE.block("lead_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> CABINCraftsSpriteShifts.LEAD_CASING)).transform(axeOrPickaxe()).register();

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        CABINCraftsItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


}
