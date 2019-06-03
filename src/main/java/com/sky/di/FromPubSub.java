package com.sky.di;

//import com.google.cloud.ServiceOptions;
import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class FromPubSub {

  private static final BlockingQueue<PubsubMessage> messages = new LinkedBlockingDeque<PubsubMessage>();

  static class MessageReceiverExample implements MessageReceiver {

    public void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
      messages.offer(message);
      consumer.ack();
    }
  }

  @SuppressWarnings("finally")
public int ReadFromPubSub(String subscription_Id , String project_Id) throws IOException, InterruptedException
  {
	  File file = new File("C:\\Users\\KKH13\\Input\\Pub-Sub-Output.txt");
	  int count=0;
	  ProjectSubscriptionName subscriptionName = ProjectSubscriptionName.of(project_Id, subscription_Id);
	  Subscriber subscriber = null;
	  try {
	      // create a subscriber bound to the asynchronous message receiver
	      subscriber =
	          Subscriber.newBuilder(subscriptionName, new MessageReceiverExample()).build();
	      subscriber.startAsync().awaitRunning();
	      // Continue to listen to messages
	      while (true) {
	      	FileOutputStream fOut = new FileOutputStream(file, true);
	      	OutputStreamWriter osw = new OutputStreamWriter(fOut);
	        PubsubMessage message = messages.poll(2L, TimeUnit.SECONDS);
	        if(message.getData().isEmpty())
	        {
	        	System.out.println(count +"number of messages read from Subscription");
	        	break;
	        }
	        System.out.println("Data: " + message.getData().toStringUtf8());
	        try{
	        	osw.write(message.getData().toStringUtf8()+ "\n");
	        	osw.flush();
	        	osw.close();
	        	count++;
	        } catch(IOException e) {
	            e.printStackTrace();
	        }
	      }
	      
	    } finally {
	    	
	      if (subscriber != null) {
	        subscriber.stopAsync();
	      }
	      return count;
	    }
	  
  }
}
