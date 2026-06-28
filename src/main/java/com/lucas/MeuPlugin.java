package com.lucas;

import org.bukkit.plugin.java.JavaPlugin;

// JavaPlugin é a classe base que todo plugin Paper/Bukkit precisa estender
public class MeuPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Esse método roda automaticamente quando o servidor liga o plugin
        getLogger().info("Plugin ligado!");

        getServer().getPluginManager().registerEvents(new MeuListener(), this);

        //Registra o novo listener da espada
        getServer().getPluginManager().registerEvents(new EspadaListener(this), this);

        //Registra o comando - o nome "darespada" precisa bater com o que vamos colocar no plugin.yml
        getCommand("darespada").setExecutor(new DarEspadaCommand(this));

        // Aqui é o passo MAIS IMPORTANTE: registrar o listener.
        // Sem essa linha, o @EventHandler no MeuListener nunca seria chamado,
        // mesmo a classe existindo - o Bukkit não saberia que ela existe.
        // "this" é o próprio plugin (precisa informar pra qual plugin esse listener pertence)
        getServer().getPluginManager().registerEvents(new MeuListener(), this);
    }

    @Override
    public void onDisable() {
        // Esse método roda automaticamente quando o servidor desliga ou recarrega o plugin
        getLogger().info("Plugin desligado!");
    }
}