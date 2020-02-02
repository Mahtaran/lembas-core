/*******************************************************************************
 * Copyright (C) 2019-2020 Lembas Modding Team
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package lembas.core;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.event.*;
import lembas.core.api.client.LembasCoreClient;
import lembas.core.api.server.LembasCoreServer;
import lembas.core.internal.client.LembasCoreClientImpl;
import lembas.core.internal.common.LembasCoreCommonImpl;
import lembas.core.internal.server.LembasCoreServerImpl;

/**
 * The main mod file of Lembas Core. Everything which can be accessed from the
 * outside (modid, version, getClient(), ...) is considered to be a part of the
 * API. Internal implementation details (for example the proxy implementation
 * classes) ARE NOT PART OF THE API.
 *
 */
@Mod(modid = LembasCore.MODID, version = LembasCore.VERSION, name = "Lembas Core", acceptedMinecraftVersions = "*")
public class LembasCore
{

    public static final String MODID = "lembas-core";
    public static final String VERSION = "@version@"; // Injected by gradle

    @Instance(value = LembasCore.MODID)
    public static LembasCore instance;

    @SidedProxy(clientSide = "lembas.core.internal.client.LembasCoreClientImpl", serverSide = "lembas.core.internal.server.LembasCoreServerImplF", modId = LembasCore.MODID)
    public static LembasCoreCommonImpl proxy;

    private LembasCoreClientImpl client;
    private LembasCoreServerImpl server;

    /**
     * Returns the client proxy instance. If called server-side, an exception will
     * be thrown. The instance won't change - it can be cached by the caller.
     * 
     * @return The client proxy instance
     */
    public LembasCoreClient getClient ()
    {
        if (client == null)
        {
            client = (LembasCoreClientImpl) proxy;
        }
        return client;
    }

    /**
     * Returns the server proxy instance - only if called on the PHYSICAL server. If
     * called client-side or via an integrated server, an exception will be thrown.
     * The instance won't change - it can be cached by the caller.
     * 
     * @return The server proxy instance
     */
    public LembasCoreServer getServer ()
    {
        if (server == null)
        {
            server = (LembasCoreServerImpl) proxy;
        }
        return server;
    }

    @EventHandler
    public void onPreInit (FMLPreInitializationEvent event)
    {
        proxy.onPreInit (event);
    }

    @EventHandler
    public void onInit (FMLInitializationEvent event)
    {
        proxy.onInit (event);
    }

    @EventHandler
    public void onPostInit (FMLPostInitializationEvent event)
    {
        proxy.onPostInit (event);
    }

    @EventHandler
    public void onLoadingComplete (FMLLoadCompleteEvent event)
    {
        proxy.onLoadingComplete (event);
    }

    @EventHandler
    public void onServerStarting (FMLServerStartingEvent event)
    {
        // Will be executed for integrated servers too - but the proxy is not the server
        // proxy there
        if (proxy instanceof LembasCoreServerImpl)
        {
            ((LembasCoreServerImpl) proxy).onServerStarting (event);
        }
    }

    @EventHandler
    public void onServerStopping (FMLServerStoppingEvent event)
    {
        if (proxy instanceof LembasCoreServerImpl)
        {
            ((LembasCoreServerImpl) proxy).onServerStopping (event);
        }
    }

}
