list:
	cat Makefile

remove:
	find ../ -name "*.html" -type f -delete

all:
	javac Main.java
	javac BaseHTML.java
	javac FileUtils.java
	javac ImageHTML.java
	javac IndexHTML.java

create:
	java Main /home/szelszabi/prog2/prog2_project/everything
