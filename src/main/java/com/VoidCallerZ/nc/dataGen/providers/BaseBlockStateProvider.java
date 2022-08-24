package com.VoidCallerZ.nc.dataGen.providers;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class BaseBlockStateProvider extends BlockStateProvider
{
    public BaseBlockStateProvider(DataGenerator gen, String modid, ExistingFileHelper exFileHelper)
    {
        super(gen, modid, exFileHelper);
    }

    protected void singleTextureBlock(Block block, String modelName, String textureName)
    {
        ModelFile model = models().cubeAll(modelName, modLoc(textureName));
        simpleBlock(block, model);
    }

    protected void singleTextureBlockWithRenderType(Block block, String modelName, String textureName, String renderType)
    {
        ModelFile model = models().cubeAll(modelName, modLoc(textureName)).renderType(renderType);
        simpleBlock(block, model);
    }

    protected void compressedPillarBlock(RotatedPillarBlock block, ResourceLocation resLoc)
    {
        axisBlock(block, models().cubeColumn(ForgeRegistries.BLOCKS.getKey(block).getPath(), resLoc, extend(resLoc, "_top")), models().cubeColumnHorizontal(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_horizontal", resLoc, extend(resLoc, "_top")));
    }

    protected void paneBlockWithRenderType(Block block, String modelName, String textureName, String renderType)
    {
        paneBlockWithRenderType((IronBarsBlock) block, modelName, modLoc(textureName), extend(modLoc(textureName), "_pane_top"), renderType);
    }

    private ResourceLocation extend(ResourceLocation rl, String suffix) {
        return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
    }
}
