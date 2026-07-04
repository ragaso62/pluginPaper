package com.lucas;
import org.bukkit.NamespacedKey;

public class ItemKeys {
    public final NamespacedKey espadaEspecial;

    public ItemKeys(MeuPlugin plugin) {
        this.espadaEspecial = new NamespacedKey(plugin, "espada_especial");
    }
}
