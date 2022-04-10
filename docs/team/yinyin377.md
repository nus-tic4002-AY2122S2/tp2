---
layout: page
title: Lim Wan Yin's Project Portfolio Page
---

## Project: Buddy App v1.4 Overview
BUDDY - Version 1.4 is a desktop application typically designed for use by a teacher who are familiar with CLI, in
managing his or her contacts' details. It leverages on an offline storage facility, hence does not require internet connection.
The user can interact with it using a CLI or GUI. 

### Summary of Contributions

- Feature: `bday MONTH` command - show all contacts or records within month range.
  - What to key in MONTH parameter: MONTH in numeric, e.g. key `bday 1` to check contact with birthday in January.
  - What it does: allows the user to view contacts filtered by their birthday month so that user, in this case - the teacher, can prepare the list of birthday babies within specified month.
  - Justification: This feature is to help a classroom teacher prepare list of birthday babies within specified month in one step.
  

- Feature: `filter TAG` command - filter all contacts or records with TAG specified.
  - What to key in TAG parameter: full TAG name, e.g. key `g501` to filter all contacts with g501 tag, or to filter contacts in class g501.
  - What it does: allows the user to view all contacts with same tag so that user can easily filter down a list of contacts.
  - Justification: This feature is to help a efficient teacher user to narrow down a list of contacts with same tag.


- Feature: `rename TAG t/TAG` command - rename all contacts or records with TAG specified to a new TAG name.
  - What to key in TAG parameter: existing full TAG name that needs to be renamed or deleted. e.g. key `g501`
  - What to key in t/TAG parameter: desired new TAG name to replace existing e.g. key `t/g601` or leave it as `t/` to delete TAG.
  - What it does: allows the user to rename all the contacts or records with specified TAG so that user can easily manage a list of contacts with same TAG.
  - Justification: This feature is to help a efficient teacher user to manage list of contact with same TAG in a single step.


- Code contributed: [Team03_yinyin377](https://nus-tic4002-ay2122s2.github.io/tp-dashboard/?search=yinyin377&breakdown=true&sort=groupTitle&sortWithin=title&since=2022-02-18&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)


- Project management:
  - Contributed to release v1.2 - v1.4 [(3 releases)](https://github.com/AY2122S2-TIC4002-F18-3/tp2/releases) on GitHub
  - Administrator Team of Team Repo


- Enhancements to existing features:
  - Implemented error parser for assert statements
  - Implementation of all features above by reusing the standardized mechanism across team member's work, to
    work synchronicity and avoid unnecessary duplication of code in codebase.
  - Implemented JUnit tests for BirthdayCommandTest, FilterCommandTest, RenameCommandTest, BirthdayCommandParserTest, FilterCommandParserTest, and RenameCommandParserTest. ([#112](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/112) , [#118](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/118) , [#119](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/119))
  

- Documentation:

  - **User Guide**:
    - Added documentation for the features: `bday`, `filter`, and `rename`.
    - Command Summary
    
  - **Developer Guide**:
    - Target User Profile
    - BUDDY's Value Proposition
    - User Stories
    - Sample instruction
    
  - **PPP Guide**:
    - [yinyin377](yinyin377.md)


- Community:
  - Administrator for the Team Repo maintenance and operations
  - Contributes and watching forum
  - PRs reviewed ([#23](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/23),
    [#27](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/27),
    [#38](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/38),
    [#45](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/45))
