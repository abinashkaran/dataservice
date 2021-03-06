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

package com.bizosys.dataservice.management;


public class MetricAvgRollup {

	public int requestsProcessed = 0;
	public int totalRequests = 0;
	public int failedRequests = 0;
	public int activeSessions = 0;
	public MetricAvg mmaRequestTime = new MetricAvg();

	public String[] measures = null;
	
	public static final int REQUESTS_ACTIVE = 0;
	public static final int REQUESTS_TOTAL = 1;
	public static final int MIN_RESPONE_MILLIS = 2;
	public static final int AVG_RESPONE_MILLIS = 3;
	public static final int MAX_RESPONE_MILLIS = 4;
	public static final int REQUESTS_FAILED = 5;
	public static final int REQUESTS_PROCESSED = 6;
	
	public MetricAvgRollup(String name) {
		measures = new String[] { 
			name + "_REQUESTS_ACTIVE",
			name + "_REQUESTS_TOTAL",
			name + "_MIN_RESPONE_MILLIS",
			name + "_AVG_RESPONE_MILLIS",
			name + "_MAX_RESPONE_MILLIS",
			name + "_REQUESTS_FAILED",
			name + "_REQUESTS_PROCESSED"
			
		};
	}
	
	public int getRequestsProcessed() {
		requestsProcessed += totalRequests;
		return requestsProcessed;
	}
	
	public void reset() {
		totalRequests = 0;
		activeSessions = 0;
		failedRequests = 0;
		mmaRequestTime.reset();
	}

}
