/*
 * Pei-Cheng (Peggy) Chen
 * pc2857
 * Talk class & Scheduler class explanation
*/


Talk.java --->
*handle unchecked exceptions in the instructor in the following order: 
1)remove all whitespaces to eliminate the potential errors caused by multiple whitespaces between two items
2)Check if each talk is formatted in such way: name + start time + end time. If not, print out statement 
"Please change to -> name+start time+end time" and terminate the program
3)If start/end time are not entered in the correct 24 hour format. For example, "00900" instead of "0900".
Print out statement "Talk info is formatted in a wrong way" and terminate the program.
4)Check if any negative value is included by using if statement to find any negative ssign "-". If there is, print out
"Negative value is found. Please fix it." and terminate the program
5)Use try-catch block to handle NumberFormatException --> check if the string can be parsed into integer
6)If either start or end time exceeds 2400, which means it's over 24 hour time frame. Print out 
"schedule time entered is not within 24 hours" and terminute the program
7)If start/end time are placed in a reversed order. Ex. end time is earlier than start time. Print out
"improper input: start time>end time" and terminate the program.

*compareTo method --> for comparable interface
- use end time as the basis of comparasion. If two talks have the same end time, the one with earler start time goes first
*toString --> for converting a Talk object to printable description





Scheduler.java --->
*makeTalks 
- Instantiate a ArrayList<Talk> for the schedule, a Scanner object, a File object
- Scan the file with the Scanner object in
- use in.hasNextLine() to check if there's anything to read in the file --> resolve unchecked exceptions
- Pass the line read to Talk class to instantiate a Talk object and add it to the ArrayList schedule
- Use try-catch block to handle FileNotFoundExceptions --> check if the file enters actually exists. If 
there is, terminate the program 

*scheduleTalks
- Instantiate another ArrayList<Talk> for the final schedule
- Sort the existing schedule first
- Check if the end time of the last talk added to the final schedule is later than the start time of the 
comparing talk. If they do overlap, don't add the comparing talk to the final schedule. If they do not, add
the comparing talk to the final schedule. 