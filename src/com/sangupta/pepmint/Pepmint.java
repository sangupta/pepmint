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

import java.io.File;

import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

/**
 * Main library class to handle communication with the Pygments python library.
 * 
 * @author sangupta
 * @since 31 Jan 2012
 * @version 1.0
 */
public final class Pepmint {
	
	/**
	 * My private instance of the {@link PythonInterpreter}.
	 */
	private final PythonInterpreter pythonInterpreter = new PythonInterpreter();
	
	/**
	 * Constructor. Do the ground work for subsequent calls.
	 */
	public Pepmint() {
		pythonInterpreter.exec("import sys");
		pythonInterpreter.exec("sys.path.append('__pyclasspath__/Lib')");
		
		String codePath;
        
        codePath = new File("C:/projects/git/jarments/src/jython").getAbsoluteFile().getAbsolutePath();
        pythonInterpreter.exec("sys.path.append('" + codePath + "')");
        
        codePath = new File("C:/projects/git/jarments/src").getAbsoluteFile().getAbsolutePath();
        pythonInterpreter.exec("sys.path.append('" + codePath + "')");
        
		pythonInterpreter.exec("from pygments import highlight");
		pythonInterpreter.exec("from pygments.lexers import get_lexer_by_name");
		pythonInterpreter.exec("from pygments.formatters import HtmlFormatter");
	}
	
	/**
	 * Obtain a new lexer implementation based on the given lexer name.
	 * 
	 * @param name
	 * @return
	 */
	public Lexer newLexer(String name) {
		PyObject object = pythonInterpreter.get("get_lexer_by_name");
		object = object.__call__(new PyString(name));
		return new Lexer(object);
	}
	
	/**
	 * Create a new HTMLFormatter object using the given parameters.
	 * 
	 * @param params
	 * @return
	 */
	public HtmlFormatter newHtmlFormatter(String params) {
		PyObject object = pythonInterpreter.eval("HtmlFormatter(" + params + ")");
		return new HtmlFormatter(object);
	}
	
	/**
	 * Highlight the given code piece using the provided lexer and formatter.
	 * 
	 * @param code
	 * @param lexer
	 * @param formatter
	 * @return
	 */
	public String highlight(String code, Lexer lexer, Formatter formatter) {
		PyFunction function = pythonInterpreter.get("highlight", PyFunction.class);
		
		PyString pyCode = new PyString(code);
		PyObject pyLexer = lexer.getLexer();
		PyObject pyFormatter = formatter.getFormatter();
		
		return function.__call__(pyCode, pyLexer, pyFormatter).asString();
	}
	
}
