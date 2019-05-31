name := "littleHacker"

version := "0.1"

scalaVersion := "2.12.8"

enablePlugins(JavaServerAppPackaging, SystemdPlugin)

maintainer in Linux := "Nepomuk Seiler <samuelcasa42@gmail.com>"
packageSummary in Linux := "Keyboard key to Display background color mapper"
packageDescription := "Shows a colored fullscreen windows, the color is changing by each keystroke."



