package com.VoidCallerZ.nc.dataGen;

import com.VoidCallerZ.nc.NuclearCarrots;
import com.VoidCallerZ.nc.registration.BlockRegistration;
import com.VoidCallerZ.nc.registration.ItemRegistration;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;

import static com.VoidCallerZ.nc.setup.ModSetup.*;

public class ncLanguageProvider extends LanguageProvider
{
    public ncLanguageProvider(DataGenerator generator, String locale)
    {
        super(generator, NuclearCarrots.MODID, locale);
    }

    @Override
    protected void addTranslations()
    {
        add("itemGroup." + NC_TAB, "Nuclear Carrots");

        add(ItemRegistration.NUCLEAR_CARROT.get(), "Nuclear Carrot");
        add(BlockRegistration.URANIUM_ORE.get(), "Uranium Ore");
        add(BlockRegistration.DEEPSLATE_URANIUM_ORE.get(), "Deepslate Uranium Ore");
    }
}
