## [2621. Sleep](https://leetcode.com/problems/sleep)

#### Difficulty: Easy

Given a positive integer ```millis```, write an asyncronous function that sleeps for ```millis``` milliseconds. It can resolve any value.

---

__Example 1:__
```
Input: millis = 100
Output: 100
Explanation: It should return a promise that resolves after 100ms.
let t = Date.now();
sleep(100).then(() => {
  console.log(Date.now() - t); // 100
});
```

__Example 2:__
```
Input: millis = 200
Output: 200
Explanation: It should return a promise that resolves after 200ms.
```

__Constraints:__

- ```1 <= millis <= 1000```

---

A promise in JavaScript is an object representing the eventual completion or failure of an asynchronous operation. Essentially, it's a returned object to which you attach callbacks, as opposed to passing callbacks into a function.

```JavaScript
let promise = new Promise((resolve, reject) => {
    let condition = true;  // This could be the result of some operation

    // After 1 second, check the condition and resolve or reject the promise
    setTimeout(() => {
        if (condition) {
            resolve('Promise fulfilled!');
        } else {
            reject('Promise rejected!');
        }
    }, 1000);
});

// Attach then() and catch() handlers to the Promise
promise
    .then(value => {
        // This will be executed if the promise is resolved
        console.log(value); // Output: Promise fulfilled!
    })
    .catch(error => {
        // This will be executed if the promise is rejected
        console.log(error);
    });
```

### ```setTimeout``` and Event Loop

The ```setTimeout``` function plays a key role in this problem. It's a method that calls a function or evaluates an expression after a specified number of milliseconds. In JavaScript, setTimeout is used to delay the execution of a piece of code.

```JavaScript
console.log("Starting the timer...");

setTimeout(() => {
    console.log("Timeout completed!");
}, 2000);
```

It's also worth to mention ```clearTimeout``` which is a valuable function in JavaScript's suite of timer functions. ```clearTimeout``` is a function that cancels a timeout previously established by calling ```setTimeout```.

Here's how you use it:

```JavaScript
console.log("Starting the timer...");

// setTimeout returns a Timeout object which can be used to reference the timer
let timeoutId = setTimeout(() => {
  console.log("Timeout completed!");
}, 2000);

// Some condition or logic
if (/* some condition */) {
// Cancels the timeout
  clearTimeout(timeoutId);
}
```

### Asynchronous Callbacks

```JavaScript
async function foo() {
  return 'Hello, World!';
}

foo().then(message => console.log(message)); // logs 'Hello, World!'
```

Here's a specific example of how asynchronous programming can be used for handling user interactions. Consider a web page where the user can click a button to load data from a server, perhaps a list of items to display. When the button is clicked, you don't want to freeze the entire page while waiting for the server to respond. Instead, you want to handle the request asynchronously. Here's how you might do this:

```JavaScript
// The 'async' keyword allows the use of 'await' inside the function
button.addEventListener('click', async () => {
    // Show a loading spinner
    spinner.style.display = 'block';

    try {
        // Fetch data from server
        let response = await fetch('https://api.example.com/items');

        // Parse the JSON response
        let items = await response.json();

        // Update the UI with the new items
        displayItems(items);
    } catch (error) {
        // Handle any errors
        console.error('Error:', error);
    } finally {
        // Hide the loading spinner
        spinner.style.display = 'none';
    }
});
```

### Async/await

Async/await can be seen as syntax sugar on top of promises, making asynchronous code easier to write and understand. When we mark a function with the ```async``` keyword, it becomes an asynchronous function that automatically returns a promise. Within an ```async``` function, we can use the ```await``` keyword to pause the execution of the code until the promise is resolved or rejected.

By employing await, we can eliminate the need for explicit .then() and .catch() chains that are typically used with promises. Instead, we can structure our code in a more linear and synchronous-looking manner. This makes it easier to reason about the flow of the program and handle errors in a more concise way.

```JavaScript
// Using explicit .then() and .catch() with promises
fetchData()
  .then(response => {
    // Handle the response
    console.log("Response:", response);
    return processData(response);
  })
  .then(result => {
    // Handle the processed data
    console.log("Processed data:", result);
  })
  .catch(error => {
    // Handle any errors
    console.error("Error:", error);
  });

// Using async/await
async function fetchDataAndProcess() {
  try {
    const response = await fetchData();
    console.log("Response:", response);

    const result = await processData(response);
    console.log("Processed data:", result);
  } catch (error) {
    console.error("Error:", error);
  }
}

fetchDataAndProcess();
```

### Promise Chaining

Promise chaining is a technique in JavaScript that allows you to perform multiple asynchronous operations in a sequence, with each operation starting when the previous one has completed. The primary advantage of promise chaining is that it allows you to avoid the "callback hell" or "pyramid of doom" that can result from using nested callbacks to handle asynchronous code. Instead, you can write asynchronous code that almost looks like synchronous code, making it much easier to understand and maintain. Each ```then``` in a promise chain receives the result of the previous promise's resolution. This result can be used to inform the next step in the chain. If a promise in the chain is rejected, the chain's subsequent ```then``` methods will be skipped until a catch method is found.

```JavaScript
fetchData()
  .then(response => {
    console.log("Response:", response);
    return processData(response);  // This returns a new promise
  })
  .then(processedData => {
    console.log("Processed data:", processedData);
    return furtherProcessing(processedData);  // This returns another new promise
  })
  .then(finalResult => {
    console.log("Final result:", finalResult);
  })
  .catch(error => {
    console.error("Error:", error);
  });
```

```fetchData```, ```processData```, and ```furtherProcessing``` are all asynchronous functions that return promises. The then methods are chained together, with each one waiting for the previous promise to resolve before starting its operation. If any promise in the chain is rejected, the catch method at the end will be invoked to handle the error.

### Understanding .finally

In JavaScript, Promises offer several powerful methods for handling asynchronous actions and their results. One of these methods is ```.finally```. The ```.finally``` method is a built-in method of a Promise that is always executed, regardless of whether the promise is fulfilled or rejected. This makes it an excellent place to put cleanup code that must be run regardless of the outcome of the promise.

```JavaScript
let isLoading = true;

fetch('https://api.example.com/data')
  .then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.json();
  })
  .then(data => console.log(data))
  .catch(error => console.error('Error:', error))
  .finally(() => {
    isLoading = false;
    console.log('Fetch operation finished');
  });
```

We're using fetch here (which returns a promise) to retrieve data from a URL. We then use ```.then``` to handle the response, and ```.catch``` to handle any errors. Finally, regardless of whether the fetch operation was successful or not, ```.finally``` is called to set isLoading to false and log a message to the console.
