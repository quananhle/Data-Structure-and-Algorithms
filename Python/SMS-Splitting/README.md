## SMS Message Splitting (Twilio OA 2020)

**Difficulty**: Red

Input is a string of characters that represents a text message. You need to segment this message into chunks of messages each of length 160 characters and add suffix "(1/5)" (representing pagination) at the end of each segmented message (Length of "(1/5)" is included in 160 length limit).

__Input__: 
    
    "njdksjfn jdfnds kjfdklsjf jsdofjsd f jdslkjfgdslkngdslkjg fljksdjflsfdsjfdslkfjdslkfmdsklmfgn ljsdglkdsfg d lkjgdslkgjdsljgdslkjgdsfjngds lkjsdlkgjdsgkldsjgsdlkg lkjdslkgjdslkgjdslgmnds glkjgdslkjgdslkjfgodsjfds g,mdsgkjdsngdlsknfgldsjfglkdsjfglkdsjglkdsjglkdsgjdsklgjdslk lkgjdslkgfjdslkgjdslkgjdsljfgdslkgjmdslkg kljghjdslkjgdslkjfg"

__Output__: 
       
    ['njdksjfn jdfnds kjfdklsjf jsdofjsd f jdslkjfgdslkngdslkjg fljksdjflsfdsjfdslkfjdslkfmdsklmfgn ljsdglkdsfg d lkjgdslkgjdsljgdslkjgdsfjngds (1/3)', 'lkjsdlkgjdsgkldsjgsdlkg lkjdslkgjdslkgjdslgmnds glkjgdslkjgdslkjfgodsjfds g,mdsgkjdsngdlsknfgldsjfglkdsjfglkdsjglkdsjglkdsgjdsklgjdslk (2/3)', 'lkgjdslkgfjdslkgjdslkgjdsljfgdslkgjmdslkg kljghjdslkjgdslkjfg(3/3)']

Bonus Points: Pass the large test cases of question 3 without using split() function.
