Pepmint is a JAVA wrapper over the famous [Pygments library](http://pygments.org) written in Python. [Jython](http://jython.org) is used as the python interpreter for the JVM.

The current release uses the following version of frameworks:

* Java 1.6
* Jython 2.5.2
* Pygments 1.4

The library can be used as,

```java
public String highlight(String code, String language) {
	Pepmint pepmint = null;
	Lexer lexer = pepmint.newLexer(format);
	Formatter formatter = pepmint.newHtmlFormatter(formatterParams);
	
	String formattedCode = pepmint.highlight(code, lexer, formatter);
	return formattedCode;
}
```

License
-------
	
	Copyright (c) 2012, Sandeep Gupta
	
	For more details on the project refer to link,
	http://www.sangupta.com/projects/pepmint
	
	The project uses various other libraries that are subject to their
	own license terms. See the distribution libraries or the project
	documentation for more details.

	The entire source is licensed under the Apache License, Version 2.0 
	(the "License"); you may not use this file except in compliance with
	the LICENSE as included in the distribution. You may obtain a copy of
	the License at

		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
