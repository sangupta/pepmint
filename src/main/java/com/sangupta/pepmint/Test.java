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

/**
 * A simple command line test application to demonstrate the
 * usage of the {@link Pepmint} library.
 * 
 * @author sangupta
 * @since Feb 2, 2012
 * @version 1.0
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pepmint pepmint = new Pepmint();
		Lexer l = pepmint.newLexer("xml");
		Formatter f = pepmint.newHtmlFormatter("");
		
		long start = System.currentTimeMillis();
		String out = pepmint.highlight("<a>123</a>", l, f);
		long end = System.currentTimeMillis();
		
		System.out.println(out);
		System.out.println("Decorated in " + (end - start) + "ms.");
	}

}
