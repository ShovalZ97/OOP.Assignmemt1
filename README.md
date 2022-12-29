# OOP Exercise 1 

### --Shoval Zohar and Rotem Kochavi--
### --318284668 207386954--

## Description
In this project we build UndoableStringBuilder class that extends the features of the StringBuilder class that
have the undo function that show us what was before the changes that was made to the object.
In addition,we realized 2 classes,one of them is GroupAdmin that implements the Sender interface which describes the update sender(observerable) and the second class is ConcreteMember that implements the Member interface which describes the recipient of the update(observer).

## Class GroupAdmin
GroupAdmin will be the main database of the members who update the UndoableStringBuilder.
In GroupAdmin we have register that add member to the list of members and for every change made in the UndoableStringBuilder object.
In addition,when we make change we will notify this to all the members.
The GroupAdmin has the functions of UndoableStringBuilder object: insert, append, delete and undo.

## Class ConcreteMember
ConcreteMember will present each member who wants to get updates about the UndoableStringBuilder.
the GroupAdmin object sends an update to the ConcreteMember class.

## Test classes
Test all the functions of the classes.

### Tests
In this class, we test how our objects conducted with the main memory and what happend to the memory when we make changes(we used the JvmUtilities class).

### UndoableStringBuilderTest
In this class, we test all the UndoableStringBuilder functions.

### ConcreteMemberTest
In this class, we test the functions of the update method of the ConcreteMember class.

### GroupAdminTest
In this class, we tests the functions of the GroupAdmin class.
