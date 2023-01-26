package dev.uten2c.fluoritedatagenerator;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.registry.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sound.BlockSoundGroup;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FluoriteDataGenerator implements ModInitializer {
    @Override
    public void onInitialize() {
        generateBlockData();
        ServerLifecycleEvents.SERVER_STARTING.register(MinecraftServer::shutdown);
    }

    private static void generateBlockData() {
        var buf = PacketByteBufs.create();
        var blocks = Registries.BLOCK.stream().toList();
        buf.writeCollection(blocks, (writer, block) -> {
            writer.writeRegistryValue(Registries.BLOCK, block);
            writer.writeEnumConstant(soundGroupToType(block.getSoundGroup(block.getDefaultState())));
        });
        writeFile(Path.of("./block_sound_groups.dat"), buf.array());
    }

    private static void writeFile(Path path, byte[] bytes) {
        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BlockSoundGroupType soundGroupToType(BlockSoundGroup soundGroup) {
        return Arrays.stream(BlockSoundGroupType.values())
                .filter(type -> type.getGroup() == soundGroup)
                .findFirst()
                .orElseThrow();
    }
}
