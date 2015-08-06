/*
* Copyright 2015 Bizosys Technologies Limited
*
* Licensed to the Bizosys Technologies Limited (Bizosys) under one
* or more contributor license agreements. See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership. The Bizosys licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License. You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.bizosys.dataservice.dao;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

//import org.apache.log4j.Logger;

public class ReadArray extends ReadBase<Object[]> {

	private final static Logger LOG = Logger.getLogger(ReadArray.class);
	
	protected List<Object[]> populate() throws SQLException {
		if ( null == this.rs) {
			LOG.warn("Rs is not initialized.");
			throw new SQLException("Rs is not initialized.");
		}
		
		ResultSetMetaData md = rs.getMetaData() ;
		int totalCol = md.getColumnCount();
		
		List<Object[]> records = new ArrayList<Object[]>();
		while (this.rs.next()) {
			Object[] cols = new Object[totalCol];
			for ( int i=0; i<totalCol; i++) {
				cols[i] = rs.getObject(i+1);
			}
			records.add(cols);
		}
		return records;
	}

	@Override
	protected Object[] getFirstRow() throws SQLException {
		if ( null == this.rs) {
			LOG.warn("Rs is not initialized.");
			throw new SQLException("Rs is not initialized.");
		}
		
		ResultSetMetaData md = rs.getMetaData() ;
		int totalCol = md.getColumnCount();
		
		if (this.rs.next()) {
			Object[] cols = new Object[totalCol];
			for ( int i=0; i<totalCol; i++) {
				cols[i] = rs.getObject(i+1);
			}
			return cols;
		}
		
		return null;
	}
}