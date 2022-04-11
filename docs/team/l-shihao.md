---
layout: page
title: Li Shihao's Project Portfolio Page
---

For [Project BUDDY](https://github.com/AY2122S2-TIC4002-F18-3/tp2) latest [v1.4](https://github.com/AY2122S2-TIC4002-F18-3/tp2/releases).

----

## Documentation

+ AboutUs.md
  1. [PR#17](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/18/files)
  2. [PR#20](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/20/files)
+ **User Guide**
  1. [PR23](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/23/files) Add `delete`, `find`, `add`, `list` commands
  2. [PR#100](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/100/files) Fix certain command errors in the table
+ **Developer Guide**
  1. [PR#55](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/55/files) Add 23 User Stories as table 
  2. [PR#125](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/125/files) Add implementation of `Relate` and a sequence diagram.

## Features & Bugs Fix

+ Sample contacts in `addressbook.json` (not correct way)
  1. [PR#35](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/35/files)
+ Create 19 suitable sample contacts for our project context in `SampleDataUtil.java`, 
  add `/data/` to `gitignore` (proper way)
  1. [PR#50](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/50/files)
+ **Relate Command**
  + which relate multiple contacts to one `relate 2 <- 1 4 5`
  + or list a person and whose every related contacts by `relate 2`
  + mutual relationship: A related to B, B automatically related to A
  1. [PR#58](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/58/files) 
     Major feature release!
  
     Also includes `RelateCommmandParserTest` test code
  2. [PR#98](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/98/files) 
     Fix invalid index after `<-` operator does not throw exception.
  3. [PR#109](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/109/files)
     Bug fix: unable to save new person added due to construct person in `AddCommandParser` with `null` for relation.-TIC4002-F18-3/tp2/pull/98/files) Fix invalid index after `<-` operator does not throw exception

+ **UI Overhaul**:
    - Light theme css
    - Person in Card View instead of List View for space-saving and info density
    1. [PR#27](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/27/files)

       (also includes a fix of `JsonUtil` and its test that `addressbook.json` would not have a
       newline at EOF which fails the CI)

   ![Ui](../images/Ui.png)



## Team Contribution 
 + [Code review 37](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/37)
 + [Code review 38](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/38)
 + Make `v1.2` [release](https://github.com/AY2122S2-TIC4002-F18-3/tp2/releases) 
 + Maintain the updates to `Ui.png`
 + Contribution to Project [shared notes](https://docs.google.com/document/d/1NC96Y2KN7qFkIhVDBuyJVqujKP3mCRSpKo2TGDgscYs/edit#), 
   topic, target user profile, value proposition, features selection
 + Contribution to User Stories

## Code contributed
 + [RepoSense l-shihao](https://nus-tic4002-ay2122s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2022-02-11&tabOpen=true&tabType=authorship&tabAuthor=l-shihao&tabRepo=AY2122S2-TIC4002-F18-3%2Ftp2%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other&authorshipIsBinaryFileTypeChecked=false)