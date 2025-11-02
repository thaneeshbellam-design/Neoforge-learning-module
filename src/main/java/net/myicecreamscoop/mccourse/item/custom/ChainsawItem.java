package net.myicecreamscoop.mccourse.item.custom;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class ChainsawItem extends Item {

    public ChainsawItem(Properties properties) {
        super(properties);
    }

    // --- Break logs on right-click ---
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();

        if (!level.isClientSide()) {
            if (level.getBlockState(pContext.getClickedPos()).is(BlockTags.LOGS)) {
                level.destroyBlock(pContext.getClickedPos(), true, pContext.getPlayer());

                ItemStack stack = pContext.getItemInHand();
                int max = stack.getMaxDamage();
                int next = Math.min(max - 1, stack.getDamageValue() + 1);
                stack.setDamageValue(next);
            }
        }

        return InteractionResult.CONSUME;
    }

    // --- Refuel when right-clicking with coal in offhand ---
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack chainsaw = player.getItemInHand(hand);
        ItemStack offhand = player.getOffhandItem();

        if (!level.isClientSide()) {
            if (offhand.is(Items.COAL) || offhand.is(Items.CHARCOAL)) {
                int repaired = Math.max(0, chainsaw.getDamageValue() - 10);
                chainsaw.setDamageValue(repaired);
                offhand.shrink(1);

                player.displayClientMessage(
                        net.minecraft.network.chat.Component.literal("Chainsaw refueled (+10 durability)!"),
                        true
                );

                return InteractionResultHolder.success(chainsaw);
            }
        }

        return InteractionResultHolder.pass(chainsaw);
    }
}
