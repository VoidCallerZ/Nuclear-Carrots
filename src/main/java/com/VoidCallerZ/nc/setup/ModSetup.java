package com.VoidCallerZ.nc.setup;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ModSetup
{
    public static final String NC_TAB = "nuclearcarrots";

    public static final CreativeModeTab NUCLEAR_CARROTS_TAB = new CreativeModeTab(NC_TAB)
    {
        @Override
        public ItemStack makeIcon()
        {
            return Items.CARROT.getDefaultInstance();
        }
    };

    public static void setup()
    {
        IEventBus bus = MinecraftForge.EVENT_BUS;
    }

    public static void init(FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {

        });
    }
}
