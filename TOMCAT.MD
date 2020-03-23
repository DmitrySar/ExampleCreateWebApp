# Tomcat

1. Скачиваем контейнер сервлетов [Tomcat](http://mirror.linux-ia64.org/apache/tomcat/tomcat-9/v9.0.33/bin/apache-tomcat-9.0.33.zip)
2. Распаковываем в d:\tomcat

	 Содержимое папки D:\tomcat

	11.03.2020  15:12    <DIR>          .
	11.03.2020  15:12    <DIR>          ..
	11.03.2020  15:12    <DIR>          bin
	11.03.2020  15:12            19 540 BUILDING.txt
	11.03.2020  17:14    <DIR>          conf
	11.03.2020  15:12             5 545 CONTRIBUTING.md
	20.03.2020  13:37    <DIR>          lib
	11.03.2020  15:12            58 153 LICENSE
	20.03.2020  15:11    <DIR>          logs
	11.03.2020  15:12             2 401 NOTICE
	11.03.2020  15:12             3 334 README.md
	11.03.2020  15:12             7 072 RELEASE-NOTES
	11.03.2020  15:12            16 738 RUNNING.txt
	11.03.2020  15:12    <DIR>          temp
	11.03.2020  17:14    <DIR>          webapps
	11.03.2020  17:14    <DIR>          work
	               7 файлов        112 783 байт
	               9 папок  513 752 997 888 байт свободно

3. Открыть в текстовом редакторе d:\tomcat\bin\catalina.bat
	заменить:
	    :emptyClasspath
	    set "CLASSPATH=%CLASSPATH%%CATALINA_HOME%\bin\bootstrap.jar"
	на:
	    :emptyClasspath
	    set "CLASSPATH=%CLASSPATH%%CATALINA_HOME%\bin\bootstrap.jar"
	    set "CLASSPATH=%CLASSPATH%;%CATALINA_HOME%\lib\h2-1.4.200.jar