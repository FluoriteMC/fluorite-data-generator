package dev.uten2c.fluoritedatagenerator;

import com.google.gson.Gson;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

import java.io.IOException;
import java.io.ObjectOutputStream;
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
        var map = new HashMap<String, EnumBlockSoundGroup>();
        Registry.BLOCK.forEach(block -> {
            var id = Registry.BLOCK.getId(block);
            map.put(id.getPath(), soundGroupToEnum(block.getSoundGroup(block.getDefaultState())));
        });
        try (var out = Files.newOutputStream(Path.of("./block_sound_groups.dat"))) {
            var objOut = new ObjectOutputStream(out);
            objOut.writeObject(map);
            objOut.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        writeFile(Path.of("./block_sound_groups.dat"), GSON.toJson(map));
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

    private static EnumBlockSoundGroup soundGroupToEnum(BlockSoundGroup soundGroup) {
        if (soundGroup == BlockSoundGroup.WOOD) {
            return EnumBlockSoundGroup.WOOD;
        } else if (soundGroup == BlockSoundGroup.GRAVEL) {
            return EnumBlockSoundGroup.GRAVEL;
        } else if (soundGroup == BlockSoundGroup.GRASS) {
            return EnumBlockSoundGroup.GRASS;
        } else if (soundGroup == BlockSoundGroup.LILY_PAD) {
            return EnumBlockSoundGroup.LILY_PAD;
        } else if (soundGroup == BlockSoundGroup.STONE) {
            return EnumBlockSoundGroup.STONE;
        } else if (soundGroup == BlockSoundGroup.METAL) {
            return EnumBlockSoundGroup.METAL;
        } else if (soundGroup == BlockSoundGroup.GLASS) {
            return EnumBlockSoundGroup.GLASS;
        } else if (soundGroup == BlockSoundGroup.WOOL) {
            return EnumBlockSoundGroup.WOOL;
        } else if (soundGroup == BlockSoundGroup.SAND) {
            return EnumBlockSoundGroup.SAND;
        } else if (soundGroup == BlockSoundGroup.SNOW) {
            return EnumBlockSoundGroup.SNOW;
        } else if (soundGroup == BlockSoundGroup.POWDER_SNOW) {
            return EnumBlockSoundGroup.POWDER_SNOW;
        } else if (soundGroup == BlockSoundGroup.LADDER) {
            return EnumBlockSoundGroup.LADDER;
        } else if (soundGroup == BlockSoundGroup.ANVIL) {
            return EnumBlockSoundGroup.ANVIL;
        } else if (soundGroup == BlockSoundGroup.SLIME) {
            return EnumBlockSoundGroup.SLIME;
        } else if (soundGroup == BlockSoundGroup.HONEY) {
            return EnumBlockSoundGroup.HONEY;
        } else if (soundGroup == BlockSoundGroup.WET_GRASS) {
            return EnumBlockSoundGroup.WET_GRASS;
        } else if (soundGroup == BlockSoundGroup.CORAL) {
            return EnumBlockSoundGroup.CORAL;
        } else if (soundGroup == BlockSoundGroup.BAMBOO) {
            return EnumBlockSoundGroup.BAMBOO;
        } else if (soundGroup == BlockSoundGroup.BAMBOO_SAPLING) {
            return EnumBlockSoundGroup.BAMBOO_SAPLING;
        } else if (soundGroup == BlockSoundGroup.SCAFFOLDING) {
            return EnumBlockSoundGroup.SCAFFOLDING;
        } else if (soundGroup == BlockSoundGroup.SWEET_BERRY_BUSH) {
            return EnumBlockSoundGroup.SWEET_BERRY_BUSH;
        } else if (soundGroup == BlockSoundGroup.CROP) {
            return EnumBlockSoundGroup.CROP;
        } else if (soundGroup == BlockSoundGroup.STEM) {
            return EnumBlockSoundGroup.STEM;
        } else if (soundGroup == BlockSoundGroup.VINE) {
            return EnumBlockSoundGroup.VINE;
        } else if (soundGroup == BlockSoundGroup.NETHER_WART) {
            return EnumBlockSoundGroup.NETHER_WART;
        } else if (soundGroup == BlockSoundGroup.LANTERN) {
            return EnumBlockSoundGroup.LANTERN;
        } else if (soundGroup == BlockSoundGroup.NETHER_STEM) {
            return EnumBlockSoundGroup.NETHER_STEM;
        } else if (soundGroup == BlockSoundGroup.NYLIUM) {
            return EnumBlockSoundGroup.NYLIUM;
        } else if (soundGroup == BlockSoundGroup.FUNGUS) {
            return EnumBlockSoundGroup.FUNGUS;
        } else if (soundGroup == BlockSoundGroup.ROOTS) {
            return EnumBlockSoundGroup.ROOTS;
        } else if (soundGroup == BlockSoundGroup.SHROOMLIGHT) {
            return EnumBlockSoundGroup.SHROOMLIGHT;
        } else if (soundGroup == BlockSoundGroup.WEEPING_VINES) {
            return EnumBlockSoundGroup.WEEPING_VINES;
        } else if (soundGroup == BlockSoundGroup.WEEPING_VINES_LOW_PITCH) {
            return EnumBlockSoundGroup.WEEPING_VINES_LOW_PITCH;
        } else if (soundGroup == BlockSoundGroup.SOUL_SAND) {
            return EnumBlockSoundGroup.SOUL_SAND;
        } else if (soundGroup == BlockSoundGroup.SOUL_SOIL) {
            return EnumBlockSoundGroup.SOUL_SOIL;
        } else if (soundGroup == BlockSoundGroup.BASALT) {
            return EnumBlockSoundGroup.BASALT;
        } else if (soundGroup == BlockSoundGroup.WART_BLOCK) {
            return EnumBlockSoundGroup.WART_BLOCK;
        } else if (soundGroup == BlockSoundGroup.NETHERRACK) {
            return EnumBlockSoundGroup.NETHERRACK;
        } else if (soundGroup == BlockSoundGroup.NETHER_BRICKS) {
            return EnumBlockSoundGroup.NETHER_BRICKS;
        } else if (soundGroup == BlockSoundGroup.NETHER_SPROUTS) {
            return EnumBlockSoundGroup.NETHER_SPROUTS;
        } else if (soundGroup == BlockSoundGroup.NETHER_ORE) {
            return EnumBlockSoundGroup.NETHER_ORE;
        } else if (soundGroup == BlockSoundGroup.BONE) {
            return EnumBlockSoundGroup.BONE;
        } else if (soundGroup == BlockSoundGroup.NETHERITE) {
            return EnumBlockSoundGroup.NETHERITE;
        } else if (soundGroup == BlockSoundGroup.ANCIENT_DEBRIS) {
            return EnumBlockSoundGroup.ANCIENT_DEBRIS;
        } else if (soundGroup == BlockSoundGroup.LODESTONE) {
            return EnumBlockSoundGroup.LODESTONE;
        } else if (soundGroup == BlockSoundGroup.CHAIN) {
            return EnumBlockSoundGroup.CHAIN;
        } else if (soundGroup == BlockSoundGroup.NETHER_GOLD_ORE) {
            return EnumBlockSoundGroup.NETHER_GOLD_ORE;
        } else if (soundGroup == BlockSoundGroup.GILDED_BLACKSTONE) {
            return EnumBlockSoundGroup.GILDED_BLACKSTONE;
        } else if (soundGroup == BlockSoundGroup.CANDLE) {
            return EnumBlockSoundGroup.CANDLE;
        } else if (soundGroup == BlockSoundGroup.AMETHYST_BLOCK) {
            return EnumBlockSoundGroup.AMETHYST_BLOCK;
        } else if (soundGroup == BlockSoundGroup.AMETHYST_CLUSTER) {
            return EnumBlockSoundGroup.AMETHYST_CLUSTER;
        } else if (soundGroup == BlockSoundGroup.SMALL_AMETHYST_BUD) {
            return EnumBlockSoundGroup.SMALL_AMETHYST_BUD;
        } else if (soundGroup == BlockSoundGroup.MEDIUM_AMETHYST_BUD) {
            return EnumBlockSoundGroup.MEDIUM_AMETHYST_BUD;
        } else if (soundGroup == BlockSoundGroup.LARGE_AMETHYST_BUD) {
            return EnumBlockSoundGroup.LARGE_AMETHYST_BUD;
        } else if (soundGroup == BlockSoundGroup.TUFF) {
            return EnumBlockSoundGroup.TUFF;
        } else if (soundGroup == BlockSoundGroup.CALCITE) {
            return EnumBlockSoundGroup.CALCITE;
        } else if (soundGroup == BlockSoundGroup.DRIPSTONE_BLOCK) {
            return EnumBlockSoundGroup.DRIPSTONE_BLOCK;
        } else if (soundGroup == BlockSoundGroup.POINTED_DRIPSTONE) {
            return EnumBlockSoundGroup.POINTED_DRIPSTONE;
        } else if (soundGroup == BlockSoundGroup.COPPER) {
            return EnumBlockSoundGroup.COPPER;
        } else if (soundGroup == BlockSoundGroup.CAVE_VINES) {
            return EnumBlockSoundGroup.CAVE_VINES;
        } else if (soundGroup == BlockSoundGroup.SPORE_BLOSSOM) {
            return EnumBlockSoundGroup.SPORE_BLOSSOM;
        } else if (soundGroup == BlockSoundGroup.AZALEA) {
            return EnumBlockSoundGroup.AZALEA;
        } else if (soundGroup == BlockSoundGroup.FLOWERING_AZALEA) {
            return EnumBlockSoundGroup.FLOWERING_AZALEA;
        } else if (soundGroup == BlockSoundGroup.MOSS_CARPET) {
            return EnumBlockSoundGroup.MOSS_CARPET;
        } else if (soundGroup == BlockSoundGroup.MOSS_BLOCK) {
            return EnumBlockSoundGroup.MOSS_BLOCK;
        } else if (soundGroup == BlockSoundGroup.BIG_DRIPLEAF) {
            return EnumBlockSoundGroup.BIG_DRIPLEAF;
        } else if (soundGroup == BlockSoundGroup.SMALL_DRIPLEAF) {
            return EnumBlockSoundGroup.SMALL_DRIPLEAF;
        } else if (soundGroup == BlockSoundGroup.ROOTED_DIRT) {
            return EnumBlockSoundGroup.ROOTED_DIRT;
        } else if (soundGroup == BlockSoundGroup.HANGING_ROOTS) {
            return EnumBlockSoundGroup.HANGING_ROOTS;
        } else if (soundGroup == BlockSoundGroup.AZALEA_LEAVES) {
            return EnumBlockSoundGroup.AZALEA_LEAVES;
        } else if (soundGroup == BlockSoundGroup.SCULK_SENSOR) {
            return EnumBlockSoundGroup.SCULK_SENSOR;
        } else if (soundGroup == BlockSoundGroup.SCULK_CATALYST) {
            return EnumBlockSoundGroup.SCULK_CATALYST;
        } else if (soundGroup == BlockSoundGroup.SCULK) {
            return EnumBlockSoundGroup.SCULK;
        } else if (soundGroup == BlockSoundGroup.SCULK_VEIN) {
            return EnumBlockSoundGroup.SCULK_VEIN;
        } else if (soundGroup == BlockSoundGroup.SCULK_SHRIEKER) {
            return EnumBlockSoundGroup.SCULK_SHRIEKER;
        } else if (soundGroup == BlockSoundGroup.GLOW_LICHEN) {
            return EnumBlockSoundGroup.GLOW_LICHEN;
        } else if (soundGroup == BlockSoundGroup.DEEPSLATE) {
            return EnumBlockSoundGroup.DEEPSLATE;
        } else if (soundGroup == BlockSoundGroup.DEEPSLATE_BRICKS) {
            return EnumBlockSoundGroup.DEEPSLATE_BRICKS;
        } else if (soundGroup == BlockSoundGroup.DEEPSLATE_TILES) {
            return EnumBlockSoundGroup.DEEPSLATE_TILES;
        } else if (soundGroup == BlockSoundGroup.POLISHED_DEEPSLATE) {
            return EnumBlockSoundGroup.POLISHED_DEEPSLATE;
        } else if (soundGroup == BlockSoundGroup.FROGLIGHT) {
            return EnumBlockSoundGroup.FROGLIGHT;
        } else if (soundGroup == BlockSoundGroup.FROGSPAWN) {
            return EnumBlockSoundGroup.FROGSPAWN;
        } else if (soundGroup == BlockSoundGroup.MANGROVE_ROOTS) {
            return EnumBlockSoundGroup.MANGROVE_ROOTS;
        } else if (soundGroup == BlockSoundGroup.MUDDY_MANGROVE_ROOTS) {
            return EnumBlockSoundGroup.MUDDY_MANGROVE_ROOTS;
        } else if (soundGroup == BlockSoundGroup.MUD) {
            return EnumBlockSoundGroup.MUD;
        } else if (soundGroup == BlockSoundGroup.MUD_BRICKS) {
            return EnumBlockSoundGroup.MUD_BRICKS;
        } else if (soundGroup == BlockSoundGroup.PACKED_MUD) {
            return EnumBlockSoundGroup.PACKED_MUD;
        }
        throw new IllegalArgumentException("Unknown type");
    }
}
