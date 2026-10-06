# Starter Compass (Fabric, Minecraft 26.3)

Server-side mod, players don't need to install anything.

- First join: 64 cooked beef + a compass pointing at 0, 0 (once per player)
- `/compass`: gives anyone a new compass
- Coordinates hidden in F3 (`reduced_debug_info`), locator bar off (`locator_bar`)

## Build
Needs JDK 25.

    ./gradlew build        (Windows: gradlew.bat build)

Jar: `build/libs/startercompass-1.0.0.jar` (not the `-sources` one).

No JDK? Push this folder to a GitHub repo, open the Actions tab, run "build",
and download the jar from the Artifacts section.

## Install on Aternos
Software: Fabric, version 26.3. Upload to the Mods tab:
1. Fabric API (0.161.0+26.3 or newer for 26.3) from Modrinth
2. startercompass-1.0.0.jar

Start the server. Done.
