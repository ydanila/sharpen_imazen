ABOUT SHARPEN
-------------

Sharpen is an Eclipse plugin which can covert Java code to C#.
This free plugin has been implemented by db4o.

See the following pages for more information:

Product description:
http://developer.db4o.com/Projects/html/projectspaces/db4o_product_design/sharpen.html

User guide:
http://developer.db4o.com/Documentation/Reference/db4o-7.12/java/reference/html/reference/sharpen.html

Source code:
https://source.db4o.com/db4o/trunk/sandbox/blogs/SharpenExamples/ContactList

##External Sharpen configuration

###When to create external config

Sharpen options file does not allows to fully override conversion options and behaviour. For example if you need to change mapping of primitive types or allow/deny mapping iterator to enumerator, ...

###Creating external config

To create external config new configuration class must:
* inherit [Configuration](sharpen.core/src/sharpen/core/Configuration.java) class;
* must be public visible;
* must have public constructor;

Example configuration project could be found here https://github.com/ydanila/sharpen_imazen_config.

###How to use external config

Place file with name \<configuration class name\>.sharpenconfig.jar in Sharpen directory. Then specify full configuration name via command line parameter or options file and if configuration library and name matches all requirements - it will be loaded.
