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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bizosys.dataservice.sql.SqlSensor;
import com.bizosys.dataservice.user.UserProfile;
import com.bizosys.dataservice.util.DataserviceConstants;
import com.bizosys.dataservice.util.ErrorCodeExp;
import com.bizosys.dataservice.util.ErrorCodes;
import com.bizosys.dataservice.util.ILogger;
import com.bizosys.dataservice.util.LoggerFactory;

public class TokenAuthentication implements IAuthenticate {

	public static ILogger l = LoggerFactory.getLogger(TokenAuthentication.class, DataserviceConstants.IS_CONSOLE_LOG);
	public ThreadLocal<HttpServletRequest> request;
	public ThreadLocal<HttpServletResponse> response;
	private final static Logger LOG = Logger.getLogger(SqlSensor.class);
	private static final boolean DEBUG_ENABLED = LOG.isDebugEnabled();
	
	
	@Override
	public void setUser(UserProfile user) throws ErrorCodeExp {
		

		if (this.request == null || this.response == null) return;
		HttpServletRequest request = this.request.get();
		HttpServletResponse response = this.response.get();
		if (request == null || response == null) 
			throw new ErrorCodeExp("AUTHORIZATION_ERROR", ErrorCodes.AUTH_FAILURE, "Not ableto authorize user.", ErrorCodes.QUERY_KEY);
		//this.setUser(user, request, response, true);
	}
	
	

	@Override
	public void setUser(UserProfile user, boolean rememberme) {
		
	}
	

	@Override
	public void store(HttpServletRequest request, HttpServletResponse response) {
		
	}

	@Override
	public void removeUser() {
	}

	@Override
	public void clear() {
	}
	

	@Override
	public UserProfile getUser(HttpServletRequest request, 
		HttpServletResponse response) throws ErrorCodeExp {
		String token = request.getParameter("token");
		String appId = request.getParameter("appId");
		
	//	String token = "DD5FBD052C67FA46B8050C062159ADED";
	//	String appId= "app1";
		
		l.debug("TokenAuthentication:getUser > " + token + "appId" +appId);
		
		
		Boolean isMatching = false;
		CookieAuthenticator ckAuthenticator = new CookieAuthenticator();
		isMatching = MD5HashComparator.getInstance().isTokenValid(appId, token);
		System.out.println(isMatching);
			
		if(isMatching){
			UserProfile user = new UserProfile("anonymous@bizosys.com",
					"tenant|1,company|unknown,role|root,user_display_name|Anonymous,locale|en");
			this.setUser(user);
			return user;
		}
		else {
			return null;
		}
}
/**public static void main(String[] args){
	//TokenAuthentication tk =  new TokenAuthentication();
	
	//UserProfile up = tk.getUser(null, null);
	//System.out.println(up.toString());
	} **/
}
