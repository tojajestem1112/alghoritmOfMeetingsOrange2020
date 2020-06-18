# alghoritmOfMeetingsOrange2020
Celem projektu było utworzenie algorytmu, który na podstawie kalendarzy dwóch osób oraz oczekiwanej długosci spotkania przedstawi 
propozycję możliwych terminow Spotkania.
Projekt powstał przy użyciu środowiska Intellij.

DANE
*******************************
Kalendarz 1:
{
working_hours: {
start: "09:00",
end: "20:00"
},
planned_meeting: [
{
start: "09:00",
end: "10:30"
},
{
start: "12:00",
end: "13:00"
},
{
start: "16:00",
end: "18:30"
}
]
}
***********************
Kalendarz 2:
{
working_hours: {
start: "10:00",
end: "18:30"
},
planned_meeting: [
{
start: "10:00",
end: "11:30"
},
{
start: "12:30",
end: "14:30"
},
{
start: "14:30",
end: "15:00"
},
{
start: "16:00",
end: "17:00"
}
]
}
*********************************
Czas spotkania:
meeting duration: [00:30]
**********************************


OUTPUT
[["11:30","12:00"], ["15:00", "16:00"], ["18:00", "18:30"]]

OPIS
Na podstawie otrzymanych danych ewidentnie można stwierdzić BŁĄD w podanych przykładowych danych wyjściowych - Przedział czasu 
["18:00", "18:30"]] jest niedopuszczalny tj. w tym czasie osoba korzystająca z kalendarza 1 ma spotkanie (od 16:00 do 18:30).
Przedstawione zadanie polegało na zaprojektowaniu algorytmu. Niestety, w zadaniu nie znalazła się specyfikacja dotycząca sposobu wprowadzania danych do programu.
W związku z powyższym, dane zostały przypisane do oddzielnej zmiennej.


