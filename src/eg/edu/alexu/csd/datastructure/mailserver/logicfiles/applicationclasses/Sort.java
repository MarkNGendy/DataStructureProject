package eg.edu.alexu.csd.datastructure.mailserver.logicfiles.applicationclasses;

import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.useddatastructures.queues.PriorityQueue;
import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.applicationinterfaces.ISort;

public class Sort implements ISort {
	private String type;
	
	public ISort(String type ) 
	{
		this.type=type;
	}
	
	public String getType() 
	{
		return type;
	}
	
	public void setType(String type) 
	{
		this.type = type;
	}
	
	public void sort (IMail[] mails)
	{
		if(type.equals("priority"))
		{
			mails=sortPriority(mails);
		}
		else
		{
			quickSortStack(mails, 0, mails.length-1, type);
		}
	}
	
	private IMail [] sortPriority(IMail[] mails)
	{
		PriorityQueue p = new PriorityQueue();
		for(int i=0;i<mails.length;i++)
		{
			p.insert(mails[i], mails[i].getPriority());
		}
		IMail[] sortedMails = new IMail[p.size()];
		for (int i=p.size()-1 ;i>=0;i--)
		{
			sortedMails[i]= (IMail) p.removeMin();
		}
		return sortedMails;
	}
	
	private void swap(IMail a, IMail b)
	{
		IMail temp =a;
		a=b;
		b=temp;
	}
	
	int partition(IMail[] mails,int left,int right ,String topic)
	{
		IMail x= mails[right];
		int i=(left-1);
		for(int j= left;j<right;j++)
		{
			if(!compareMail(mails[j],x,topic))
			{
				i++;
				swap(mails[j],mails[i]);
			}
		}
		
		swap(mails[i+1],mails[h]);
		
		return i+1;
	}
	public boolean compareMail(IMail mailA,IMail mailB,String topic)
	{
		switch(topic)
		{
		case "subject":
			return compareMailSubject(mailA, mailB);
			break;
		case "sender":
			return compareMailSender(mailA, mailB);
			break;
		case "time":
			return compareMailTime(mailA, mailB);
			break;
		default:
			return false;	
		}
	}
	
	public boolean compareMailSubject(IMail mailA,IMail mailB)
	{
		if(mailA.getSubject().compareTo(mailB.getSubject())>0)
		{
			return true;
		}
		return false;
	}
	
	public boolean compareMailSender(IMail mailA,IMail mailB)
	{
		if(mailA.getSender().compareTo(mailB.getSender())>0)
		{
			return true;
		}
		return false;
	}
	
	public boolean compareMailTime(IMail mailA,IMail mailB)
	{
		LocalDateTime timeA= mailA.getTime();
		LocalDateTime timeB= mailB.getTime();
		Duration duration=Duration.between(timeA, timeB);

		long diff =duration.toMillis();
		if(diff>0)
		{
			return true;

		}
		return false;
	}
	
	
	void quickSortStack(IMail mails[],int left,int right, String topic)
	{
		Stack stack = new Stack();
		int p;
		stack.push(left);
		stack.push(right);
		while(!stack.isEmpty())
		{
			right=(int) stack.pop();
			left=(int) stack.pop();
			p=partition(mails, left, right,topic);
			if(p-1>l)
			{
				stack.push(left);
				stack.push(p-1);
			}
			if(p+1<right)
			{
				stack.push(p+1);
				stack.push(right);
			}
		}
		for(int i=0 ;i<mails.length/2;i++)
		{
			IMail temp = mails[i];
			mails[i]=mails[mails.length-1-i];
			mails[mails.length-1-i]=temp;
		}

	}
	
	
	
}
