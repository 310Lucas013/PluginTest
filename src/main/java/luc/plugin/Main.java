package luc.plugin;

import luc.plugin.command.TestCommand;
import luc.plugin.file.Configuration;
import luc.plugin.listener.TestListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    private boolean debug = false;
    private boolean vault = false;
    private boolean logging = false;

    private boolean disabling = false;

    @Override
    public void onLoad() {
        Configuration configuration = new Configuration(this);
        configuration.loadDefaultConfig();

        setDebug(getConfig().getBoolean("debug"));
        setVault(getConfig().getBoolean("vault"));
        setLogging(getConfig().getBoolean("transaction_log"));
    }

    @Override
    public void onEnable() {
        instance = this;

        getServer().getPluginManager().registerEvents(new TestListener(), this);
        getCommand("test").setExecutor(new TestCommand());

    }





    private void setDebug(boolean debug) {
        this.debug = debug;
    }

    private void setVault(boolean vault) {
        this.vault = vault;
    }

    public void setLogging(boolean logging) {
        this.logging = logging;
    }

    public static Main getInstance() {
        return instance;
    }
}
