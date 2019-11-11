# language: nl

Functionaliteit: Fruit meegeven

  Een particulier is in staat om fruit mee te geven zodat Pipo Appelsap
  dit voor deze particulier omvormt en hij zich hier zelf geen
  kopzorgen aan moet maken.
# eventueel meer info van fruit of confituur en bij 100 flessen --> krijg 1 fles gratis

Scenario: Particulier geeft een aantal peren in ruil voor een aantal flessen perensap
Gegeven  Particulier bevindt zich op de bestelpagina
Als Particulier 97 peren afgeeft
Dan zou de particulier 24 + 1 gratis flessen perensap moeten krijgen

Scenario: Particulier geeft een aantal appels in ruil voor een aantal flessen appelsap
Gegeven Particulier bevindt zich op de bestelpagina
Als particulier 19 appels afgeeft
Dan zou de particulier 6 flessen appelsap moeten krijgen

Scenario: Particulier geeft een aantal kilo kersen in ruil voor een aantal potten confituur
Gegeven Particulier bevindt zich op de bestelpagina
Als particulier 12 kilo kersen afgeeft
Dan zou de particulier 10 potten confituur moeten krijgen

Scenario: Particulier kiest verschillende soorten fruit
Gegeven Particulier bevindt zich op de bestelpagina
Als Particulier appel en peer kiest
Dan zou de particulier een melding krijgen dat hij maar 1 soort fruit mag kiezen

Scenario: Particulier wil kunnen meegeven aan pipo appelsap in welk recipient ze het sap moeten plaatsen
Gegeven Particulier bevindt zich op de bestelpagina
Als Particulier 2l flessen wenst
Dan zou zijn sap in 2l flessen moeten worden geplaatst




