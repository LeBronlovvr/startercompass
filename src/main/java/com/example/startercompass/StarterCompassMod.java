package com.example.startercompass;

import com.mojang.brigadier.Command;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;

/**
 * Registers /compass (usable by everyone). Everything else this mod does
 * (first-join kit, hiding coordinates, hiding the locator bar) lives in the
 * data files under src/main/resources/data/.
 */
public class StarterCompassMod implements ModInitializer {
	@Override
	public void onInitialize() {
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
			dispatcher.register(Commands.literal("compass").executes(context -> {
				ServerPlayer player = context.getSource().getPlayerOrException();
				MinecraftServer server = context.getSource().getServer();

				// Run the give_compass function as the player, using the server's own
				// (full-permission) command source so non-op players can use /compass.
				server.getCommands().performPrefixedCommand(
					server.createCommandSourceStack(),
					"execute as " + player.getUUID() + " run function startercompass:give_compass"
				);

				context.getSource().sendSuccess(() -> Component.literal("Here's your compass (points to 0, 0)."), false);
				return Command.SINGLE_SUCCESS;
			}))
		);
	}
}
