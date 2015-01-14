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

##How to call Sharpen from command line

* If you don't have or don't need custom options for the configuration. Just call it from Sharpen directory with specified java source directory. Project will be converted using default configuration.
```
java -jar sharpen-jar-with-dependencies.jar C:/java_src/
```
* If you need to override some conversion options, you can use configuration file which contains all required data for this. For example, for the [XMP core port](https://github.com/ydanila/n-metadata-extractor/tree/xmp-core) it could be used like this.
```
java -jar sharpen-jar-with-dependencies.jar C:/java_src/ @sharpen-all-options-without-configuration
```
* If you also need to specify conversion configuration, you can do this using command line option. For example, for the [XMP core port](https://github.com/ydanila/n-metadata-extractor/tree/xmp-core) with this prebuilt [Sharpen configuration](https://github.com/ydanila/sharpen_imazen_config) it could be used like this.
```
java -jar sharpen-jar-with-dependencies.jar C:/java_src/ -configurationClass sharpen.config.MEConfiguration @sharpen-all-options-without-configuration
```
Configuration also could be specified in options file. In this case, for the [XMP core port](https://github.com/ydanila/n-metadata-extractor/tree/xmp-core) with this prebuilt [Sharpen configuration](https://github.com/ydanila/sharpen_imazen_config) it could be used like this.
```
java -jar sharpen-jar-with-dependencies.jar C:/java_src/ @sharpen-all-options
```