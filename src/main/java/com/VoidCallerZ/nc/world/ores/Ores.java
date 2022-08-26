package com.VoidCallerZ.nc.world.ores;

import com.VoidCallerZ.nc.registration.BlockRegistration;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class Ores
{
    public static Holder<PlacedFeature> DEEPSLATE_OREGEN;

    @NotNull
    public static Holder<PlacedFeature> createOverworldOregen(boolean isDeepslate, boolean isUniform, RegistryObject<Block> oreBlock, int veinSize, int amount, int height)
    {
        VerticalAnchor zero = VerticalAnchor.absolute(0);
        VerticalAnchor absMinY = VerticalAnchor.absolute(height);
        VerticalAnchor absMaxY = VerticalAnchor.absolute(height);

        OreConfiguration overworldConfig = new OreConfiguration(isDeepslate ? OreFeatures.DEEPSLATE_ORE_REPLACEABLES : OreFeatures.STONE_ORE_REPLACEABLES, oreBlock.get().defaultBlockState(), veinSize);
        return registerPlacedFeature(oreBlock.getId().getNamespace(), new ConfiguredFeature<>(Feature.ORE, overworldConfig),
                CountPlacement.of(amount),
                InSquarePlacement.spread(),
                BiomeFilter.biome(),
                isDeepslate ?
                        (isUniform ? HeightRangePlacement.uniform(absMinY, zero) : HeightRangePlacement.triangle(absMinY, zero)):
                        (isUniform ? HeightRangePlacement.uniform(zero, absMaxY) : HeightRangePlacement.triangle(zero, absMaxY))

        );
    }

    private static <C extends FeatureConfiguration, F extends Feature<C>> Holder<PlacedFeature> registerPlacedFeature(String registryName, ConfiguredFeature<C, F> feature, PlacementModifier... placementModifiers)
    {
        return PlacementUtils.register(registryName, Holder.direct(feature), placementModifiers);
    }
}
