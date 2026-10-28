package com.crybaby.steppers.networking;

import com.crybaby.steppers.networking.packet.TestPacketC2S;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;

// We out here, on Da Server
public class ServerBoundPackets {
    public static void handleTestPacket(TestPacketC2S testPacket, IPayloadContext context) {
        Player player = context.player();
        ServerLevel level = ((ServerLevel) player.level());

    }
}
