clean:
	rm -rf build/

compile:
	mkdir build
	mkdir build/src
	mkdir build/src/tipos
	mkdir build/src/auxiliares
	mkdir build/src/estructuras
	mkdir build/src/procedimientos
	javac src/tipos/*.java
	javac src/auxiliares/*.java
	javac src/estructuras/*.java
	javac src/procedimientos/*.java
	javac Main.java
	mv src/tipos/*.class build/src/tipos/
	mv src/auxiliares/*.class build/src/auxiliares/
	mv src/estructuras/*.class build/src/estructuras/
	mv src/procedimientos/*.class build/src/procedimientos/
	mv *.class build/
