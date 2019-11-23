# language: en
Feature: Fruit meegeven via UI

  Bij appelen moeten er minstens 3 appelen ingediend worden,
  zodat een volledige fles gevuld kan worden. Bij peren is dit minimum echter 4.



  Scenario: Particulier geeft te weinig peren mee via UI
    Given particulier is ingelogd
    And de particulier begeeft zich op de pagina om een nieuwe pressorder aan te maken
    When particulier 3 peren invoert in het veld "fruitAmount"
    And hij duidt peer aan in de combobox "fruitId"
    And hij klikt op Submit
    Then krijgt de particulier de volgende boodschap te zien : "Het minimum aantal peren is 4" in het field "msgError"



  Scenario: Particulier geeft te weinig appelen mee via UI
    Given particulier is ingelogd
    And de particulier begeeft zich op de pagina om een nieuwe pressorder aan te maken
    When de particulier 2 appelen invoert in het veld "fruitAmount"
    And hij duidt appel aan in de combobox "fruitId"
    And hij klikt op Submit
    Then krijgt de particulier de volgende boodschap te zien : "Het minimum aantal appelen is 3" in het field "msgError"




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
