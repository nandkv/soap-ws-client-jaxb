# soap-ws-client-jaxb

## Ensure that the classpath includes the target folder target/generated-sources/jaxb

## Command Line to generate the classes / client.jar
### wsimport -Xnocompile -XdisableSSLHostnameVerification -d generated -extension -p com.service -clientjar client.jar -b bindings.xjb <wsdl url>

## Customized bindings
#### to avoid JAXBElement review the bindings.xjb

## Plugins to generate classes review the plugins in pom.xml
#### If you do not specify the target default would be target package. Add this to class path.
#### If you want to specify a package add to the options
#### You can disable host checking if relying on the wsdl



