# Talking Clock Coding Challenge

Within the team, we don't like clocks that display as numbers. In fact, we like clocks that present the current time in 
a more _"Human Friendly"_ way.

## Objective 1

Write a command-line program that returns the current time using the "Human Friendly Text" demonstrated in the example below.

Numeric Time Human Friendly Text -

* 1:00 One o'clock
* 2:00 Two o'clock
* 13:00 One o'clock
* 13:05 Five past one
* 13:10 Ten past one
* 13:25 Twenty five past one
* 13:30 Half past one
* 13:35 Twenty five to two
* 13:55 Five to two

For example, if we execute this program at 16:30, it should output "Half past four"

`$ ..some command..`
`Half past four`

#### Execution example
`java -jar services-0.0.1-SNAPSHOT.jar -n`  
`11:40 twenty to twelve`

## Objective 2

Allow the command to take an arbitrary Numeric Time parameter as input and return the "Human Friendly Text" equivalent.

For example:

`$ ..some command.. 15:00`
`Three o'clock`

#### Execution example
* Get the time with a given argument  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`java -jar services-0.0.1-SNAPSHOT.jar -t 23:45`  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`23:45 quarter to twelve`  

* Error handling  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`java -jar services-0.0.1-SNAPSHOT.jar -t 21.56`   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`Error: Text '21.56' could not be parsed at index 2`  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`usage: TalkingClock`  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`-?         help`  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`-n         Returns a human friendly equivalent of the current time`  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`-t <arg>   Returns a human friendly equivalent of the numeric time given`  


## Objective 3
Write a REST service to expose the clock and allow an optional parameter to pass the arbitrary Numeric Time like Objective 2, returning the "Human Friendly Text" as JSON.

#### Execution example
* Get the current time  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`http://localhost:9090/test`   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`{"humanFriendlyTime":"sixteen to twelve","numericTime":"11:44"}`   

* Get the time with a given path variable  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`http://localhost:9090/time/16:30`  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`{"humanFriendlyTime":"half past four","numericTime":"16:30"}`  

* Get the time with a given query parameter  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`http://localhost:9090/time?t=01:15`  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`{"humanFriendlyTime":"quarter past one","numericTime":"01:15"}`  

* Get the time with a given translation strategy. The following uses the CommonLanguageStrategy with English Language applied, this is the default.      
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`http://localhost:9090/time?t=01:15&s=EnglishCommonLanguageStrategy`  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`{"humanFriendlyTime":"quarter past one","numericTime":"01:15"}`  

* Get the time with a given translation strategy.  There following uses EnglishBasicStrategy.   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`http://localhost:9090/time?t=01:15&s=EnglishBasicStrategy`  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`{"humanFriendlyTime":"one fifteen am","numericTime":"01:15"}`  


* Error handling  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`http://localhost:9090/time?t=99:30`   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;`{"timestamp":"2019-10-17 11:48:50","message":"Text '99:30' could not be parsed: Invalid value for HourOfDay (valid values 0 - 23): 99","status":422}`  

