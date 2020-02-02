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
package lembas.core.internal.client;

import cpw.mods.fml.common.event.*;
import lembas.core.api.client.LembasCoreClient;
import lembas.core.internal.common.LembasCoreCommonImpl;

/*
 * The implementation of the client proxy
 */
public class LembasCoreClientImpl extends LembasCoreCommonImpl implements LembasCoreClient
{

    @Override
    public void onPreInit (FMLPreInitializationEvent event)
    {
        super.onPreInit (event);
    }

    @Override
    public void onInit (FMLInitializationEvent event)
    {
        super.onInit (event);
    }

    @Override
    public void onPostInit (FMLPostInitializationEvent event)
    {
        super.onPostInit (event);
    }

    @Override
    public void onLoadingComplete (FMLLoadCompleteEvent event)
    {
        super.onLoadingComplete (event);
    }

}
