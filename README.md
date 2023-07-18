# Gwen't

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of the
[_Gwent_](https://www.playgwent.com/en) card game developed by [_CD PROJEKT RED_](https://cdprojektred.com/en/)

---
### Diagrama de estados

<img src=state_diagram.jpg alt="state diagram" width=550>

### Personal Comments
- Los efectos de las cartas los representé usando visitors porque me pareció lógico, dado que eso es lo que hacen los 
efectos, visitar otras cartas y aplicarles su efecto y además así, como se especifica en el enunciado, en el futuro sería
más fácil implementar nuevos tipos de efectos.
- El cómo hacer que el jugador le notifique al controlador cuando se queda sin gemas lo hice haciendo que el controlador
fuese un observer y el jugador un sujeto observable (un poco bastante inspirado por el aux 9 de Slater xd) pero me queda la duda
de que no entendí muy bien a qué se refiere el enunciado con que el jugador no interactúe con el controlador, espero que
mi código cumpla eso u.u
- Me acabo de dar cuenta de que leí mal el efecto de la carta de Clima Despejado así que voy a ver si me puedo 
speedrunear una solución sin romper todo el código xdn't
