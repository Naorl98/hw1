# hw1 - 318664190_209133826

the arthurs:
-Naor Ladani - 318664190
-Itamar Cohen - 209133826

## Description

### Interfaces:
Member - The observer inteface, has a "Update" method that save all the changes about the string in the admin Observerable.
Sender - The Observerable interface, save list of all the members that listen to him, do changes to the string and send the update to the members that in the list, has a register and unregister method that add or remove members to the list.

### Classes:
GroupAdmin - implements "Sender" interface, save UndoableStringBuilder object and list of ConcreteMember:
```
$ usb - UndoableStringBuilder variable
$ append - Method that call to append method in UndoableStringBuilder class and call to update method of ConcrteMember for all the members in Members list.
$ undo - Method that call to undo method in UndoableStringBuilder class with usb and call to update method of ConcrteMember for all the members in Members list.
$ insert - Method that call to insert method in UndoableStringBuilder class with usb and call to update method of ConcrteMember for all the members in Members list.
$ delete - Method that call to delete method in UndoableStringBuilder clas with usb s and call to update method of ConcrteMember for all the members in Members list.
$ register - Method that add a new member to the Members list.
$ unregister - Method that remove member to the Members list and set his usb to new UndoableStringBuilder variable.
```
ConcreteMember - Implements "Mmeber", save UndoableStringBuilder object, and listen and wait for update:
```
$ usb - UndoableStringBuilder variable
$ Update - Method that save in usb the null.
```
UndoableStringBuilder - A StringBuilder method with a undo option.

Tests - Do tests on the classes and check if the observer work and give memory data of the members variable.

## The observer temple

 (images.githubusercontent.com/118805710/210023920-ff0a5f49-2100-4978-a51b-298b174f0890.png)

#### how it work:
The observer - ConcrateMember listen to GroupAdmin.
The Observerable - GroupAdmin has ConcrateMember type list, and send update to all the members in list when he does changes in the variable usb.
When member need to join and fet update of usb, he use the register method of GroudAdmin and enter to the "Members" list,
and when he need to get out he use the unregister method of GroudAdmin and leave to the "Members" list
ConcrateMember wait to the update from GroupAdmin and change his usb variable to the UndoableStringBuilder variable that he get from the GroupAdmin.
The code use shallow copy on usb variable.

## Tests

In The tests we can see that all the method work perfect with out erors.
About the memory settings:
We can see that because the shallow copy, all the members use the same place in the memory and dont catches a lot of space in the memory.

Same to the "Members" list, we can see that all the members in the list togther catches space like one variable plus the size of the variables count.

