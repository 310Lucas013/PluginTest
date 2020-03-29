package luc.plugin.file;

import luc.plugin.Main;
import org.bukkit.configuration.file.FileConfiguration;

public class Configuration {
    private Main main;

    public Configuration(Main main) {
        this.main = main;
    }

    public void loadDefaultConfig() {

        FileConfiguration config = main.getConfig();

        config.options().header(main.getDescription().getName()
                + "\n"
                + "Version: " + main.getDescription().getVersion()
                + "\nTestPlugin Main Configuration file."
                + "\n"
                + "Developer(s): " + main.getDescription().getAuthors()
                + "\n\n"
                + "You have three valid storage methods, yaml, mysql or sqlite. If you choose mysql you would have to enter the database credentials down below."
                + "\n"
                + "All messages below are configurable, I hope you use them because it took 1 hour to make all of them into the plugin and configurable.");

        String path = "Messages.";

        config.addDefault("storage", "yaml");
        config.addDefault("debug", false);
        config.addDefault("vault", false);
        config.addDefault("transaction_log", true);

        config.options().copyDefaults(true);
        main.saveConfig();
        main.reloadConfig();
    }

}
