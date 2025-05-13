
//1)What is the time complexity of adding an element at the end of the list? Why?

//Time Complexity: O(1)
//Adding to the end is fast because the list always remembers the last node.
// It just connects the new item to the end without looking through the list.
// That’s why it takes the same short time no matter how big the list is.


//2)What time complexity of adding element at the i position of the list with method add(int i, T e)? Why?
//Time Complexity: O(n)

// I think, to add at a certain spot like index 5, the list has to walk through each item from the beginning to get there.
// This takes more time if the index is further. After it finds the spot, adding is quick — but finding it is what makes it slower.

//3)Suppose we use for traversing this snippet of code:
//for(int i=0; i<list.getSize(); i++ ){
//  System.out.println(list.get(i));
//What time complexity of such traversing? Why?
//This loop is slow because every time it runs get(i), it has to count from the start of the list to find the item.
// So the first time is quick, but each time after takes longer and longer.
//Together, it ends up taking a lot of time as the list gets bigger.
//It's better to use a for-each loop, which goes through the list just once, much faster.