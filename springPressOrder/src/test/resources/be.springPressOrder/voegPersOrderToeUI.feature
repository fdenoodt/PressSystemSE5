# language: en
Feature: Fruit meegeven via UI

  Bij appelen moeten er minstens 3 appelen ingediend worden,
  zodat een volledige fles gevuld kan worden. Bij peren is dit minimum echter 4.


  Scenario: Particulier geeft te weinig peren mee via UI
    Given particulier is ingelogd
    And de particulier begeeft zich op de pagina om een nieuwe pressorder aan te maken
    When particulier 3 peren invoert in het veld "fruitamount"
    And hij duidt peer aan in de combobox "fruitsoort"
    And hij klikt op Submit
    Then krijgt de particulier de volgende boodschap op het scherm te zien: "Het minimum aantal peren is 4"



#  Scenario: Particulier geeft te weinig appelen mee
#    Gegeven particulier heeft 2 appelen en wilt een pers-opdracht doen
#    Als de particulier deze appelen afgeeft
#    Dan krijgt de particulier de volgende boodschap te zien: "Het minimum aantal appels is 3"
#
#
#  Scenario: De particulier maakt een pers-opdracht van een correct aantal appelen, met bonus
#    Gegeven particulier heeft 50 appelen en wilt een pers-opdracht doen
#    Als de particulier deze appelen afgeeft
#    Dan krijgt de particulier 17 flessen en 0 bonus terug
#
#
#  Scenario: De particulier maakt een pers-opdracht van een correct aantal peren, zonder bonus
#    Gegeven particulier heeft 50 peren en wilt een pers-opdracht doen
#    Als de particulier deze peren afgeeft
#    Dan krijgt de particulier 12 flessen en 0 bonus terug
