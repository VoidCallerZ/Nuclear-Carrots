package com.VoidCallerZ.nc.registration;

import com.VoidCallerZ.nc.NuclearCarrots;
import com.VoidCallerZ.nc.world.modifiers.OreBiomeModifier;
import com.VoidCallerZ.nc.world.ores.Ores;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.VoidCallerZ.nc.world.modifiers.OreBiomeModifier.ORE_BIOME_MODIFIER_NAME;

public class WorldGenRegistration
{
    private static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, NuclearCarrots.MODID);
    private static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, NuclearCarrots.MODID);

    public static void init()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BIOME_MODIFIERS.register(bus);
        PLACED_FEATURES.register(bus);
    }

    public static final RegistryObject<Codec<? extends BiomeModifier>> ORE_BIOME_MODIFIER = BIOME_MODIFIERS.register(ORE_BIOME_MODIFIER_NAME, OreBiomeModifier::makeCodec);

    //Overworld Ores
    public static final RegistryObject<PlacedFeature> URANIUM_OREGEN = PLACED_FEATURES.register("uranium_ore", () -> Ores.createOverworldOregen(false, true, BlockRegistration.URANIUM_ORE, 8, 3, 64).get());

    //Deepslate Ores
    public static final RegistryObject<PlacedFeature> DEEPSLATE_URANIUM_OREGEN = PLACED_FEATURES.register("deepslate_uranium_ore", () -> Ores.createOverworldOregen(true, true, BlockRegistration.DEEPSLATE_URANIUM_ORE, 8, 3, -64).get());
}
