## [2622. Cache With Time Limit](https://leetcode.com/problems/cache-with-time-limit)

```Tag```: ```Time (setTimeout)```

#### Difficulty: Medium

Write a class that allows getting and setting key-value pairs, however a __time until expiration__ is associated with each key.

The class has three public methods:

```set(key, value, duration)```: accepts an integer ```key```, an integer ```value```, and a ```duration``` in milliseconds. Once the ```duration``` has elapsed, the ```key``` should be inaccessible. The method should return ```true``` if the same un-expired ```key``` already exists and ```false``` otherwise. Both the ```value``` and ```duration``` should be overwritten if the ```key``` already exists.

```get(key)```: if an un-expired ```key``` exists, it should return the associated ```value```. Otherwise it should return ```-1```.

```count()```: returns the count of un-expired ```keys```.

---

__Example 1:__
```
Input: 
["TimeLimitedCache", "set", "get", "count", "get"]
[[], [1, 42, 100], [1], [], [1]]
[0, 0, 50, 50, 150]
Output: [null, false, 42, 1, -1]
Explanation:
At t=0, the cache is constructed.
At t=0, a key-value pair (1: 42) is added with a time limit of 100ms. The value doesn't exist so false is returned.
At t=50, key=1 is requested and the value of 42 is returned.
At t=50, count() is called and there is one active key in the cache.
At t=100, key=1 expires.
At t=150, get(1) is called but -1 is returned because the cache is empty.
```

__Example 2:__
```
Input: 
["TimeLimitedCache", "set", "set", "get", "get", "get", "count"]
[[], [1, 42, 50], [1, 50, 100], [1], [1], [1], []]
[0, 0, 40, 50, 120, 200, 250]
Output: [null, false, true, 50, 50, -1]
Explanation:
At t=0, the cache is constructed.
At t=0, a key-value pair (1: 42) is added with a time limit of 50ms. The value doesn't exist so false is returned.
At t=40, a key-value pair (1: 50) is added with a time limit of 100ms. A non-expired value already existed so true is returned and the old value was overwritten.
At t=50, get(1) is called which returned 50.
At t=120, get(1) is called which returned 50.
At t=140, key=1 expires.
At t=200, get(1) is called but the cache is empty so -1 is returned.
At t=250, count() returns 0 because the cache is empty.
```

__Constraints:__

- ```0 <= key <= 10^9```
- ```0 <= value <= 10^9```
- ```0 <= duration <= 1000```
- total method calls will not exceed ```100```

---

### Use-case for a Cache with a Time Limit

Imagine you are maintaining a cache of files from a database. You could load each file once and keep it in memory indefinitely. The issue is if a file is updated in the database, the cache will contains out-of-date data. Another option is to constantly re-download the files every time a file is accessed (or at least send a request asking if it changed). But this could be inefficient and slow, especially if the files change infrequently.

If it is acceptable for the data to sometimes be a little out of date, a good compromise is to give the data a Time Until Expiration. This provides a good balance between performance and having up-to-date data. This type of cache is most effective when the same key is accessed in rapid succession.

Here is some code showing how to use this type of cache for that purpose:

```JavaScript
const cache = new TimeLimitedCache();

async function getFileWithCache(filename) {
  let content = cache.get(filename);
  if (content !== -1) return content;
  content = await loadFileContents(filename);
  const ONE_HOUR = 60 * 60 * 1000;
  cache.set(filename, content, ONE_HOUR);
  return content;
}
```

In the above code, ```getFileWithCache``` first tries to load the data from the cache. If there was a cache-hit, it immediately returns the result. Otherwise it downloads the data and populates the cache before returning the downloaded data.

---

### Approach 1: setTimeout + clearTimeout + Class Syntax

```JavaScript
var TimeLimitedCache = function() {
    this.cache = new Map();
};

/** 
 * @param {number} key
 * @param {number} value
 * @param {number} time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function(key, value, duration) {
    const valueInCache = this.cache.get(key);
    if (valueInCache) {
      clearTimeout(valueInCache.timeout);
    }
    const timeout = setTimeout(() => this.cache.delete(key), duration);
    this.cache.set(key, { value, timeout });
    return Boolean(valueInCache);
};

/** 
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function(key) {
    return this.cache.has(key) ? this.cache.get(key).value : -1;
};

/** 
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function() {
    return this.cache.size;
};

/**
 * Your TimeLimitedCache object will be instantiated and called as such:
 * var obj = new TimeLimitedCache()
 * obj.set(1, 42, 1000); // false
 * obj.get(1) // 42
 * obj.count() // 1
 */
```

Approach 2: Maintain Expiration Times

```JavaScript
class TimeLimitedCache {
  cache = {};

  set(key, value, duration) {
    const hasUnexpiredValue = key in this.cache && Date.now() < this.cache[key].expiration;
    this.cache[key] = { value, expiration: Date.now() + duration };
    return hasUnexpiredValue;
  }

  get(key) {
    if (this.cache[key] === undefined) return -1;
    if (Date.now() > this.cache[key].expiration) return -1;
    return this.cache[key].value;
  }

  count() {
    let count = 0;
    for (const entry of Object.values(this.cache)) {
        if (Date.now() < entry.expiration) {
            count += 1;
        }
    }
    return count;
  }
};
```

### Approach 3: Maintain Expiration Times + Priority Queue

```JavaScript
class TimeLimitedCache {
  cache = {};
  queue = new MinPriorityQueue();
  size = 0;

  handleExpiredData() {
    const now = Date.now();
    while (this.queue.size() > 0 && this.queue.front().priority < now) {
      const entry = this.queue.dequeue().element;
      if (!entry.overwritten) {
        delete this.cache[entry.key];
        this.size -= 1;
      }
    }
  };

  set(key, value, duration) {
    this.handleExpiredData();
    const hasVal = key in this.cache
    if (hasVal) {
      this.cache[key].overwritten = true
    } else {
      this.size += 1;
    }
    const expiration = Date.now() + duration;
    const entry = { key, value, expiration, overwritten: false }
    this.cache[key] = entry
    this.queue.enqueue(entry, expiration);
    return hasVal;
  }

  get(key) {
    this.handleExpiredData();
    if (this.cache[key] === undefined) return -1;
    return this.cache[key].value;
  }

  count() {
    this.handleExpiredData();
    return this.size;
  }
};
```
