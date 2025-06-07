# Concordion Features Demo

This specification demonstrates all Concordion features available in Markdown syntax.

## [Variable Declaration and Assignment](- "")

We can declare a variable [John Smith](- "#fullName") and use it later.

We can also assign the result of an expression to a variable [like this](- "#result = split(#fullName)").

## Variable References

The declared variable contains [John Smith](- "?=#fullName").

## Property References

After splitting the name, the first name is [John](- "?=#result.firstName") and the last name is [Smith](- "?=#result.lastName").

## Method Execution

Let's [execute](- "#theResult2 = methodName(#TEXT)") a method [here](- "?=methodName(#TEXT)").

## Method Execution with Parameters

We can pass parameters to methods [like this](- "greetPerson(#fullName)").

## Verify Results

The greeting should be [Hello, John Smith!](- "?=getGreeting(#fullName)").

The greeting should be [Hello, John Smith!](- "?=getGreetingSmall(#fullName)").

The greeting should be [Hello, John!](- "?=getGreetingSmall(#result.firstName)").

## Run Command
To specify a custom runner, use:

`[Display text](spec.html "c:run=runnerName")`

where `runnerName` is the fully qualified class name of the runner.

Here we demo run with spec.CustomRunner of [another specification](SplittingNames.md "c:run=spec.CustomRunner"). Such custom runner can run other types of tests.

To run another Concordion specification: 
- [Concordion Syntax Reference ::  spec>ConcordionSyntaxReference ](ConcordionSyntaxReference.html "c:run")


## Example Heading

This is a normal example using a Markdown heading.

### [Ignored Example](- "c:status=Ignored")

This example will be ignored during test execution.

### [Expected to Fail Example](- "c:status=ExpectedToFail")

This example is expected to fail but will not cause the build to break.

## [Extensions](- "")

We can use custom extensions [like this](- "ext:screenshot=example").
