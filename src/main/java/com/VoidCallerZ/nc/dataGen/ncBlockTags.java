package com.VoidCallerZ.nc.dataGen;

import com.VoidCallerZ.nc.NuclearCarrots;
import com.VoidCallerZ.nc.registration.BlockRegistration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ncBlockTags extends BlockTagsProvider
{
    public ncBlockTags(DataGenerator generator, ExistingFileHelper helper)
    {
        super(generator, NuclearCarrots.MODID, helper);
    }

    @Override
    protected void addTags()
    {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockRegistration.URANIUM_ORE.get())
                .add(BlockRegistration.DEEPSLATE_URANIUM_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockRegistration.URANIUM_ORE.get())
                .add(BlockRegistration.DEEPSLATE_URANIUM_ORE.get());

        tag(Tags.Blocks.ORES)
                .add(BlockRegistration.URANIUM_ORE.get())
                .add(BlockRegistration.DEEPSLATE_URANIUM_ORE.get());
    }
}
