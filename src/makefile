JFLAGS = -g
JCC = javac

default: sim.class Binary.class Linear.class Logarithmic.class myBackoff.class

sim.class: sim.java
	$(JCC) $(JFLAGS) sim.java

Binary.class: Binary.java
	$(JCC) $(JFLAGS) Binary.java

Linear.class: Linear.java
	$(JCC) $(JFLAGS) Linear.java

Logarithmic.class: Logarithmic.java
	$(JCC) $(JFLAGS) Logarithmic.java

myBackoff.class: myBackoff.java
	$(JCC) $(JFLAGS) myBackoff.java

clean: 
	$(RM) Binary.class Linear.class Logarithmic.class sim.class myBackoff.class
