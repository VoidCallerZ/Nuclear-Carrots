package com.VoidCallerZ.nc.world.modifiers;

import com.VoidCallerZ.nc.registration.WorldGenRegistration;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

public record OreBiomeModifier(HolderSet<Biome> biomes, HolderSet<PlacedFeature> features) implements BiomeModifier
{
    public static final String ORE_BIOME_MODIFIER_NAME = "ore_biome_modifier";

    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder)
    {
        if (phase == Phase.ADD && this.biomes.contains(biome))
        {
            BiomeGenerationSettingsBuilder generation = builder.getGenerationSettings();
            this.features.forEach(holder -> generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, holder));
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec()
    {
        return WorldGenRegistration.ORE_BIOME_MODIFIER.get();
    }

    public static Codec<OreBiomeModifier> makeCodec()
    {
        return RecordCodecBuilder.create(builder -> builder.group(
                Biome.LIST_CODEC.fieldOf("biomes").forGetter(OreBiomeModifier::biomes),
                PlacedFeature.LIST_CODEC.fieldOf("feature").forGetter(OreBiomeModifier::features)
        ).apply(builder, OreBiomeModifier::new));
    }
}
