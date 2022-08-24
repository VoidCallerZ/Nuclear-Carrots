package com.VoidCallerZ.nc.dataGen;

import com.VoidCallerZ.nc.NuclearCarrots;
import com.VoidCallerZ.nc.dataGen.providers.BaseBlockStateProvider;
import com.VoidCallerZ.nc.registration.BlockRegistration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ncBlockStates extends BaseBlockStateProvider
{
    public ncBlockStates(DataGenerator generator, ExistingFileHelper helper)
    {
        super(generator, NuclearCarrots.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        singleTextureBlock(BlockRegistration.URANIUM_ORE.get(), "uranium_ore", "block/uranium_ore");
        singleTextureBlock(BlockRegistration.DEEPSLATE_URANIUM_ORE.get(), "deepslate_uranium_ore", "block/deepslate_uranium_ore");
    }
}
