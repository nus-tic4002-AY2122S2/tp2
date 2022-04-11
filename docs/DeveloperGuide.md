---
layout: page
title: Developer Guide
---
Table of Contents
* *[Acknowledgements](DeveloperGuide.md#acknowledgements)*
* *[Setting up, getting started](DeveloperGuide.md#setting-up-getting-started)*
* *[Design](DeveloperGuide.md#design)*
* *[Implementation](DeveloperGuide.md#implementation-sequence-diagram)*
* *[Documentation, logging, testing](DeveloperGuide.md#documentation-logging-testing)*
* *[Appendix: Requirements](DeveloperGuide.md#appendix-requirements)*
* *[Use Cases](DeveloperGuide.md#use-cases)*

--------------------------------------------------------------------------------------------------------------------

## **Acknowledgements**

* Libraries used: [JavaFX](https://openjfx.io/), [Jackson](https://github.com/FasterXML/jackson), [JUnit5](https://github.com/junit-team/junit5)
* This project is based on the AddressBook-Level3 project created by the [SE-EDU initiative](https://se-education.org).

--------------------------------------------------------------------------------------------------------------------

## **Setting up, getting started**

Refer to the guide [_Setting up and getting started_](SettingUp.md).

*Quick Set-up*
1. Ensure that you have Java 11 or above installed.
2.  **Fork** this [repo](https://github.com/AY2122S2-TIC4002-F18-3/tp2), and **clone** the fork into your local computer.

--------------------------------------------------------------------------------------------------------------------

## **Design**

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:** The `.puml` files used to create diagrams in this document can be found in the [diagrams](https://github.com/se-edu/addressbook-level3/tree/master/docs/diagrams/) folder. Refer to the [_PlantUML Tutorial_ at se-edu/guides](https://se-education.org/guides/tutorials/plantUml.html) to learn how to create and edit diagrams.
</div>

### Architecture

<img src="images/ArchitectureDiagram.png" width="280" />

The ***Architecture Diagram*** given above explains the high-level design of the App.

Given below is a quick overview of main components and how they interact with each other.

**Main components of the architecture**

**`Main`** has two classes called [`Main`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/Main.java) and [`MainApp`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/MainApp.java). It is responsible for,
* At app launch: Initializes the components in the correct sequence, and connects them up with each other.
* At shut down: Shuts down the components and invokes cleanup methods where necessary.

[**`Commons`**](#common-classes) represents a collection of classes used by multiple other components.

The rest of the App consists of four components.

* [**`UI`**](#ui-component): The UI of the App.
* [**`Logic`**](#logic-component): The command executor.
* [**`Model`**](#model-component): Holds the data of the App in memory.
* [**`Storage`**](#storage-component): Reads data from, and writes data to, the hard disk.


**How the architecture components interact with each other**

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues the command `delete 1`.

<img src="images/ArchitectureSequenceDiagram.png" width="574" />

Each of the four main components (also shown in the diagram above),

* defines its *API* in an `interface` with the same name as the Component.
* implements its functionality using a concrete `{Component Name}Manager` class (which follows the corresponding API `interface` mentioned in the previous point.

For example, the `Logic` component defines its API in the `Logic.java` interface and implements its functionality using the `LogicManager.java` class which follows the `Logic` interface. Other components interact with a given component through its interface rather than the concrete class (reason: to prevent outside component's being coupled to the implementation of a component), as illustrated in the (partial) class diagram below.

<img src="images/ComponentManagers.png" width="300" />

The sections below give more details of each component.

### UI component

The **API** of this component is specified in [`Ui.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/Ui.java)

![Structure of the UI Component](images/UiClassDiagram.png)

The UI consists of a `MainWindow` that is made up of parts e.g.`CommandBox`, `ResultDisplay`, `PersonListPanel`, `StatusBarFooter` etc. All these, including the `MainWindow`, inherit from the abstract `UiPart` class which captures the commonalities between classes that represent parts of the visible GUI.

The `UI` component uses the JavaFx UI framework. The layout of these UI parts are defined in matching `.fxml` files that are in the `src/main/resources/view` folder. For example, the layout of the [`MainWindow`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/MainWindow.java) is specified in [`MainWindow.fxml`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/resources/view/MainWindow.fxml)

The `UI` component,

* executes user commands using the `Logic` component.
* listens for changes to `Model` data so that the UI can be updated with the modified data.
* keeps a reference to the `Logic` component, because the `UI` relies on the `Logic` to execute commands.
* depends on some classes in the `Model` component, as it displays `Person` object residing in the `Model`.

### Logic component

**API** : [`Logic.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/logic/Logic.java)

Here's a (partial) class diagram of the `Logic` component:

<img src="images/LogicClassDiagram.png" width="550"/>

How the `Logic` component works:
1. When `Logic` is called upon to execute a command, it uses the `AddressBookParser` class to parse the user command.
1. This results in a `Command` object (more precisely, an object of one of its subclasses e.g., `AddCommand`) which is executed by the `LogicManager`.
1. The command can communicate with the `Model` when it is executed (e.g. to add a person).
1. The result of the command execution is encapsulated as a `CommandResult` object which is returned back from `Logic`.

The Sequence Diagram below illustrates the interactions within the `Logic` component for the `execute("delete 1")` API call.

![Interactions Inside the Logic Component for the `delete 1` Command](images/DeleteSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `DeleteCommandParser` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.
</div>

Here are the other classes in `Logic` (omitted from the class diagram above) that are used for parsing a user command:

<img src="images/ParserClasses.png" width="600"/>

How the parsing works:
* When called upon to parse a user command, the `AddressBookParser` class creates an `XYZCommandParser` (`XYZ` is a placeholder for the specific command name e.g., `AddCommandParser`) which uses the other classes shown above to parse the user command and create a `XYZCommand` object (e.g., `AddCommand`) which the `AddressBookParser` returns back as a `Command` object.
* All `XYZCommandParser` classes (e.g., `AddCommandParser`, `DeleteCommandParser`, ...) inherit from the `Parser` interface so that they can be treated similarly where possible e.g, during testing.

### Model component
**API** : [`Model.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/model/Model.java)

<img src="images/ModelClassDiagram.png" width="450" />


The `Model` component,

* stores the address book data i.e., all `Person` objects (which are contained in a `UniquePersonList` object).
* stores the currently 'selected' `Person` objects (e.g., results of a search query) as a separate _filtered_ list which is exposed to outsiders as an unmodifiable `ObservableList<Person>` that can be 'observed' e.g. the UI can be bound to this list so that the UI automatically updates when the data in the list change.
* stores a `UserPref` object that represents the user’s preferences. This is exposed to the outside as a `ReadOnlyUserPref` objects.
* does not depend on any of the other three components (as the `Model` represents data entities of the domain, they should make sense on their own without depending on other components)

<div markdown="span" class="alert alert-info">:information_source: **Note:** An alternative (arguably, a more OOP) model is given below. It has a `Tag` list in the `AddressBook`, which `Person` references. This allows `AddressBook` to only require one `Tag` object per unique tag, instead of each `Person` needing their own `Tag` objects.<br>

<img src="images/BetterModelClassDiagram.png" width="450" />

</div>


### Storage component

**API** : [`Storage.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/storage/Storage.java)

<img src="images/StorageClassDiagram.png" width="550" />

The `Storage` component,
* can save both address book data and user preference data in json format, and read them back into corresponding objects.
* inherits from both `AddressBookStorage` and `UserPrefStorage`, which means it can be treated as either one (if only the functionality of only one is needed).
* depends on some classes in the `Model` component (because the `Storage` component's job is to save/retrieve objects that belong to the `Model`)

### Common classes

Classes used by multiple components are in the `seedu.addressbook.commons` package.

--------------------------------------------------------------------------------------------------------------------

## **Implementation**

This section describes some noteworthy details on how certain features are implemented.

### Undo feature

It extends `AddressBook` with an undo history, stored internally as a `ReadOnlyAddressBook`. 

The operation is exposed in the `Model` interface as `Model#setAddressBook().

Given below is an example usage scenario and how the undo mechanism behaves at each step.

Step 1. The user launches the application for the first time. The `originalAddressBook` will be initialized with the initial address book state.

![UndoRedoState0](images/UndoRedoState0.png)

Step 2. The user executes `delete 5` command to delete the 5th person in the address book. The `delete` command calls `LogicManager#updateOriginalAddressBook()`, causing the modified state of the address book after the `delete 5` command executes to be saved in the `ReadOnlyAddressBook`, and the `exCommand` is updated to `delete 5`.

![UndoRedoState1](images/UndoRedoState1.png)

Step 3. The user decides that deleting the person was a mistake, and decides to undo that action by executing the `undo` command. The `undo` command will determine the `exCommand` is a delete command and call `Model#setAddressBook()`, which will reset the address book to the `originalAddressBook`.

![UndoRedoState3](images/UndoRedoState3.png)

The following sequence diagram shows how the undo operation works:

![UndoSequenceDiagram](images/UndoSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `UndoCommand` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.

</div>

#### Design considerations:

BUDDY App leverages on Java Stream and jSON data structures, to allow a single user create and edit contracts to their preference:

**Aspect: How undo & redo executes:**

* **Alternative 1 (current choice):** Saves the entire address book.
  * Pros: Easy to implement.
  * Cons: May have performance issues in terms of memory usage.

* **Alternative 2:** Individual command knows how to undo/redo by
  itself.
  * Pros: Will use less memory (e.g. for `delete`, just save the person being deleted).
  * Cons: We must ensure that the implementation of each individual command are correct.

**Aspect: How filter executes:**

* **Alternative 1 (current choice):** filter down to one category tag
    * Pros: Easy to manage contracts in one category tag.
    * Cons: Not able to view other contact in the listing.

* **Alternative 2:** filter multiple category tag
    * Pros: Combine two category tag into one result view
    * Cons: May have to navigate through all contacts within tag.

_{more aspects and alternatives to be added}_

### Relate feature
Relate Command extends `Command` Abstract Class.

Relate Command serves 2 purposes with one command keyword `relate`: 
1. create relationship 
2. display people's related contacts. 

Which relies on `RelateCommandParser` to identify `Index to` and `Optional<List<Index>> from`, as well as `RelateToPersonPredicate` that filters matched `Person` from `Model`.

The sequence diagram of how `RelateCommand` related to various components: 
![RelateSequenceDiagram](images/RelateSeqDiag.png)



#### Design considerations: 
The data structure to hold the mutual relationship chosen to be `Set`. Because in a pool of people related to a person should not have any duplicated one. 

Originally, `Set<Person>` seem to be a natural choice which largely aligns with logic: Person has relation with another person. However, relation would be one of attributes of a person which later will be store in the `json` file. It could be difficult to store a list of JS Object under an Object. Unless we create another `json` file just for mapping relations, which could be more like a DataBase tables kind of storage. 

I noticed that the `id` to identify a person in the original code base is actually `name`, which is why it does not allow person with same name. So for the ease of storage, I decidede to use `Set<Name>` to store the relation of person.


### \[Proposed\] Data archiving

_{Explain here how the data archiving feature will be implemented}_


--------------------------------------------------------------------------------------------------------------------

## **Documentation, logging, testing, configuration, dev-ops**

* [Documentation guide](Documentation.md)
* [Testing guide](Testing.md)
* [Logging guide](Logging.md)
* [Configuration guide](Configuration.md)
* [DevOps guide](DevOps.md)

--------------------------------------------------------------------------------------------------------------------

## **Appendix: Requirements**

### Product scope

**Target user profile**

Karen, secondary school teacher with work commitments
As a typical teacher managing 40 students in a class and in charge of
other co-curricular activities, it is always a hassle to manage the contacts of students’
and parents’ information. In addition, manage contact information of external vendors that are involved
in co-curricular activities and school’s event.


**Value proposition**

Project BUDDY is a Teacher’s Contact Management Application supported by CLI text input commands.
Teachers can enter contact information for a swift search and retrieve desired contact information
within a few keystrokes. The application provides an all-in-one display of the contacts related information
and their details are presented in a beautiful scrolling view.

### User stories

Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`

| no. | As a                                        | I want to                                                            | so that I can                                               |
|-----|---------------------------------------------|----------------------------------------------------------------------|-------------------------------------------------------------|
| 1   | forgetful user                              | record down people’s number and address                              | contact them later                                          |
| 2   | organized user                              | group contacts into different labels                                 | quickly filter out the category I want                      |
| 3   | productive user                             | search contact by name or number                                     | find a contact easily                                       |
| 4   | school teacher                              | know which student and parents belong to the same family             | call the parents of the student                             |
| 5   | school teacher that uses multiple softwares | copy a particular contact info                                       | paste it in other app to make use of the info               |
| 6   | school teacher                              | know which students belong to which class                            | use the filtered list to take attendance                    |
| 7   | contacts user                               | take notes for a particular contact                                  | record down happenings involving this contact               |
| 8   | GUI user                                    | have different tags in different colors                              | be visually pleased and easily distinguish them             |
| 9   | contacts user                               | quickly filter out all contacts without a tag                        | assign at least one tag to them                             |
| 10  | contacts user                               | batch select a list of contacts for editing                          | assign tags to multiple contacts at once                    |
| 11  | careless user                               | undo the previous command                                            | I will not lose my students' contact details.               |
| 12  | typo-prone user                             | edit the contact                                                     | correct the typo                                            |
| 13  | visual person                               | add photos to the contacts                                           | recall their identities                                     |
| 14  | school teacher                              | record students’ birthdays and filter contacts by birthday months    | prepare gifts in advance                                    |
| 15  | school teacher                              | record contacts’ email address                                       | contact them later                                          |
| 16  | Diligent school teacher                     | Which students needs help in particular subject                      | Keep a close update on student’s subject progress           |
| 17  | Health concerning teacher                   | Get quick access to student’s emergency contact                      | Call the contact immediately                                |
| 18  | Achievement motivating teacher              | highlight students with high flying result                           | identity them to partake in school or national competitions |
| 19  | Co-curricular teacher                       | group my co-curricular students                                      | Send updates on co-curricular activities                    |
| 20  | Concerning teacher                          | Highlight students who often skipped classes or missed homework      | Contact student for a one to one session                    |
| 21  | Starter                                     | Add some sample data within the code                                 | get familiar with the app interface and features            |
| 22  | Organized person                            | sort by Alphabetical order                                           | quickly find out someone based on name                      |
| 23  | Visual Person                               | Setting preference - colors or notification                          | distinguish people more easily                              |


*{More to be added}*

### Use cases

(For all use cases below, the **System** is the `Project BUDDY` and the **Actor** is the `user`, unless specified otherwise)

**Use case: Add a person**

**add n/NAME p/PHONE_NUMBER b/BIRTHDAY e/EMAIL a/ADDRESS [t/TAG]

**Use case: Edit a person**
**edit INDEX (must be a positive integer) [n/NAME] [b/BIRTHDAY] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]
…​


**Use case: Undo a command**

**MSS**

1.  User accidentally deletes a wrong person from the contact list
2.  User requests to undo the delete command
3.  AddressBook recovered to the original list

    Use case ends.


**Use case: Copy a contact**

**MSS**

1.  User requests to list persons
2.  AddressBook shows a list of persons
3.  User requests to copy a specific person in the list
4.  The contact details are copied

    Use case ends.

**Extensions**

* 2a. The list is empty.

  Use case ends.

* 3a. The given index is invalid.

    * 3a1. AddressBook shows an error message.

      Use case resumes at step 2.



*{More to be added}*

### Non-Functional Requirements

* Should work on any mainstream OS as long as it has Java 11 or above installed.
* Should be able to hold up to 1000 persons without a noticeable sluggishness in performance.
* The command should be simple enough so that users are able to accomplish most of the tasks faster using typing than using the mouse.
* Should be easy for new users to get used to usage fast.

### Glossary

**Mainstream OS**:  Windows, Linux, Unix, OS-X
* **Private contact detail**: A contact detail that is not meant to be shared with others
*{More to be added}*


--------------------------------------------------------------------------------------------------------------------

## **Appendix: Instructions for manual testing**

Given below are instructions to test the app manually.

<div markdown="span" class="alert alert-info">:information_source: **Note:** These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.

</div>

### Launch and shutdown

1. Initial launch

   1. Download the jar file and copy into an empty folder

   1. Double-click the jar file Expected: Shows the GUI with a set of sample contacts. The window size may not be optimum.

1. Saving window preferences

   1. Resize the window to an optimum size. Move the window to a different location. Close the window.

   1. Re-launch the app by double-clicking the jar file.<br>
       Expected: The most recent window size and location is retained.

1. _{ more test cases …​ }_

### Deleting a person

1. Deleting a person while all persons are being shown

   1. Prerequisites: List all persons using the `list` command. Multiple persons in the list.

   1. Test case: `delete 1`<br>
      Expected: First contact is deleted from the list. Details of the deleted contact shown in the status message. Timestamp in the status bar is updated.

   1. Test case: `delete 0`<br>
      Expected: No person is deleted. Error details shown in the status message. Status bar remains the same.

   1. Other incorrect delete commands to try: `delete`, `delete x`, `...` (where x is larger than the list size)<br>
      Expected: Similar to previous.

2. _{ more test cases …​ }_


### Relate

1. Relate a group of persons to a person
    1. Prerequisites: List all persons using the `list` command. Multiple persons in the list.
    2. Test case: `relate 2 <- 1 4 5`
    3. Expect: contact 1 2 4 5 displayed (potentially other existing related contacts). Output message shows: contact2_Name has relation with: ["contact1_Name" "contact4_Name" "contact5_Name" "otherExistingNames"]
    4. Test case: `relate 2 <- 1000`
    5. Expect: Invalid contact index message 
    6. Test case: `relate 1000 <- 1`
    7. Expect: Invalid contact index message
2. Display all related persons of a person  
    2. Test case: `relate 2 `
    3. Expect: contact 1 2 4 5 displayed (potentially other existing related contacts). Output message shows: contact2_Name has relation with: ["contact1_Name" "contact4_Name" "contact5_Name" "otherExistingNames"]
    4. Test case: `relate 1000`
    5. Expect: Invalid contact index message


### Saving data

1. Dealing with missing/corrupted data files

   1. _{explain how to simulate a missing/corrupted file, and the expected behavior}_

1. _{ more test cases …​ }_
