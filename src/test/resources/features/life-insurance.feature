# language: de

Funktionalität: Lebensversicherungsantrag

  Szenario: Ein Angebot wird berechnet
    Wenn ich ein Angebot für das Produkt "Basis" mit einer Laufzeit von 10 Jahren anfordere
    Dann erhalte ich ein Angebot mit einem Beitrag größer als 0

  Szenario: Ein Antrag wird gestellt
    Gegeben sei ein Angebot für das Produkt "Komfort" mit einer Laufzeit von 20 Jahren
    Wenn ich einen Antrag für "Max Mustermann" auf dieses Angebot stelle
    Dann sollte der Antrag den Status "EINGEREICHT" haben