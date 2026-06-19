package net.sniffth.create_cabin_crafts.fluid;

import com.tterrag.registrate.util.entry.FluidEntry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidInteractionRegistry;
import net.sniffth.create_cabin_crafts.CreateCABINCrafts;
import org.checkerframework.checker.nullness.qual.NonNull;

import static net.sniffth.create_cabin_crafts.CreateCABINCrafts.REGISTRATE;

public class CABINCraftsFluids {
    public static final FluidEntry<BaseFlowingFluid.Flowing> LIQUID_RUBBER = REGISTRATE.fluid("liquid_rubber",
                    CreateCABINCrafts.rl("block/fluid/liquid_rubber_still"),
                    CreateCABINCrafts.rl("block/fluid/liquid_rubber_flow"))
            .properties(b -> b.viscosity(1500)
                    .density(500))
            .fluidProperties(p -> p.levelDecreasePerBlock(2)
                    .tickRate(25)
                    .slopeFindDistance(3)
                    .explosionResistance(100f))
            .source(BaseFlowingFluid.Source::new)
            .block()
            .build()
            .bucket()
            .onRegister(CABINCraftsFluids::registerFluidDispenseBehavior)
            .build()
            .register();

    public static final FluidEntry<BaseFlowingFluid.Flowing> LIQUID_REDSTONE = REGISTRATE.fluid("liquid_redstone",
                    CreateCABINCrafts.rl("block/fluid/redstone_still"),
                    CreateCABINCrafts.rl("block/fluid/redstone_flow"))
            .properties(b -> b.viscosity(1500)
                    .density(500))
            .fluidProperties(p -> p.levelDecreasePerBlock(1)
                    .tickRate(10)
                    .slopeFindDistance(3)
                    .explosionResistance(100f))
            .source(BaseFlowingFluid.Source::new)
            .block()
            .build()
            .bucket()
            .onRegister(CABINCraftsFluids::registerFluidDispenseBehavior)
            .build()
            .register();

    public static final FluidEntry<BaseFlowingFluid.Flowing> LIQUID_PULP = REGISTRATE.fluid("liquid_pulp",
                    CreateCABINCrafts.rl("block/fluid/liquid_pulp_still"),
                    CreateCABINCrafts.rl("block/fluid/liquid_pulp_flow"))
            .properties(b -> b.viscosity(1500)
                    .density(500))
            .fluidProperties(p -> p.levelDecreasePerBlock(1)
                    .tickRate(20)
                    .slopeFindDistance(3)
                    .explosionResistance(100f))
            .source(BaseFlowingFluid.Source::new)
            .block()
            .build()
            .bucket()
            .onRegister(CABINCraftsFluids::registerFluidDispenseBehavior)
            .build()
            .register();


    public static void registerFluidInteractions() {
        FluidInteractionRegistry.addInteraction(NeoForgeMod.LAVA_TYPE.value(), new FluidInteractionRegistry.InteractionInformation(
                LIQUID_RUBBER.get().getFluidType(),
                fluidState -> {
                    if (fluidState.isSource()) {
                        return Blocks.OBSIDIAN.defaultBlockState();
                    } else {
                        return Blocks.DEEPSLATE.defaultBlockState();
                    }
                }
        ));

           FluidInteractionRegistry.addInteraction(NeoForgeMod.LAVA_TYPE.value(), new FluidInteractionRegistry.InteractionInformation(
                LIQUID_REDSTONE.get().getFluidType(),
                fluidState -> {
                    if (fluidState.isSource()) {
                        return Blocks.OBSIDIAN.defaultBlockState();
                    } else {
                        return Blocks.NETHERRACK.defaultBlockState();
                    }
                }
        ));
}

    private static final DispenseItemBehavior DEFAULT = new DefaultDispenseItemBehavior();
    private static final DispenseItemBehavior DISPENSE_FLUID = new DefaultDispenseItemBehavior(){
        @Override
        protected @NonNull ItemStack execute(BlockSource pSource, ItemStack pStack) {
            DispensibleContainerItem dispensibleContainerItem = (DispensibleContainerItem) pStack.getItem();
            BlockPos pos = pSource.pos().relative(pSource.state().getValue(DispenserBlock.FACING));
            Level level = pSource.level();
            if (dispensibleContainerItem.emptyContents(null, level, pos, null, pStack)) {
                return new ItemStack(Items.BUCKET);
            }
            return DEFAULT.dispense(pSource, pStack);
        }
    };
    private static void registerFluidDispenseBehavior(BucketItem bucket) {
        DispenserBlock.registerBehavior(bucket, DISPENSE_FLUID);
    }
    public static void register(IEventBus eventBus) {

    }
}
