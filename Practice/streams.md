Filtering and Collecting:

Input: ["apple", "banana", "cherry", "date"]
Exercise: Filter words starting with 'a' and collect them 
into a new list.
Expected Output: ["apple"]

Mapping:

Input: [1, 2, 3, 4, 5]
Exercise: Square each number using the map operation.
Expected Output: [1, 4, 9, 16, 25]

FlatMap:

Input: [[1, 2], [3, 4], [5, 6]]
Exercise: Flatten the list using flatMap operation.
Expected Output: [1, 2, 3, 4, 5, 6]

Sorting:

Input: ["apple", "orange", "banana"]
Exercise: Sort strings in alphabetical order.
Expected Output: ["apple", "banana", "orange"]

Matching:

Input: [5, 8, 12, 15]
Exercise: Check if all numbers are greater than 4.
Expected Output: true

Reduction:

Input: [1, 2, 3, 4, 5]
Exercise: Calculate the sum of integers using reduce 
operation.
Expected Output: 15

Grouping and Partitioning:

Input: ["apple", "banana", "avocado", "cherry"]
Exercise: Group words by their lengths.
Expected Output: {5=["apple"], 6=["banana"], 7=["avocado", "cherry"]}
Joining:

Input: ["apple", "banana", "cherry"]
Exercise: Join strings into a comma-separated string.
Expected Output: "apple,banana,cherry"

Peek:

Input: [1, 2, 3, 4, 5]
Exercise: Use peek to print each element before doubling it.
Expected Output: 1, 2, 3, 4, 5 (printed)

Limit and Skip:

Input: [1, 2, 3, 4, 5]
Exercise: Use limit(3) to get the first 3 elements.
Expected Output: [1, 2, 3]

Distinct:
Input: [1, 2, 2, 3, 4, 4, 5]
Exercise: Remove duplicates.
Expected Output: [1, 2, 3, 4, 5]

Stream from Different Sources:

Exercise: Create a stream of integers from an array: [1, 2, 3, 4, 5].
Expected Output: Stream<Integer>

Infinite Streams:

Exercise: Generate an infinite stream of sequential integers starting from 1.
Expected Output: Stream<Integer> representing (1, 2, 3, ...)

Parallel Streams:

Input: Large list of integers.
Exercise: Use parallel stream to find the sum of integers.
Expected Output: Result representing the sum of all integers.

Combining Streams:

Input: ["apple", "banana"] and ["cherry", "date"]
Exercise: Merge the lists into a single stream.
Expected Output: ["apple", "banana", "cherry", "date"]

Optional and Streams:

Input: [3, 7, 1, 9, 5]
Exercise: Find the maximum element and return it as an OptionalInt.
Expected Output: OptionalInt[9]

Custom Operations:

Input: [1, 2, 3, 4, 5]
Exercise: Create a custom collector to calculate the product of all elements.
Expected Output: 120

Parallel Processing:

Input: Large list of elements.
Exercise: Measure the time taken to process the list sequentially vs. in parallel using a specific operation.
Expected Output: Execution times for sequential and parallel processing.

Error Handling:

Input: ["1", "2", "three", "4"]
Exercise: Convert strings to integers handling NumberFormatException, then calculate their sum.
Expected Output: 7 (since "three" will be skipped due to the exception)

Stream Performance:

Input: Large dataset for various stream operations.
Exercise: Measure the execution time for operations like filtering, mapping, etc., on the large dataset.
Expected Output: Execution times for different stream operations.