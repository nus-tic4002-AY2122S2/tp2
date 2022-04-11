## DevOps
- Set up the team project repo
- Create pull request from team repo to the main tp2 repo
- Integrated Codecov inside the team repo
- enable the assertion in build.gradle

## Features

- [#PR14](https://github.com/AY2122S2-TIC4002-F18-6/tp2/pull/14)
  - GUI change 
    - Create two panel screen to be able to show both client and post list
  - Model Structures
    - Create post structures and post list structures
    - Reconfigure the model and storage to match the added Post structure and PostList

- [#PR25](https://github.com/AY2122S2-TIC4002-F18-6/tp2/pull/25)
  - Parser
    - Create a parser to detect the target list to process 
    - The second argument (the argument after command word) will be `c|client` for client list or `p|post` for post list
  - `delete` Command for post list
  - Rewrite `delete` command for client list to capture the second argument via the parser

- [#PR30](https://github.com/AY2122S2-TIC4002-F18-6/tp2/pull/30)
  - `send` command 
    - `send c/1 2 4 p/1 2` means send the post index 1, 2 to client 1, 2, 4
    - Create a `parseIndexList(String indexListString)` function which returns `List<Index>` in `ParserUtil.java` to be able to capture multiple index, and other command also can use this parser.
    - Improve send command to detect duplicate clients

- [#PR32](https://github.com/AY2122S2-TIC4002-F18-6/tp2/pull/32)
  - `sort` command
    - `sort postdate asc` or `sort postdate desc`
    - convert postDate from string to `LocalDateTime`

- [#PR35](https://github.com/AY2122S2-TIC4002-F18-6/tp2/pull/35)
  - `add` command for post list
  - Rewrite `add` command for client list to capture the second argument via the parser

- [#PR56](https://github.com/AY2122S2-TIC4002-F18-6/tp2/pull/56)
  - Mass delete

- [SampleDataUtil](https://github.com/AY2122S2-TIC4002-F18-6/tp2/commit/10bd5df9ca1ba77fb42547fff5bec64e8dec96c7)
  - add sample data in SampleDataUtil to make sure jar file can load sample data without json file

## Bug fixing

- [#PR53](https://github.com/AY2122S2-TIC4002-F18-6/tp2/pull/53)
  - send command avoid click cell to refresh
  
## Documentation

- User Guide
  - [#PR18](https://github.com/AY2122S2-TIC4002-F18-6/tp2/pull/18) - v1.1 initial draft
  - [#Direct Commit](https://github.com/AY2122S2-TIC4002-F18-6/tp2/commit/0f7fab97a8b2cb3922ea5ab0e1fe5505b1b9ebc0) - v1.3 update prepare for the dry run
- Developer Guide
  - [#PR22](https://github.com/AY2122S2-TIC4002-F18-6/tp2/pull/22)
  - v1.4 update for SendCommand and [SendCommandSequenceDiagram](images/SendCommandSequenceDiagram.png)
- Readme
  - [#PR12](https://github.com/AY2122S2-TIC4002-F18-6/tp2/pull/12)

## Team Contribution

- basically all (code, documentation, class demo, release, deliverable etc.)

## Code contribution
- [Ruiting1 RepoSense](https://nus-tic4002-ay2122s2.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2022-02-11&tabOpen=true&tabType=authorship&tabAuthor=Ruiting1&tabRepo=AY2122S2-TIC4002-F18-6%2Ftp2%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other&authorshipIsBinaryFileTypeChecked=false)



