package com.VoidCallerZ.nc.dataGen;

import com.VoidCallerZ.nc.NuclearCarrots;
import com.VoidCallerZ.nc.registration.WorldGenRegistration;
import com.VoidCallerZ.nc.world.modifiers.OreBiomeModifier;
import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.RegistryObject;

import java.io.IOException;
import java.nio.file.Path;

import static com.VoidCallerZ.nc.NuclearCarrots.MODID;

public class ncBiomeModifiers implements DataProvider
{
    public final DataGenerator generator;

    public ncBiomeModifiers(DataGenerator generator)
    {
        this.generator = generator;
    }

    @Override
    public void run(CachedOutput cache)
    {
        final RegistryOps<JsonElement> ops = RegistryOps.create(JsonOps.INSTANCE, RegistryAccess.BUILTIN.get());

        //Overworld Ores
        setOverworldModifier(cache, ops, WorldGenRegistration.URANIUM_OREGEN);

        //Deepslate Ores
        setOverworldModifier(cache, ops, WorldGenRegistration.DEEPSLATE_URANIUM_OREGEN);
    }

    @Override
    public String getName()
    {
        return "Nuclear Carrots Biome Modifiers";
    }

    private void setOverworldModifier(CachedOutput cache, RegistryOps<JsonElement> ops, RegistryObject<PlacedFeature> oreFeature)
    {
        BiomeModifier biomeModifier_ = new OreBiomeModifier(
                new HolderSet.Named<>(ops.registry(Registry.BIOME_REGISTRY).get(), BiomeTags.IS_OVERWORLD),
                HolderSet.direct(ops.registry(Registry.PLACED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, new ResourceLocation(MODID, oreFeature.getId().getPath())))));
        customEncoder(cache, ops, oreFeature, biomeModifier_);
    }

    private void customEncoder(CachedOutput cache, RegistryOps<JsonElement> ops, RegistryObject<PlacedFeature> oreFeature, BiomeModifier biomeModifier)
    {
        String featurePathString_ = String.join("/", PackType.SERVER_DATA.getDirectory(), MODID, Registry.PLACED_FEATURE_REGISTRY.location().getPath(), oreFeature.getId().getPath() + "_pf.json");
        Path featurePath_ = generator.getOutputFolder().resolve(featurePathString_);

        String biomeModifierPathString_ = String.join("/", PackType.SERVER_DATA.getDirectory(), MODID, "forge/biome_modifier", oreFeature.getId().getPath() + "_bm.json");
        Path biomeModifierPath_ = generator.getOutputFolder().resolve(biomeModifierPathString_);

        PlacedFeature.DIRECT_CODEC.encodeStart(ops, oreFeature.get())
                .resultOrPartial(msg -> NuclearCarrots.LOGGER.error("Failed to encode {}:{}", featurePathString_, msg))
                .ifPresent(json ->
                {
                    try
                    {
                        DataProvider.saveStable(cache, json, featurePath_);
                    } catch (IOException e)
                    {
                        NuclearCarrots.LOGGER.error("Failed to save " + featurePathString_, e);
                    }
                });

        BiomeModifier.DIRECT_CODEC.encodeStart(ops, biomeModifier)
                .resultOrPartial(msg -> NuclearCarrots.LOGGER.error("Failed to encode {}:{}", biomeModifierPathString_, msg))
                .ifPresent(json ->
                {
                    try
                    {
                        DataProvider.saveStable(cache, json, biomeModifierPath_);
                    } catch (IOException e)
                    {
                        NuclearCarrots.LOGGER.error("Failed to save " + biomeModifierPathString_, e);
                    }
                });
    }
}
