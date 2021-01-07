## [Java Stack](https://www.hackerrank.com/challenges/java-stack/problem)



__Code:__ Orange

#### Using stack 

```{Java}
class Solution{
	public static void main(String []argh){
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
            // //Complete the code
            String input=sc.next();
            Deque<Character> stringStack = new ArrayDeque<>();
            for (int i = 0; i < input.length(); i++) {
                if (!stringStack.isEmpty()) {
                    switch(input.charAt(i)) {
                        case '}' : 
                            if (stringStack.peek() == '{') {
                                stringStack.pop();
                            } 
                            break;
                        case ']' : 
                            if (stringStack.peek() == '[') {
                                stringStack.pop();
                            } 
                            break;
                        case ')' : 
                            if (stringStack.peek() == '(') {
                                stringStack.pop();
                            } 
                            break;
                        default: 
                            stringStack.push(input.charAt(i));
                    }
                } 
                else {
                    stringStack.push(input.charAt(i));
                } 
            }
            System.out.println(stringStack.isEmpty());
		}
	}
}
```

#### Using Regex

```{Java}
class Solution{
	public static void main(String []argh){
		Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
        String input=sc.next();
        //Complete the code
        String str = "\\(\\)|\\[\\]|\\{\\}";
        Pattern p = Pattern.compile(str);
        while(p.matcher(input).find()){
            input = input.replaceAll(str, "");
        }
        System.out.println(input.isEmpty());
    }
  }
}
```
