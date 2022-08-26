package com.VoidCallerZ.nc.dataGen;

import com.VoidCallerZ.nc.NuclearCarrots;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NuclearCarrots.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        boolean isClient = event.includeClient();
        boolean isServer = event.includeServer();

        DataGenerator generator = event.getGenerator();
        generator.addProvider(isClient, new ncBlockTags(generator, event.getExistingFileHelper()));
        generator.addProvider(isClient, new ncBiomeModifiers(generator));

        generator.addProvider(isServer, new ncBlockStates(generator, event.getExistingFileHelper()));
        generator.addProvider(isServer, new ncItemModels(generator, event.getExistingFileHelper()));
        generator.addProvider(isServer, new ncLanguageProvider(generator, "en_us"));
    }
}
