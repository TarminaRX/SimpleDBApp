mvn clean package
$lastJarFile = Get-ChildItem -Path .\target\*.jar | Select-Object -Last 1
# Now pass $lastJarFile to another command
java8 -jar $($lastJarFile.FullName)
