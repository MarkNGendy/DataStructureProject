package eg.edu.alexu.csd.datastructure.mailserver.logicfiles.applicationclasses;

import java.time.LocalDateTime;
import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.useddatastructures.linkedlists.DoubleLinkedList;
import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.useddatastructures.queues.LinkedListQueue;
import eg.edu.alexu.csd.datastructure.mailserver.logicfiles.applicationinterfaces.IMail;

public class Mail implements IMail {
	private String subject;
    private String sender;
    private LinkedListQueue recivers;
    private String text;
    private boolean starred;
    private DoubleLinkedList attachmets;
    private LocalDateTime time;
    private LocalDateTime trashedtime;
    private int priority;
    private String folder;
    
    public Mail() 
    {
   	 attachmets= new DoubleLinkedList();
	}
    
	public String getSubject() 
	{
		return subject;
	}
	
	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	
	public String getSender()
	{
		return sender;
	}
	
	public void setSender(String sender)
	{
		this.sender = sender;
	}
	
	public LinkedListQueue getRecivers()
	{
		return recivers;
	}
	
	public void setRecivers(LinkedListQueue recivers)
	{
		this.recivers = recivers;
	}
	public String getText()
	{
		return text;
	}
	public void setText(String text)
	{
		this.text = text;
	}
	public boolean isStarred() 
	{
		return starred;
	}
	public void setStarred(boolean starred) 
	{
		this.starred = starred;
	}
	public DoubleLinkedList getAttachmets()
	{
		return attachmets;
	}
	public void setAttachmets(DoubleLinkedList attachmets) 
	{
		this.attachmets = attachmets;
	}
	public LocalDateTime getTime()
	{
		return time;
	}
	public void setTime(LocalDateTime time)
	{
		this.time = time;
	}
	public int getPriority()
	{
		return priority;
	}
	public void setPriority(int priority)
	{
		this.priority = priority;
	}
	public String getFolder()
	{
		return folder;
	}
	public void setFolder(String folder)
	{
		this.folder = folder;
	}
	public LocalDateTime getTrashedtime()
	{
		return trashedtime;
	}
	public void setTrashedtime(LocalDateTime trashedtime) 
	{
		this.trashedtime = trashedtime;
	}
}
