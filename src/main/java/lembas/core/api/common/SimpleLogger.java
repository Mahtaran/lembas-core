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
package lembas.core.api.common;

import java.util.Objects;
import java.util.function.Function;

/**
 * A simple wrapper for a logger that should use String.format for formatting
 * the log messages. The [...]Throwable functions are there to avoid bugs
 * related to the varargs.
 *
 */
public abstract class SimpleLogger
{

    static Function<String, SimpleLogger> factory;

    /**
     * Creates a logger with the supplied name. If no logging factory is set, an
     * {@link IllegalStateException} will be thrown.
     */
    public static SimpleLogger create (String name)
    {
        if (factory == null)
            throw new IllegalStateException ("No logger factory was set");
        Objects.requireNonNull (name);
        return factory.apply (name);
    }

    /**
     * Sets the provider used to create the loggers. Should only be used by service
     * providers. If null is provided as the factory, no loggers can be created.
     */
    public static void setProvider (Function<String, SimpleLogger> factory)
    {
        SimpleLogger.factory = factory;
    }

    public abstract String getName ();

    public abstract void debug (String message, Object... params);

    public abstract void debugThrowable (String message, Throwable throwable, Object... params);

    public abstract void info (String message, Object... params);

    public abstract void infoThrowable (String message, Throwable throwable, Object... params);

    public abstract void warning (String message, Object... params);

    public abstract void warningThrowable (String message, Throwable throwable, Object... params);

    public abstract void error (String message, Object... params);

    public abstract void errorThrowable (String message, Throwable throwable, Object... params);

}
