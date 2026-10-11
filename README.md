# IPv4 / IPv6 Calculator

Java Swing desktop calculator for IPv4 addresses (class, subnet mask, network, gateway, broadcast and usable hosts) that stores its results in a PostgreSQL database.

## Setup

1. Create the database from `DBCalculadoraIP.sql` (a PostgreSQL custom-format dump; restore it with `pg_restore`).
2. Define the `IPCALC_DB_PASSWORD` environment variable with your PostgreSQL password (on Windows: System Properties > Environment Variables). It is never stored in the code.

3. Open `Calculadora IP` in Eclipse (or any Java IDE) and run `CalculadoraIP.java`. The PostgreSQL JDBC driver must be on the classpath.