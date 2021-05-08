Amit Kadosh 205954316

"I pledge the highest level of ethical principles in support of academic excellence.
 I ensure that all of my work reflects my own abilities and not those of someone else."

Saying we want to add a cool feature - button "x" to run multiplication.
What code do we need to change/add/remove to support this feature?
Which tests can we run on the calculator? On the activity? On the app?

first of all we will need to add a textView for the "x" button in the xml file.
after that we will need to add function that insert "x" in the calculator.
Moreover we will need to add the options to add "(" ")" for determinate order of actions.
in the insertEqual function we will need to change the calculate  of output by order default first what in "()" afte "x"
and only than "+, -".

the test we should run on calculator:
"1+2x3="
insertDigit(1);
insertPlus();
insertDigit(2);
insertMul();
insertDigit(3);
insertEqual;

and the expected output should be "7"

on the activity:
if we click button x if we accept the string "button MUL clicked"

on the app:
the same as on the calculator just insted calling the functions of the calculator
we will preform clicks on the relevant buttons