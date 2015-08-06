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

package com.bizosys.dataservice.util;

import java.io.IOException;

public class CreateException extends Exception  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreateException(InstantiationException ex) {
		super(ex);
	}
	
	public CreateException(IllegalAccessException ex) {
		super(ex);
	}

	public CreateException(ClassNotFoundException ex) {
		super(ex);
	}

	public CreateException(IOException ex) {
		super(ex);
	}
	
	public CreateException(String ex) {
		super(ex);
	}
	
}
