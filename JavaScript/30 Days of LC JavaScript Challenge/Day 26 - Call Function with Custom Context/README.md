## [2693. Call Function with Custom Context](https://leetcode.com/problems/call-function-with-custom-context)

```Tag```: ```This```

#### Difficulty: Medium

Enhance all functions to have the ```callPolyfill``` method. The method accepts an object ```obj``` as it's first parameter and any number of additional arguments. The ```obj``` becomes the ```this``` context for the function. The additional arguments are passed to the function (that the ```callPolyfill``` method belongs on).

For example if you had the function:

```JavaScript
function tax(price, taxRate) {
  const totalCost = price * (1 + taxRate);
  console.log(`The cost of ${this.item} is ${totalCost}`);
}
```

Calling this function like ```tax(10, 0.1)``` will log ```"The cost of undefined is 11"```. This is because the ```this``` context was not defined.

However, calling the function like ```tax.callPolyfill({item: "salad"}, 10, 0.1)``` will log ```"The cost of salad is 11"```. The ```this``` context was appropriately set, and the function logged an appropriate output.

Please solve this without using the built-in ```Function.call``` method.

---

__Example 1:__
```
Input:
fn = function add(b) {
  return this.a + b;
}
args = [{"a": 5}, 7]
Output: 12
Explanation:
fn.callPolyfill({"a": 5}, 7); // 12
callPolyfill sets the "this" context to {"a": 5}. 7 is passed as an argument.
```

__Example 2:__
```
Input: 
fn = function tax(price, taxRate) { 
 return `The cost of the ${this.item} is ${price * taxRate}`; 
}
args = [{"item": "burger"}, 10, 1,1]
Output: "The cost of the burger is 11"
Explanation: callPolyfill sets the "this" context to {"item": "burger"}. 10 and 1.1 are passed as additional arguments.
```

__Constraints:__

- ```typeof args[0] == 'object' and args[0] != null```
- ```1 <= args.length <= 100```
- ```2 <= JSON.stringify(args[0]).length <= 10^5```

---

### Use Cases:

#### Function Context Binding:

- Sometimes, you may have a function that relies on a specific context or this value to work correctly. By using the ```callPolyfill``` method, you can explicitly set the this context for the function. This can be handy in scenarios where you need to invoke a function with a specific object as the context.
- Example:
  - In an event handler, you can use ```callPolyfill``` to set the event target as the ```this``` context for the handler function, allowing you to access the target properties conveniently.

```JavaScript
function sayHello() {
  console.log(`Hello, ${this.name}!`);
}

const person = { name: 'LeetCode-Users' };

// Using callPolyfill to bind the function to the person object
sayHello.callPolyfill(person); // Output: "Hello, LeetCode-Users!"
```

__Method Borrowing__:

- In JavaScript, objects can share methods by borrowing them from other objects. The ```callPolyfill``` method can facilitate method borrowing by setting the ```this``` context to the object you want to borrow the method from.
- Example:
  - If you have multiple objects with similar functionality and want to reuse a method from one object in another object, you can use ```callPolyfill``` to invoke the method with the desired object as the context.

```JavaScript
const calculator = {
  calculateTotal: function(a, b) {
      return a + b;
  }
};

const numbers = [3, 4];

// Using callPolyfill to borrow the calculateTotal method from calculator
const sum = calculator.calculateTotal.callPolyfill(calculator, numbers[0], numbers[1]);
console.log(sum); // Output: 7
```

__Custom Function Invocation__:

- The ```callPolyfill``` method allows you to invoke functions with any number of additional arguments. This flexibility can be helpful when you need to pass dynamic or variable arguments to a function.
- Example:
  - Suppose you have a function that greets multiple people based on provided names. You can use ```callPolyfill``` to pass different input values to the function dynamically, depending on the situation.

```JavaScript
function greetMultiplePeople(greeting, ...names) {
names.forEach(name => {
    console.log(`${greeting}, ${name}!`);
});
}

const greeting = 'Welcome';
const people = ['Daniel860305', 'Kunal-j', 'ADS2K'];

// Using callPolyfill to invoke greetMultiplePeople with dynamic arguments
greetMultiplePeople.callPolyfill(null, greeting, ...people);
// Output:
// "Welcome, Daniel860305!"
// "Welcome, Kunal-j!"
// "Welcome, ADS2K!"
```

__Method Chaining__:

- Method chaining is a technique where multiple methods are called in a chain on the same object. The ```callPolyfill``` method can be used to invoke methods in a chain, ensuring that the correct object is used as the this context for each method.
- Example:
  - When working with libraries or frameworks that support method chaining, you can use ```callPolyfill``` to chain methods on specific objects, ensuring that the chain operates on the desired object.

```JavaScript
const user = {
name: 'Cosmic',
greet: function() {
    console.log(`Hello, ${this.name}!`);
    return this; // Returning the object to enable method chaining
},
sayAge: function() {
    console.log(`I am ${this.age} years old.`);
    return this; // Returning the object to enable method chaining
}
};

user.greet.callPolyfill({ name: 'Batman' }).sayAge.callPolyfill({ age: 1000 });
// Output:
// "Hello, Batman!"
// "I am 1000 years old."
```
