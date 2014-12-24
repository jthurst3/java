java
====

Library of useful Java functions

Instructions for installing and running:
```
# Clone the repository
git clone https://github.com/jthurst3/java.git
# Add jar file to CLASSPATH (replace /path/to/this/folder with real path)
echo "export CLASSPATH=$CLASSPATH:/path/to/this/folder/doc/hassler.jar" >> .bashrc
# build the Java files from source (optional)
ant
```

Example usage:
```
import static hassler.Basic.hello_world;
import static hassler.Basic.println;

public class HasslerTest {
	public static void main(String[] args) {
		hello_world();
		println("Hello, world!");
	}
}
```

