## [2633. Convert Object to JSON String](https://leetcode.com/problems/convert-object-to-json-string)

```Tag```: ```JSON / Recursion / Important Utilities```

#### Difficulty: Medium

Given an object, return _a valid JSON string of that object_. You may assume the object only inludes strings, integers, arrays, objects, booleans, and null. The returned string should not include extra spaces. The order of keys should be the same as the order returned by ```Object.keys()```.

Please solve it without using the built-in ```JSON.stringify``` method.

---

__Example 1:__
```
Input: object = {"y":1,"x":2}
Output: {"y":1,"x":2}
Explanation: 
Return the JSON representation.
Note that the order of keys should be the same as the order returned by Object.keys().
```

__Example 2:__
```
Input: object = {"a":"str","b":-12,"c":true,"d":null}
Output: {"a":"str","b":-12,"c":true,"d":null}
Explanation:
The primitives of JSON are strings, numbers, booleans, and null.
```

__Example 3:__
```
Input: object = {"key":{"a":1,"b":[{},null,"Hello"]}}
Output: {"key":{"a":1,"b":[{},null,"Hello"]}}
Explanation:
Objects and arrays can include other objects and arrays.
```

__Example 4:__
```
Input: object = true
Output: true
Explanation:
Primitive types are valid inputs.
```

__Constraints:__

- object includes strings, integers, booleans, arrays, objects, and ```null```
- ```1 <= JSON.stringify(object).length <= 10^5```
- ```maxNestingLevel <= 1000```
- all strings will only contain alphanumeric characters

---

A valid JSON string follow some rules that are given below:

- All property names (keys) must be enclosed in double quotes.
- String values must be enclosed in double quotes.
- Numeric values can be written without quotes.
- Boolean values and the null value are written without quotes, using the keywords ```true```, ```false```, and ```null```, respectively.
- Arrays are enclosed in square brackets ```[]```, and values inside the array are separated by commas.
- Objects are enclosed in curly braces ```{}```, and key-value pairs inside the object are separated by commas. The key and value are separated by a colon ```:```.

For example:

```JavaScript
{
"name": "Phantom",
"age": 20,
"hobbies": ["chess", "sitting_idle"],
"address": {
    "street": "123 Main St",
    "city": "Mumbattan"
},
"active": true,
"score": null
}
```

> Note: The JSON format does not allow trailing commas, so make sure to remove any unnecessary commas when constructing a JSON string representation.

### Use Cases:

- __API Data Serialization__: When building web applications that communicate with APIs, objects often need to be converted to JSON strings before sending them as data in HTTP requests. This allows the data to be properly serialized and transmitted in a format that APIs understand.

```JavaScript
// Creating an object to be sent as data in an HTTP request
const data = { name: 'Racoon', age: 9, email: 'racoon@example.com' };

// Converting the object to a JSON string
const jsonData = JSON.stringify(data);
// jsonData: '{"name":"Racoon","age":9,"email":"racoon@example.com"}'

// Sending an HTTP POST request with the JSON data as the request body
fetch('https://api.example.com/users', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'
  },
  body: jsonData
})
  .then(response => response.json())
  .then(responseData => {
    // Handling the response data received from the server
    console.log(responseData);
  })
  .catch(error => {
    // Handling any errors that occurred during the request
    console.error(error);
  });
```

- __Local Storage__: In web development, the ```localStorage``` or ```sessionStorage``` APIs are commonly used to store data locally within the browser. Since these APIs only accept string values, converting objects to JSON strings is necessary to store complex data structures and retrieve them later.

```JavaScript
const user = { name: 'RocketRacoon', id: 8913, isAdmin: false };
const jsonUser = JSON.stringify(user);
localStorage.setItem('user', jsonUser);

// Retrieve the user from local storage and parse it back to an object
const storedUser = localStorage.getItem('user');
const parsedUser = JSON.parse(storedUser);
console.log(parsedUser.name); // Output: "RocketRacoon"
```

- __Logging__: When logging data or generating log files, converting objects to JSON strings provides a structured and readable format for storing logs. It allows for easy analysis, searching, and processing of log data.

```JavaScript
const logData = { timestamp: new Date(), level: 'info', message: 'User logged in' };
const jsonLogData = JSON.stringify(logData);

// Store the jsonLogData in log files or send it to a logging service
// ...
```

- __Configuration Files__: JSON is commonly used for configuration files in various applications. Converting objects to JSON strings allows for easy storage and retrieval of configuration settings, enabling customization and flexibility in application behavior.

```JavaScript
const config = { apiUrl: 'https://api.example.com', maxRetries: 3, timeout: 5000 };
const jsonConfig = JSON.stringify(config);

// Save the jsonConfig to a configuration file
// ...
```

---

### Approach 1: Using JSON-like String Concatenation

```JavaScript
/**
 * @param {any} object
 * @return {string}
 */
var jsonStringify = function(object) {
    if (object === null) {
        return 'null';
    }
    if (Array.isArray(object)) {
        const elements = object.map((element) => jsonStringify(element));
        return `[${elements.join(',')}]`;
    }
    if (typeof object === 'object') {
        const keys = Object.keys(object);
        const keyValuePairs = keys.map((key) => `"${key}":${jsonStringify(object[key])}`);
        return `{${keyValuePairs.join(',')}}`;
    }
    if (typeof object === 'string') {
        return `"${object}"`;
    }
    return String(object);
};
```

### Approach 2: Using Switch Case

```JavaScript
/**
 * @param {any} object
 * @return {string}
 */
var jsonStringify = function(object) {
  switch (typeof object) {
    case 'object':
      if (Array.isArray(object)) {
        const elements = object.map((element) => jsonStringify(element));
        return `[${elements.join(',')}]`;
      } else if (object) {
        const keys = Object.keys(object);
        const keyValuePairs = keys.map((key) => `"${key}":${jsonStringify(object[key])}`);
        return `{${keyValuePairs.join(',')}}`;
      } else {
        return 'null';
      }
    case 'boolean':
    case 'number':
      return `${object}`;
    case 'string':
      return `"${object}"`;
    default:
      return '';
  }
};
```

### Approach 3: Using Ternary Operator

```JavaScript
/**
 * @param {any} object
 * @return {string}
 */
var jsonStringify = function(object) {
    return typeof object === 'string' ? '"' + object + '"' :
        object === null || typeof object !== 'object' ? object :
        Array.isArray(object) ? '[' + object.reduce((acc, x) => acc + jsonStringify(x) + ',', '').slice(0, -1) + ']' :
        '{' + Object.entries(object).reduce((acc, x) => acc + jsonStringify(x[0]) + ':' + jsonStringify(x[1]) + ',', '').slice(0, -1) + '}';
};
```
