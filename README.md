# Jmix Database Tests

This project is designed for testing compatibiltiy with various databases. It uses [Testcontainers](https://www.testcontainers.org) for running test databases in Docker containers.   

The following databases are tested as main data store: PostgreSQL, SQL Server, MySQL, MariaDB, Oracle 11.

Firebird is tested as an additional data store.

## Usage

Run Docker.

To test all databases, run:

```
./gradlew test
```

To test also with a custom Oracle image, provide a local image with Oracle XE, then run:

```
./gradlew test -PoracleImage=my-oracle-xe
``` 
