package veravity.net.rechonv;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.plugin.java.JavaPlugin;

public final class Recho_nv extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        // Plugin initialization code
        getCommand("nv").setExecutor(this); // Register the command executor
    }

    @Override
    public void onDisable() {
        // Plugin cleanup code
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be executed by players.");
            return true;
        }

        Player player = (Player) sender;
        if (!player.hasPermission("recho.nightvision")) {
            player.sendMessage("You don't have permission to use this command.");
            return true;
        }

        if (player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
            player.removePotionEffect(PotionEffectType.NIGHT_VISION);
            player.sendMessage("Night vision disabled!");
        } else {
            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0, false, false));
            player.sendMessage("Night vision enabled!");
        }

        return true;
    }
}
