---
layout: page
title: User Guide
---

Project BUDDY is a Teacher’s Contact Management Application supported by CLI text input commands. Teachers can enter contact information for a swift search and retrieve desired contact information within a few keystrokes. The application provides an all-in-one display of the contacts related information and their details are presented in a beautiful scrolling view.

* Table of Contents
  {:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `projectbuddy.jar` from [here](https://github.com/AY2122S2-TIC4002-F18-3/tp2/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your Project BUDDY.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

    * **`list`** : Lists all contacts.

    * **`add`**`n/John Doe b/2020-01-01 p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a contact named `John Doe` to the Address Book.

    * **`delete`**`3` : Deletes the 3rd contact shown in the current list.

    * **`clear`** : Deletes all contacts.

    * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Command corresponding to Feature

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Record people’s name, birthday, phone number, email and address:
  Format:      add n/NAME b/BIRTHDAY p/PHONE_NUMBER e/EMAIL a/ADDRESS
  Example:     add n/Duke b/2020-01-01 p/98001234 e/duke@gmail.com a/Duke street, block 1, #05-01

</div>

### Viewing help : `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`


### Adding a contact: `add`

Create a new contact with info such as name, hp, email, address and optional number of tags.

Format: `add n/NAME b/BIRTHDAY p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>

Examples:
```
add n/Nana Park b/2000-01-01 p/9666 4222 e/nana@example.com a/620 Bedok Rd, 470620 t/student t/G5-C02
```

### Editing a contact: `edit`

Edit an existing contact with info such as name, hp, email, address and optional number of tags.

Format: `edit SEQ_NO_OF_CONTACT n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>

Examples:
```
edit 1 n/John p/9001 4232 e/john@example.com a/621 Bedok Rd, 470623 t/colleague t/Math-department
```

### Batch editing contacts: `edit -batch`

Edit existing contacts with info such as hp, email, address and optional number of tags.

Format: `edit -batch SEQ_NO_OF_CONTACT,SEQ_NO_OF_CONTACT p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​`

+ SEQ_NO_OF_CONTACT must be a positive integer.
+ Cannot batch edit the name fields of the contacts.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A person can have any number of tags (including 0)
</div>

Examples:
```
edit 1,2,3 p/9001 4232 t/Engineering-department
```

### Delete a contact: `delete`

Format:      `delete SEQ_NO_OF_CONTACT`

+ SEQ_NO_OF_CONTACT refers to the numbering of the contact in the list.
+ SEQ_NO_OF_CONTACT must be a positive integer.

Example:
```
delete 2
```

### View a list of contacts: `list`

Format:      `list`
+ All contacts’ name, phone number, email and address will be displayed.

Example:
```
list
```
### Search contact by name: `filter`

Format:      `filter TAG`

+ TAG is case-insensitive. I.e. `filter teacher` will return `teacher`’s contact.
+ TAG has to be a full word. I.e. `find teach` will not return `teacher`’s contact.
+ If TAG consists of two or more words, the sequence of words will not affect the search result.
+ Contacts matching either one of the TAG will be returned. I.e. `filter teacher student` will return both `teacher` and `student`’s contacts.

Example:
```
filter student
```

### Search contact by name: `find`

Format:      `find NAME`

+ NAME is case-insensitive. I.e. `find DUKE` will return `Duke`’s contact.
+ NAME has to be a full word. I.e. `find DUK` will not return `Duke`’s contact.
+ If NAME consists of two words, the sequence of words will not affect the search result. I.e. `find Duke John` will return both `John Duke`’s and `Duke John`’s contacts.
+ Contacts matching either one of the NAME will be returned. I.e. `find Duke John` will return both `Duke Mark` and `Charles Duke`’s contacts.

Example:
```
find Duke
```


### Undo the previous command: `undo`

Format:      `undo`
+ The previous contact list will be recovered.

Example:
```
undo
```

### Copy a contacts: `copy`

Format:      `copy SEQ_NO_OF_CONTACT`
+ SEQ_NO_OF_CONTACT refers to the numbering of the contact in the list.
+ SEQ_NO_OF_CONTACT must be a positive integer.
+ A string of text of the contact details will be copied to clipboard.
+ User can paste (CMD/CTL v) the details to a text field.

Example:
```
copy 1
```

### Search contact by tag: `filter`

Format:      `filter TAG`

+ TAG is case-insensitive. I.e. `filter G501` will return `g501`’s contact.
+ TAG has to be a full word. I.e. `filter G50` will not return `g501`’s contact.
+ Contacts matching either one of the TAG returning a combined result set, the sequence of words will not affect the search result. I.e. `filter g501 g502` will return both `g501`’s and `g502`’s contacts.

Example:
```
filter g501
```

### Search contact by name: `rename`

Format:      `rename TAG t/TAG`

+ To rename all contacts with same TAG.
+ TAG has to be a full word matching existing tag in the records.
+ TAG is the existing tag that needs to be renamed.
+ t/TAG is the tag to be renamed into.
+ For TAG to be renamed into multiple TAG, you may do do by adding more parameter. I.e. `rename g501 t/graduated t/NUS` will remove all contact with existing 'g501' tag and add on new tag 'graduated' and 'NUS'.

Example:
```
rename g501 t/graduated t/NUS
```

### Remove tag from all contact: `rename TAG t/`

Format:      `rename TAG t/`

+ TAG is case-sensitive. I.e. `rename student t/` will remove `student` tag from all contact.
+ TAG has to be a full word. I.e. `find G50` will not remove tag `g501`.

Example:
```
rename student t/
```

### Search contact by birthday month: `bday MONTH`

Format:      `bday MONTH`

+ MONTH has to be within 1 to 12. I.e. `bday 1` will return contact with birthday month of January.
+ Contacts matching either one of the month returning a combined result set, the sequence of words will not affect the search result. I.e. `bday 1 2` will return all contact with birthday month in either January or February.

Example:
```
bday 1
```



### Create relation among persons: `relate`
#### Relate multiple persons to someone

Format: `relate TO_SEQ_NO_OF_CONTACT <- FROM_SEQ_NO_OF_CONTACT1 FROM_SEQ_NO_OF_CONTACT2 ...`
+ The `relate` command has a 1 to n relationship 
+ TO_SEQ_NO_OF_CONTACT on the left hand side of `<-` is the target whom persons going to relate to
+ FROM_SEQ_NO_OF_CONTACTi on the right hand side of `<-` is the group to relate to the target one by one 
+ Relation is _mutual_. So A related to B, B also related to A automatically

Example:
```
relate 2 <- 1 4 5
```
+ **Recommended usage**: you could first `filter` by tag like a class no. `g503`, then use `relate` to relate from all the students to a teacher in that class one at a time.
#### Show everyone related to a particular person
Format: `relate SEQ_NO_OF_CONTACT`
+ When there is no `<-` action symbol used, `relate` acts like a listing command that displays the person and whose every related persons

Example:
```
relate 2
```



### Exit the program:
Format:      `exit`
+ The contact list will not be deleted after exiting.

Example:
```
exit
```



--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action     | Format, Examples                                                                                                                                                          |
|------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**    | `add n/NAME b/BIRTHDAY p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g. <br> `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague` |
| **Edit**    | `edit INDEX n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g. <br> `edit 1 p/91234567 e/johndoe@example.com a/111, Clementi Rd, 1234665 t/student` |
| **Batch edit**    | `edit -batch INDEX,INDEX n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g. <br> `edit -batch 1,2,3 p/92234567 e/johndoe@gmail.com ` |
| **Bday** | `bday MONTH` <br> e.g. <br> `bday 12`
| **Delete** | `delete INDEX` <br> e.g. <br> `delete 2`                                                                                                                                  |
| **List**   | `list`    
| **Filter**   | `filter TAG` <br> e.g. <br> `filter student`                                                                                                                             
| **Find**   | `find NAME` <br> e.g. <br> `find steve`                                                                                                                                   
| **Rename**   | `rename TAG t/TAG` <br> e.g. <br> `rename student t/graduated t/NUS`                                                                                                      
| **Remove tag**   | `rename TAG t/` <br> e.g. <br> `rename student t/`
| **Undo**   | `undo`                                                                                                                                                                    |
| **Copy** | `Copy INDEX` <br> e.g. <br> `copy 1`                                                                                                                                      |
| **Relate** | `relate INDEX_TO <- INDEX1 INDEX2 INDEX3 ...` <br> e.g. <br> `relate 2 <- 1 4 5` <br><br> `relate INDEX` <br> e.g. <br> `relate 2`                                        |
| **Exit**   | `exit`                                                                                                                                                                    |
