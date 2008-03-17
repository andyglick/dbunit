/*
 *
 * The DbUnit Database Testing Framework
 * Copyright (C)2005, DbUnit.org
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
package org.dbunit.util.search;

import java.util.Set;

/**
 * @author Felipe Leme <dbunit@felipeal.net>
 * @version $Revision$
 * @since Aug 25, 2005
 * 
 */
public abstract class AbstractExcludeNodesSearchCallback extends
    AbstractNodesFilterSearchCallback {

  public AbstractExcludeNodesSearchCallback(Set deniedNodes) {
    super();
    setDeniedNodes(deniedNodes);
  }

  public AbstractExcludeNodesSearchCallback(Object[] deniedNodes) {
    super();
    setDeniedNodes(deniedNodes);
  }

}
