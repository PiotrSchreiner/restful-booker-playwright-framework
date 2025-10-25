# 🛠️ Testautomatisierungs-Framework: Restful Booker (UI)

Dieses Projekt demonstriert einen professionellen Ansatz zur **UI-Testautomatisierung** der **Restful-Booker-Platform** (RBPM) unter Verwendung des **Java**-Stacks und des **Playwright**-Frameworks.

Die Architektur folgt den modernen Enterprise-Prinzipien des **Lightweight Page Object Model (POM)** in Kombination mit **App Actions/Service-Layern**, basierend auf den Empfehlungen der Playwright-Community und der ISTQB-Testautomatisierungsstandards.

## 🎯 Architektur & Prinzipien

| Pattern                                 | Zweck                                                                                                                       | Umsetzung in Java                                                                   |
| :-------------------------------------- | :-------------------------------------------------------------------------------------------------------------------------- | :---------------------------------------------------------------------------------- |
| **Lightweight Page Object Model (POM)** | [cite_start]Zentrale Pflege aller **Locators** und einfacher Seiteninteraktionen. [cite: 577, 594]                          | **`src/main/java/pages`** (Klassen wie `LoginPage.java`, `BookingPage.java`)        |
| **App Actions / Service Layer**         | [cite_start]Bündelung komplexer, domänenübergreifender **Geschäftslogik** (z. B. `loginAndCreateBooking`). [cite: 584, 595] | **`src/main/java/actions`** (Klassen wie `AuthActions.java`, `BookingActions.java`) |
| **Test Cases**                          | Klar definierte Testfälle, die die App Actions nutzen und Assertions enthalten (z. B. `testBookingCreation`).               | **`src/test/java/tests`** (Klassen wie `BookingTests.java`)                         |

## 📦 Technologie-Stack

- **Sprache:** Java (mit JDK 17 oder höher)
- **Build-Tool:** Maven
- **UI-Automatisierung:** Microsoft Playwright (Java Binding)
- **Test-Runner:** JUnit 5 (Jupiter)
- **Basis-Anwendung:** Restful-Booker-Platform (lokal via Docker Compose)

## 🚀 Quick Start (Ausführung)

### Voraussetzungen

1.  **Java JDK:** Installation von Java Development Kit (mindestens Version 17).
2.  **Maven:** Installation des Apache Maven Build-Tools.
3.  **Docker Compose:** Installiert und gestartet, um die Restful-Booker-Platform bereitzustellen.

### 1. Anwendung starten

Da das Repository bereits die **Docker Compose Konfiguration** enthält, kann die Testumgebung einfach gestartet werden:

```bash
docker compose up -d --build
```
