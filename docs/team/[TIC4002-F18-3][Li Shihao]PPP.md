

## Documentation

+ AboutUs.md
  1. [PR#17](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/18/files)
  2. [PR#20](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/20/files)
+ **User Guide**
  1. [PR23](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/23/files) Add `delete`, `find`, `add`, `list` commands
  2. [PR#100](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/100/files) Fix certain command errors in the table
+ **Developer Guide**
  1. [PR#55](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/55/files) Add 23 User Stories as table 

## Features

+ **UI Overhaul**:
  - Light theme css 
  - Person in Card View instead of List View for space saving and info density
  1. [PR#27](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/27/files)
     
     (also includes a fix of `JsonUtil` and its test that `addressbook.json` would not have a 
     newline at EOF which fails the CI)

+ Sample contacts in `addressbook.json` (not correct way)
  1. [PR#35](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/35/files)
+ Create 19 suitable sample contacts for our project context in `SampleDataUtil.java`, add `/data/` to `gitignore` (proper way)
  1. [PR#50](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/50/files)
+ Relate Command 
  + which relate multiple contacts to one `relate 2 <- 1 4 5`
  + or list a person and whose every related contacts by `relate 2`
  + mutual relationship: A related to B, B automatically related to A
  1. [PR#58](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/58/files) Major feature release
  2. [PR#98](https://github.com/AY2122S2-TIC4002-F18-3/tp2/pull/98/files) Fix invalid index after `<-` operator does not throw exception
