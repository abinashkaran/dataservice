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
package com.bizosys.dataservice.authorization;

import org.apache.log4j.Logger;

import com.bizosys.dataservice.sql.SqlSensor;
import com.bizosys.dataservice.util.CreateException;
import com.bizosys.dataservice.util.DataserviceConstants;


public class AuthorizationFactory {

	private static AuthorizationFactory instance = null;

	public static AuthorizationFactory getInstance() {
		if ( null != instance ) return instance;
		synchronized (AuthorizationFactory.class.getName()) {
			if ( null != instance ) return instance;
			instance = new AuthorizationFactory();
		}
		return instance;
	}
	
	IAuthroize authorizationImplInstance = null;
	Logger LOG = Logger.getLogger(SqlSensor.class);
	
	public IAuthroize getAuthorizationcatorImpl() throws CreateException {

		if ( null != authorizationImplInstance) return authorizationImplInstance;

		synchronized (IAuthroize.class.getName()) {
			if ( null != authorizationImplInstance ) return authorizationImplInstance;
			try {
				LOG.info("Initializing the authorizer module :" + DataserviceConstants.AUTHORIZATION_CLASS);
				Object authroizorImplInstanceO = Class.forName(DataserviceConstants.AUTHORIZATION_CLASS).newInstance();
				if( ! (authroizorImplInstanceO instanceof IAuthroize) )
					throw new CreateException("Couldnot find the authorizer Implementation: [" + authorizationImplInstance + "]");
				this.authorizationImplInstance = (IAuthroize) authroizorImplInstanceO;
			} catch (Exception e) {
				LOG.fatal(e);
				throw new CreateException("Unable to crate the authorizor : " + DataserviceConstants.AUTHORIZATION_CLASS);
			} 
			
		}
		return authorizationImplInstance;
	}	
}