/*
 *
 * The DbUnit Database Testing Framework
 * Copyright (C)2002, Manuel Laflamme
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
package org.dbunit.dataset;

import org.dbunit.dataset.ITableIterator;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.ITableMetaData;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.Column;
import org.dbunit.dataset.RowOutOfBoundsException;
import org.dbunit.dataset.IDataSet;

/**
 * @author Manuel Laflamme
 * @since Apr 17, 2003
 * @version $Revision$
 */
public class DefaultDataSetSource implements IDataSetSource
{
    private final ITableIterator _iterator;

    public DefaultDataSetSource(ITableIterator iterator)
    {
        _iterator = iterator;
    }

    public DefaultDataSetSource(IDataSet dataSet) throws DataSetException
    {
        _iterator = dataSet.iterator();
    }

    ////////////////////////////////////////////////////////////////////////////
    // IDataSetSource interface

    public void process(IDataSetListener _handler) throws DataSetException
    {
        _handler.startDataSet();
        while(_iterator.next())
        {
            ITable table = _iterator.getTable();
            ITableMetaData metaData = table.getTableMetaData();

            _handler.startTable(metaData);
            try
            {
                Column[] columns = metaData.getColumns();
                if (columns.length == 0)
                {
                    _handler.endTable();
                    continue;
                }

                for (int i = 0; ; i++)
                {
                    Object[] values = new Object[columns.length];
                    for (int j = 0; j < columns.length; j++)
                    {
                        Column column = columns[j];
                        values[j] = table.getValue(i, column.getColumnName());
                    }
                    _handler.row(values);
                }
            }
            catch (RowOutOfBoundsException e)
            {
                // end of table
                _handler.endTable();
            }
        }
        _handler.endDataSet();
    }
}

