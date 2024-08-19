[//]: # (INIT -> SALESMAN -> Jakub;Sprzedażowy;81050299875)

[//]: # (INIT -> SALESMAN -> Katarzyna;Autoekspres;75081214578)

[//]: # (INIT -> SALESMAN -> Michał;Szybki;68012265892)

[//]: # (INIT -> SALESMAN -> Joanna;Raty;72051945621)

[//]: # ()
[//]: # (INIT -> MECHANIC -> Adam;Klucz;74030467120)

[//]: # (INIT -> MECHANIC -> Paweł;Naprawczy;85040567124)

[//]: # (INIT -> MECHANIC -> Grzegorz;Wymieniacz;69122398345)

[//]: # ()
[//]: # (INIT -> CAR -> WBA5A7C50FD737019;Audi;A4;2021;white;25000)

[//]: # (INIT -> CAR -> WAUBFAFLXCA416702;Audi;A6;2021;silver;35000)

[//]: # (INIT -> CAR -> WBA4F9C58ED723938;Audi;A6;2021;silver;35000)

[//]: # (INIT -> CAR -> WBA4A7C52FD109567;Audi;A8;2021;blue;45000)

[//]: # (INIT -> CAR -> WAUCFAFL4EN731952;Audi;A8;2021;blue;45000)

[//]: # (INIT -> CAR -> WBA7E4C59GG110593;Audi;Q7;2021;black;65000)

[//]: # ()
[//]: # (INIT -> SERVICE -> 12345-678;Wymiana opony;250.00)

[//]: # (INIT -> SERVICE -> 98765-432;Kalibracja układu;60.50)

[//]: # (INIT -> SERVICE -> 00123-456;Wymiana filtra oleju;160.25)

[//]: # (INIT -> SERVICE -> 78901-234;Wymiana uszczelki;20.00)

[//]: # (INIT -> SERVICE -> 45678-901;Wymiana filtra kabinowego;25.50)

[//]: # ()
[//]: # (INIT -> PART -> 98761-2345;Opona;350.00)

[//]: # (INIT -> PART -> 54320-123;Olej syntetyczny;300.00)

[//]: # (INIT -> PART -> 67891-245;Uszczelka;150.00)

[//]: # (INIT -> PART -> 13579-246;Filtr kabinowy;100.00)

BUY_FIRST_TIME -> CUSTOMER -> Piotr;Nowak;+48 567 890 234;piotr.nowak@gmail.com;Polska;Warszawa;00-001;Krucza 10 -> CAR -> WBA4F9C58ED723938 -> SALESMAN -> 75081214578
BUY_FIRST_TIME -> CUSTOMER -> Anna;Kowalska;+48 654 321 987;anna.kowalska@gmail.com;Polska;Kraków;30-001;Floriańska 5 -> CAR -> WBA5A7C50FD737019 -> SALESMAN -> 68012265892
BUY_FIRST_TIME -> CUSTOMER -> Marek;Wiśniewski;+48 456 123 789;marek.wisniewski@gmail.com;Polska;Gdańsk;80-001;Długa 7 -> CAR -> WBA4A7C52FD109567 -> SALESMAN -> 68012265892
BUY_FIRST_TIME -> CUSTOMER -> Ewa;Jankowska;+48 123 456 789;ewa.jankowska@gmail.com;Polska;Poznań;60-001;Ratajczaka 8 -> CAR -> WBA7E4C59GG110593 -> SALESMAN -> 72051945621
BUY_FIRST_TIME -> CUSTOMER -> Krzysztof;Mazur;+48 789 123 456;krzysztof.mazur@gmail.com;Polska;Łódź;90-001;Piotrkowska 12 -> CAR -> WAUBFAFLXCA416702 -> SALESMAN -> 72051945621

BUY_AGAIN -> CUSTOMER -> piotr.nowak@gmail.com -> CAR -> WAUCFAFL4EN731952 -> SALESMAN -> 68012265892

SERVICE_REQUEST -> CUSTOMER -> piotr.nowak@gmail.com -> CAR -> WAUCFAFL4EN731952 -> WHAT -> Uszczelka do wymiany
SERVICE_REQUEST -> CUSTOMER -> marek.wisniewski@gmail.com -> CAR -> WBA4A7C52FD109567 -> WHAT -> Olej przecieka

SERVICE_REQUEST -> CUSTOMER -> Bartosz;Pakietowy;+48 999 888 777;bartosz.pakietowy@gmail.com;Polska;Lublin;20-001;Zamkowa 9 -> CAR -> JH4KA8170PC000623;Audi;A3;2017 -> WHAT -> Silnik hałasuje

DO_THE_SERVICE -> MECHANIC -> 74030467120 -> CAR -> WAUCFAFL4EN731952 -> WHAT -> 98761-2345;1;12345-678;4;OK;NOT_FINISHED
DO_THE_SERVICE -> MECHANIC -> 69122398345 -> CAR -> WAUCFAFL4EN731952 -> WHAT -> ;;98765-432;2;OK;FINISHED
DO_THE_SERVICE -> MECHANIC -> 74030467120 -> CAR -> WBA4A7C52FD109567 -> WHAT -> 54320-123;1;00123-456;1;OK;NOT_FINISHED
DO_THE_SERVICE -> MECHANIC -> 85040567124 -> CAR -> WBA4A7C52FD109567 -> WHAT -> 67891-245;2;78901-234;2;OK;NOT_FINISHED
DO_THE_SERVICE -> MECHANIC -> 69122398345 -> CAR -> WBA4A7C52FD109567 -> WHAT -> 13579-246;2;45678-901;1;OK;FINISHED