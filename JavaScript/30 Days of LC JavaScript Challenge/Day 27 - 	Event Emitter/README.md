## [2694. Event Emitter](https://leetcode.com/problems/event-emitter)

```Tag```: ```Classes```

#### Difficulty: Medium

Design an ```EventEmitter``` class. This interface is similar (but with some differences) to the one found in Node.js or the Event Target interface of the DOM. The ```EventEmitter``` should allow for subscribing to events and emitting them.

Your ```EventEmitter``` class should have the following two methods:

- subscribe - This method takes in two arguments: the name of an event as a string and a callback function. This callback function will later be called when the event is emitted. 
An event should be able to have multiple listeners for the same event. When emitting an event with multiple callbacks, each should be called in the order in which they were subscribed. An array of results should be returned. You can assume no callbacks passed to ```subscribe``` are referentially identical.
The ```subscribe``` method should also return an object with an ```unsubscribe``` method that enables the user to unsubscribe. When it is called, the callback should be removed from the list of subscriptions and ```undefined``` should be returned.
- emit - This method takes in two arguments: the name of an event as a string and an optional array of arguments that will be passed to the callback(s). If there are no callbacks subscribed to the given event, return an empty array. Otherwise, return an array of the results of all callback calls in the order they were subscribed.

---

__Example 1:__
```
Input: actions = ["EventEmitter", "emit", "subscribe", "subscribe", "emit"], values = [[], ["firstEvent", "function cb1() { return 5; }"],  ["firstEvent", "function cb1() { return 5; }"], ["firstEvent"]]
Output: [[],["emitted",[]],["subscribed"],["subscribed"],["emitted",[5,6]]]
Explanation: 
const emitter = new EventEmitter();
emitter.emit("firstEvent"); // [], no callback are subscribed yet
emitter.subscribe("firstEvent", function cb1() { return 5; });
emitter.subscribe("firstEvent", function cb2() { return 6; });
emitter.emit("firstEvent"); // [5, 6], returns the output of cb1 and cb2
```

__Example 2:__
```
Input: actions = ["EventEmitter", "subscribe", "emit", "emit"], values = [[], ["firstEvent", "function cb1(...args) { return args.join(','); }"], ["firstEvent", [1,2,3]], ["firstEvent", [3,4,6]]]
Output: [[],["subscribed"],["emitted",["1,2,3"]],["emitted",["3,4,6"]]]
Explanation: Note that the emit method should be able to accept an OPTIONAL array of arguents.

const emitter = new EventEmitter();
emitter.subscribe("firstEvent, function cb1(...args) { return args.join(','); });
emitter.emit("firstEvent", [1, 2, 3]); // ["1,2,3"]
emitter.emit("firstEvent", [3, 4, 6]); // ["3,4,6"]
```

__Example 3:__
```
Input: actions = ["EventEmitter", "subscribe", "emit", "unsubscribe", "emit"], values = [[], ["firstEvent", "(...args) => args.join(',')"], ["firstEvent", [1,2,3]], [0], ["firstEvent", [4,5,6]]]
Output: [[],["subscribed"],["emitted",["1,2,3"]],["unsubscribed",0],["emitted",[]]]
Explanation:
const emitter = new EventEmitter();
const sub = emitter.subscribe("firstEvent", (...args) => args.join(','));
emitter.emit("firstEvent", [1, 2, 3]); // ["1,2,3"]
sub.unsubscribe(); // undefined
emitter.emit("firstEvent", [4, 5, 6]); // [], there are no subscriptions
```

__Constraints:__

- ```1 <= actions.length <= 10```
- ```values.length === actions.length```
- All test cases are valid, e.g. you don't need to handle scenarios when unsubscribing from a non-existing subscription.
- There are only 4 different actions: ```EventEmitter```, ```emit```, ```subscribe```, and ```unsubscribe```.
- The ```EventEmitter``` action doesn't take any arguments.
- The ```emit``` action takes between either 1 or 2 arguments. The first argument is the name of the event we want to emit, and the 2nd argument is passed to the callback functions.
- The ```subscribe``` action takes 2 arguments, where the first one is the event name and the second is the callback function.
- The ```unsubscribe``` action takes one argument, which is the 0-indexed order of the subscription made before.

---

### Use Cases:

- __User Interface (UI) Interactions__: In web development, an ```EventEmitter``` can be used to handle user interactions such as button clicks, form submissions, or menu selections. Components can subscribe to these events and perform appropriate actions or updates when the events are emitted.

```JavaScript
// Create an EventEmitter instance
const eventEmitter = new EventEmitter();

// Subscribe to a button click event
eventEmitter.subscribe("buttonClick", () => {
console.log("Button clicked!");
});

// Emit the button click event
eventEmitter.emit("buttonClick");
```

- __Asynchronous Operations__: When working with asynchronous operations like fetching data from an API or handling database queries, an ```EventEmitter``` can be used to notify components or modules about the completion or status of these operations. Subscribed callbacks can then handle the returned data or trigger subsequent actions.

```JavaScript
// Create an EventEmitter instance
const eventEmitter = new EventEmitter();

// Simulate an asynchronous operation
function fetchData() {
setTimeout(() => {
    const data = "Some fetched data";
    // Emit the event with the fetched data
    eventEmitter.emit("dataFetched", data);
}, 2000);
}

// Subscribe to the dataFetched event
eventEmitter.subscribe("dataFetched", (data) => {
console.log("Data fetched:", data);
});

// Trigger the asynchronous operation
fetchData();
```

- __Custom Event-driven Systems__: ```EventEmitters``` can be used to build custom event-driven systems for specific application needs. For example, in a game engine, an ```EventEmitter``` can be used to manage events like player movement, collision detection, or game state changes. Components, such as game objects or UI elements, can subscribe to these events and respond accordingly.

```JavaScript
// Create an EventEmitter instance
const eventEmitter = new EventEmitter();

// Game state change event
eventEmitter.subscribe("gameStateChange", (newState) => {
console.log("Game state changed:", newState);
});

// Player movement event
eventEmitter.subscribe("playerMovement", (movement) => {
console.log("Player moved:", movement);
});

// Emit game events
eventEmitter.emit("gameStateChange", "start");
eventEmitter.emit("playerMovement", "left");
```

- __Logging and Error Handling__: An ```EventEmitter``` can be utilized to handle logging and error events. Subscribed callbacks can capture error events, log them to a file or console, and perform error handling tasks such as sending error reports or displaying error messages to the user.

```JavaScript
// Create an EventEmitter instance
const eventEmitter = new EventEmitter();

// Error event
eventEmitter.subscribe("error", (errorMessage) => {
console.error("Error occurred:", errorMessage);
});

// Log event
eventEmitter.subscribe("log", (message) => {
console.log("Log message:", message);
});

// Emit logging and error events
eventEmitter.emit("error", "Something went wrong!");
eventEmitter.emit("log", "Info: Application started.");
```

- __Event-driven Architectures__: ```EventEmitters``` are a fundamental building block in event-driven architectures. They enable loose coupling and decoupling of components by allowing them to communicate through events. This promotes modularity and scalability in large-scale applications.

### Approach 1: Using Array

```JavaScript
class EventEmitter {
    constructor() {
        this.events = {};
    }

    subscribe(event, cb) {
      this.events[event] = this.events[event] ?? [];
      this.events[event].push(cb);

      return {
        unsubscribe: () => {
          this.events[event] = this.events[event].filter(f => f !== cb);
          //To avoid memory leaks adding a cleanup condition
          if (this.events[event].length === 0) { delete this.events[event] }
        },
      };
    }

    emit(event, args = []) {
        if (!(event in this.events)) return [];
        return this.events[event].map(f => f(...args));
    }
}

/**
 * const emitter = new EventEmitter();
 *
 * // Subscribe to the onClick event with onClickCallback
 * function onClickCallback() { return 99 }
 * const sub = emitter.subscribe('onClick', onClickCallback);
 *
 * emitter.emit('onClick'); // [99]
 * sub.unsubscribe(); // undefined
 * emitter.emit('onClick'); // []
 */
```

### Apprach 2: Using Set

```JavaScript
class EventEmitter {
  constructor() {
    this.events = {};
  }

  subscribe(event, cb) {
    if (!(event in this.events)) {
      this.events[event] = new Set([cb]);
    } else {
      this.events[event].add(cb);
    }

    return {
      unsubscribe: () => {
        this.events[event].delete(cb);
      },
    };
  }

  emit(event, args = []) {
    if (!(event in this.events)) return [];
    const result = [];
    this.events[event].forEach((fn) => {
      result.push(fn(...args));
    });
    return result;
  }
}

/**
 * const emitter = new EventEmitter();
 *
 * // Subscribe to the onClick event with onClickCallback
 * function onClickCallback() { return 99 }
 * const sub = emitter.subscribe('onClick', onClickCallback);
 *
 * emitter.emit('onClick'); // [99]
 * sub.unsubscribe(); // undefined
 * emitter.emit('onClick'); // []
 */
```
