# Jmix Database Tests

This project is designed for testing compatibiltiy with various databases. It uses [Testcontainers](https://www.testcontainers.org) for running test databases in Docker containers.   

The following databases are tested as main data store: PostgreSQL, SQL Server, MySQL, MariaDB, Oracle.

Firebird is tested as an additional data store.

## Usage

Run Docker.

To test all databases except Oracle, run:

```
./gradlew test
```

In order to test all databases including Oracle, provide a local image with Oracle XE, then run:

```
./gradlew test -PoracleImage=my-oracle-xe
``` 
