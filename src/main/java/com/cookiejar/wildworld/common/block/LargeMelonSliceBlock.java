package com.cookiejar.wildworld.common.block;

import com.cookiejar.wildworld.common.block.property.CarvedSide;
import com.cookiejar.wildworld.common.core.registry.WWBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.Tags;

import javax.annotation.Nullable;

public class LargeMelonSliceBlock extends BaseLargeMelonSliceBlock {

    public LargeMelonSliceBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (itemStack.is(Tags.Items.TOOLS_SHEAR)) {
            Direction direction = hit.getDirection().getAxis() == Direction.Axis.Y ? player.getDirection().getOpposite() : hit.getDirection();
            Direction facing = state.getValue(FACING);

            if (canCarve(direction, facing)) {
                if (!level.isClientSide) {
                    CarvedSide carvedside = CarvedSide.getCarvedSide(direction.getAxis());
                    BlockState newState = WWBlocks.CARVED_LARGE_MELON_SLICE.get().defaultBlockState()
                            .setValue(CarvedLargeMelonSliceBlock.FACING, facing)
                            .setValue(CarvedLargeMelonSliceBlock.HALF, state.getValue(HALF))
                            .setValue(CarvedLargeMelonSliceBlock.CARVED_SIDE, carvedside);

                    level.playSound(null, pos, SoundEvents.PUMPKIN_CARVE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.setBlock(pos, newState, Block.UPDATE_ALL_IMMEDIATE);

                    ItemEntity itemEntity = new ItemEntity(level, (double) pos.getX() + 0.5D + (double) direction.getStepX() * 0.65D, (double) pos.getY() + 0.1D, (double) pos.getZ() + 0.5D + (double) direction.getStepZ() * 0.65D, new ItemStack(Items.MELON_SEEDS, 4));
                    itemEntity.setDeltaMovement(0.05D * (double) direction.getStepX() + level.random.nextDouble() * 0.02D, 0.05D, 0.05D * (double) direction.getStepZ() + level.random.nextDouble() * 0.02D);
                    level.addFreshEntity(itemEntity);

                    itemStack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
                }
                return ItemInteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        return super.useItemOn(itemStack, state, level, pos, player, hand, hit);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        BlockState bottomBlock = context.getLevel().getBlockState(pos.below());
        BlockState topBlock = context.getLevel().getBlockState(pos.above());

        if (bottomBlock.getBlock() instanceof BaseLargeMelonSliceBlock && bottomBlock.getValue(HALF) == Half.BOTTOM) {
            return defaultBlockState().setValue(FACING, bottomBlock.getValue(FACING)).setValue(HALF, Half.TOP);
        }
        else if (topBlock.getBlock() instanceof BaseLargeMelonSliceBlock && topBlock.getValue(HALF) == Half.TOP) {
            return defaultBlockState().setValue(FACING, topBlock.getValue(FACING)).setValue(HALF, Half.BOTTOM);
        }
        Half half = context.getPlayer() == null ? Half.BOTTOM :
                (Mth.sin(context.getPlayer().getViewXRot(1.0F) * ((float) Math.PI / 180F)) > 0 ? Half.BOTTOM : Half.TOP);

        return defaultBlockState()
                .setValue(FACING, getFacing(context))
                .setValue(HALF, half);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HALF);
    }
}
