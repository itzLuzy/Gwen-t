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

- A pesar de que no entregué las tareas parciales, cuando comencé a hacer la tarea estaba trabajando en la rama correspondiente
a la entrega parcial 4 y ahí hice casi todo lo relacionado a los states, espero que no cause ningún problema en la revisión
así que aviso por si acaso.
- Los efectos de las cartas los representé usando visitors porque me pareció lógico, dado que eso es lo que hacen los 
efectos, visitar otras cartas y aplicarles su efecto y además así, como se especifica en el enunciado, en el futuro sería
más fácil implementar nuevos tipos de efectos.
- Para los efectos de clima, ya que no se especificaba en el enunciado, asumí que al aplicarse dejaban la fuerza de las
cartas en 1 mientras estuviera activo el efecto y que por lo tanto los efectos causados por las cartas de unidad como el
refuerzo moral no se aplicarían a la carta durante ese momento, pero que al quitarse los efectos de clima, estos sí que
se aplicarían a las cartas. Por lo tamto lo que hice es que al llamar al getter de la fuerza de la carta te retorne 1 si 
hay un clima activo mientras la fuerza real de la carta se sigue actualizando por detrás (espero que se entienda u.u)
- El cómo hacer que el jugador le notifique al controlador cuando se queda sin gemas lo hice haciendo que el controlador
fuese un observer y el jugador un sujeto observable (un poco bastante inspirado por el aux 9 de Slater xd) pero me queda la duda
de que no entendí muy bien a qué se refiere el enunciado con que el jugador no interactúe directamente con el controlador, 
espero que mi código cumpla eso u.u
