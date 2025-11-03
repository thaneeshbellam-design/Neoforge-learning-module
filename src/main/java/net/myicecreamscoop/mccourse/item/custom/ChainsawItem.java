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
        ItemStack stack = pContext.getItemInHand();

        // Stop breaking if durability is at 1
        if (stack.getDamageValue() >= stack.getMaxDamage() - 1) {
            return InteractionResult.FAIL;
        }

        if (!level.isClientSide()) {
            if (level.getBlockState(pContext.getClickedPos()).is(BlockTags.LOGS)) {
                level.destroyBlock(pContext.getClickedPos(), true, pContext.getPlayer());

                int max = stack.getMaxDamage();
                int next = Math.min(max - 1, stack.getDamageValue() + 1);
                stack.setDamageValue(next);
            }
        }

        return InteractionResult.CONSUME;
    }

    // --- Refuel chainsaw with coal in offhand ---
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack chainsaw = player.getItemInHand(hand); // chainsaw in main hand
        ItemStack offhand = player.getOffhandItem();      // coal in offhand

        if (!level.isClientSide()) {
            // Only refuel if chainsaw is not already at 0 damage (full durability)
            if ((offhand.is(Items.COAL) || offhand.is(Items.CHARCOAL)) && chainsaw.getDamageValue() > 0) {
                int repaired = Math.max(0, chainsaw.getDamageValue() - 10);
                chainsaw.setDamageValue(repaired);

                offhand.shrink(1); // consume coal

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
