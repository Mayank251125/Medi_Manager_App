
## Problem statement
Running a small medical store means juggling stock levels, prices, expiry dates and simple billing — often using paper records or scattered spreadsheets. That leads to mistakes: expired medicines left on the shelf, ambiguous stock counts, slow customer service at busy times, and extra time spent tracking down where records were saved. The core problem this project addresses is making inventory management for a medical store simpler, less error-prone, and fast enough for everyday use.

## Scope of the project
This is a lightweight, console-based Java application intended to manage a medical store’s inventory with straightforward features and file-based persistence. It focuses on the essentials — adding and removing medicines, viewing current stock, checking for near-expiry items, and saving/loading data to a plain-text database file. The project is intentionally not a full enterprise system: it does not include a web frontend, multi-user accounts, a relational database, or advanced reporting. Instead, it is a small, practical tool you can compile and run locally with Java 8+.

Key boundaries:
- Local, single-machine usage only (no built-in network sync).
- Persistence is a simple text file (pharmacy_db.txt) rather than a DBMS.
- Command-line / console interface (no graphical UI).
- Designed for small-to-medium inventories — not for large-scale hospital supply chains. :contentReference[oaicite:1]{index=1}

## Target users
This app is aimed at:
- Independent pharmacists and small medical store owners who want an easy, no-friction way to track medicine stock.
- Pharmacy assistants who need a quick tool to check inventory and detect soon-to-expire items.
- Beginners learning Java who want a readable, practical sample project that demonstrates file I/O, simple data models, and command-line interaction.
- Hobbyists or students who need a small, extendable inventory manager as a starting point for enhancements (GUI, DB, reports). :contentReference[oaicite:2]

## High-level features
The application focuses on a compact set of features that cover daily inventory needs:

- *Add / Remove Medicines* — create and delete items with essential fields (name, ID, price, quantity).  
- *List Inventory* — display current stock in an easy-to-read console layout so staff can see what’s on the shelf instantly.  
- *Expiry Tracking* — scan the inventory to flag medicines near expiry so you can act before waste or risk.  
- *Persistent Storage* — save and load inventory using a plain-text database file (pharmacy_db.txt) so data survives between runs.  
- *Simple Billing / Stock Adjustment* — process a basic sale that decrements stock, with console confirmation.  
- *Compact codebase* — a few Java classes (entry point, backend logic, and a medicine model) that are easy to read and extend. :contentReference[oaicite:3]

---

### Notes & how to run
- The project is written in Java and targets Java 8+. Compile and run from the command line (javac / java). The README describes the build steps and the data-file format. :contentReference[oaicite:4]