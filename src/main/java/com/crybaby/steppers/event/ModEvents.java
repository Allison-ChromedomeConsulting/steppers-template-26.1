package com.crybaby.steppers.event;

import com.crybaby.steppers.Steppers;
import com.crybaby.steppers.block.ModBlocks;
import com.crybaby.steppers.networking.ServerBoundPackets;
import com.crybaby.steppers.networking.packet.TestPacketC2S;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

import static com.crybaby.steppers.tag.ModTags.Items.NO_FALL_DAMAGE;

@EventBusSubscriber(modid = Steppers.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void registerPayloads(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1");

        registrar.playToServer(TestPacketC2S.TYPE, TestPacketC2S.STREAM_CODEC, ServerBoundPackets::handleTestPacket);

    }

    //Big Steppas negate fall damage
    @SubscribeEvent
    public static void onFall(LivingFallEvent event){
        LivingEntity entity = event.getEntity();

        if (!event.getEntity().getItemBySlot(EquipmentSlot.FEET).is(NO_FALL_DAMAGE)) return;
        if (!(entity.level() instanceof ServerLevel level)) return;
        event.setDamageMultiplier(0f);

        if(event.getDistance() <= 3.0) return;
        level.playSound(null, entity.getX(), entity.getY(), entity.getZ(),
                SoundEvents.CHICKEN_AMBIENT_BABY, SoundSource.PLAYERS, 2.0f, 1.0f);

        level.sendParticles(ParticleTypes.WAX_OFF, entity.getX(), entity.getY(), entity.getZ(), 10,
                0.4, 0.1, 0.4, 0.0);


    }

    //No more trample da farm wahoo
    @SubscribeEvent
    public static void onFarmlandTrample(BlockEvent.FarmlandTrampleEvent event) {
        BlockState above = event.getLevel().getBlockState(event.getPos().above());

            event.setCanceled(true);
    }

    //Till dirt/grass into Golden Farmland yippie
    @SubscribeEvent
    public static void onToolModify(BlockEvent.BlockToolModificationEvent event) {
        if (event.getItemAbility() != ItemAbilities.HOE_TILL) return;
        if (!event.getHeldItemStack().is(Items.GOLDEN_HOE)) return;

        BlockState state = event.getState();
        if (!(state.is(Blocks.DIRT) || state.is(Blocks.GRASS_BLOCK))) return;
        
        if (!event.getLevel().getBlockState(event.getPos().above()).isAir()) return;

        event.setFinalState(ModBlocks.GOLDEN_FARMLAND.get().defaultBlockState());
    }



}
