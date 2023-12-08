package org.hello;

public class HelloRecord {

    record TestRecord(
            Object metadata,
            String message,
            TestRecord testRecord
    ) {}

    record TestSubRecord<T>(
            T t,
            String message
    ) {}
}
