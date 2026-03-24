package com.benbenlaw.colors;

import com.benbenlaw.colors.block.ColorsBlocks;
import com.benbenlaw.colors.block.sets.ColorsWoodTypes;
import com.benbenlaw.colors.config.StartupConfig;
import com.benbenlaw.colors.config.WorldGenConfig;
import com.benbenlaw.colors.item.ColorsCreativeTab;
import com.benbenlaw.colors.item.ColorsItems;
import com.benbenlaw.colors.maps.StrippedLogMap;
import com.benbenlaw.colors.util.ColorList;
import com.benbenlaw.colors.util.ColorMap;
import com.benbenlaw.colors.util.ColorsMaterials;
import com.benbenlaw.colors.worldgen.ColorsWorldGen;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.apache.logging.log4j.LogManager;

import java.util.Map;

import static com.benbenlaw.colors.block.ColorsBlocks.*;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Colors.MOD_ID)
public class Colors{

    public static final String MOD_ID = "colors";
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public Colors(final IEventBus modEventBus, final ModContainer modContainer) {

        ColorsBlocks.BLOCKS.register(modEventBus);
        ColorsItems.ITEMS.register(modEventBus);
        ColorsCreativeTab.CREATIVE_TABS.register(modEventBus);

        ColorsWorldGen.PLACEMENTS.register(modEventBus);
        ColorsWorldGen.FEATURES.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.STARTUP, WorldGenConfig.SPEC, "bbl/colors/worldgen.toml");
        modContainer.registerConfig(ModConfig.Type.STARTUP, StartupConfig.SPEC, "bbl/colors/startup.toml");

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(ColorsBlocks::addPlanksToSigns);


        if (FMLEnvironment.getDist() == Dist.CLIENT) {
            modEventBus.addListener(ColorsWoodTypes::clientSetup);
        }

    }

    public static Identifier identifier(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

    @EventBusSubscriber(modid = Colors.MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            //event.register(ClocheMenus.CLOCHE_MENU.get(), ClocheScreen::new);
        }

        @SubscribeEvent
        private static void onClientSetup(final FMLCommonSetupEvent event) {

            for (String color : ColorList.COLORS) {

                //ItemBlockRenderTypes.setRenderLayer(SAPLINGS.get(color + "_sapling").get(), ChunkSectionLayer.CUTOUT);
                //ItemBlockRenderTypes.setRenderLayer(POPPY.get(color + "_poppy").get(), ChunkSectionLayer.CUTOUT);
                //ItemBlockRenderTypes.setRenderLayer(DANDELION.get(color + "_dandelion").get(), ChunkSectionLayer.CUTOUT);
                //ItemBlockRenderTypes.setRenderLayer(SHORT_GRASS.get(color + "_short_grass").get(), ChunkSectionLayer.CUTOUT);
                //ItemBlockRenderTypes.setRenderLayer(TALL_GRASS.get(color + "_tall_grass").get(), ChunkSectionLayer.CUTOUT);
                //ItemBlockRenderTypes.setRenderLayer(POTTED_DANDELION.get(color + "_potted_dandelion").get(), ChunkSectionLayer.CUTOUT);
                //ItemBlockRenderTypes.setRenderLayer(POTTED_POPPY.get(color + "_potted_poppy").get(), ChunkSectionLayer.CUTOUT);
                //ItemBlockRenderTypes.setRenderLayer(POTTED_SAPLING.get(color + "_potted_sapling").get(), ChunkSectionLayer.CUTOUT);

            }

            ColorsMaterials.bootstrap();                //Not sure what the correct way of doing this is but this works for the current version of Minecraft



        }

        //@SubscribeEvent
        //private static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
//
        //    for (String color : ColorList.COLORS) {
        //        event.register(leavesColor, LEAVES.get(color + "_leaves").get());
        //    }
        //}
    }

    //private static final BlockColor leavesColor = (state, world, pos, tintIndex) -> {
//
    //    for (DyeColor dyeColor : DyeColor.values()) {
    //        if (state.is(LEAVES.get(dyeColor.getName() + "_leaves"))) {
    //            return ColorMap.COLOR_MAP.get(dyeColor);
    //        }
    //    }
//
    //    return -1;
    //};


    public void commonSetup(final FMLCommonSetupEvent event) {

        StrippedLogMap logMap = new StrippedLogMap();
        logMap.updateLogMaps();

        event.enqueueWork(() -> {

            for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.POPPY.entrySet()) {
                String poppyBlock = entry.getKey().replace("_poppy", "_potted_poppy");
                DeferredBlock<Block> block = ColorsBlocks.POTTED_POPPY.get(poppyBlock);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(entry.getValue().getId(), block);
            }

            for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.DANDELION.entrySet()) {
                String poppyBlock = entry.getKey().replace("_dandelion", "_potted_dandelion");
                DeferredBlock<Block> block = ColorsBlocks.POTTED_DANDELION.get(poppyBlock);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(entry.getValue().getId(), block);
            }


            for (Map.Entry<String, DeferredBlock<Block>> entry : ColorsBlocks.SAPLINGS.entrySet()) {
                String poppyBlock = entry.getKey().replace("_sapling", "_potted_sapling");
                DeferredBlock<Block> block = ColorsBlocks.POTTED_SAPLING.get(poppyBlock);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(entry.getValue().getId(), block);
            }

        });


    }



}
