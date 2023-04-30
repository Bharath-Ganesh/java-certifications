Steps to reproduce

Session 1

In this session, you'll simulate multiple concurrent callers that are going to share a single
instance of the ProductManager.
You'll have to decouple locale management from the instance of the ProductManager, to allow different
concurrent callers to set their own locale.
Finally, you'll have to resolve filesystem path clashes that may occur when concurrent callers attempt
to write the same files.

Concurrency design

1. Each concurrent caller creates its own instance of the ProductManager.
    a. In this scenario, data cache store inside the ProductManager, as an instance variable would not be 
    shared between different threads.
    b. Each invoke would be able to assign its own locale.
2. All concurrent callers share a single instance of the ProductManager
    a. Having a shared cache would require a logic to prevent data corruption.
    b. Invokers would not be able to use different locale.
   
Steps.

1. We have to decouple ResourceFormatter one-one mapping with ProductManager.
2. Now provide languageTag to printProducts() and getDiscounts().
3. Make ProductManager singleton. Only one instance of the PM would get created.
4. Make the constructor private.

Session 2

To ensure safe and consistent access of the data using lock.

1. Some data can be immutable.
2. Some data can be made thread specific instead of shared.
3. Some data has to be made mutable, so it has to be guarded with thread lock.

5. Make ProductManager class as immutable as possible.
6. loadAllData(), loadProduct(), loadReview(), restoreData(), and createProduct() require write access as they
    populate value into the products hashmap.
7. findProduct(), getDiscounts(), printProducts(), dumpData() and printProductReport() requires only read access.
8. Change Map to ConcurrentHashMap. 
9. Introduce read and write lock

Session 3

In this session you simulate concurrent callers that shares a single instance of the ProductManager.

1. Client should have : Unique client id, thread name, random locale, random product Id.
