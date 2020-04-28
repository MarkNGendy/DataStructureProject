package eg.edu.alexu.csd.datastructure.mailserver.logicfiles.applicationclasses;

import java.util.Stack;

import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.applicationinterfaces.IFilter;

public class Filter implements IFilter {
	private String filterTopic;
	private String value;
	
	public String getTopic()
	{
		return filterTopic;
	}
	public void setTopic(String filterTopic)
	{
		this.filterTopic = filterTopic;
	}
	public String getValue()
	{
		return value;
	}
	public void setValue(String value)
	{
		this.value = value;
	}
	
	public DoubleLinkedList filter(IMail[] mails)
	{
		switch(filterTopic)
		{
		case "subject":
			return searchSub(mails, 0, mails.length-1, value);
			break;
		case "sender":
			return searchSend(mails, 0, mails.length-1, value);
			break;
		case "priority":
			return searchPrio(mails, 0, mails.length-1, Integer.parseInt(value));
			break;
		default:
			return null;
		}
	}
	
	public DoubleLinkedList searchSub(IMail[] mails, int left, int right, String subject)
	{
		DoubleLinkedList mlist = new DoubleLinkedList();
		Stack<E> s = new Stack();
		int mid;
		s.push(left);
		s.push(right);
		while(!s.isEmpty())
		{
			right = (int)s.pop();
			left = (int)s.pop();
			mid= (left+right)/2;
			if(mails[mid].getSubject().equals(subject))
			{
				while((mails[mid-1].getSubject().equals(subject)))
				{
					mid--;
				}
				if(!mails[mid].getSubject().equals(subject))
				{
					mid++;
				}
				while(mails[mid].getSubject().equals(subject))
				{
					mList.add(mails[mid]);
					mid++;
				}
				break;
			}
			else if(right<left)
			{
				break;
			}
			else if(mails[mid].getSubject().compareTo(subject)>0)
			{
				s.push(left);
				s.push(mid);
			}
			else if(mails[mid].getSubject().compareTo(subject)<0)
			{
				s.push(mid);
				s.push(right);
			}

		}
		return mList;
	}
	public DoubleLinkedList searchSend(IMail[] mails, int left, int right, String sender)
	{
		DoubleLinkedList mlist = new DoubleLinkedList();
		Stack<E> s = new Stack();
		int mid;
		s.push(left);
		s.push(right);
		while(!s.isEmpty())
		{
			right = (int)s.pop();
			left = (int)s.pop();
			mid= (left+right)/2;
			if(mails[mid].getSender().equals(sender))
			{
				while((mails[mid-1].getSender().equals(sender)))
				{
					mid--;
				}
				if(!mails[mid].getSender().equals(sender))
				{
					mid++;
				}
				while(mails[mid].getSender().equals(sender))
				{
					mList.add(mails[mid]);
					mid++;
				}
				break;
			}
			else if(right<left)
			{
				break;
			}
			else if(mails[mid].getSender().compareTo(sender)>0)
			{
				s.push(left);
				s.push(mid);
			}
			else if(mails[mid].getSender().compareTo(sender)<0)
			{
				s.push(mid);
				s.push(right);
			}

		}
		return mList;
	}
	
	public DoubleLinkedList searchPrio(IMail[] mails, int left, int right, int priority)
	{
		DoubleLinkedList mlist = new DoubleLinkedList();
		Stack<E> s = new Stack();
		int mid;
		s.push(left);
		s.push(right);
		while(!s.isEmpty())
		{
			right = (int)s.pop();
			left = (int)s.pop();
			mid= (left+right)/2;
			if(mails[mid].getPriority() == priority)
			{
				while(mid-1>=0 && mails[mid-1].getPriority() == priority)
				{
					mid--;
				}
				if(mid-1>=0 && mails[mid-1].getPriority() != priority )
				{
					mid++;
				}
				while(mid+1 < mails.length && mails[mid+1].getPriority() == priority)
				{
					mList.add(mails[mid]);
					mid++;
				}
				break;
			}
			else if(right < left)
			{
				break;
			}
			else if(mails[mid].getPriority() > priority)
			{
				s.push(left);
				s.push(mid);
			}
			else if(mails[mid].getPriority() < priority)
			{
				s.push(mid);
				s.push(right);
			}

		}
		return mailList;
	}
}
