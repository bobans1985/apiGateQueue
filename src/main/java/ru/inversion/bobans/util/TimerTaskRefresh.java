package ru.inversion.bobans.util;

import ru.inversion.bobans.block.queueBlock;

import java.util.TimerTask;

/**
 * Created by GrishukovVM on 13.03.2017.
 */
public class TimerTaskRefresh extends TimerTask {
    private queueBlock block_Queue;

    public TimerTaskRefresh(queueBlock block_Queue) {
        this.block_Queue = block_Queue;
    }

    public queueBlock getBlock_Queue() {
        return block_Queue;
    }

    public void setBlock_Queue(queueBlock block_Queue) {
        this.block_Queue = block_Queue;
    }

    @Override
    public void run() {
        try {
            block_Queue.refresh();
        } catch (Exception ex) {
            System.out.println("Error refresh:" + ex.toString());
        }
    }
}
