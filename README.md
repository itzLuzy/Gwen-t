# Gwen't

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of the
[_Gwent_](https://www.playgwent.com/en) card game developed by [_CD PROJEKT RED_](https://cdprojektred.com/en/)

---

#### Personal Comments
When I started working on the project I thought that I had to do all the implementations for
the methods, so I started doing it. Much later I realized that it was not necessary (XD) but since I
had already started to do it, it felt wrong not to finish it or to at least make something that passed
all the tests I had implemented, so I did it, but, because the implementations were not necessary
and because I didn't had much time, I did not made the documentation for the methods (I will do it in the 
future though).

In regards to the structure of the project, I'm still indecisive about creating subclasses of CardSet to separate 'decks' from 'hands',
because they share almost every method except for play(), which only applies to cards on the Hand, and draw() which
has different functions depending if the card is on a Deck or a Hand. Also I wasn't really sure of
what to do with the play() and remove() methods from cardSet, because they are similar yet they're not the 
same, so I decided to have play() depending on the add() and remove() methods, also did the same with draw().
Maybe I'll change the way that works on future versions.
