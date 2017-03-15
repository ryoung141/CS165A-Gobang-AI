default: jar

clean:

	rm *.class
	rm Gobang.jar
	rm *.out
jar:
	javac -g AI.java Player.java Human.java Game.java Board.java
	jar cfm Gobang.jar Manifest.txt *.class
