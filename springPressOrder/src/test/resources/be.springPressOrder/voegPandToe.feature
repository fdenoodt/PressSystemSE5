# language: nl

Functionaliteit: Fruit meegeven

  Een particulier is in staat om fruit mee te geven zodat Pipo Appelsap
  dit voor deze particulier omvormt en hij zich hier zelf geen
  kopzorgen aan moet maken.

  Bij appelen moeten er minstens 3 appelen ingediend worden,
  zodat een volledige fles gevuld kan worden. Bij peren is dit minimum echter 4.

  Maximum van 100 fruit stukken.

  Vanaf 51 fruit stukken krijgt de particulier 1 fles als bonus bovenop zijn bestelling.

  Scenario: Particulier geeft te weinig peren mee
    Gegeven particulier heeft 3 peren en wilt een pers-opdracht doen
    Als de particulier deze peren afgeeft
    Dan krijgt de particulier de volgende boodschap te zien: "Het minimum aantal peren is 4"


  Scenario: Particulier geeft te weinig appelen mee
    Gegeven particulier heeft 2 appelen en wilt een pers-opdracht doen
    Als de particulier deze appelen afgeeft
    Dan krijgt de particulier de volgende boodschap te zien: "Het minimum aantal appels is 3"


  Scenario: De particulier maakt een pers-opdracht van een correct aantal peren, zonder bonus
    Gegeven particulier heeft 4 peren en wilt een pers-opdracht doen
    Als de particulier deze peren afgeeft
    Dan krijgt de particulier 1 flessen en 0 bonus terug


  Scenario: De particulier maakt een pers-opdracht van een correct aantal appelen, zonder bonus
    Gegeven particulier heeft 3 appelen en wilt een pers-opdracht doen
    Als de particulier deze appelen afgeeft
    Dan krijgt de particulier 1 flessen en 0 bonus terug


  Scenario: De particulier maakt een pers-opdracht van een correct aantal appelen, met bonus
    Gegeven particulier heeft 51 appelen en wilt een pers-opdracht doen
    Als de particulier deze appelen afgeeft
    Dan krijgt de particulier 17 flessen en 1 bonus terug


  Scenario: De particulier maakt een pers-opdracht van een correct aantal peren, met bonus
    Gegeven particulier heeft 51 peren en wilt een pers-opdracht doen
    Als de particulier deze peren afgeeft
    Dan krijgt de particulier 12 flessen en 1 bonus terug


  Scenario: De particulier maakt een pers-opdracht van een correct aantal appelen, zonder bonus
    Gegeven particulier heeft 50 appelen en wilt een pers-opdracht doen
    Als de particulier deze appelen afgeeft
    Dan krijgt de particulier 16 flessen en 0 bonus terug


  Scenario: De particulier maakt een pers-opdracht van een correct aantal peren, zonder bonus
    Gegeven particulier heeft 50 peren en wilt een pers-opdracht doen
    Als de particulier deze peren afgeeft
    Dan krijgt de particulier 12 flessen en 0 bonus terug


  Scenario: De particulier maakt een pers-opdracht van een correct aantal peren, met bonus
    Gegeven particulier heeft 100 peren en wilt een pers-opdracht doen
    Als de particulier deze peren afgeeft
    Dan krijgt de particulier 25 flessen en 1 bonus terug


  Scenario: De particulier maakt een pers-opdracht van een correct aantal appelen, met bonus
    Gegeven particulier heeft 100 appelen en wilt een pers-opdracht doen
    Als de particulier deze appelen afgeeft
    Dan krijgt de particulier 33 flessen en 1 bonus terug


  Scenario: De particulier geeft te veel peren mee
    Gegeven particulier heeft 101 peren en wilt een pers-opdracht doen
    Als de particulier deze peren afgeeft
    Dan krijgt de particulier de volgende foutmelding : "Het max aantal stukken fruit is 100"


  Scenario: De particulier geeft te veel appelen  mee
    Gegeven particulier heeft 101 peren en wilt een pers-opdracht doen
    Als de particulier deze appelen afgeeft
    Dan krijgt de particulier de volgende foutmelding : "Het max aantal stukken fruit is 100"
