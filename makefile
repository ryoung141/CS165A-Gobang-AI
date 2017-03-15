default: jar

clean:

	rm *.class
	rm *.jar

jar:
	javac -g AI.java Player.java Human.java Game.java Board.java
	jar cfm Gobang.jar Manifest.txt *.class
