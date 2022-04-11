---
layout: page title: User Guide
---

**MyContentPlanner** is a desktop app for social media managers to manage the posts and clients, optimized for use via
a **Command Line Interface (CLI)** while still having the benefits of a **Graphical User Interface (GUI)**. If you can
type fast, MyContentPlanner can get your social media management tasks done faster than traditional GUI apps.

* Table of Contents {:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `mycontentplanner.jar` from [here](https://github.com/AY2122S2-TIC4002-F18-6/tp2/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your Content Planner.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app
   contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will
   open the help window.<br>
   Some example commands you can try:

    * **`list`** : Lists all clients and posts.

    * **`add`** **`client`** `n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a
      client named `John Doe` to the **Client List**.

    * **`delete`** **`post`**`3 5` : Deletes the 3rd and 5th post shown in the **Post List**.

    * **`clear`** **`client`**: Deletes all clients in the **Client List**.

    * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command but you specified it multiple times, only the last occurrence of
  the parameter will be taken.<br>
  e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be
  ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

### `add` - Add a client or a post

Add a client into the **Client List** or add a post into the **Post List**

Syntax: `add client|c n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` or `add post|p t/TITLE c/CONTENT p/POSTDATE ca/CATEGORY n/NOTES`

* `POSTDATE` format is `yyyyMMdd HHmm` e.g. `20220314 1800`

Examples: 
* `add client n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01`
* `add c n/Betsy Crowe t/friend e/betsycrowe@example.com a/Newgate Prison p/1234567 t/criminal`
* `add post t/a dummy title one c/a dummy example content one p/20220314 1800 ca/promotion n/remember sent by 14/03`
* `add p t/a dummy title two c/a dummy example content two p/20220805 0900 ca/notice n/remember sent to all VIP1`

Expected outcome:

```
![Ui](images/AddPost.png)
```

### `delete` - Delete a client or a post (for mass delete haven't implement)

Delete a client from the **Client List** or delete a post from the **Post List** based on the specified INDEX in each
list.

* Deletes the client or the post at the specified `INDEX`.
* The index refers to the index number shown in the displayed **Client List** or **Post List**.
* The index **must be a positive integer** 1, 2, 3, …​
* The index can be a single index or multiple index(index list)

Syntax: `delete client|c INDEX1 INDEX2 ...` or `delete post|p INDEX1 INDEX2 ...`

Examples: 
* `delete post 3 5`
* `delete c 1 3`


### `list` - List the clients and posts

List all the clients in the **Client List** and all the posts in the **Post List**.

Syntax: `list`


### `send` - Send the post(s) to client(s)

Send the selected post(s) in the **Post List** to the selected client(s) in the **Client List** by the index.

* Application will check if a post already sent to a client.
* If a post already send to all the clients that user selected, the application will do nothing but have a warning
* If some clients already received the post, it will send to the rest clients.
* The index refers to the index number shown in the displayed **Client List** or **Post List**.
* The index **must be a positive integer** 1, 2, 3, …​
* The index can be a single index or multiple index(index list)

Syntax: `send c/INDEX1 INDEX2...  p/INDEX1 INDEX2...`

Examples: 
* `send c/1 3 4 5 p/1 4` means send the post index 1 and 4 to the client index 1, 3, 4 and 5
* `send c/1 p/1 2 3` means send the post index 1, 2 and 3 to the client index 1


### `sort` - Sort the post by post date

Sort all the posts in **Post List** by the post date (either ascending order or descending order)

* the first argument after command word is a keyword, currently only implement for `postdate`

Syntax: `sort postdate asc|desc`

Examples:
* `sort postdate asc` for ascending order
* `sort postdate desc`for descending order


### `help` - Viewing help

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Syntax: `help`

### `clear` - Clearing all entries

Clears all entries from the Content Planner.

Syntax: `clear`

### `exit` - Exiting the program

Exits the program.

Syntax: `exit`



### `edit` - Edit a client or a post (haven't implemented)

Edit an existing client in the **Client List** or an existing post in the **Post List** based on the specified INDEX in
each list.

* Edits the client or the post at the specified `INDEX`.
* The index refers to the index number shown in the displayed **Client List** or **Post List**.
* The index **must be a positive integer** 1, 2, 3, …​
* The index must be a single index.

* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the client will be removed i.e adding of tags is not cumulative.
* You can remove all the client's tags by typing `t/` without specifying any tags after it.

Syntax: `edit client|c INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​` or
`delete post|p INDEX [t/TITLE] [c/CONTENT]...`

Example: `edit c 3 a/a new address`

Expected outcome:

```

```







### Locating persons by name: `find`

Finds persons whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. `OR` search). e.g. `Hans Bo` will return `Hans Gruber`
  , `Bo Yang`

Examples:

* `find John` returns `john` and `John Doe`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)



### Saving the data

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to
save manually.

### Editing the data file

AddressBook data are saved as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to
update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains
the data of your previous MyContentPlanner home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary - pending update

Action | Format, Examples
--------|------------------
**Add** | `add client n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add client n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`
**Clear** | `clear`
**Delete** | `delete client INDEX INDEX` or `delete post INDEX INDEX` <br> e.g., `delete client 3`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Find** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**List** | `list`
**Help** | `help`
**send** | `send c/INDEX1 INDEX2…​ p/INDEX1 INDEX2…​` <br> e.g. `send c/1 2 4 5 p/ 1 4`
**sort** | `sort postdate asc` or `sort postdate desc`
