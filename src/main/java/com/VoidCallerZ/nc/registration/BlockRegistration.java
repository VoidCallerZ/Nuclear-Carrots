package com.VoidCallerZ.nc.registration;

import com.VoidCallerZ.nc.blocks.NcOreBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.VoidCallerZ.nc.NuclearCarrots.MODID;

public class BlockRegistration
{
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static void init()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
    }

    public static final BlockBehaviour.Properties ORE_PROPERTIES = BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops();
    public static final BlockBehaviour.Properties DEEPSLATE_ORE_PROPERTIES = BlockBehaviour.Properties.of(Material.STONE).strength(4.5f).requiresCorrectToolForDrops();



    public static final RegistryObject<Block> URANIUM_ORE = BLOCKS.register("uranium_ore", () -> new NcOreBlock(ORE_PROPERTIES, 100, 200));
    public static final RegistryObject<Block> DEEPSLATE_URANIUM_ORE = BLOCKS.register("deepslate_uranium_ore", () -> new NcOreBlock(DEEPSLATE_ORE_PROPERTIES, 100, 200));
}
