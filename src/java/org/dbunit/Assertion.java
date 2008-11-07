/*
 *
 * The DbUnit Database Testing Framework
 * Copyright (C)2002-2004, DbUnit.org
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */

package org.dbunit;

import java.sql.SQLException;

import org.dbunit.assertion.DefaultDbUnitAssert;
import org.dbunit.assertion.FailureHandler;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.Column;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;

/**
 * Provides static methods for the most common DbUnit assertion needs.
 * 
 * Although the methods are static, they rely on a {@link DefaultDbUnitAssert} instance 
 * to do the work. So, if you need to customize this class behavior, you can create
 * your own {@link DefaultDbUnitAssert} extension.
 * 
 * @author Manuel Laflamme
 * @author Felipe Leme <dbunit@felipeal.net>
 * @author Last changed by: $Author$
 * @version $Revision$ $Date$
 * @since 1.3 (Mar 22, 2002)
 */
public class Assertion {

    /**
     * Object that will effectively do the assertions.
     */
    private static final DefaultDbUnitAssert INSTANCE = new DefaultDbUnitAssert();

    private Assertion() {
        throw new UnsupportedOperationException(
        "this class has only static methods");
    }

    /**
     * @see DefaultDbUnitAssert#assertEqualsIgnoreCols(IDataSet, IDataSet, String, String[])
     */
    public static void assertEqualsIgnoreCols(final IDataSet expectedDataset,
            final IDataSet actualDataset, final String tableName,
            final String[] ignoreCols) throws DatabaseUnitException {
        INSTANCE.assertEqualsIgnoreCols(expectedDataset, actualDataset, tableName,
                ignoreCols);
    }

    /**
     * @see DefaultDbUnitAssert#assertEqualsIgnoreCols(ITable, ITable, String[])
     */
    public static void assertEqualsIgnoreCols(final ITable expectedTable,
            final ITable actualTable, final String[] ignoreCols)
    throws DatabaseUnitException {
        INSTANCE.assertEqualsIgnoreCols(expectedTable, actualTable, ignoreCols);
    }

    /**
     * @see DefaultDbUnitAssert#assertEqualsByQuery(IDataSet, IDatabaseConnection, String, String, String[])
     */
    public static void assertEqualsByQuery(final IDataSet expectedDataset,
            final IDatabaseConnection connection, final String sqlQuery,
            final String tableName, final String[] ignoreCols)
    throws DatabaseUnitException, SQLException {
        INSTANCE.assertEqualsByQuery(expectedDataset, connection, sqlQuery,
                tableName, ignoreCols);
    }

    /**
     * @see DefaultDbUnitAssert#assertEqualsByQuery(ITable, IDatabaseConnection, String, String, String[])
     */
    public static void assertEqualsByQuery(final ITable expectedTable,
            final IDatabaseConnection connection, final String tableName,
            final String sqlQuery, final String[] ignoreCols)
    throws DatabaseUnitException, SQLException {
        INSTANCE.assertEqualsByQuery(expectedTable, connection, tableName,
                sqlQuery, ignoreCols);
    }

    /**
     * @see DefaultDbUnitAssert#assertEquals(IDataSet, IDataSet)
     */
    public static void assertEquals(IDataSet expectedDataSet,
            IDataSet actualDataSet) throws DatabaseUnitException {
        INSTANCE.assertEquals(expectedDataSet, actualDataSet);
    }

    /**
     * @see DefaultDbUnitAssert#assertEquals(IDataSet, IDataSet, FailureHandler)
     * @since 2.4
     */
    public static void assertEquals(IDataSet expectedDataSet,
            IDataSet actualDataSet, FailureHandler failureHandler)
    throws DatabaseUnitException {
        INSTANCE.assertEquals(expectedDataSet, actualDataSet, failureHandler);
    }

    /**
     * @see DefaultDbUnitAssert#assertEquals(ITable, ITable)
     */
    public static void assertEquals(ITable expectedTable, ITable actualTable)
    throws DatabaseUnitException {
        INSTANCE.assertEquals(expectedTable, actualTable);
    }

    /**
     * @see DefaultDbUnitAssert#assertEquals(ITable, ITable, Column[])
     */
    public static void assertEquals(ITable expectedTable, ITable actualTable,
            Column[] additionalColumnInfo) throws DatabaseUnitException {
        INSTANCE.assertEquals(expectedTable, actualTable, additionalColumnInfo);
    }

    /**
     * @see DefaultDbUnitAssert#assertEquals(ITable, ITable, FailureHandler)
     * @since 2.4
     */
    public static void assertEquals(ITable expectedTable, ITable actualTable,
            FailureHandler failureHandler) throws DatabaseUnitException {
        INSTANCE.assertEquals(expectedTable, actualTable, failureHandler);
    }

}
