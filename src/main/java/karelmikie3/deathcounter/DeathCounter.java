package karelmikie3.deathcounter;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

import java.io.*;

@Mod(modid = "deathcounter", name = "Death Counter", version = "1.7.10-0.0.1a")

public class DeathCounter {

    File mcDir;

    @Mod.Instance
    public static DeathCounter deathCounter;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(EventDeath.instance);
        try {
            File file = new File(mcDir, "Deaths.txt");

            if (!file.exists()) {
                file.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(0 + "\n");
                writer.close();
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            EventDeath.Deaths = Integer.parseInt(reader.readLine());
            reader.close();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}