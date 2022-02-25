# Lim Wan Yin - Project Portfolio Page

## Project: JustBook App v3.0 Overview
JustBook - Version 3.0 is a desktop application typically designed for use by a modern poly or JC student, in
registering his or her personal bookings or appointments. It leverages on an online database storage facility, backed by
an offline backup file. The user interacts with it using a CLI. It is written in Java(ver. 11), and has about 702 LoC.

### Summary of Contributions
- Feature: `save` command - the ability to save all bookings or appointments up to point of saving.
   - What it does: helps the user to save records up to saving point.
   - Justification: This feature is to help a student user save their work fast on the go.
   - Highlights: This command helps to save existing records, after any command to modify has been used.

- Feature: `onLoad` command - load all bookings or appointments records from previous sessions at start up.
  - What it does: allows the user to load all the bookings or appointment at start up so that user do not need to re-create them everytime they log in.
  - Justification: This feature is to help a busy student user to load appointments without the need to enter all details again.
  - Highlights: This command helps to load existing records from previous session (if any) at program start up.

- Feature: `show /b STARTDATE ENDDATE` command - show all bookings or appointments records within date range.
  - What to key in date parameter: key in start date before end date of the desired range in yyyy-mm-dd format.
  - What it does: allows the user to view all the bookings or appointment for indicated time period so that user have a clear distinct view of appointments within specified time frame.
  - Justification: This feature is to help a structured student user to view appointments within specified time frame.

- Feature: `del /b STARTDATE ENDDATE` command - delete all bookings or appointments records within date range.
  - What to key in date parameter: key in start date before end date of the desired range in yyyy-mm-dd format.
  - What it does: allows the user to delete all the bookings or appointment for indicated time period so that user can delete a list of appointments within specified time frame.
  - Justification: This feature is to help a efficient student user to delete list of appointments within specified time frame in one step.

- Code contributed: [Team04_yinyin377](https://nus-tic4001-ay2122s1.github.io/tp-dashboard/?search=yinyin377&breakdown=true&sort=groupTitle&sortWithin=title&since=2021-09-17&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

- Project management:
  - Contributed to releases v1.0 - v3.0 (3 releases) on GitHub
  - Administrator Team of Team Repo

- Enhancements to existing features:
  - Implemented loading error for assert statements upon file processing
  - Implementation of all features above by reusing the standardized mechanism across team member's work, to
    work synchronicity and avoid unnecessary duplication of code in codebase.
  - Implemented 2 JUnit tests ([59](https://github.com/AY2122S1-TIC4001-F18-4/tp/pull/59),
  [60](https://github.com/AY2122S1-TIC4001-F18-4/tp/pull/60))


- Documentation:
  - **User Guide**:
    - Added documentation for the features: `Load Application`, `show range`, `delete range` and `save`.
    - FAQ
    - Command Summary
  - **Developer Guide**:
    - Target User Profile
    - JustBook's Value Proposition
    - Non-Functional Requirements
    - User Stories
    - Sample instruction
  - **About Us**:
    - Link all team member's PPP
  - **PPP Guide**:
    - [yinyin377](yinyin377.md)


- Community:
  - Administrator for the Team Repo maintenance and operations
  - PRs reviewed ([#14](https://github.com/AY2122S1-TIC4001-F18-4/tp/pull/14),
    [#20](https://github.com/AY2122S1-TIC4001-F18-4/tp/pull/20),
    [#21](https://github.com/AY2122S1-TIC4001-F18-4/tp/pull/21),
    [#28](https://github.com/AY2122S1-TIC4001-F18-4/tp/pull/28),
    [#58](https://github.com/AY2122S1-TIC4001-F18-4/tp/pull/58))
