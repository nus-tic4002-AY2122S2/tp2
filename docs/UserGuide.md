---
layout: page
title: User Guide
---

GreatBook is a **desktop app for teachers to manage grades of students, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI).


### Table of Contents
* Quick Start
* Features
  * Viewing Help
  * Adding a student
  * Listing all students
  * Editing student information
  * Locating a student by name
  * Deleting a student
  * Clearing all students from address book
  * Exiting Program
  * Saving Data
  * Editing Data File
  * Sort students by subject marks (Coming in v1.4)
  * Highlight failing students (Coming in v1.4)
  * Sort students by Classroom (Coming in v1.4)


--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `greatbook.jar` from [here](https://github.com/se-edu/addressbook-level3/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your GreatBook.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all students.

   * **`add`**`n/James Ho p/22224444 en/90 mt/90 m/90 s/90 : Adds a contact named `John Doe` to the Address Book.

   * **`delete`**`3` : Deletes the 3rd contact shown in the current list.

   * **`clear`** : Deletes all contacts.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [p/PHONE_NUMBER]` can be used as ` n/John Doe p/23333333` or as `n/John Doe`.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

### Viewing help : `help`

Shows a message explaning how to access the help page.

Format: `help`


### Adding a person: `add`

Adds a person to the GreatBook.

Format: `add n/NAME p/PHONE_NUMBER e/CLASS en/SCORE mt/SCORE m/SCORE s/SCORE​`

There are only 4 subjects in the primary school syllabus. En refers to English, MT to Mother Tongue, M to Maths, S to science

Examples:
* `add n/James Ho p/22224444 en/90 mt/90 m/90 s/90`
* `add n/Betsy Crowe p/55556666 en/70 mt/80 m/78 s/97`


### Listing all persons : `list`

Shows a list of all persons in the GreatBook.

Format: `list`


### Editing a person : `edit`

Edits an existing person in the GreatBook.

Format: `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/CLASS] [en/ENGLISH] [mt/MOTHER TONGUE] [m/MATH] [s/SCIENCE]`

* Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.

Examples:
*  `edit 2 n/James Lee en/80` Edits the 2nd student in GreatBook, updates student name to James Lee and English grade to `80`.


### Locating persons by name: `find`

Finds student whose names contain any of the given keywords.

Format: `find NAME`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `find John` returns `john` and `John Doe`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>


### Deleting a person : `delete`

Deletes the specified person from the GreatBook.

Format: `delete INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd person in the GreatBook.
* `find Betsy` followed by `delete 1` deletes the 1st person in the results of the `find` command.

### Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

GreatBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

GreatBook data are saved as a JSON file `[JAR file location]/data/GreatBook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME p/PHONE_NUMBER e/CLASS en/SCORE mt/SCORE m/SCORE s/SCORE ` <br> e.g., `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague` <br>En refers to English, MT to Mother Tongue, M to Maths, S to science
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/CLASS] [en/ENGLISH] [mt/MOTHER TONGUE] [m/MATH] [s/SCIENCE]​`<br> e.g.,`edit 2 n/James Lee en/80`
**Find** | `find NAME`<br> e.g., `find James Jake`
**List** | `list`
**Help** | `help`
