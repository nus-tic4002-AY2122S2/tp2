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

2. Download the latest `greatbook.jar` from [here](https://github.com/AY2122S2-TIC4002-F18-2/tp2/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your GreatBook.

4. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all students.

   * **`add`**`n/John Doe p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25 c/1A en/90 mt/95 ma/100 sc/85`: Add a student to GreatBook.

   * **`edit`**`2 n/James Lee en/80`: Edits the 2nd student's name and English mark.

   * **`delete`**`3`: Deletes the 3rd contact shown in the current list.

   * **`find`**`John`: Finds the person.

   * **`top`**`english`: Shows the top student of English.

   * **`last`**`science`: Shows the last student of Science.

   * **`clear`** : Deletes all contacts.

   * **`exit`** : Exits the app.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g. `n/NAME [p/PHONE_NUMBER]` can be used as ` n/John Doe p/23333333` or as `n/John Doe`.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command, but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

### Viewing help : `help`

Shows a message explaning how to access the help page.

Format: `help`


### Adding a student: `add`

Adds a student to the GreatBook.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS c/CLASSROOM en/ENGLISH mt/MOTHERTONGUE ma/MATH sc/SCIENCE`

There are only 4 subjects in the primary school syllabus. `en` refers to English, `mt` Mother Tongue, `ma` Maths, `sc` science.

You may enter any string for the classroom field. You may enter either `email` or `sms` for the receive type field.

Examples:
* `add n/John Doe p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25 c/1A en/90 mt/95 ma/100 sc/85`

### Listing all students : `list`

Shows a list of all persons in the GreatBook.

Format: `list`

### Editing a students : `edit`

Edits an existing person in the GreatBook.

Format: `edit INDEX [n/NAME] [p/PHONE_NUMBER] [a/ADDRESS] [e/EMAIL] [c/CLASSROOM] [en/ENGLISH] [mt/MOTHERTONGUE] [ma/MATH] [sc/SCIENCE] [rt/RECEIVE_TYPE] [t/TAGS]`

* Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.

Examples:
*  `edit 2 n/James Lee en/80` Edits the 2nd student in GreatBook, updates student name to James Lee and English grade to `80`.

### Locating students by name: `find`

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

### Locating top students: `top`

Finds student whose names contain any of the given keywords.

Format: `top SUBJECT`

* Find the student who get the highest mark in the subject.
* Only one student will be shown with the highest mark.

Examples:
* `top english` returns `Top english Scorer: Min Tan 99`
* `top science` returns `Top science Scorer: Lee Kuan Yeow 85`<br>

### Locating top students: `last`

Finds student whose names contain any of the given keywords.

Format: `last SUBJECT`

* Find the student who get the lowest mark in the subject.
* Only one student will be shown with the lowest mark.

Examples:
* `last english` returns `lowest english Scorer: Min Tan 20`
* `last science` returns `lowest science Scorer: Lee Kuan Yeow 30`<br>

### Deleting a students : `delete`

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

GreatBook data are saved as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run.
</div>

### Sort students by subject marks`[Coming in v1.5]`

Details in v1.5

### Highlight failing students `[Coming in v1.5]`

Details in v1.5

### Sort students by Classroom `[Coming in v1.5]`

Details in v1.5



--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action     | Format, Examples                                                                                                                                                                                                                                                                                                   |
|------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add**    | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS c/CLASSROOM en/ENGLISH mt/MOTHERTONGUE ma/MATH sc/SCIENCE [t/TAGS] ` <br> e.g., `add n/John Doe p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25 c/1A en/90 mt/95 ma/100 sc/85` <br>en refers to English, mt to Mother Tongue, ma to Maths, sc to science |
| **Clear**  | `clear`                                                                                                                                                                                                                                                                                                            |
| **Delete** | `delete INDEX`<br> e.g., `delete 3`                                                                                                                                                                                                                                                                                |
| **Edit**   | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/CLASS] [en/ENGLISH] [mt/MOTHER TONGUE] [m/MATH] [s/SCIENCE]​`<br> e.g.,`edit 2 n/James Lee en/80`                                                                                                                                                                         |
| **Find**   | `find NAME`<br> e.g., `find John`                                                                                                                                                                                                                                                                                  |
| **Top**    | `top SUBJECT` <br> e.g., `top english`                                                                                                                                                                                                                                                                             |
| **Last**   | `last SUBJECT` <br> e.g., `last science`                                                                                                                                                                                                                                                                           |
| **List**   | `list`                                                                                                                                                                                                                                                                                                             |
| **Help**   | `help`                                                                                                                                                                                                                                                                                                             |
