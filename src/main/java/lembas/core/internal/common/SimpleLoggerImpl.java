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
package lembas.core.internal.common;

import org.apache.logging.log4j.Logger;

import lembas.core.api.common.SimpleLogger;

/*
 * Implementation of the SimpleLogger which uses a Log4j logger as backend.
 */
public class SimpleLoggerImpl extends SimpleLogger
{

    private final Logger logger;

    public SimpleLoggerImpl (Logger logger)
    {
        this.logger = logger;
    }

    @Override
    public String getName ()
    {
        return logger.getName ();
    }

    @Override
    public void debug (String message, Object... params)
    {
        logger.debug (String.format (message, params));
    }

    @Override
    public void debugThrowable (String message, Throwable throwable, Object... params)
    {
        logger.debug (String.format (message, params), throwable);

    }

    @Override
    public void info (String message, Object... params)
    {
        logger.info (String.format (message, params));
    }

    @Override
    public void infoThrowable (String message, Throwable throwable, Object... params)
    {
        logger.info (String.format (message, params), throwable);
    }

    @Override
    public void warning (String message, Object... params)
    {
        logger.warn (String.format (message, params));
    }

    @Override
    public void warningThrowable (String message, Throwable throwable, Object... params)
    {
        logger.warn (String.format (message, params), throwable);
    }

    @Override
    public void error (String message, Object... params)
    {
        logger.error (String.format (message, params));
    }

    @Override
    public void errorThrowable (String message, Throwable throwable, Object... params)
    {
        logger.error (String.format (message, params), throwable);
    }

}
