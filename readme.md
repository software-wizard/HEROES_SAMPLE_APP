# SZKOŁA DOBREGO KODU 
##### Zapraszamy do tworzenia Twoj pierwszej sensownej aplikacji. Dlaczego tak powinieneś się uczyć? Dlaczego taką proponujemy na start? ? O tym możesz posłuchać na naszym youtube.
#

Skoro tu jesteś, to pewnie zdajesz sobie sprawę, że **jakość kodu jest znacznie ważniejsza niż znajomość technologii**. Oddaję w Twoje ręcę szablon aplikacji heroes. Póki co niewiele robi, ale mam nadzieję, że ją rozwiniesz :).

Stan jest tragiczny, ale z czasem pojawiać się będą pewne tipy na blogu - jak zrobić coś lepiej. Ćwicz praktykuj, **nie bądź biernym obserwatorem tylko bierz się do roboty.**

Projekt oparty o Java, ale nie ma to znaczenia - ucz się myśleć w paradygmacie programowania obiektowego. Jeśli wolisz python czy .NET - to nie problem! Powiem to ostatni raz **technologia nie ma znaczenia**.

# Czego potrzebuję by rozpocząć przygodę z nami?
- **java 11** https://jdk.java.net/java-se-ri/11
- **maven** (narzędzie budujące projekt) https://maven.apache.org/download.cgi 
- **IDE(edytor kodu)** - polecany **IntelliJ** Damowa wersja community w zupełności wystarczy. https://www.jetbrains.com/idea/download/#section=window 
- **Dużo determinacji**. Obiektowość nie jest prosta, ale głębokie zrozumienie SOLID wyniesie Cię ponad przeciętność.

# Jak to uruchomić?
Uruchamiasz konsole polecamy **cmder**, idziesz do katalogu gdzie zrobiłeś git clone i piszesz:
```sh
$ mvn clean install
$ mvn javafx:run
```

### Uruchomienie z IDE:
Idziesz do klasy start i klikasz play xd.
Sensowna implementacja zaczyna się w klasie **MainBattleController**

## Proponowane zadania na start:
##### Zadanie 1
Dodaj jednostką pancerz. Nowy algorytm ataku: Obrażenia = atak - pancerz
Nie dopuśc do sytuacji by punkty życia jednostki atakowanej wzrosły (pancerz obrońcy większy niż atak agresora).

##### Zadanie 2
Spraw by atakowana jednostka oddawała.

##### Zadanie 3
Stwórz jednostkę, która potrafi strzelać.

##### Zadanie 4 
Dodaj przeszkody terenowe, uniemożliwijące przemiszczanie się.

##### Zadanie 5
Zaimplementuj możliwość rzucenia czaru Magic Arrow.

##### Zadanie 6 
Jednostka specjalna leczy się o połowe zadanych obrażeń.

##### Zadanie 7
Nowy typ jednostki - latająca - potrafi przelecieć przez pasmo przeszkód z zadani 4

Na start w zupełności wystarczy. Nie zapomnij o TESTACH :).


# Po co mi to?
Nauka programowania wymaga czasu i powtórek, wielu powtórek. Jeśli są przyjemne lepiej zostają w głowie. Kto nie zechciałby zagrać we własną implementacje gry Heroes III.

Ucząc się nowych zagadnień dotyczących obiektowości jak np. **polimorfizm, hermetyzacja, wzorce projektowe**, ćwicz tutaj, spraw by Twoja implementacja była **czytelna, testowalna, łatwo rozszerzalna**. Ten projekt to nieograniczone pole możliwości - serio.


#### Prezentowany kod nie ma nic wspólnego z dobrymi praktykami programowania! Twój cel - zrobić z niego coś pieknego :). POWODZENIA

# **TIME TO START, Hell Yeah!**