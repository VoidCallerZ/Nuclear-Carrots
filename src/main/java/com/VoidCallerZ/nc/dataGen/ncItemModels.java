package com.VoidCallerZ.nc.dataGen;

import com.VoidCallerZ.nc.NuclearCarrots;
import com.VoidCallerZ.nc.dataGen.providers.BaseItemModelProvider;
import com.VoidCallerZ.nc.registration.ItemRegistration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ncItemModels extends BaseItemModelProvider
{
    public ncItemModels(DataGenerator generator, ExistingFileHelper helper)
    {
        super(generator, NuclearCarrots.MODID, helper);
    }

    @Override
    protected void registerModels()
    {
        singleTextureGenerated(ItemRegistration.NUCLEAR_CARROT.get(), "item/nuclear_carrot");

        withExistingParent(ForgeRegistries.ITEMS.getKey(ItemRegistration.URANIUM_ORE.get()).getPath(), modLoc("block/uranium_ore"));
        withExistingParent(ForgeRegistries.ITEMS.getKey(ItemRegistration.DEEPSLATE_URANIUM_ORE.get()).getPath(), modLoc("block/deepslate_uranium_ore"));
    }
}
