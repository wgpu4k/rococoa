/*
 * Copyright 2007, 2008, 2009 Duncan McGregor
 *
 * This file is part of Rococoa, a library to allow Java to talk to Cocoa.
 *
 * Rococoa is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Rococoa is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Rococoa.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.rococoa.cocoa.foundation;

import org.rococoa.ObjCClass;
import org.rococoa.Rococoa;


public abstract class NSNumber extends NSObject {
    public static final _Class CLASS = Rococoa.createClass("NSNumber", _Class.class); //$NON-NLS-1$

    public interface _Class extends ObjCClass {
        NSNumber numberWithBool(boolean value);

        NSNumber numberWithInt(int value);

        NSNumber numberWithDouble(double e);

        NSNumber numberWithLong(long value);

        NSNumber numberWithFloat(float value);
    }

    public abstract short shortValue();

    public abstract int intValue();

    public abstract long longValue();

    public abstract float floatValue();

    public abstract double doubleValue();

    public abstract int compare(NSNumber another);
}