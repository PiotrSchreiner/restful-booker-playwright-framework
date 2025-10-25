# 📝 Testplan: UI-Automatisierung der Restful Booker Platform (RBP)

Dieses Dokument umreißt den Testansatz, die Strategie und die Architektur für die Automatisierung der End-to-End (E2E) UI-Funktionalität der Restful Booker Platform (RBP).

## 1. Testziel (Test Objective)

Das Hauptziel ist die Verifizierung, dass die kritischen **End-to-End (E2E) Geschäftsfälle** der RBP-Anwendung wie spezifiziert funktionieren. Der Fokus liegt auf der **Zuverlässigkeit** der Testfälle und der **Wartbarkeit** des Test-Frameworks.

- **Abdeckung:** Kritische CRUD-Operationen (Create, Read, Update, Delete) für Buchungen sowie der Authentifizierungs-Flow (Login/Logout).
- **Qualitätsmerkmal (ISTQB):** Funktionalität, Zuverlässigkeit, Benutzbarkeit (aus Sicht des automatisierten Flows).

## 2. Teststrategie (Test Strategy)

Wir verfolgen eine **analytische, risikobasierte Teststrategie** (ISTQB-konform) kombiniert mit **funktionaler Regressionstest-Automatisierung**.

| Strategie                  | Fokus                                                                                            | Begründung                                                                                                                                    |
| :------------------------- | :----------------------------------------------------------------------------------------------- | :-------------------------------------------------------------------------------------------------------------------------------------------- |
| **Risikobasiert**          | Priorisierung der Testfälle nach Geschäftskritikalität (z. B. Buchungserstellung und -änderung). | Maximale Effizienz durch Konzentration der Automatisierungsbemühungen auf die Bereiche mit dem größten Schadenspotenzial.                     |
| **Funktionale Regression** | Überprüfung bekannter Geschäftsfälle nach Codeänderungen.                                        | Gewährleistung, dass neue Features oder Fixes keine unbeabsichtigten Nebenwirkungen (Side Effects) in bestehenden Kernfunktionen verursachen. |
| **Testbasis**              | Anwendungsspezifikation, User Stories und die UI-Designvorgaben.                                 | Sicherstellung, dass die automatisierten Tests die tatsächlichen Anforderungen widerspiegeln.                                                 |

## 3. Testumgebung

| Komponente    | Details                                                                             |
| :------------ | :---------------------------------------------------------------------------------- |
| **Anwendung** | Restful-Booker-Platform (RBP), bereitgestellt in einem isolierten Docker-Container. |
| **URL**       | `http://localhost:8080`                                                             |
| **Browser**   | Chromium, Firefox und WebKit (getestet im CI/CD-Kontext).                           |

## 4. Testarchitektur und -design

Der Code-Aufbau basiert auf dem **Test Automation Design Pattern Layered Architecture** zur Trennung von Anwendungslogik, Locator-Management und Testfällen.

| Schicht                          | Zweck                                                                                                                | ISTQB-Ziel                                                                     |
| :------------------------------- | :------------------------------------------------------------------------------------------------------------------- | :----------------------------------------------------------------------------- |
| **Page Layer (Lightweight POM)** | [cite_start]Kapselung von UI-Locators und einfachen, seiteninternen Aktionen (z. B. `clickLoginButton`). [cite: 577] | **Wartbarkeit** und zentrale Pflege der Selektoren.                            |
| **Action/Service Layer**         | [cite_start]Implementierung der **E2E-Geschäftslogik** (App Actions, z. B. `loginAsAdmin`). [cite: 584]              | **Wiederverwendbarkeit** von komplexen Arbeitsabläufen in verschiedenen Tests. |
| **Test Layer**                   | Enthält JUnit 5 Testmethoden, die Aktionen aufrufen und das Ergebnis mit Assertions verifizieren.                    | **Lesbarkeit** und klare Struktur des Testfalls.                               |

## 5. Implementierungsrichtlinien (Compact Code)

1.  [cite_start]**Keine Base-Page-Klassen:** Vermeidung unnötiger Vererbungskomplexität ("BasePage-Orgie" [cite: 595]).
2.  [cite_start]**Playwright Locators:** Nutzung der robusten, semantischen Locators (`getByRole`, `getByLabel`) als Standard, bevor auf CSS- oder XPath-Fallbacks zurückgegriffen wird. [cite: 585]
3.  **Kompakte Tests:** Testfälle sollen nur die für den Business-Case notwendigen Aufrufe des Action/Service-Layers enthalten.

---

## 🛠️ Nächster Schritt: Maven Setup

Um mit der Implementierung zu beginnen, ist der erste konkrete Schritt die Erstellung der **`pom.xml`** im Root-Verzeichnis, um alle Java-Abhängigkeiten (Playwright, JUnit 5) zu definieren.

### **`pom.xml`**
