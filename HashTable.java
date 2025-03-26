//Colton Owen
//Chpt 6 PA

// Class to represent the key-value pair (Item)
class Item {
    String key;  
    String value;  
    Item next;  

    // Constructor to initialize the key-value pair and set the next pointer to null
    public Item(String key, String value) {
        this.key = key;  
        this.value = value;  
        this.next = null;  
    }
}

// Class to represent a hash table 
class HashTable {
    private Item[] hashTable;  
    private int length;  

    // Constructor to initialize the hash table with a specified size
    public HashTable (int size) {
        this.length = size;  
        this.hashTable = new Item[length];  
    }

    // Hash method to get the index for a given key
    public int hash(String key) {
		int stringHash = 0; 

        for (int i = 0; i < key.length(); i++) {    //Search through length of string
            stringHash = (stringHash * 13) + key.charAt(i); //Mult stringHash by 13 & add value of character
        }
        return stringHash;
    }

    // Method to Insert the specified key-value pair into the hash table, pseudocode found in Figure 6.3.1 with 
    public boolean hashInsert(String key, String value) {
        int bucketIndex = hash(key) % length;  

        Item currentItem = hashTable[bucketIndex];  
        Item previousItem = null;  

        while (currentItem != null) {  
            if (currentItem.key.equals(key)) {  
                currentItem.value = value;  
                return true;  
            }
            previousItem = currentItem;  
            currentItem = currentItem.next;
        }

        Item newItem = new Item(key, value);  
        if (hashTable[bucketIndex] == null) {  
            hashTable[bucketIndex] = newItem;  
        } else {
            previousItem.next = newItem;  
        }
        return true;  
    }

    // Method to search for the specified key and return the corresponding value, pseudocode found in Figure 6.3.1
    public String hashGet(String key) {
        int bucketIndex = hash(key) % length;  
        Item item = hashTable[bucketIndex];  

        while (item != null) {  
            if (item.key.equals(key)) {  
                return item.value;  
            }
            item = item.next;  
        }

        return null;  
    }

    // Method to remove the key-value pair from the hash table, pseudocode found in Figure 6.3.1
    public boolean hashRemove(String key) {
        int bucketIndex = hash(key) % length;  
        Item currentItem = hashTable[bucketIndex];  
        Item previousItem = null;  

        while (currentItem != null) {  
            if (currentItem.key.equals(key)) {  
                if (previousItem == null) {  
                    hashTable[bucketIndex] = currentItem.next;  
                } else {  
                    previousItem.next = currentItem.next;  
                }
                return true;  
            }
            previousItem = currentItem;  
            currentItem = currentItem.next;
        }

        return false;  
    }

    // Method to print the entire hash table, showing each bucket and its key-value pairs
    public void printTable() {
        for (int i = 0; i < length; i++) {  
            System.out.print("Bucket " + i + ": ");  
            Item currentItem = hashTable[i];  
            if (currentItem == null) {  
                System.out.println("empty");  
            } else {
                while (currentItem != null) {  
                    System.out.print("[ Hash is: " + hash(currentItem.key) + ", key is: " + currentItem.key + ", value is : " + currentItem.value + "] ");  //Calls hash function to find hash value
                    currentItem = currentItem.next;  
                }
                System.out.println();  
            }
        }
    }

    // Main method for testing the HashTable class
	// Implement the main method per the assignment instructions
    public static void main(String[] args) {
        HashTable table = new HashTable(5);  // Create a hash table with 5 buckets
		table.hashInsert("keyA1", "value1");    //Adds keyA1 w/ value of value1 to table
        table.hashInsert("keyB2", "value2");    //Adds keyB2 w/ value of value2 to table
        table.hashInsert("keyC3", "value3");    //Adds keyC3 w/ value of value3 to table
        table.hashInsert("keyD23", "value23");  //Adds keyD23 w/ value of value23 to table
        table.hashInsert("keyE45", "value45");  //Adds keyE45 w/ value of value45 to table
        table.hashInsert("keyF52", "value52");  //Adds keyF52 w/ value of value52 to table
        System.out.println("Hash Table:");
        table.printTable(); //Prints current table
        
        if (table.hashRemove("keyF52") == true) {   //Removes keyF52, prints success or failure
            System.out.println("\nkeyF52 was removed");
        } else {
            System.out.println("\nkeyF52 was not removed");
        }
        
        if (table.hashGet("keyZ6") != null) {   //Gets keyZ6, prints success or failure
            System.out.println("\nkeyZ6's value is: " + table.hashGet("keyZ6"));
        } else {
            System.out.println("\nkeyZ6 was not found");
        }
        
        if (table.hashGet("keyC3") != null) {   //Gets keyC3, prints success or failure
            System.out.println("\nkeyC3's value is: " + table.hashGet("keyC3"));
        } else {
            System.out.println("\nkeyC3 was not found");
        }
        
        System.out.println("\nUpdated Hash Table:");
        table.hashInsert("keyG18", "value18");  //Adds keyG18 w/ value of value18 to table
        table.hashInsert("keyH7", "value7");    //Adds keyH7 w/ value of value7 to table
        table.hashInsert("keyI33", "value33");  //Adds keyI33 w/ value of value33 to table
        table.hashInsert("keyD23", "newvalue23");  //Updates key23's value to newvalue23
        table.printTable(); //Prints current table
    }
}
