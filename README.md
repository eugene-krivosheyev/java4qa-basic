Java Application Development
================

_2. Java Application as a White Box: designing, coding, debugging and using._ 51hrs.

# Recordings
- [25.02](https://us02web.zoom.us/rec/share/gGCYwGMkiVbxse0RRQCdQioacna880vWEywb52Rpuk-my1sAoa5XhdIzrcGRIucN.icrDiEvIak0gUTUT)
- [02.03](https://us02web.zoom.us/rec/share/vLjSe665N9hAkVosrEt-Z-dpZlSmSJg6ESrlgdTgIn9CFuSto3Wvbail5jA8g0KY._pRYjSPd41mY7C6L)
- [04.03](https://us02web.zoom.us/rec/share/aq1xwp-XHvLMGSweCbl3SWDu0FeGXnHcaOwipmEouB4yKnEho06hX_DS07CZe9YG.OlF1ewq-WabhQv0k)
- [09.03](https://us02web.zoom.us/rec/share/fU1AoDhKItkcAR3L4MNSNjflbFGK9yqydB2l9N4NBgkRjxRIq-2qk7CK2JXZ-VXE.j07pnQxVdOAh48Fh)
- [11.03](https://us02web.zoom.us/rec/share/31e5gnpTJhuWMw3ejaCGOZbDxKoG2y6FZwxp_SK_PUqsZZt-M8Mcil6kSIogVRbf.-wW1QilP9_jUcKmB)
- [16.03](https://us02web.zoom.us/rec/share/A2wk5hsq8FSUS6rN_nt3NdasOrtK_YKuC7Fk-e4Ht0IIg7JCGQL_0o8PCyfE-UpX.oLYzq758GHevnwIe)
- [18.03](https://us02web.zoom.us/rec/share/SN-p9lZ8QdIaMomsQCoAL3AlGU-G2_w8oI2VJ09j0GszZXOPo_KpxDneM0N1pl6j.aTew3EKqtf4hK6XL) (ошибка записи, поэтому запись от второй группы)
- [23.03](https://us02web.zoom.us/rec/share/Y1DTLrXzYjWqbi_3wC2Q6GngkBbzJVVct7PVxV4VWKtOQKClkN2FLHsjNUl4qFuo.eb1CaqPP82cFJGJV)
- [25.03](https://us02web.zoom.us/rec/share/POWmAwrr6tWEJolJ6T_h09Q0DVnw8QGGYB_IpiIVlvG_pj3kAM_2cDk896W8-zll.KOJCpvmc6q_miXJh)
- [30.03](https://us02web.zoom.us/rec/share/CR9lTaHdMBBpM8CTvo9dWOdPjyPQMUyh7Natz531fBYQJt1QTKZa0WFw0aAfXC_m.jiwmUUYJVrRRcKeI)
- [01.04](https://us02web.zoom.us/rec/share/q793jZIQk428Lf1g62nzUXxtSw99uGVN-FeEcugi4lQyxGcNt8i9l66EaBd0_lP8.OW0ObJOnmdKooiob)
- [06.04](https://us02web.zoom.us/rec/share/sCeWEe-G3gOIgr4IArZ0FejuYMbv0pWR3dIYqbNLkh1jZEbdGzGNg3nBkiTNL4lA.d-qcVREkr7cTd0Mi)

# Attendee prerequisites
- [ ] Training «1. Java Application Building» completion

# Training Objectives
- [ ] Hands-on skill of localizing and fixing deep build-time errors
- [ ] Hands-on skill of run-time JVM parameterization
- [ ] Understanding Java syntax deep details
- [ ] Understanding system design principles and patterns
- [ ] Hands-on skill of developing maintainable application
- [ ] Hands-on skill of developing error-handling applications
- [ ] Understanding Java parallelism and concurrency architecture
- [ ] Hands-on skill of localizing and fixing concurrency issues
- [ ] Understanding Java Collections API
- [ ] Hands-on skill of developing memory-intensive applications
- [ ] Understanding Java networking architecture
- [ ] Hands-on skill of developing distributed applications
- [ ] Understanding Java IO architecture
- [ ] Hands-on skill of developing file-persistent applications
- [ ] Hands-on skill of IDE productive using

# Prerequisites
### Hardware
- [ ] RAM ≥ 8Гб
- [ ] Wi-Fi with Internet access
## Software
- [ ] [git](https://git-scm.com/downloads)
- [ ] [JDK8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [ ] [IDEA (trial Ultimate)](https://www.jetbrains.com/idea/download/)
- [ ] [Maven](https://maven.apache.org/download.cgi)
## Network Access
- [ ] github.org :443 :80
- [ ] repo1.maven.org :443 :80
- [ ] jcenter.bintray.com :443 :80

# Agenda
## Training introducing and focusing (1 hrs)
- [ ] Schedule
- [ ] Trainer
- [ ] Training overview
- [ ] Rules
### Hands-on: teams and their demand
- [ ] Pairs forming and introduction
- [ ] Attendees prerequisites check
- [ ] Topics focus demand from attendees
- [ ] Additional topics demand form attendees

## Sound-check (0.5)
### Hands-on
- [ ] Fork training repo and clone this fork
```bash
git clone --branch master --depth 1 https://github.com/ACCOUNT/java-application-development
```
- [ ] Open project with IDEA
- [ ] Project JDK set
- [ ] Sourcepath and classpathes
- [ ] Maven full build
### Demo
- [ ] Application requirements overview
- [ ] Application architecture overview
- [ ] DevOps pipeline overview

## Java application documenting (1)
### Java application structure recap
- [ ] Methods: why?
- [ ] Classes: why?
- [ ] Packages: why?
### Documenting
- [ ] Single-line comments
- [ ] Multi-line comments
### JavaDoc comments demo
- [ ] Syntax for documenting methods and classes
- [ ] Documenting packages
- [ ] Maven download dependencies sources and javadocs
- [ ] Using javadocs with IDE
### Maintainability with documentation
- [ ] What entities we should comment?
- [ ] What we should describe with comments?
- [ ] Comments Quality Gate

## Procedure style (2.5)
### Key concepts
- [ ] Package
- [ ] "Class"
- [ ] Class variables
- [ ] Method
- [ ] Method variables
- [ ] Naming things with JCSC
### Package
- [ ] Package: why?
- [ ] Package declaration
- [ ] Import directive
### Class
- [ ] Class: why?
- [ ] Class declaration
- [ ] Class variables declaration
- [ ] Static initialization section
### Method declaration
- [ ] Method: why?
- [ ] Method declaration
- [ ] Method body code block
- [ ] Returning values
### JVM memory structure
- [ ] Methods call stack
- [ ] Perm/Meta space
### Calling methods
- [ ] Dot notation
- [ ] Static import directive
### Parameters passing while calling methods
- [ ] 3 passing styles
- [ ] Formal and factual arguments
### Demo
- [ ] Debug session with primitive value passing and monitoring variables
### Methods overloading
- [ ] Overloading concept
- [ ] Why?
- [ ] Overloading operators and "+" operator

## Hand-on Iteration 00: The rise of Transaction Logger
- [ ] Read and analyse specification as tests for this iteration in *src/test*
- [ ] Full Maven Build
- [ ] Run tests from IDEA 
### DoD
- [ ] All given specifications runs are green
- [ ] Code reuse and minimum code duplication
- [ ] Code style

## Java syntax for procedure style: primitive types system (2.5)
### Variable declaration
- [ ] Variable declaration scopes
- [ ] Declaration
- [ ] Initialization
- [ ] Literals
- [ ] Default initialization values for class and method variables
### Memory allocation size
- [ ] JLS vs JVM implementation
### Evens and literals
- [ ] byte
- [ ] int
- [ ] short
- [ ] long
### Fractions and literals
- [ ] float
- [ ] double
### Character and literals
- [ ] char
### Logical and literals
- [ ] boolean
### Wrappers
- [ ] Wrapper types and main features: referenced, constants, string parsing
- [ ] Why?
- [ ] Autoboxing/unboxing and performance issue

## Hand-on Iteration 01: Decorating Transaction Logger
- [ ] Read and analyse specification as tests for this iteration in *src/test*
- [ ] Uncomment specification cases
- [ ] Implement features needed
### DoD
- [ ] All given specifications runs are green
- [ ] Code reuse and minimum code duplication
- [ ] Code style

## Java syntax for procedure style: operators for data processing (2.5)
### Type operators
- [ ] type casting
- [ ] instanceof
### Arithmetics
- [ ] +, -, *, /, %
- [ ] Typed operators: 1/3 vs 1/3.
- [ ] Arithmetic types promotion
- [ ] ArithmeticException
- [ ] Types Overflow and solution with BigInteger
- [ ] FP precision loss and solution with BigDecimal
### Bitwise
- [ ] &, |, ~, ^
- [ ] <<, >>, >>>
### Logical
- [ ] Type-stricted
- [ ] &, |, !
- [ ] Lazy and eager form
- [ ] ==, !=, <, <=, >, >=
- [ ] Reference types issue: absence of === and .equals()
- [ ] Ternary operator

## Java syntax for procedure style: controlling execution flow (2.5)
### Switching
- [ ] if
- [ ] switch and limitations
### Demo
- [ ] Does switch use == or .equals() for String type?
### Looping
- [ ] for
- [ ] do
- [ ] while
- [ ] "foreach"
### Breaking switches and loops
- [ ] Nested switches and loops
- [ ] break
- [ ] continue
- [ ] labels:
### Design considerations
- [ ] Procedure Metrics: CC
- [ ] Readability and high CC: Extract Method refactoring

## Hand-on Iteration 02: Stateful decorating Transaction Logger
- [ ] Read and analyse specification as tests for this iteration in *src/test*
- [ ] Uncomment specification cases
- [ ] Implement features needed
### DoD
- [ ] All given specifications runs are green
- [ ] Code reuse and minimum code duplication
- [ ] Code style

## Java reference types (2.5)
### References
- [ ] Reference + referenced object
- [ ] JVM memory structure revisited: Heap object space
- [ ] Object structure and its defining class
### Demo
- [ ] Where reference can be placed?
- [ ] What is memory consumption for reference?
- [ ] What is default value for reference?
- [ ] Double-referencing and == vs equals()
- [ ] Dereferencing and GC
### Reference argument passing
- [ ] What passing style used?
- [ ] Side effects concept and its scopes
### Demo
- [ ] Reference passing and memory side effect
### Java Array reference type
- [ ] Declaration
- [ ] Initialization
- [ ] API: addressing, length
- [ ] Exceptions
- [ ] "Immutability"
- [ ] "foreach" cycle
- [ ] Milti-dimentional arrays
- [ ] Array literal
### Demo
- [ ] Milti-dimentional literal references array walking
### Varargs
- [ ] Why?
- [ ] Declaration
- [ ] Passing
- [ ] Using
- [ ] Limitations
### Demo
- [ ] Analyzing program arguments as main(string vararg)
### Strings
- [ ] Declaration
- [ ] Initialization with literal and constructor
- [ ] "Immutability" vs StringBuffer/StringBuilder
- [ ] API
- [ ] Strings equality: == and .equals()
- [ ] Surprise: Strings interning and pool
### Demo
- [ ] Strings interning
- [ ] Wrappers interning and limitations

## Hand-on Iteration 03: Type-safe stateful decorating logger
- [ ] Read and analyse specification as tests for this iteration in *src/test*
- [ ] Uncomment specification cases
- [ ] Implement features needed
### DoD
- [ ] All given specifications runs are green
- [ ] Code reuse and minimum code duplication
- [ ] Code style

## OOAD style (1)
### Demo
- [ ] Procedure-oriented application design stub
- [ ] Maintainability issues: ~~SRP~~, ~~OCP~~
- [ ] Refactoring Extract Enum
- [ ] Clear code and readability values
- [ ] Refactoring Extract Method
- [ ] Encapsulation concept and values
- [ ] Refactoring Extract class / Move method
- [ ] Polymorphism concept and values
- [ ] Refactoring Extract Interface
- [ ] Inheritance concept and values
- [ ] Refactoring Extract Superclass
### Dealing with state
- [ ] Stateful vs Stateless components
### Demo
- [ ] Creational problem
- [ ] Creator pattern
- [ ] Factory Method pattern and cases
- [ ] Abstract Factory pattern and cases
- [ ] Registry pattern and cases
- [ ] DI pattern and cases: field, constructor, setter, method injections
- [ ] Final full UML picture

## Enumerated types in Java (1)
### Final keyword
- [ ] 3 modifier semantics
### Enums
- [ ] Enumerated type concept: why?
- [ ] API
- [ ] Referencing and == vs equals()
- [ ] Using with switch 
- [ ] Smart Enum anti/pattern
### Demo
- [ ] Implementing enum without built-in enum type
- [ ] Check if static concept understood well
- [ ] Implementing Singleton anti/pattern

## Hand-on Iteration 04: Refactor towards OOAD through enums 
- [ ] Refactor to Enums: Dumb Commands
### DoD
- [ ] All given specifications runs are green
- [ ] Code reuse and minimum code duplication
- [ ] Code style

## Java syntax for OOAD: Encapsulation (2.5)
### Data and Behavior encapsulation
- [ ] Why?
- [ ] Packages and classes as Encapsulation units
- [ ] Access modifiers and their order
- [ ] Encapsulating state: data hiding with accessors/mutators as OCP implementation for flexibility
- [ ] Setters/getters is not encapsulation in general case
### Object instatiation 
- [ ] Constructor сoncept
- [ ] Differences with methods
- [ ] Default constructor
- [ ] Variable shading within constructor
- [ ] Overloaded constructors and its reuse
### Demo
- [ ] Factory Method Pattern as constructor alternative: OCP implementation for flexibility
- [ ] Builder Pattern as constructor alternative: OCP implementation for flexibility

## Hand-on Iteration 05: Refactor towards OOAD through encapsulation 
- [ ] FR: presentation changes
- [ ] Refactor to code reuse with Smart Commands
- [ ] Refactor to code reuse with Factory Method pattern
### DoD
- [ ] All given specifications runs are green
- [ ] Code reuse and minimum code duplication
- [ ] Code style

## Java syntax for OOAD: Polymorphism (2.5)
### Polymorphism concept
- [ ] Type system with "IS-A" relationship: introducing _abstract type_
- [ ] Polymorphic/dynamic/virtual method call: 
```java
AbstractType object = new ImplementationType();
```
- [ ] Limitations of visible features
- [ ] Static methods shading and its "polymorphic" call
### Type-switching
- [ ] Type casting operator
- [ ] instanceof operator
- [ ] Why is it anti-pattern?
### Interfaces as a case of Abstract Type 
- [ ] Interface declaration
- [ ] Default modifiers for methods and "variables"
- [ ] Interface inheritance
- [ ] Interface implementation
- [ ] Multiple implementations
- [ ] Defender methods: static and default, diamond problem
### Demo
- [ ] Polymorphic arrays
- [ ] Polymorphic methods arguments
- [ ] Strategy Design Pattern
- [ ] State Design Pattern

## Hand-on Iteration 06: Refactor towards OOAD through polymorphism 
- [ ] FR: presentation changes and sink changes
- [ ] Refactor to Polymorphic Commands and Appenders
### DoD
- [ ] All given specifications runs are green
- [ ] Code reuse and minimum code duplication
- [ ] Code style

## Java syntax for OOAD: Inheritance (2.5)
### Polymorphism with subclassing
- [ ] Abstract modifier
- [ ] Abstract class as a case of Abstract Type
- [ ] Show-case for interface-like substituting
### Code Reuse with subclassing
- [ ] Extending abstract class with subclass
- [ ] Limitation on parents count
- [ ] Limitation on parents member visibility
- [ ] Out-of-box reusing all inherited members
- [ ] Overriding parents behavior
- [ ] Reusing some behavior with super()
- [ ] Overriding methods constraints and LSP
### Constructors issue with subclassing
- [ ] Constructor ~~inheritance~~ and why? (interfaces)
- [ ] Ok google, so how I can call super constructor?
- [ ] Constructors call wave for hierarchy: compiler's _default_ super() call
- [ ] super() vs this() and its position within constructor
- [ ] Object Initialization section
### Demo
- [ ] Implementing Template Method Pattern with abstract superclass

## Hand-on Iteration 07: Refactor towards OOAD through inheritance 
- [ ] FR: decoration changes
- [ ] Refactor to code reuse with Template Method pattern
### DoD
- [ ] All given specifications runs are green
- [ ] Code reuse and minimum code duplication
- [ ] Code style

## OOAD Principles and Patterns: Revisiting (2)
### OOAD Principles: SOLID
- [ ] SRP
- [ ] OCP
- [ ] LSP
- [ ] ISP
- [ ] DIP
### Creation Patterns
- [ ] ~~Singleton~~
- [ ] Creator
- [ ] Factory Method
- [ ] Builder
- [ ] Abstract Factory
- [ ] Registry
- [ ] DI: field, constructor, setter, method
### Structural Patterns
- [ ] Adapter
- [ ] Decorator
- [ ] Facade
- [ ] Proxy
- [ ] Composite
### Behavioral Patterns
- [ ] State/Strategy
- [ ] Command
- [ ] Mediator (our Controller)
- [ ] Observer/Listener
- [ ] Visitor
### Demo
- [ ] Typical enterprise application architecture overview with patterns spotted
- [ ] Visitor implementation for Expression Problem statement

## Hand-on Iteration 08: Technical debt towards modern application design 
- [ ] Application architecture and design review
- [ ] Technical debt fixed in backlog
- [ ] Refactor to DI pattern
### DoD
- [ ] All given specifications runs are green
- [ ] Code reuse and minimum code duplication
- [ ] Code style
### Debrief
- [ ] Cross-review of technical backlog

## Error handling in Java (2.5)
### Exception concept
- [ ] Type information
- [ ] Object data information
- [ ] Methods call stack information
### Trowing and handling exceptions
- [ ] creating exception instance
- [ ] throw operator
- [ ] Methods call stack tracing
- [ ] try section
- [ ] catch section
- [ ] Where in call stack we should handle for typical architecture?
- [ ] How we should handle? Log/Retry/Rethow patterns.
- [ ] finally section
- [ ] Suppression bug
### Syntax sugar
- [ ] multi-catch
- [ ] try-with-resources
### Demo
- [ ] Typical layered architecture
- [ ] Rising exception in deep layer
- [ ] Rethrow example
- [ ] Exception from main() example
- [ ] Suppression example
### Exceptions type system
- [ ] Built-in types
- [ ] Errors vs Exceptions
- [ ] Checked vs Runtime exceptions
- [ ] Exceptions type system architecture styles: old-school and hipsta
### Demo
- [ ] Add custom business exception type
- [ ] Add handling within application architecture

## Hand-on Iteration 09: Make application ~~great again~~ fail-over and user-friendly in corner cases 
- [ ] Introduce business exception type system
- [ ] Implement exception handling
### DoD
- [ ] All given specifications runs are green
- [ ] Code reuse and minimum code duplication
- [ ] Code style

## Unit testing overview (2)
### Test scopes
- [ ] Mapping test scopes to typical architecture
- [ ] Testing pyramid with testability base
### Test structure with JUnit
- [ ] AAA & GWT
- [ ] Fixtures
- [ ] Assertions
### Isolating tests with Mockito test doublers
- [ ] State-based test scenario
- [ ] Interaction-based test scenario
### Coverage reporting
- [ ] Running JaCoCo with Maven build
- [ ] Analyzing reporting
### Demo
- [ ] What to cover?
- [ ] Test case with test doublers and coverage analysis

## Hand-on Iteration 10: Make developers sleep at nights 
- [ ] Decide what to cover and state your coverage decisions
- [ ] Cover application with _unit_ auto tests 
### DoD
- [ ] All given specifications runs are green
- [ ] Code reuse and minimum code duplication
- [ ] Code style
- [ ] Unit test coverage metric achieved

## Java syntax for Generic Programming style (1)
### Problem statement
- [ ] Given type-generic algorithm/data structure: e.g. Optional
- [ ] Choosing Object as data type
- [ ] Issues with type checks and downcasting
### Type safety with generic programming
- [ ] Type parameters for methods
- [ ] Type parameters for class 
- [ ] Instatiating type-parameterized class
- [ ] Type erasure :(
### Demo
- [ ] Type parameters for interface
- [ ] Issue with type parameter invariance and complex type parameter patterns
- [ ] Patterns for implementing type-parameterized interface

## Functional style (0.5)
### Main features
- [ ] Infinite data
- [ ] Immutable data
- [ ] Composing functions around data
- [ ] Functions as arguments and return types
- [ ] Computation lazyness
### Demo for High-order function
- [ ] Passing function as parameter as alternative for TM and ST
- [ ] Passing Comparator to sort()

## Java syntax for functional style (2.5)
### Nested classes
- [ ] Static nested classes
- [ ] Inner (non-static nested) classes
- [ ] Local inner classes
- [ ] Anonymous inner classes
### Local classes as closures
- [ ] Auto passing by name / capturing outer variables
- [ ] Captured variable limitations
### Lambda syntax for anonymous inner classes
- [ ] Declaring lambdas
- [ ] Compiler types inference
- [ ] Functional interface
- [ ] Method reference
### Demo for lambda use-cases
- [ ] Alternative implementation for Template Method, Strategy/State, Listener
- [ ] Optional API
- [ ] Collection API: sorting with Comparator
- [ ] Java8 Stream API
- [ ] Runnable and Executors API
- [ ] CompletableFuture API

## Hand-on Iteration 11: Refactor to functional style
- [ ] Refactor to ƛ-style: introduce HOFs for main responsibilities
- [ ] Introduce data immutability
- [ ] Introduce Optional type  
### DoD
- [ ] All given specifications runs are green
- [ ] Code reuse and minimum code duplication
- [ ] Code style
- [ ] Unit test coverage metric achieved

## System library core classes overview (2)
- [ ] System
- [ ] System properties acessing and setting
- [ ] Runtime
- [ ] Math: issue with FP types presicion loss 
- [ ] String: immutable and interned
- [ ] StringBuffer & StringBuilder: mutable, thread safe/unsafe + String concat JVM optimization with SB
- [ ] Wrapper classes for primitives: immutable and interned, autoboxed/unboxed
- [ ] Objects: utility tasks
- [ ] Arrays: utility tasks
### Object
- [ ] finalize()
- [ ] toString()
- [ ] clone()
- [ ] equals() and hashCode() contract
### Demo
- [ ] Implementing cloneable ability
- [ ] Implementing equals() and hashCode() for entity class

## Hands-on Iteration 12: Readiness for Collection API
- [ ] Implementing equals() and hashCode() for entity class
### DoD
- [ ] All given specifications runs are green
- [ ] Code reuse and minimum code duplication
- [ ] Code style
- [ ] Unit test coverage metric achieved

## Collections API (2)
### Built-in types overview
- [ ] "Old" collection classes: why replaced?
- [ ] Modern Collection API overview: iterating
- [ ] Iterator: why?
- [ ] Set vs List API overview: unique? ordered? sorted?
- [ ] Map API overview
- [ ] Queue and Dequeue API overview
- [ ] Collections: utility class and basic operations
### Sets
- [ ] Set API
- [ ] SortedSet
- [ ] NavigableSet
#### HashSet implementation
- [ ] Buckets
- [ ] Load factor
- [ ] Rehashing when?
- [ ] Treefying
- [ ] Performave issue with not setting initial size
#### LinkedHashSet implementation
- [ ] Ordering
#### TreeSet implementation
- [ ] R/B balanced tree
- [ ] Comparable objects or Comparator needed
- [ ] Rebalancing when?
#### Demo 
- [ ] Set constraint violation issue with mutable object and equals/hashCode set
### Lists
- [ ] List API
#### ArrayList implementation
- [ ] Array rebuilding
- [ ] RandomAccess
#### LinkedList implementation
- [ ] Double-ended linked list
### Maps
- [ ] Map API
- [ ] nulls?
#### Implementations
- [ ] HashMap vs TreeMap: the same 
- [ ] WeakHashMap
### Queues
- [ ] Queue API
- [ ] Dequeue API
#### Implementations
- [ ] LinkedList
- [ ] PriorityQueue
- [ ] ArrayDequeue

## Hands-on Iteration 13: Refactor to memory-intensive design
- [ ] Decide and state decision for Collection class for application state handling
- [ ] Introduce implementation
### DoD
- [ ] All given specifications runs are green
- [ ] Code reuse and minimum code duplication
- [ ] Code style
- [ ] Unit test coverage metric achieved
### Debrief
- [ ] State for implementation chosen

## Blocking IO (2.5)
### IO Stream API overview
- [ ] Streams and Readers/Writers
- [ ] Buffering
- [ ] Encoding
### File IO
- [ ] File and Path
- [ ] File IO with Stream API
- [ ] Simple file operations with utility class Files
- [ ] RandomAccessFile
### Serialization
- [ ] ObjectInput/OutputStream
- [ ] Serializable

## Hands-on Iteration 14: Logging to file... finally
- [ ] Saving log data to file
- [ ] Rotating files
### DoD
- [ ] All given specifications runs are green
- [ ] Code reuse and minimum code duplication
- [ ] Code style
- [ ] Unit test coverage metric achieved

## Networking with TCP/IP (2)
- [ ] Socket abstraction
- [ ] ServerSocket listener
### NIO2 intro demo
- [ ] Architecture
- [ ] API
### Distributed systems issue
- [ ] CAP requirements

## Hands-on Iteration 15: Distributed logging
- [ ] Remote logging for one client
### DoD
- [ ] All given specifications runs are green
- [ ] Code reuse and minimum code duplication
- [ ] Code style
- [ ] Unit test coverage metric achieved

## Annotations and Reflection API (2)
### Annotations
- [ ] Annotation concept
- [ ] Compiler annotations
- [ ] Annotation processing
- [ ] Developing custom annotation
### Reflection API: introspection
- [ ] Class API
- [ ] FEST-reflect library
### Reflection API: class loading/unloading
- [ ] Class loading API
- [ ] JVM Agent concept

## Hands-on Iteration 16: Refactor to custom Enterprise Framework
- [ ] Ops need to configure business logic components with configuration file
### DoD
- [ ] All given specifications runs are green
- [ ] Code reuse and minimum code duplication
- [ ] Code style
- [ ] Unit test coverage metric achieved

## Parallelism (2)
### Miltithreading in Java
- [ ] Thread definition
- [ ] Scheduler
- [ ] Scheduling overhead
- [ ] Green vs Native threads
### Thread API
- [ ] Thread start
- [ ] Thread management
- [ ] Thread states
- [ ] Priorities
- [ ] Daemons
- [ ] Blocking operations and states
### Thread pool API
- [ ] Executor and ExecutorService API
- [ ] Callable and Future API
- [ ] ExecutionException container
### JMH intro
- [ ] Microbenchmarking common issues
- [ ] JMH API
### Demo
- [ ] JMH benchmarking collection operations

## Hands-on Iteration 17: Multi-client remote logging
- [ ] Remote logging for up to 1k clients
### DoD
- [ ] All given specifications runs are green
- [ ] Code reuse and minimum code duplication
- [ ] Code style
- [ ] Unit test coverage metric achieved

## Concurrency (3)
### Data Race issue
- [ ] Preemptive parallelism trade-off for atomicity
- [ ] Data race concept
- [ ] Thread-safety concept
- [ ] synchronized method
- [ ] New thread state
- [ ] Monitor Object
- [ ] synchronized() section
- [ ] Monitor granularity patterns
- [ ] Lock and ReadWriteLock as improved monitors
### Visibility and Reordering issues
- [ ] JVM optimizations
- [ ] CPU core cache syncronization protocol and defult strategy
- [ ] Visibility issue
- [ ] Reordering issue
- [ ] Known synchronized and lock tools
- [ ] New volatile keyword
- [ ] volatile limitations
### JMM intro
- [ ] Happens-before relation
- [ ] Core happens-before events
### Non-blocking concurrency
- [ ] Trade-offs for blocking monitor synchronization
- [ ] CAS operation and hardware support
- [ ] Atomic data types and reference
- [ ] Algorithm patterns on Atomics
### Thread syncronization
- [ ] join() and sleep() and new thread state
- [ ] Blocking IO and new thread state
- [ ] Waiting and new thread state
- [ ] Dealing with InterruptedException
- [ ] Waiting for event with ~~polling~~
- [ ] Waiting for event with monitor.wait()
- [ ] Waking up with monitor.notify()
- [ ] Double-checked waking up pattern

## Hands-on Iteration 18: Concurrent multi-client remote logging
- [ ] Remote logging for up to 1k clients with correctness prove
### DoD
- [ ] All given specifications runs are green
- [ ] Code reuse and minimum code duplication
- [ ] Code style
- [ ] Unit test coverage metric achieved

## Concurrent collections (1)
- [ ] Collections.synronizedXXX _is not_ concurrent collections
- [ ] java.util.concurrent Collections overview
- [ ] Profits and trade-offs
#### Implementations
- [ ] ConcurrentSkipListSet
- [ ] CopyOnWriteArraySet
- [ ] CopyOnWriteArrayList
- [ ] ConcurrentHashMap
- [ ] ConcurrentSkipListMap
- [ ] ArrayBlockingQueue / LinkedBlockingQueue
- [ ] ConcurrentLinkedQueue

## Database access (?)
### JDBC intro
### JPA intro

## Buffer (2.5)
- [ ] Daily retrospectives
