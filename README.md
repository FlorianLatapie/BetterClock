# ⏰ BetterClock ⏰

[![BCH compliance](https://bettercodehub.com/edge/badge/FlorianLatapie/BetterClock?branch=main)](https://bettercodehub.com/)

## Origin story

I just watched this video :
[So... the minute hand shows progression — apparently we think of time in wildly different ways][youtube_video]
from the excellent channel [Technology Connextras][youtube_second_channel].

I wanted to create a clock that combines the advantage of an analog clock: progress bar thanks to the hands and the advantage of a digital clock: precise and quick numbers to read.

## Screenshots

### App

| Theme | Default                 | With seconds            | Top left menu        |
|-------|-------------------------|-------------------------|----------------------|
| Black | ![image][default_black] | ![image][seconds_black] | ![image][menu_black] |
| White | ![image][default_white] | ![image][seconds_white] | ![image][menu_white] |

### Taskbar

| Default                   | With seconds              |
|---------------------------|---------------------------|
| ![image][default_taskbar] | ![image][seconds_taskbar] |

## How to compile and run ?

### From IntelliJ IDEA

Just click on the "Run" button.

### From the compiled executable

First use maven to compile the project.

```sh
mvn javafx:jlink
```

This command generates a `launcher.bat` file that can be used to run the application.
You just have to run `launcher.vbs` at the root of the project to run it. Feel free to create a shortcut to the vbs script.

<!-- Sources -->
[youtube_video]:https://youtu.be/NeopkvAP-ag
[youtube_second_channel]:https://www.youtube.com/c/TechnologyConnections2

[default_black]: https://user-images.githubusercontent.com/70631622/169669787-4f5f1fe4-e05e-4a92-9165-aa7932a0962c.png
[seconds_black]:https://user-images.githubusercontent.com/70631622/169669930-858d2abe-a630-41b3-aafb-d6fa38e127ab.png
[menu_black]:https://user-images.githubusercontent.com/70631622/169669942-56419e66-861b-49b5-aabc-0cbd31ec5147.png

[default_white]:https://user-images.githubusercontent.com/70631622/169669995-2acfef84-729b-413b-9043-f51c6d08523d.png
[seconds_white]:https://user-images.githubusercontent.com/70631622/169669999-9205dc49-a2f3-463a-ab31-9b6b8b30fdda.png
[menu_white]:https://user-images.githubusercontent.com/70631622/169670005-0eb67d82-f86c-4fe7-9129-ef51c7c598be.png

[default_taskbar]:https://user-images.githubusercontent.com/70631622/169670107-ec7641fb-32e5-4e4b-9863-2197157a180f.png
[seconds_taskbar]:https://user-images.githubusercontent.com/70631622/169670109-c2901571-9c2b-4ada-9dd5-f7459502a889.png
