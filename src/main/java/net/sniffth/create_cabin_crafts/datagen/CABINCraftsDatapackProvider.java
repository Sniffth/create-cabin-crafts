package net.sniffth.create_cabin_crafts.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.sniffth.create_cabin_crafts.CreateCABINCrafts;
import net.sniffth.create_cabin_crafts.worldgen.CABINCraftsBiomeModifiers;
import net.sniffth.create_cabin_crafts.worldgen.CABINCraftsConfiguredFeatures;
import net.sniffth.create_cabin_crafts.worldgen.CABINCraftsPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class CABINCraftsDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, CABINCraftsConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, CABINCraftsPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, CABINCraftsBiomeModifiers::bootstrap);

    public CABINCraftsDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(CreateCABINCrafts.MODID));
    }
}