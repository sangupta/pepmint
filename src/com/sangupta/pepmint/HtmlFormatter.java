/**
 *
 * Pepmit - Java wrapper over Python Pygments library
 * Copyright (c) 2012, Sandeep Gupta
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.sangupta.pepmint;

import org.python.core.PyObject;
import org.python.core.PyString;

/**
 * {@link Formatter} implementation for the HTML formatter of the
 * Pygments library.
 * 
 * @author sangupta
 * @since Feb 2, 2012
 * @version 1.0
 */
public final class HtmlFormatter extends Formatter {

	HtmlFormatter(PyObject formatter) {
		super(formatter);
	}

	public String getStyleDefs(String selector) {
		return formatter.invoke("get_style_defs", new PyString(selector)).asString();
	}

}
