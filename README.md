## Spigot-Maven-Plugin-Tutorial
This repository contains a basic template of a spigot plugin. Spigot's predecessor Bukkit was and is still used to code a lot of plugins for minecraft servers.

In case you are wondering what plugins are, here's a brief explaination:
+ plugins are soly run on servers
+ you can not modify the client in any way
+ you can not influence client side settings: like the key on which the player opens his inventory
+ you can only change or modify items and functions which are already included in vanilla minecraft

With all that said I hope that I haven't extinguish the fire inside you because there are more than enough possibilities with plugins alone. But in case you are not satisfied you should look up **FORGE MODS** right now.

*Please note that I only code plugins in Eclipse, there might be some tweaks you need to do to adjust it to your platform!*

### Let's get started
We are going to have a look at the ...
+ [Package Structure](#package-structure)
+ [Maven](#maven)
+ [Main](#main) (the Entry of the Plugin)
+ [Events](#events)
+ [Commands](#commands)
+ [plugin.yml](#plugin.yml)
+ [config.yml](#config.yml)

### Package Structure
After downloading the project from this repository we will first rename (refactor -> rename) the project so that it matches this naming pattern:

**\<country-code\>.\<author\>.\<plugin-name\>**

***This is important because it is impossible in Java to load two plugins with the same plugin name!***

### Maven
What is [Maven](https://maven.apache.org/): *Maven is used to manage all your dependencies and support you when compileing your java projects.*

Before we start we still need to set the \<groupId\> and the \<artifactId\> as well as the \<version\>. In case we don't want the name of the plugin to be written the same way as the \<artifactId\>, we can redefine the name ourselfes by filling in the following tag: \<name\>

First of all we need to add the [spigot and bungeecord repository](https://hub.spigotmc.org/nexus/#view-repositories;snapshots~browsestorage) to our pom file (pom.xml) because those libraries are not hosted on the [Maven Central](https://mvnrepository.com/repos/central) repository. For further information like integration into gradle please look up the [Spigot Help Page](https://www.spigotmc.org/wiki/spigot-maven/)

```xml
<repositories>
    <!--Spigot Repo-->
    <repository>
        <id>spigot-repo</id>
        <url>https://hub.spigotmc.org/nexus/content/repositories/snapshots/</url>
    </repository>
    <!--Bungeecord Repo-->
    <repository>
       <id>bungeecord-repo</id>
       <url>https://oss.sonatype.org/content/repositories/snapshots</url>
    </repository>
</repositories>
```

After that we need to add the spigot and bungecord dependencies into the pom file. Please note that the dependency is scoped as *provided* because is is already contained in the spigot server when it is loaded by the server!

```xml
<dependencies>
    <!--Spigot API-->
    <!--You only need one of the two, don't put both. Spigot is recommended.-->
    <dependency>
           <groupId>org.spigotmc</groupId>
           <artifactId>spigot-api</artifactId>
           <version>1.14.2-R0.1-SNAPSHOT</version>
           <scope>provided</scope>
    </dependency>
  ...
</dependencies>
```

With those two things you would have enough to start codeing but for compiling you still need a compiler! In case you set the *\<name\>* tag before, you can now change the *\<finalName\>* tag to match *\<finalName\>${project.name}-${project.version}\</finalName\>*

```xml
<build>
	<sourceDirectory>src/main/java</sourceDirectory>
	<plugins>
		<plugin>
			<artifactId>maven-assembly-plugin</artifactId>
			<executions>
				<execution>
					<phase>package</phase>
					<goals>
						<goal>single</goal>
					</goals>
				</execution>
			</executions>
			<configuration>
				<descriptorRefs>
					<descriptorRef>jar-with-dependencies</descriptorRef>
				</descriptorRefs>
				<appendAssemblyId>false</appendAssemblyId>
				<finalName>${project.artifactId}-${project.version}</finalName>
			</configuration>
		</plugin>
		<plugin>
			<artifactId>maven-compiler-plugin</artifactId>
			<version>3.7.0</version>
			<configuration>
				<source>1.8</source>
				<target>1.8</target>
			</configuration>
		</plugin>
	</plugins>
</build>
```

To compile you should run maven with following goals in order:
1. compile
2. assembly:single
