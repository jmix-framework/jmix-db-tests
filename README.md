# Jmix Database Tests

This project is designed for testing compatibiltiy with various databases. It uses [Testcontainers](https://www.testcontainers.org) for running test databases in Docker containers.   

The following databases are tested as main data store: PostgreSQL, SQL Server, MySQL, MariaDB.

Oracle is tested as a main data store if an Oracle XE image is provided in the Gradle property:
```
`./gradlew test -PoracleImage=my-oracle-xe`
``` 

Firebird is tested as an additional data store.

## Usage

- Run Docker
- `./gradlew test`
- Wait - for the first time it will take quite a lot of time