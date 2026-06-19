package net.sniffth.create_cabin_crafts;

import com.simibubi.create.AllItems;
import com.simibubi.create.Create;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sniffth.create_cabin_crafts.block.CABINCraftsBlocks;
import net.sniffth.create_cabin_crafts.fluid.CABINCraftsFluids;
import net.sniffth.create_cabin_crafts.item.CABINCraftsItems;

import java.util.function.Supplier;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateCABINCrafts.MODID);

    public static final Supplier<CreativeModeTab> COMPONENTS_AND_MACHINES_TAB = CREATIVE_MODE_TAB.register("components_and_machines_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(CABINCraftsBlocks.ANDESITE_MACHINE.asItem()))
                    .title(Component.translatable("creative_tab.create_cabin_crafts.tab"))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Create.ID, "palettes"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(CABINCraftsBlocks.ANDESITE_MACHINE);
                        output.accept(CABINCraftsBlocks.COPPER_MACHINE);
                        output.accept(CABINCraftsBlocks.GOLD_MACHINE);
                        output.accept(CABINCraftsBlocks.BRASS_MACHINE);
                        output.accept(CABINCraftsBlocks.LEAD_MACHINE);
                        output.accept(CABINCraftsBlocks.LEAD_CASING);
                        output.accept(CABINCraftsItems.KINETIC_MECHANISM);
                        output.accept(CABINCraftsItems.SEALED_MECHANISM);
                        output.accept(CABINCraftsItems.REINFORCED_MECHANISM);
                        output.accept(AllItems.PRECISION_MECHANISM);
                        output.accept(CABINCraftsItems.SAW_BLADE);
                        output.accept(CABINCraftsItems.DRILL_HEAD);
                        output.accept(CABINCraftsItems.RUBBER);
                        output.accept(CABINCraftsItems.CURED_RUBBER);
                        output.accept(CABINCraftsFluids.LIQUID_RUBBER.getBucket().get());
                        output.accept(CABINCraftsFluids.LIQUID_REDSTONE.getBucket().get());
                        output.accept(CABINCraftsFluids.LIQUID_PULP.getBucket().get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
