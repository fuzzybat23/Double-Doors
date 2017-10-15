package com.fuzzybat23.ddoors;


import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DoubleDoorsOpener
{
    public DoubleDoorsOpener()
    { }

    @SubscribeEvent
    public void onDoorInteract(PlayerInteractEvent.RightClickBlock event)
    {
        EntityPlayer player = event.getEntityPlayer();
        BlockPos blockpos = event.getPos().offset(event.getFace());
        Block block = player.getEntityWorld().getBlockState(blockpos).getBlock();


        if( WoodenDoor.WoodenDoor(block) )
            return;

    }
}
