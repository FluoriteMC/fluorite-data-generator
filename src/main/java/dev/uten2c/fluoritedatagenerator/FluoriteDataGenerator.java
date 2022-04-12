package dev.uten2c.fluoritedatagenerator;

import com.google.gson.Gson;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class FluoriteDataGenerator implements ModInitializer {
    private static final Gson GSON = new Gson();

    @Override
    public void onInitialize() {
        generateBlockData();
        ServerLifecycleEvents.SERVER_STARTING.register(MinecraftServer::shutdown);
    }

    private static void generateBlockData() {
        var map = new HashMap<Identifier, String>();
        Registry.BLOCK.forEach(block -> {
            var id = Registry.BLOCK.getId(block);
            map.put(id, soundGroupToString(block.getSoundGroup(block.getDefaultState())));
        });
        writeFile(Path.of("./block_sound_groups.json"), GSON.toJson(map));
    }

    private static void writeFile(Path path, String string) {
        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
            Files.writeString(path, string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String soundGroupToString(BlockSoundGroup soundGroup) {
        if (soundGroup == BlockSoundGroup.WOOD) {
            return "WOOD";
        } else if (soundGroup == BlockSoundGroup.GRAVEL) {
            return "GRAVEL";
        } else if (soundGroup == BlockSoundGroup.GRASS) {
            return "GRASS";
        } else if (soundGroup == BlockSoundGroup.LILY_PAD) {
            return "LILY_PAD";
        } else if (soundGroup == BlockSoundGroup.STONE) {
            return "STONE";
        } else if (soundGroup == BlockSoundGroup.METAL) {
            return "METAL";
        } else if (soundGroup == BlockSoundGroup.GLASS) {
            return "GLASS";
        } else if (soundGroup == BlockSoundGroup.WOOL) {
            return "WOOL";
        } else if (soundGroup == BlockSoundGroup.SAND) {
            return "SAND";
        } else if (soundGroup == BlockSoundGroup.SNOW) {
            return "SNOW";
        } else if (soundGroup == BlockSoundGroup.POWDER_SNOW) {
            return "POWDER_SNOW";
        } else if (soundGroup == BlockSoundGroup.LADDER) {
            return "LADDER";
        } else if (soundGroup == BlockSoundGroup.ANVIL) {
            return "ANVIL";
        } else if (soundGroup == BlockSoundGroup.SLIME) {
            return "SLIME";
        } else if (soundGroup == BlockSoundGroup.HONEY) {
            return "HONEY";
        } else if (soundGroup == BlockSoundGroup.WET_GRASS) {
            return "WET_GRASS";
        } else if (soundGroup == BlockSoundGroup.CORAL) {
            return "CORAL";
        } else if (soundGroup == BlockSoundGroup.BAMBOO) {
            return "BAMBOO";
        } else if (soundGroup == BlockSoundGroup.BAMBOO_SAPLING) {
            return "BAMBOO_SAPLING";
        } else if (soundGroup == BlockSoundGroup.SCAFFOLDING) {
            return "SCAFFOLDING";
        } else if (soundGroup == BlockSoundGroup.SWEET_BERRY_BUSH) {
            return "SWEET_BERRY_BUSH";
        } else if (soundGroup == BlockSoundGroup.CROP) {
            return "CROP";
        } else if (soundGroup == BlockSoundGroup.STEM) {
            return "STEM";
        } else if (soundGroup == BlockSoundGroup.VINE) {
            return "VINE";
        } else if (soundGroup == BlockSoundGroup.NETHER_WART) {
            return "NETHER_WART";
        } else if (soundGroup == BlockSoundGroup.LANTERN) {
            return "LANTERN";
        } else if (soundGroup == BlockSoundGroup.NETHER_STEM) {
            return "NETHER_STEM";
        } else if (soundGroup == BlockSoundGroup.NYLIUM) {
            return "NYLIUM";
        } else if (soundGroup == BlockSoundGroup.FUNGUS) {
            return "FUNGUS";
        } else if (soundGroup == BlockSoundGroup.ROOTS) {
            return "ROOTS";
        } else if (soundGroup == BlockSoundGroup.SHROOMLIGHT) {
            return "SHROOMLIGHT";
        } else if (soundGroup == BlockSoundGroup.WEEPING_VINES) {
            return "WEEPING_VINES";
        } else if (soundGroup == BlockSoundGroup.WEEPING_VINES_LOW_PITCH) {
            return "WEEPING_VINES_LOW_PITCH";
        } else if (soundGroup == BlockSoundGroup.SOUL_SAND) {
            return "SOUL_SAND";
        } else if (soundGroup == BlockSoundGroup.SOUL_SOIL) {
            return "SOUL_SOIL";
        } else if (soundGroup == BlockSoundGroup.BASALT) {
            return "BASALT";
        } else if (soundGroup == BlockSoundGroup.WART_BLOCK) {
            return "WART_BLOCK";
        } else if (soundGroup == BlockSoundGroup.NETHERRACK) {
            return "NETHERRACK";
        } else if (soundGroup == BlockSoundGroup.NETHER_BRICKS) {
            return "NETHER_BRICKS";
        } else if (soundGroup == BlockSoundGroup.NETHER_SPROUTS) {
            return "NETHER_SPROUTS";
        } else if (soundGroup == BlockSoundGroup.NETHER_ORE) {
            return "NETHER_ORE";
        } else if (soundGroup == BlockSoundGroup.BONE) {
            return "BONE";
        } else if (soundGroup == BlockSoundGroup.NETHERITE) {
            return "NETHERITE";
        } else if (soundGroup == BlockSoundGroup.ANCIENT_DEBRIS) {
            return "ANCIENT_DEBRIS";
        } else if (soundGroup == BlockSoundGroup.LODESTONE) {
            return "LODESTONE";
        } else if (soundGroup == BlockSoundGroup.CHAIN) {
            return "CHAIN";
        } else if (soundGroup == BlockSoundGroup.NETHER_GOLD_ORE) {
            return "NETHER_GOLD_ORE";
        } else if (soundGroup == BlockSoundGroup.GILDED_BLACKSTONE) {
            return "GILDED_BLACKSTONE";
        } else if (soundGroup == BlockSoundGroup.CANDLE) {
            return "CANDLE";
        } else if (soundGroup == BlockSoundGroup.AMETHYST_BLOCK) {
            return "AMETHYST_BLOCK";
        } else if (soundGroup == BlockSoundGroup.AMETHYST_CLUSTER) {
            return "AMETHYST_CLUSTER";
        } else if (soundGroup == BlockSoundGroup.SMALL_AMETHYST_BUD) {
            return "SMALL_AMETHYST_BUD";
        } else if (soundGroup == BlockSoundGroup.MEDIUM_AMETHYST_BUD) {
            return "MEDIUM_AMETHYST_BUD";
        } else if (soundGroup == BlockSoundGroup.LARGE_AMETHYST_BUD) {
            return "LARGE_AMETHYST_BUD";
        } else if (soundGroup == BlockSoundGroup.TUFF) {
            return "TUFF";
        } else if (soundGroup == BlockSoundGroup.CALCITE) {
            return "CALCITE";
        } else if (soundGroup == BlockSoundGroup.DRIPSTONE_BLOCK) {
            return "DRIPSTONE_BLOCK";
        } else if (soundGroup == BlockSoundGroup.POINTED_DRIPSTONE) {
            return "POINTED_DRIPSTONE";
        } else if (soundGroup == BlockSoundGroup.COPPER) {
            return "COPPER";
        } else if (soundGroup == BlockSoundGroup.CAVE_VINES) {
            return "CAVE_VINES";
        } else if (soundGroup == BlockSoundGroup.SPORE_BLOSSOM) {
            return "SPORE_BLOSSOM";
        } else if (soundGroup == BlockSoundGroup.AZALEA) {
            return "AZALEA";
        } else if (soundGroup == BlockSoundGroup.FLOWERING_AZALEA) {
            return "FLOWERING_AZALEA";
        } else if (soundGroup == BlockSoundGroup.MOSS_CARPET) {
            return "MOSS_CARPET";
        } else if (soundGroup == BlockSoundGroup.MOSS_BLOCK) {
            return "MOSS_BLOCK";
        } else if (soundGroup == BlockSoundGroup.BIG_DRIPLEAF) {
            return "BIG_DRIPLEAF";
        } else if (soundGroup == BlockSoundGroup.SMALL_DRIPLEAF) {
            return "SMALL_DRIPLEAF";
        } else if (soundGroup == BlockSoundGroup.ROOTED_DIRT) {
            return "ROOTED_DIRT";
        } else if (soundGroup == BlockSoundGroup.HANGING_ROOTS) {
            return "HANGING_ROOTS";
        } else if (soundGroup == BlockSoundGroup.AZALEA_LEAVES) {
            return "AZALEA_LEAVES";
        } else if (soundGroup == BlockSoundGroup.SCULK_SENSOR) {
            return "SCULK_SENSOR";
        } else if (soundGroup == BlockSoundGroup.GLOW_LICHEN) {
            return "GLOW_LICHEN";
        } else if (soundGroup == BlockSoundGroup.DEEPSLATE) {
            return "DEEPSLATE";
        } else if (soundGroup == BlockSoundGroup.DEEPSLATE_BRICKS) {
            return "DEEPSLATE_BRICKS";
        } else if (soundGroup == BlockSoundGroup.DEEPSLATE_TILES) {
            return "DEEPSLATE_TILES";
        } else if (soundGroup == BlockSoundGroup.POLISHED_DEEPSLATE) {
            return "POLISHED_DEEPSLATE";
        }
        throw new IllegalArgumentException("Unknown type");
    }
}
