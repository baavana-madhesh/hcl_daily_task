
# Day 14 - Streams API

## Objective
Generate sales analytics using Java Streams and Collectors.

## Features
- Revenue grouped by category
- Top three customers by total spending
- Orders partitioned by delivery status
- Average order value
- Comma-separated distinct product list
- Order amount summary statistics
- Sequential and parallel stream timing comparison

## Concepts Covered
- Stream creation
- map(), filter(), distinct(), sorted(), limit()
- groupingBy()
- partitioningBy()
- summingDouble()
- averagingDouble()
- summarizingDouble()
- joining()
- Parallel streams

## Run
```bash
javac SalesAnalytics.java
java SalesAnalytics
```

## Note
The sample uses eight orders to keep the demo readable.
Performance timings are illustrative and are not reliable benchmarks.
