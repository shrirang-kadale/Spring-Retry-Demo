# Spring-Retry-Demo

Spring-Retry demo application with spring boot

Introduction
-To avoid the failure scenarios we can retry the same identical request using spring retry
-Usually we implement the retry functionality on any service call using loop and break condition but this solution is error prone
-To overcome this issue spring has provided one simple framework Spring-Retry which can be configured using annotations
-We can define the retry limits, fallback methods and many more using annotations.


Annotations used in application

@EnableRetry
-It is used to enable spring retry in spring boot project.

@Retryable
-It is used to indicate any method to be a candidate of retry.

@Recover
-It is used to specify the fallback method.

Demo application overview
-We will create one spring boot project to expose one simple REST API which will call one backend operation which is prone to failure. We will simulate this failure conditions to initiate the retry.
-One service class which will invoke the remote API and this will send exception in case of failure.
-We will design the retry based on this custom exception, like once we receive this exception, we will retry for 3 times and finally return to the client.
-In those 3 attempts, if we get success response from backend service then that success response will be returned else the standard fallback method will be called.

