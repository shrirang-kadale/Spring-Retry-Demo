6	Spring-Retry demo application with spring boot

6.1	Expected reasons for the unsuccessful result/exception from the remote service
-Your request never reached inventory server
-Your request reached server but it refused it
-Server accepted connection but failed to read request
-Server read request but hanged
-Server processed request but failed to send response
-Server sent 200 OK response but it was lost and you never received it
-Server's response was received but client failed to process it
-Server's response was sent but client timed-out earlier

6.2	Introduction
-To avoid the above scenarios we can retry the same identical request using spring retry
-Usually we implement the retry functionality on any service call using loop and break condition but this solution is error prone
-To overcome this issue spring has provided one simple framework Spring-Retry which can be configured using annotations
-We can define the retry limits, fallback methods and many more using annotations.


6.3	Annotations used in application

6.3.1	@EnableRetry
-It is used to enable spring retry in spring boot project.

6.3.2	@Retryable
-It is used to indicate any method to be a candidate of retry.

6.3.3	@Recover
-It is used to specify the fallback method.

6.4	Demo application overview
-We will create one spring boot project to expose one simple REST API which will call one backend operation which is prone to failure. We will simulate this failure conditions to initiate the retry.
-One service class which will invoke the remote API and this will send exception in case of failure.
-We will design the retry based on this custom exception, like once we receive this exception, we will retry for 3 times and finally return to the client.
-In those 3 attempts, if we get success response from backend service then that success response will be returned else the standard fallback method will be called.
# spring-retry
# Spring-Retry-Demo
