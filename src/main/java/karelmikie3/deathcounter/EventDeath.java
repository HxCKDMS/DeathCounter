package karelmikie3.deathcounter;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import java.io.*;
import java.util.EventListener;

public class EventDeath implements EventListener {

    File mcDir;
    public static int Deaths;
    public static EventDeath instance = new EventDeath();

    @SubscribeEvent
    public void playerDeath(LivingDeathEvent event) {
        if (event.entityLiving instanceof EntityPlayer) {
            try{
                File file = new File(mcDir, "Deaths.txt");

                BufferedReader reader = new BufferedReader(new FileReader(file));
                Deaths = Integer.parseInt(reader.readLine());
                reader.close();
                Deaths++;
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(Deaths + "\n");
                writer.close();
            }catch(IOException exception){
                exception.printStackTrace();
            }
        }
    }
}