# Coding Challenge Bücher Shop

Dieses Projekt ist Gegenstand einer Coding Challenge im Zusammenhang mit einer Bewerbung.
Die ausführbaren Dateien sind die Test-Files: BookTest.java, CustomerTest.java und ShopTest.java

# Setup
Die Dateien können über Git geladen werden:
* Clone repository.

        git clone https://github.com/konsti-gehrke/coding_challenge.git

# Testing
Es wurde beim Testen darauf geachtet möglichst viele Fälle abzudecken. Dabei wurde fast immer versucht mit Gut- und Schlechtfällen zu arbeiten.

### Shop
Es wurde folgendes getestet:
* Getter-Methoden
* Hinzufügen von Büchern
* Erhalten von Bücherlisten ohne Duplikate
* Erhalten von Bücherlisten eines bestimmten Genres
* Verkaufen von Büchern an einen Kunden (mit Fehlerfällen)
* Vergleichen ob zwei Shops die gleichen Bücher im Angebot haben


### Book
Es wurde folgendes getestet:
* Kreieren von Büchern
* Validierung der ISBN-13
* Die @Override Methode "Equals"
* Die @Override Methode "CompareTo"
* Es wurden die vorgegebenen ISBN-13 Nummern zum testen der Erstellung von Büchern verwendet. Bei dem Shop wurden noch eigene ISBN-13 verwendet, um eine vielfältigere Gleichheitsprüfung zu ermöglichen.

### Customer
Es wurde folgendes getestet:
* Das Erstellen von Benutzern
* Hinzufügen von Büchern
* Getter-Methoden
* Verringern von Geld


### Technologie
* JUnit5 wurde zum Testen verwendet.

        https://junit.org/junit5/docs/current/user-guide/

