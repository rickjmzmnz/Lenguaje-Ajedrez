clean:
	rm src/tipos/*.class
	rm src/auxiliares/*.class
	rm src/procedimientos/*.class
	rm *.class

exec:
	javac src/tipos/*.java
	javac src/auxiliares/*.java
	javac src/procedimientos/*.java
	javac Main.java
	java Main
