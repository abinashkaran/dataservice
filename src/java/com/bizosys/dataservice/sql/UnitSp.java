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

package com.bizosys.dataservice.sql;

import java.util.List;

import com.bizosys.dataservice.model.StoredProcConfig;
import com.bizosys.dataservice.model.StoredProcOutParam;


public class UnitSp extends UnitStep {
	
	public StoredProcConfig spId = null ;
	public String variables = null;
	List<Object> inParams  = null;
	List<StoredProcOutParam> queryOutVars = null;
	List<String> inputVars  = null;
	
	public UnitSp(StoredProcConfig spId , String variables, List<Object> inParams, List<StoredProcOutParam> queryOutVars, List<String> inputVars ) {
		this.spId = spId;
		this.variables = variables;
		this.inParams = inParams;
		this.queryOutVars = queryOutVars;
		this.inputVars = inputVars;
	}

	public UnitStep cloneIt() {
		return new UnitSp(spId,variables,inParams,queryOutVars,inputVars);
	}
}
